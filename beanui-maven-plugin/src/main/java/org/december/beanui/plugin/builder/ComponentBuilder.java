package org.december.beanui.plugin.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;
import org.december.beanui.event.annotation.Created;
import org.december.beanui.plugin.bean.Element;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.exception.ComponentBuilderException;
import org.december.beanui.plugin.util.ClassUtil;
import org.december.beanui.tool.RestReader;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.*;

public class ComponentBuilder extends Builder {
    private static RestReader pathBuilder;

    public ComponentBuilder(String name, Class clazz, ClassLoader classLoader, String distPath) throws IOException, TemplateException, NoSuchFieldException, IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException {
        super(name, clazz, classLoader, distPath);
    }

    public Object run(Template template, Class clazz) throws BuilderException {
        Map result = new HashMap();
        try {
            List<Element> elements = new ArrayList<Element>();
            Map<String, String> datas = new HashMap<String, String>();
            Field[] formFields = clazz.getDeclaredFields();

            for(Field formField:formFields) {
                Annotation[] formAnnotations = formField.getType().getAnnotations();
                Element element = new Element();
                List<Map> events = new ArrayList<Map>();
                for (Annotation formAnnotation : formAnnotations) {
                    if(Created.class.getPackage().getName().equals(formAnnotation.annotationType().getPackage().getName())) {
                        events.add(buildEvent(formAnnotation));
                    }
                    if(formAnnotation.annotationType() == Form.class) {
                        String formId = formField.getName();
                        element.setId(formId);
                        element.setType(formAnnotation.annotationType().getSimpleName());
                        element.setContent(ClassUtil.annotation2map(formId, formAnnotation));
                        element.setChildren(buildForm(formId, formField.getType()));
                        String data = buildFormData(formField.getType());
                        datas.put(formField.getName(), data);
                    }
                }
                element.setEvents(events);
                elements.add(element);
            }
            result.put("elements", elements);
            result.put("datas", datas);
        } catch (Exception e) {
            throw new ComponentBuilderException(e);
        }
        return result;
    }

    private List<Element> buildForm(String formId, Class clazz) throws NoSuchFieldException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException {
        Field[] fields = clazz.getDeclaredFields();
        Field.setAccessible(fields, true);
        List<Element> list = new ArrayList<Element>();
        for (Field field : fields) {
            final Element element = new Element();
            Element formItemElement = new Element();
            List<Map> events = new ArrayList<Map>();
            Annotation[] annotations = field.getDeclaredAnnotations();
            FormItem formItem = (FormItem)field.getAnnotation(FormItem.class);
            formItemElement.setId(field.getName());
            formItemElement.setType(FormItem.class.getName());
            String prop = "";
            Class type = null;
            if(formItem != null) {
                Map map = ClassUtil.annotation2map(formId, formItem);
                prop = formItem.prop();
                formItemElement.setContent(map);
            } else {
                Map map = new HashMap();
                map.put("label", "");
                formItemElement.setContent(map);
            }
            for (Annotation annotation : annotations) {
                String packageName = annotation.annotationType().getPackage().getName();
                if(Component.class.getPackage().getName().equals(packageName)) {
                    if(annotation.annotationType() != FormItem.class) {
                        type = annotation.annotationType();
                        element.setId(field.getName());
                        element.setType(type.getSimpleName());
                        if(annotation.annotationType() == Table.class) {
                            ParameterizedType pt = (ParameterizedType)field.getGenericType();
                            element.setChildren(buildTable(formId, (Class)pt.getActualTypeArguments()[0]));
                        }
                        Map map = ClassUtil.annotation2map(formId, annotation);
                        element.setContent(map);
                    }
                }
                if(Click.class.getPackage().getName().equals(packageName)) {
                    events.add(buildEvent(annotation));
                }
            }
            element.setEvents(events);
            boolean hasProp = false;
            if(!"".equals(prop)) {
                for(Element f:list) {
                    if(prop.equals(f.getContent().get("prop"))) {
                        f.getChildren().add(element);
                        hasProp = true;
                        break;
                    }
                }
            }
            if(!hasProp) {
                formItemElement.setChildren(new ArrayList<Element>() {{
                    add(element);
                }});
                if(type != Option.class && type != TransferData.class) {
                    list.add(formItemElement);
                }
            }
        }
        return list;
    }

    private Map buildEvent(Annotation annotation) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Map map = eventAnnotation2map(annotation);
        map.put("type", annotation.annotationType().getSimpleName().toLowerCase());
        String path = (String)map.get("path");
        if("".equals(path)) {
            Class clz = (Class)map.get("rest");
            String func = (String)map.get("func");
            Class controllerClazz = this.getClassLoader().loadClass(clz.getName());
            Map<String, String> results = readSetting(controllerClazz, func, path);
            map.put("path", results.get("path"));
            map.put("method", results.get("method"));
        }
        return map;
    }

    private List<Element> buildTable(String formId, Class clazz) {
        Field[] fields = clazz.getDeclaredFields();
        Field.setAccessible(fields, true);
        List<Element> list = new ArrayList<Element>();
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            Element element = new Element();
            element.setId(field.getName());
            List<Element> children = new ArrayList<Element>();
            for (Annotation annotation : annotations) {
                if(annotation.annotationType() == TableColum.class) {
                    Map map = ClassUtil.annotation2map(formId, annotation);
                    if(map.get("label") == null || "".equals(map.get("label"))) {
                        map.put("label", field.getName());
                    }
                    if(map.get("prop") == null || "".equals(map.get("prop"))) {
                        map.put("prop", field.getName());
                    }
                    element.setType(annotation.annotationType().getSimpleName());
                    element.setContent(map);
                } else {
                    Element child = new Element();
                    Map map = ClassUtil.annotation2map(formId, annotation);
                    child.setId(field.getName());
                    child.setType(annotation.annotationType().getSimpleName());
                    child.setContent(map);
                    children.add(child);
                }
            }
            element.setChildren(children);
            list.add(element);
        }
        return list;
    }

    private String buildFormData(Class clazz) throws JsonProcessingException {
        Field[] fields = clazz.getDeclaredFields();
        Map<String, Object> results = new HashMap<String, Object>();
        Field.setAccessible(fields, true);
        for (Field field : fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if(annotation.annotationType().getPackage().getName().equals(Component.class.getPackage().getName())) {
                    if(annotation.annotationType() == Option.class) {
                        results.put(field.getName(), new ArrayList());
                    } else if(annotation.annotationType() == Table.class) {
                        results.put(field.getName(), new ArrayList());
                    } else if(annotation.annotationType() == TransferData.class) {
                        results.put(field.getName(), new ArrayList());
                    } else {
                        results.put(field.getName(), "");
                    }
                    break;
                }
            }
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(results);
        return json;
    }

    private Map eventAnnotation2map(Annotation annotation) throws IllegalAccessException, NoSuchFieldException {
        String property = "memberValues";
        InvocationHandler invo = Proxy.getInvocationHandler(annotation);
        Field field = invo.getClass().getDeclaredField(property);
        field.setAccessible(true);
        Map map = (Map)field.get(invo);
        return map;
    }

    private Map<String, String> readSetting(Class clazz, String func, String path) {
        Map<String, String> results = new HashMap<String, String>();
        try {
            if(pathBuilder == null) {
                Class c = Class.forName("org.december.beanui.spring.ControllerReader");
                pathBuilder = (RestReader)(c.newInstance());
                results = pathBuilder.readResourceSetting(clazz, func);
            } else {
                results = pathBuilder.readResourceSetting(clazz, func);
            }
        } catch (ClassNotFoundException e) {
            return results;
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return results;
    }
}
