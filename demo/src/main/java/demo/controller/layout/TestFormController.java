package demo.controller.layout;

import demo.view.layout.card.TestChart;
import demo.view.layout.card.TestForm;
import demo.view.layout.test2.UserQueryForm;
import demo.view.layout.test2.UserRow;
import org.december.beanui.element.annotation.Cascader;
import org.december.beanui.element.annotation.Select;
import org.december.beanui.element.annotation.Transfer;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
        user.setName("Jack");
        user.setAge(20);
        user.setLastDate(new Date());
        users.add(user);

        user = new UserRow();
        user.setName("Mary");
        user.setAge(25);
        user.setLastDate(new Date());
        users.add(user);

        user = new UserRow();
        user.setName("eric");
        user.setAge(30);
        user.setLastDate(new Date());
        users.add(user);

        userQuery.setUsers(users);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return userQuery;
    }

    @RequestMapping(value="/demo3",  method = RequestMethod.GET)
    public TestForm test3() {
        TestForm testForm = new TestForm();

        List<UserRow> users = new ArrayList<UserRow>();
        UserRow user = new UserRow();
        user.setName("Jack");
        user.setAge(20);
        user.setLastDate(new Date());
        users.add(user);

        user = new UserRow();
        user.setName("Mary");
        user.setAge(25);
        user.setLastDate(new Date());
        users.add(user);

        user = new UserRow();
        user.setName("eric");
        user.setAge(30);
        user.setLastDate(new Date());
        users.add(user);

        testForm.setUserData(users);

        List<Select.Option> options = new ArrayList<Select.Option>();
        List<Transfer.Data> addressData = new ArrayList<Transfer.Data>();
        options.add(new Select.Option("t1", "text1"));
        options.add(new Select.Option("t2", "text2"));

        addressData.add(new Transfer.Data("1", "address1"));
        addressData.add(new Transfer.Data("2", "address2"));

        List<Cascader.Option> cascaderOptions = new ArrayList<Cascader.Option>();
        List<Cascader.Option> cascaderOptions2 = new ArrayList<Cascader.Option>();
        cascaderOptions2.add(new Cascader.Option("3", "aa1"));
        cascaderOptions2.add(new Cascader.Option("4", "aa2"));
        cascaderOptions.add(new Cascader.Option("1", "a1", cascaderOptions2));
        cascaderOptions.add(new Cascader.Option("2", "a2", cascaderOptions2));
        testForm.setCascaderOptions(cascaderOptions);
        String[] casscader = {"1", "3"};
        testForm.setCascader(casscader);

        testForm.setOptions(options);
        testForm.setDetail("");
        testForm.setLastDate(new Date());
        testForm.setAddressData(addressData);
        testForm.setAddress(new ArrayList<String>() {{
            add("2");
        }});

        TestChart testChart = new TestChart();
        int[] line1 = {743,465,665,3123,665};
        int[] line2 = {3443,656,3443,2323,46};
        String[] x = {"Mon","Tue","Wed","Thu","Fri","layout"};
        testChart.setLine1(line1);
        testChart.setLine2(line2);
        testChart.setX(x);
        testForm.setTestChart(testChart);
        return testForm;
    }

    @RequestMapping(value="/demo4",  method = RequestMethod.POST)
    public UserQueryForm test4(@RequestBody UserQueryForm userQueryForm) throws InterruptedException {
        List<UserRow> list = userQueryForm.getUser();
        if(list == null) {
            System.out.println("No rows are selected.");
        } else {
            for(UserRow userRow:list) {
                System.out.println(userRow.getName());
            }
        }
        return test2();
    }
}
