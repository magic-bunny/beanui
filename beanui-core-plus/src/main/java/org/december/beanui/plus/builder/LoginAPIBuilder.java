package org.december.beanui.plus.builder;

import freemarker.template.Template;
import org.december.beanui.plugin.face.Builder;
import org.december.beanui.plugin.face.exception.BuilderException;
import org.december.beanui.plugin.face.exception.SpringReaderException;
import org.december.beanui.plugin.face.util.RestReader;
import org.december.beanui.plus.element.annotation.Login;
import org.december.beanui.plus.element.annotation.Logout;
import org.december.beanui.plus.element.annotation.Userinfo;

import java.util.HashMap;
import java.util.Map;

public class LoginAPIBuilder extends Builder {

    private static RestReader pathBuilder;
    private Login login;
    private Logout logout;
    private Userinfo userinfo;

    public Map run(Template template) throws BuilderException {
        Map map = new HashMap();
        try {
            if(login != null) {
                Map<String, String> results = readSetting(login.rest(), login.func());
                map.put("loginURI", results.get("path"));
            }
            if(logout != null) {
                Map<String, String> results = readSetting(logout.rest(), logout.func());
                map.put("logoutURI", results.get("path"));
            }
            if(userinfo != null) {
                Map<String, String> results = readSetting(userinfo.rest(), userinfo.func());
                map.put("userinfoURI", results.get("path"));
            }
        } catch (SpringReaderException e) {
            throw new BuilderException(e);
        }
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

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Logout getLogout() {
        return logout;
    }

    public void setLogout(Logout logout) {
        this.logout = logout;
    }

    public Userinfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(Userinfo userinfo) {
        this.userinfo = userinfo;
    }
}
