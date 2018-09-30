package demo;

import org.december.beanui.plus.bean.Permission;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@SpringBootApplication
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }

    @GetMapping("/test")
    public Helloworld test() {
        Helloworld helloworld = new Helloworld();
        helloworld.setInput("test");
        return helloworld;
    }
}
