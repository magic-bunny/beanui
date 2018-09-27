package org.december.beanui.plugin.builder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import freemarker.template.Template;
import org.december.beanui.element.annotation.*;
import org.december.beanui.event.annotation.Click;
import org.december.beanui.event.annotation.Created;
import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.plugin.face.Builder;
import org.december.beanui.plugin.face.bean.Element;
import org.december.beanui.plugin.face.exception.BuilderException;
import org.december.beanui.plugin.face.exception.ComponentBuilderException;
import org.december.beanui.plugin.face.exception.SpringReaderException;
import org.december.beanui.plugin.face.util.ClassUtil;
import org.december.beanui.plugin.face.util.RestReader;
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

    public Map run(Template template) throws BuilderException {
        Map result = new HashMap();
        try {
            int[] defaultSubplot = {1, 1, 1};
            Element component = new Element();
            List<Element> elements = new ArrayList<Element>();
            Field[] formFields = this.getTemplateClass().getDeclaredFields();
            Annotation[] annotations = this.getTemplateClass().getAnnotations();
            boolean isComponent = false;
            boolean isForm = false;
            component.setId(this.getTemplateClass().getSimpleName());
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
                throw new BuilderException(this.getTemplateClass().getName() + " is not a Component!");
            }

            if (isForm) {
                Annotation[] formAnnotations = this.getTemplateClass().getAnnotations();
                Element element = buildForm(this.getTemplateClass().getSimpleName(), this.getTemplateClass(), formAnnotations);
                element.setSubplot(defaultSubplot);
                elements.add(element);
            } else {
                Set<Field> formFieldSet = new HashSet<Field>();
                for (Field field : formFields) {
                    field.setAccessible(true);
                    Subplot subplot = field.getAnnotation(Subplot.class);
                    if (field.getAnnotation(Dialog.class) != null || field.getAnnotation(Card.class) != null || field.getAnnotation(Carousel.class) != null) {
                        Element element = new Element();
                        if(subplot == null) {
                            element.setSubplot(defaultSubplot);
                        } else {
                            element.setSubplot(subplot.value());
                        }
                        Annotation[] othersAnnotations = field.getAnnotations();
                        for(Annotation annotation:othersAnnotations) {
                            if(annotation.annotationType() == Subplot.class) {
                                continue;
                            }
                            Map content = ClassUtil.annotation2map(annotation);
                            String[] datas = (String[])content.get("data");
                            if(datas.length > 0) {
                                for(String data:datas) {
                                    Field formField = this.getTemplateClass().getDeclaredField(data.startsWith("$")?data.substring(1):data);
                                    formField.setAccessible(true);
                                    formFieldSet.add(formField);
                                    element.setId(formField.getName());
                                    element.setType(annotation.annotationType().getSimpleName());
                                    Annotation[] formAnnotations = formField.getType().getAnnotations();
                                    Element formElement = buildForm(formField.getName(), formField.getType(), formAnnotations);
                                    if(element.getChildren() == null) {
                                        List<Element> otherElementChildren = new ArrayList<Element>();
                                        otherElementChildren.add(formElement);
                                        element.setChildren(otherElementChildren);
                                    } else {
                                        element.getChildren().add(formElement);
                                    }
                                }
                            } else {
                                Field formField = field;
                                formField.setAccessible(true);
                                formFieldSet.add(formField);
                                Annotation[] formAnnotations = formField.getType().getAnnotations();
                                element.setId(formField.getName());
                                element.setType(annotation.annotationType().getSimpleName());
                                Element formElement = buildForm(formField.getName(), formField.getType(), formAnnotations);
                                if(element.getChildren() == null) {
                                    List<Element> otherElementChildren = new ArrayList<Element>();
                                    otherElementChildren.add(formElement);
                                    element.setChildren(otherElementChildren);
                                } else {
                                    element.getChildren().add(formElement);
                                }
                            }
                            element.setType(annotation.annotationType().getSimpleName());
                            content.remove(":data");
                            content.remove("data");
                            element.setContent(content);
                        }
                        elements.add(element);
                    }
                }

                for (Field formField : formFields) {
                    formField.setAccessible(true);
                    Subplot subplot = formField.getAnnotation(Subplot.class);
                    if(formField.getType().getAnnotation(Form.class) != null && !formFieldSet.contains(formField)) {
                        Annotation[] formAnnotations = formField.getType().getAnnotations();
                        Element element = buildForm(formField.getName(), formField.getType(), formAnnotations);
                        if(subplot == null) {
                            element.setSubplot(defaultSubplot);
                        } else {
                            element.setSubplot(subplot.value());
                        }
                        elements.add(element);
                    }
                }
            }
            component.setChildren(elements);
            result.put("component", component);
        } catch (Exception e) {
            throw new ComponentBuilderException(e);
        }
        return result;
    }

    private Element buildForm(String formId, Class formType, Annotation[] formAnnotations) throws SpringReaderException, IllegalAccessException, NoSuchFieldException, JsonProcessingException, BuilderException {
        if(formType.getAnnotation(Form.class) == null) {
            throw new BuilderException(formType.getName() + " is note a Form");
        }

        Element element = new Element();
        List<Map> events = new ArrayList<Map>();
        for (Annotation formAnnotation : formAnnotations) {
            if (Created.class.getPackage().getName().equals(formAnnotation.annotationType().getPackage().getName())) {
                events.add(buildEvent(formAnnotation));
            }
            if (formAnnotation.annotationType() == Form.class) {
                element.setId(formId);
                element.setType(formAnnotation.annotationType().getSimpleName());
                Map map = ClassUtil.annotation2map(formAnnotation);
                element.setChildren(buildFormChildren(formId, formType, map));
                element.setContent(map);
            }
        }
        if(events.size() == 0) {
            Map defaultEvent = new HashMap();
            defaultEvent.put("type", "placeholder");
            events.add(defaultEvent);
        }
        element.setEvents(events);
        return element;
    }

    private List<Element> buildFormChildren(String formId, Class clazz, Map formContent) throws SpringReaderException, NoSuchFieldException, IllegalAccessException, JsonProcessingException {
        Field[] fields = clazz.getDeclaredFields();
        Field.setAccessible(fields, true);
        List<Element> list = new ArrayList<Element>();
        ObjectMapper objectMapper = new ObjectMapper();
        boolean hasRules = false;
        for (Field field : fields) {
            final Element element = new Element();
            Element formItemElement = new Element();
            List<Map> events = new ArrayList<Map>();
            List<Map> methods = new ArrayList<Map>();
            Annotation[] annotations = field.getAnnotations();
            FormItem formItem = field.getAnnotation(FormItem.class);
            formItemElement.setId(field.getName());
            formItemElement.setType(FormItem.class.getName());
            String prop = "";
            Class type = null;
            if (formItem != null) {
                Map map = ClassUtil.annotation2map(formItem);
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
                        if(annotation.annotationType() == Badge.class) {
                            element.setBadge(ClassUtil.annotation2map(annotation));
                        } else if (annotation.annotationType() == Tooltip.class) {
                            element.setTooltip(ClassUtil.annotation2map(annotation));
                        } else {
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
                            Map map = ClassUtil.annotation2map(annotation);
                            element.setContent(map);
                        }
                    }
                }
                if (Click.class.getPackage().getName().equals(packageName)) {
                    events.add(buildEvent(annotation));
                }
            }

            if (isComponent) {
                if(events.size() == 0) {
                    Map defaultEvent = new HashMap();
                    defaultEvent.put("type", "placeholder");
                    events.add(defaultEvent);
                }
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
                Map<String, String> results = readSetting(controllerClazz, func);
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
            if (tableColum == null) {
                continue;
            }
            Map map = ClassUtil.annotation2map(tableColum);
            String prop = tableColum.prop();
            tableColumnElement.setContent(map);
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
                    if (annotation.annotationType() != TableColum.class) {
                        isCompoent = true;
                        if(annotation.annotationType() == Badge.class) {
                            element.setBadge(ClassUtil.annotation2map(annotation));
                        } else if(annotation.annotationType() == Tooltip.class) {
                            element.setTooltip(ClassUtil.annotation2map(annotation));
                        } else {
                            isWord = false;
                            Map content = ClassUtil.annotation2map(annotation);
                            element.setId(field.getName());
                            element.setType(annotation.annotationType().getSimpleName());
                            element.setContent(content);
                            if (i18n != null) {
                                element.setI18n(clazz.getName() + "." + field.getName());
                            }
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
                Map content = new HashMap();
                content.put("tag", "span");
                content.put("label", "");
                element.setContent(content);
                if (i18n != null) {
                    element.setI18n(clazz.getName() + "." + field.getName());
                }
            }

            if (isCompoent) {
                if(events.size() == 0) {
                    Map defaultEvent = new HashMap();
                    defaultEvent.put("type", "placeholder");
                    events.add(defaultEvent);
                }
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

    private Map<String, String> readSetting(Class clazz, String func) throws SpringReaderException {
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
}