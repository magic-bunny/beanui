package org.december.beanui.plugin.builder;

import freemarker.template.Template;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;
import org.december.beanui.event.annotation.Created;
import org.december.beanui.plugin.bean.Element;
import org.december.beanui.plugin.tool.Builder;
import org.december.beanui.plugin.tool.RestReader;
import org.december.beanui.plugin.tool.exception.BuilderException;
import org.december.beanui.plugin.tool.exception.ComponentBuilderException;
import org.december.beanui.plugin.tool.util.ClassUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComponentBuilder extends Builder {
    private static RestReader pathBuilder;

    private Class templateClass;

    public ComponentBuilder(String name, ClassLoader classLoader, String distPath) {
        super(name, classLoader, distPath);
    }

    public Map run(Template template) throws BuilderException {
        Map result = new HashMap();
        try {
            Element component = new Element();
            List<Element> elements = new ArrayList<Element>();
            Field[] formFields = templateClass.getDeclaredFields();
            Annotation[] annotations = templateClass.getAnnotations();
            boolean isComponent = false;
            boolean isForm = false;
            component.setId(templateClass.getSimpleName());
            component.setType(Component.class.getSimpleName());
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == Component.class) {
                    component.setContent(ClassUtil.annotation2map(annotation));
                    isComponent = true;
                }
                if (annotation.annotationType() == Form.class) {
                    isForm = true;
                }
            }
            if (!isComponent) {
                throw new BuilderException(templateClass.getName() + " is not a Component!");
            }

            if (isForm) {
                Annotation[] formAnnotations = templateClass.getAnnotations();
                Element element = new Element();
                List<Map> events = new ArrayList<Map>();
                for (Annotation formAnnotation : formAnnotations) {
                    if (Created.class.getPackage().getName().equals(formAnnotation.annotationType().getPackage().getName())) {
                        events.add(buildEvent(formAnnotation));
                    }
                    if (formAnnotation.annotationType() == Form.class) {
                        String formId = templateClass.getSimpleName();
                        element.setId(formId);
                        element.setType(formAnnotation.annotationType().getSimpleName());
                        element.setContent(ClassUtil.annotation2map(formId, formAnnotation));
                        element.setChildren(buildForm(formId, templateClass));
                    }
                }
                element.setEvents(events);
                elements.add(element);
            } else {
                for (Field formField : formFields) {
                    Annotation[] formAnnotations = formField.getType().getAnnotations();
                    Element element = new Element();
                    List<Map> events = new ArrayList<Map>();
                    for (Annotation formAnnotation : formAnnotations) {
                        if (Created.class.getPackage().getName().equals(formAnnotation.annotationType().getPackage().getName())) {
                            events.add(buildEvent(formAnnotation));
                        }
                        if (formAnnotation.annotationType() == Form.class) {
                            String formId = formField.getName();
                            element.setId(formId);
                            element.setType(formAnnotation.annotationType().getSimpleName());
                            element.setContent(ClassUtil.annotation2map(formId, formAnnotation));
                            element.setChildren(buildForm(formId, formField.getType()));
                        }
                    }
                    element.setEvents(events);
                    elements.add(element);
                }
            }
            result.put("component", component);
            result.put("elements", elements);
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
            FormItem formItem = field.getAnnotation(FormItem.class);
            formItemElement.setId(field.getName());
            formItemElement.setType(FormItem.class.getName());
            String prop = "";
            Class type = null;
            if (formItem != null) {
                Map map = ClassUtil.annotation2map(formId, formItem);
                prop = formItem.prop();
                formItemElement.setContent(map);
            } else {
                Map map = new HashMap();
                map.put("label", "");
                formItemElement.setContent(map);
            }
            boolean isComponent = false;
            I18N i18n = field.getAnnotation(I18N.class);
            for (Annotation annotation : annotations) {
                String packageName = annotation.annotationType().getPackage().getName();
                if (Component.class.getPackage().getName().equals(packageName)) {
                    isComponent = true;
                    if (annotation.annotationType() != FormItem.class) {
                        type = annotation.annotationType();
                        element.setId(field.getName());
                        if (i18n != null) {
                            element.setI18n(clazz.getName() + "." + field.getName());
                        }
                        element.setType(type.getSimpleName());
                        if (annotation.annotationType() == Table.class) {
                            if (field.getType() == List.class) {
                                ParameterizedType pt = (ParameterizedType) field.getGenericType();
                                element.setChildren(buildTable(formId, (Class) pt.getActualTypeArguments()[0]));
                            } else {
                                element.setChildren(buildTable(formId, field.getType()));
                            }
                        }
                        Map map = ClassUtil.annotation2map(formId, annotation);
                        element.setContent(map);
                    }
                }
                if (Click.class.getPackage().getName().equals(packageName)) {
                    events.add(buildEvent(annotation));
                }
            }
            if (isComponent) {
                element.setEvents(events);
                boolean hasProp = false;
                if (!"".equals(prop)) {
                    for (Element f : list) {
                        if (prop.equals(f.getContent().get("prop"))) {
                            f.getChildren().add(element);
                            hasProp = true;
                            break;
                        }
                    }
                }
                if (!hasProp) {
                    formItemElement.setChildren(new ArrayList<Element>() {{
                        add(element);
                    }});
                    if (type != Option.class && type != TransferData.class) {
                        list.add(formItemElement);
                    }
                }
            }
        }
        return list;
    }

    private Map buildEvent(Annotation annotation) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Map map = eventAnnotation2map(annotation);
        map.put("type", annotation.annotationType().getSimpleName().toLowerCase());
        String path = (String) map.get("path");
        if ("".equals(path)) {
            Class clz = (Class) map.get("rest");
            String func = (String) map.get("func");
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
            I18N i18n = field.getAnnotation(I18N.class);
            Annotation[] annotations = field.getDeclaredAnnotations();
            Element element = new Element();
            element.setId(field.getName());
            if (i18n != null) {
                element.setI18n(clazz.getName() + "." + field.getName());
            }
            List<Element> children = new ArrayList<Element>();
            boolean isCompoent = false;
            for (Annotation annotation : annotations) {
                if (annotation.annotationType() == TableColum.class) {
                    isCompoent = true;
                    Map map = ClassUtil.annotation2map(formId, annotation);
                    if (map.get("label") == null || "".equals(map.get("label"))) {
                        map.put("label", field.getName());
                    }
                    if (map.get("prop") == null || "".equals(map.get("prop"))) {
                        map.put("prop", field.getName());
                    }
                    element.setType(annotation.annotationType().getSimpleName());
                    element.setContent(map);
                } else {
                    isCompoent = true;
                    Element child = new Element();
                    Map map = ClassUtil.annotation2map(formId, annotation);
                    child.setId(field.getName());
                    child.setType(annotation.annotationType().getSimpleName());
                    child.setContent(map);
                    children.add(child);
                }
            }
            if (isCompoent) {
                element.setChildren(children);
                list.add(element);
            }
        }
        return list;
    }

    private Map eventAnnotation2map(Annotation annotation) throws IllegalAccessException, NoSuchFieldException {
        String property = "memberValues";
        InvocationHandler invo = Proxy.getInvocationHandler(annotation);
        Field field = invo.getClass().getDeclaredField(property);
        field.setAccessible(true);
        Map map = (Map) field.get(invo);
        return map;
    }

    private Map<String, String> readSetting(Class clazz, String func, String path) {
        Map<String, String> results = new HashMap<String, String>();
        try {
            if (pathBuilder == null) {
                Class c = Class.forName("org.december.beanui.spring.ControllerReader");
                pathBuilder = (RestReader) (c.newInstance());
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

    public Class getTemplateClass() {
        return templateClass;
    }

    public void setTemplateClass(Class templateClass) {
        this.templateClass = templateClass;
    }
}
