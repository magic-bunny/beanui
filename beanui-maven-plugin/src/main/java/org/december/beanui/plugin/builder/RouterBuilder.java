package org.december.beanui.plugin.builder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.plugin.face.Builder;
import org.december.beanui.plugin.face.bean.Router;
import org.december.beanui.plugin.face.exception.BuilderException;
import org.december.beanui.plugin.face.exception.RouterBuilderException;
import org.december.beanui.plugin.face.util.ClassUtil;
import org.december.beanui.plugin.face.util.PluginSystem;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.*;

public class RouterBuilder extends Builder {
    private Router router;

    public static final String LOGIN = "login";

    public Map run() throws BuilderException {
        Map result = new HashMap();
        try {
            String routerPath = PluginSystem.getProperty("routerPath");
            if(routerPath == null || "".equals(routerPath)) {
                Router root = createRouterByClassloader(super.getClassLoader());
                this.router = root;
                result.put("router", root.getChildren());
                Router login = new Router();
                login.setMenu(false);
                login.setComponent("@/views/login/index");
                login.setPath("/login");
                result.put(LOGIN, login);
            } else{
                InputStream input = this.getClassLoader().getResourceAsStream(PluginSystem.getProperty("routerPath"));
                YAMLFactory yamlFactory = new YAMLFactory();
                ObjectMapper mapper = new ObjectMapper();
                mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
                YAMLParser yamlParser = yamlFactory.createParser(input);
                final JsonNode node = mapper.readTree(yamlParser);
                TreeTraversingParser treeTraversingParser = new TreeTraversingParser(node);
                Router root = mapper.readValue(treeTraversingParser, Router.class);
                this.router = root;
                Router login = new Router();
                login.setMenu(false);
                if(!"/login".equals(root.getPath())) {
                    login.setComponent("@/views/login/index");
                } else {
                    login.setComponent("@/views/beanui/" + root.getComponent());
                }
                login.setPath("/login");
                result.put(LOGIN, login);
                if(root.getChildren() == null) {
                    List<Router> singleRouter = new ArrayList<Router>();
                    root.setMenu(false);
                    singleRouter.add(root);
                    result.put("router", singleRouter);
                } else {
                    result.put("router", root.getChildren());
                }
            }
        } catch (Exception e) {
            throw new RouterBuilderException(e);
        }
        return result;
    }

    public void search(ClassLoader classLoader, Router router) throws ClassNotFoundException {
        if(router.getComponent() != null) {
            Class clazz = classLoader.loadClass(router.getComponent());
            Annotation[] annos = clazz.getAnnotations();
            for (Annotation anno : annos) {
                if("Component".equals(anno.annotationType().getSimpleName())) {
                    String distPath = "${workPath}/src/views/beanui/" + clazz.getName() + ".vue";
                    ComponentBuilder componentBuilder = new ComponentBuilder();
                    componentBuilder.setTemplateName("Component.ftl");
                    componentBuilder.setClassLoader(classLoader);
                    componentBuilder.setDistPath(distPath);
                    componentBuilder.setTemplateClass(clazz);
                    componentBuilder.create();
                    break;
                }
            }
        } else {
            List<Router> routers = router.getChildren();
            for(Router r:routers) {
                search(classLoader, r);
            }
        }
    }

    private Router createRouterByClassloader(ClassLoader classLoader) {
        Router root = new Router();
        root.setTitle(LOGIN);
        Set<Class> classes = ClassUtil.getClasses(classLoader);
        List<Router> children = new ArrayList<Router>();
        for(Class clazz:classes) {
            Component component = (Component)clazz.getAnnotation(Component.class);
            if(component != null) {
                Router router = new Router();
                router.setMenu(false);
                router.setPath(component.value());
                router.setComponent(clazz.getName());
                children.add(router);
            }
        }
        root.setChildren(children);
        return root;
    }

    public Router getRouter() {
        return router;
    }

    public void setRouter(Router router) {
        this.router = router;
    }
}
