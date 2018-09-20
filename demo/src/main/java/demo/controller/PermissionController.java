package demo.controller;

import demo.view.LoginComponent;
import org.december.beanui.plus.bean.Permission;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class PermissionController {
    @RequestMapping(value="/login",  method = RequestMethod.POST)
    public Permission login(@RequestBody LoginComponent loginComponent) {
        if("admin".equals(loginComponent.getUsername()) && "111111".equals(loginComponent.getPassword())) {
            Permission permission = new Permission();
            permission.setToken("admin");
            return permission;
        } else {
            return null;
        }
    }

    @RequestMapping(value="/logout",  method = RequestMethod.POST)
    public Permission logout() {
        return null;
    }

    @RequestMapping(value="/info",  method = RequestMethod.GET)
    public Permission info(@RequestParam("token") String token) {
        System.out.println(token);
        Permission permission = new Permission();
        String[] roles = {"admin"};
        permission.setRoles(roles);
        permission.setToken("admin");
        permission.setIntroduction("我是超级管理员");
        permission.setAvatar("https://img.zcool.cn/community/01c87a55410392000001e71bb21f65.jpg@1280w_1l_2o_100sh.webp");
        permission.setName("Super Admin");
        return permission;
    }
}
