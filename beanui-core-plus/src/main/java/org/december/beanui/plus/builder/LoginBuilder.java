package org.december.beanui.plus.builder;

import freemarker.template.Template;
import org.december.beanui.i18n.annotation.I18N;
import org.december.beanui.plugin.bean.Element;
import org.december.beanui.plugin.builder.Builder;
import org.december.beanui.plugin.exception.BuilderException;
import org.december.beanui.plugin.exception.SpringReaderException;
import org.december.beanui.plugin.util.RestReader;
import org.december.beanui.plus.element.annotation.Login;
import org.december.beanui.plus.element.annotation.Logout;
import org.december.beanui.plus.element.annotation.Userinfo;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class LoginBuilder extends Builder {

    public Map run(Template template) throws BuilderException, SpringReaderException {
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
            I18N i18n = field.getAnnotation(I18N.class);
            if(i18n != null) {
                element.setI18n(super.getTemplateClass().getName() + "." + elementId);
            }
            Login.Title title = field.getAnnotation(Login.Title.class);
            if(title != null) {
                content.put("label", title.label());
                result.put("title", element);
            }
            Login.Username username = field.getAnnotation(Login.Username.class);
            if(username != null) {
                content.put("label", username.label());
                result.put("username", element);
            }
            Login.Password password = field.getAnnotation(Login.Password.class);
            if(password != null) {
                content.put("label", password.label());
                result.put("password", element);
            }
            Login.Button button = field.getAnnotation(Login.Button.class);
            if(button != null) {
                content.put("label", button.label());
                result.put("button", element);
            }
            Login.ThirdpartyButton thirdpartyButton = field.getAnnotation(Login.ThirdpartyButton.class);
            if(thirdpartyButton != null) {
                content.put("label", thirdpartyButton.label());
                result.put("thirdpartyButton", element);
            }
            Login.ThirdpartyTitle thirdpartyTitle = field.getAnnotation(Login.ThirdpartyTitle.class);
            if(thirdpartyTitle != null) {
                content.put("label", thirdpartyTitle.label());
                result.put("thirdpartyTitle", element);
            }
            Login.ThirdpartyTips thirdpartyTips = field.getAnnotation(Login.ThirdpartyTips.class);
            if(thirdpartyTips != null) {
                content.put("label", thirdpartyTips.label());
                result.put("thirdpartyTips", element);
            }
            element.setContent(content);
        }
        result.put("login", loginElement);
        return result;
    }
}
