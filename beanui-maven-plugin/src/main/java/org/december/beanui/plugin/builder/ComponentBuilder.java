package org.december.beanui.plugin.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Template;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;
import org.december.beanui.event.annotation.Created;
import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.plugin.bean.Element;
import org.december.beanui.plugin.tool.Builder;
import org.december.beanui.plugin.tool.RestReader;
import org.december.beanui.plugin.tool.exception.BuilderException;
import org.december.beanui.plugin.tool.exception.ComponentBuilderException;
import org.december.beanui.plugin.tool.exception.SpringReaderException;
import org.december.beanui.plugin.tool.util.ClassUtil;
import org.december.beanui.rule.annotation.Rule;
import org.december.beanui.rule.annotation.Rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.util.*;

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
                        Map map = ClassUtil.annotation2map(formId, formAnnotation);
                        element.setChildren(buildForm(formId, templateClass, map));
                        element.setContent(map);
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
                            Dialog dialog = formField.getType().getAnnotation(Dialog.class);
                            if(dialog != null) {
                                String formId = formField.getName();
                                element.setId(formId);
                                element.setType(Dialog.class.getSimpleName());
                                element.setContent(ClassUtil.annotation2map(formId, dialog));

                                final Element formElement = new Element();
                                formElement.setId(formId);
                                formElement.setType(formAnnotation.annotationType().getSimpleName());
                                Map map = ClassUtil.annotation2map(formId, formAnnotation);
                                formElement.setChildren(buildForm(formId, formField.getType(), map));
                                formElement.setContent(map);
                                element.setChildren(new ArrayList<Element>() {{
                                    add(formElement);
                                }});
                            } else {
                                String formId = formField.getName();
                                element.setId(formId);
                                element.setType(formAnnotation.annotationType().getSimpleName());
                                Map map = ClassUtil.annotation2map(formId, formAnnotation);
                                element.setChildren(buildForm(formId, formField.getType(), map));
                                element.setContent(map);
                            }
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

    private List<Element> buildForm(String formId, Class clazz, Map formContent) throws SpringReaderException, NoSuchFieldException, IllegalAccessException, JsonProcessingException {
        Field[] fields = clazz.getDeclaredFields();
        Field.setAccessible(fields, true);
        List<Element> list = new ArrayList<Element>();
        ObjectMapper objectMapper = new ObjectMapper();
        boolean hasRules = false;
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
                map.put("prop", field.getName());
                formItemElement.setContent(map);
            }
            boolean isComponent = false;
            I18N i18n = field.getAnnotation(I18N.class);
            final Rule rule = field.getAnnotation(Rule.class);
            if(rule != null) {
                hasRules = true;
                List<Map> ruleList = new ArrayList<Map>();
                Map map = annotation2map(rule);
                ruleList.add(map);
                formItemElement.setRules(objectMapper.writeValueAsString(ruleList));
            }
            Rules rules = field.getAnnotation(Rules.class);
            if(rules != null) {
                hasRules = true;
                List<Map> ruleList = new ArrayList<Map>();
                for(Rule object:rules.value()) {
                    Map map = annotation2map(object);
                    ruleList.add(map);
                }
                formItemElement.setRules(objectMapper.writeValueAsString(ruleList));
            }
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
                    list.add(formItemElement);
                }
            }
        }
        if(hasRules) {
            formContent.put(":rules", formId + "_rules");
        }
        return list;
    }

    private Map buildEvent(Annotation annotation) throws SpringReaderException {
        Map map = new HashMap();
        try {
            map = annotation2map(annotation);
            String path = (String) map.get("path");
            if ("".equals(path)) {
                Class clz = (Class) map.get("rest");
                String func = (String) map.get("func");
                Class controllerClazz = this.getClassLoader().loadClass(clz.getName());
                Map<String, String> results = readSetting(controllerClazz, func, path);
                map.putAll(results);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return map;
    }

    private List<Element> buildTable(String formId, Class clazz) throws SpringReaderException {
        Field[] fields = clazz.getDeclaredFields();
        Field.setAccessible(fields, true);
        List<Element> list = new ArrayList<Element>();

        for (Field field : fields) {
            final Element tableColumnElement = new Element();
            List<Map> events = new ArrayList<Map>();
            tableColumnElement.setType(TableColum.class.getSimpleName());
            tableColumnElement.setId(field.getName());
            TableColum tableColum = field.getAnnotation(TableColum.class);
            String prop = "";
            if (tableColum != null) {
                Map map = ClassUtil.annotation2map(formId, tableColum);
                prop = tableColum.prop();
                tableColumnElement.setContent(map);
            } else {
                Map map = new HashMap();
                map.put("label", "");
                tableColumnElement.setContent(map);
            }
            I18N i18n = field.getAnnotation(I18N.class);
            Annotation[] annotations = field.getDeclaredAnnotations();

            tableColumnElement.setId(field.getName());
            if (i18n != null) {
                tableColumnElement.setI18n(clazz.getName() + "." + field.getName());
            }
            boolean isCompoent = false;
            final Element element = new Element();
            boolean isWord = true;
            for (Annotation annotation : annotations) {
                String packageName = annotation.annotationType().getPackage().getName();
                if (Component.class.getPackage().getName().equals(packageName)) {
                    if (annotation.annotationType() != TableColum.class && annotation.annotationType() != I18N.class) {
                        isWord = false;
                        isCompoent = true;
                        Map map = ClassUtil.annotation2map(formId, annotation);
                        element.setId(field.getName());
                        element.setType(annotation.annotationType().getSimpleName());
                        element.setContent(map);
                        if (i18n != null) {
                            element.setI18n(clazz.getName() + "." + field.getName());
                        }
                    }
                }
                if (Click.class.getPackage().getName().equals(packageName)) {
                    events.add(buildEvent(annotation));
                }
            }

            if(isWord) {
                isCompoent = true;
                element.setId(field.getName());
                element.setType("Element");
                element.setTag("span");
                element.setContent(new HashMap());
                if (i18n != null) {
                    element.setI18n(clazz.getName() + "." + field.getName());
                }
            }

            if (isCompoent) {
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
                    tableColumnElement.setChildren(new ArrayList<Element>() {{
                        add(element);
                    }});
                    list.add(tableColumnElement);
                }

            }
        }
        return list;
    }

    private Map annotation2map(Annotation annotation) throws IllegalAccessException, NoSuchFieldException {
        String property = "memberValues";
        InvocationHandler invo = Proxy.getInvocationHandler(annotation);
        Field field = invo.getClass().getDeclaredField(property);
        field.setAccessible(true);
        Map map = (Map) field.get(invo);
        return map;
    }

    private Map<String, String> readSetting(Class clazz, String func, String path) throws SpringReaderException {
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
