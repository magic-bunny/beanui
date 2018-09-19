package demo.controller;

import demo.view.LoginComponent;
import org.december.beanui.plus.bean.Permission;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class LoginController {
    @RequestMapping(value="/login",  method = RequestMethod.POST)
    public Permission login(@RequestBody LoginComponent loginComponent) {
        return null;
    }

    @RequestMapping(value="/logout",  method = RequestMethod.POST)
    public Permission logout(@RequestBody LoginComponent loginComponent) {
        return null;
    }

    @RequestMapping(value="/info",  method = RequestMethod.POST)
    public Permission info(@RequestBody LoginComponent loginComponent) {
        return null;
    }
}
