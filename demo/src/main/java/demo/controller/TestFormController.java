package demo.controller;

import demo.view.form.TestForm;
import demo.view.table.UserRow;
import demo.view.form.UserQueryForm;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class TestFormController {
    @RequestMapping(value="/demo",  method = RequestMethod.POST)
    public String test(@RequestBody TestForm testForm) {
        System.out.println(testForm.getUsername());
        System.out.println(testForm.getPassword());
        return "ok";
    }

    @RequestMapping(value="/demo2",  method = RequestMethod.GET)
    public UserQueryForm test2() {
        UserQueryForm userQuery = new UserQueryForm();
        List<UserRow> users = new ArrayList<UserRow>();
        UserRow user = new UserRow();
        user.setId(1);
        user.setName("Jack");
        user.setAge(20);
        user.setLastDate(new Date());
        users.add(user);

        user = new UserRow();
        user.setId(2);
        user.setName("Mary");
        user.setAge(25);
        user.setLastDate(new Date());
        users.add(user);

        user = new UserRow();
        user.setId(3);
        user.setName("eric");
        user.setAge(30);
        user.setLastDate(new Date());
        users.add(user);

        userQuery.setUsers(users);
        return userQuery;
    }

    @RequestMapping(value="/demo3",  method = RequestMethod.GET)
    public TestForm test3() {
        TestForm testForm = new TestForm();
        List<Map<String, String>> options = new ArrayList<Map<String, String>>();
        List<Map<String, String>> addressData = new ArrayList<Map<String, String>>();
        options.add(new HashMap<String, String>() {{
            put("label", "text1");
            put("value", "t1");
        }});
        options.add(new HashMap<String, String>() {{
            put("label", "text2");
            put("value", "t2");
        }});
        addressData.add(new HashMap<String, String>(){{
            put("key", "1");
            put("label", "address1");
        }});
        addressData.add(new HashMap<String, String>(){{
            put("key", "2");
            put("label", "address2");
        }});
        testForm.setOptions(options);
        testForm.setDetail("");
        testForm.setLastDate(new Date());
        testForm.setAddressData(addressData);
        testForm.setAddress(new ArrayList<String>() {{
            add("2");
        }});
        return testForm;
    }
}
