package org.december.beanui.plus.builder;

import freemarker.template.Template;
import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.plugin.face.Builder;
import org.december.beanui.plugin.face.bean.Element;
import org.december.beanui.plugin.face.exception.BuilderException;
import org.december.beanui.plugin.face.util.ClassUtil;
import org.december.beanui.plus.element.annotation.Login;
import org.december.beanui.plus.element.annotation.Logout;
import org.december.beanui.plus.element.annotation.Userinfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LoginBuilder extends Builder {

    public Map run(Template template) throws BuilderException {
        if(super.getTemplateClass() == null) {
            throw new BuilderException("No builder template class can be found");
        }
        if(super.getDistPath() == null || "".equals(super.getDistPath())) {
            super.setDistPath("${workPath}/src/views/beanui/" + super.getTemplateClass().getName() + ".vue");
        }
        Map result = new HashMap();
        Element loginElement = new Element();

        Login login = (Login)super.getTemplateClass().getAnnotation(Login.class);
        Logout logout = (Logout)super.getTemplateClass().getAnnotation(Logout.class);
        Userinfo userinfo = (Userinfo)super.getTemplateClass().getAnnotation(Userinfo.class);
        if(login == null) {
            throw new BuilderException(super.getTemplateClass().getName() + " is not a Login!");
        }

        LoginAPIBuilder loginAPIBuilder = new LoginAPIBuilder();
        loginAPIBuilder.setLogin(login);
        loginAPIBuilder.setLogout(logout);
        loginAPIBuilder.setUserinfo(userinfo);
        loginAPIBuilder.setTemplateName("LoginAPI.ftl");
        loginAPIBuilder.setDistPath("${workPath}/src/api/login.js");
        loginAPIBuilder.create();

        String formId = super.getTemplateClass().getSimpleName();
        loginElement.setId(formId);
        Field[] fields = super.getTemplateClass().getDeclaredFields();
        for(Field field:fields) {
            Map content = new HashMap();
            String elementId = field.getName();
            Element element = new Element();
            element.setId(elementId);
            field.setAccessible(true);
            Annotation[] annotations = field.getAnnotations();
            I18N i18n = field.getAnnotation(I18N.class);
            if(i18n != null) {
                element.setI18n(super.getTemplateClass().getName() + "." + elementId);
            }
            for(Annotation annotation:annotations) {
                if(annotation.annotationType() != I18N.class) {
                    Map map = ClassUtil.annotation2map(annotation);
                    content.put("label", map.get("label"));
                    result.put(annotation.annotationType().getSimpleName(), element);
                }
            }
            element.setContent(content);
        }
        result.put("Login", loginElement);
        return result;
    }
}
