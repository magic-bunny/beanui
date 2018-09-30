package demo.controller;

import demo.view.LoginComponent;
import org.december.beanui.plus.bean.Permission;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PermissionController {
    @RequestMapping(value="/login",  method = RequestMethod.POST)
    public Permission login(@RequestBody LoginComponent loginComponent) {
        Permission permission = new Permission();
        if("admin".equals(loginComponent.getUsername())) {
            permission.setToken("admin");
        } else if("editor".equals(loginComponent.getUsername())) {
            permission.setToken("editor");
        } else {
            permission.setMessage("No user named " + loginComponent.getUsername());
        }
        return permission;
    }

    @RequestMapping(value="/logout",  method = RequestMethod.POST)
    public Permission logout() {
        return null;
    }

    @RequestMapping(value="/info",  method = RequestMethod.GET)
    public Permission info(@RequestParam("token") String token) {
        Permission permission = new Permission();
        if("admin".equals(token)) {
            String[] roles = {"admin"};
            permission.setRoles(roles);
            permission.setToken("admin");
            permission.setIntroduction("我是超级管理员");
            permission.setAvatar("https://img.zcool.cn/community/01ec7d55410392000001e71bb2f340.jpg@1280w_1l_2o_100sh.jpg");
            permission.setName("Super Admin");
        } else if("editor".equals(token)) {
            String[] roles = {"editor"};
            permission.setRoles(roles);
            permission.setToken(token);
            permission.setIntroduction("");
            permission.setAvatar("https://img.zcool.cn/community/01c87a55410392000001e71bb21f65.jpg@1280w_1l_2o_100sh.webp");
            permission.setName("Editor");
        } else {
            permission.setAvatar("http://pic.51yuansu.com/pic2/cover/00/31/31/5810af000d5d5_610.jpg");
        }
        return permission;
    }
}
