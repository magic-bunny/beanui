package org.december.beanui.plugin.builder;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.TreeTraversingParser;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLParser;
import freemarker.template.Template;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.plugin.bean.Router;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.exception.RouterBuilderException;
import org.december.beanui.plugin.util.ClassUtil;
import org.december.beanui.plugin.util.PluginSystem;

import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.util.*;

public class RouterBuilder extends Builder {
    private Router router;

    public static final String LOGIN = "login";

    public Map run(Template template) throws BuilderException {
        Map result = new HashMap();
        try {
            String routerPath = PluginSystem.getProperty("routerPath");
            if(routerPath == null || "".equals(routerPath)) {
                Router root = createRouterByClassloader(super.getClassLoader());
                this.router = root;
                result.put("router", root.getChildren());
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
                login.setComponent(root.getComponent());
                login.setMenu(false);
                result.put(LOGIN, login);
                result.put("router", root.getChildren());
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
        Map<String, Router> map = new HashMap();
        for(Class clazz:classes) {
            Annotation[] annotations = clazz.getAnnotations();
            for(Annotation annotation:annotations) {
                Class annotationName = annotation.annotationType();
                if (Component.class == annotationName) {
                    Map<String, String> annotationKV = ClassUtil.annotation2map(annotation);
                    String packageName = clazz.getPackage().getName();
                    if(annotationKV.get("superPath")!=null && !"".equals(annotationKV.get("superPath"))) {
                        packageName = annotationKV.get("superPath");
                    }
                    if(map.containsKey(packageName)) {
                        Router router = (Router)map.get(packageName);
                        Router componentRouter = new Router();
                        if(annotationKV.get("title")==null || "".equals(annotationKV.get("title"))) {
                            componentRouter.setTitle(clazz.getSimpleName());
                        } else {
                            componentRouter.setTitle(annotationKV.get("title"));
                        }
                        if(annotationKV.get("path")==null || "".equals(annotationKV.get("path"))) {
                            componentRouter.setPath(clazz.getSimpleName());
                        } else {
                            componentRouter.setPath(annotationKV.get("path"));
                        }
                        if(annotationKV.get("icon")!=null && !"".equals(annotationKV.get("icon"))) {
                            componentRouter.setIcon(annotationKV.get("icon"));
                        }
                        componentRouter.setComponent(clazz.getName());
                        router.getChildren().add(componentRouter);
                    } else {
                        Router router = new Router();
                        router.setTitle(packageName);
                        router.setPath(packageName);
                        if(annotationKV.get("superPath")!=null && !"".equals(annotationKV.get("superPath"))) {
                            router.setPath(annotationKV.get("superPath"));
                        }
                        if(annotationKV.get("superTitle")!=null && !"".equals(annotationKV.get("superTitle"))) {
                            router.setTitle(annotationKV.get("superTitle"));
                        }
                        if(annotationKV.get("superIcon")!=null && !"".equals(annotationKV.get("superIcon"))) {
                            router.setIcon(annotationKV.get("superIcon"));
                        }
                        List<Router> children = new ArrayList<Router>();
                        Router componentRouter = new Router();
                        if(annotationKV.get("title")==null || "".equals(annotationKV.get("title"))) {
                            componentRouter.setTitle(clazz.getSimpleName());
                        } else {
                            componentRouter.setTitle(annotationKV.get("title"));
                        }
                        if(annotationKV.get("path")==null || "".equals(annotationKV.get("path"))) {
                            componentRouter.setPath(clazz.getSimpleName());
                        } else {
                            componentRouter.setPath(annotationKV.get("path"));
                        }
                        if(annotationKV.get("icon")!=null && !"".equals(annotationKV.get("icon"))) {
                            componentRouter.setIcon(annotationKV.get("icon"));
                        }
                        componentRouter.setComponent(clazz.getName());
                        children.add(componentRouter);
                        router.setChildren(children);
                        map.put(packageName, router);
                    }
                    break;
                }
            }
        }
        Iterator<String> iterator = map.keySet().iterator();
        List<Router> children = new ArrayList<Router>();
        while(iterator.hasNext()) {
            Router router = map.get(iterator.next());
            children.add(router);
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
