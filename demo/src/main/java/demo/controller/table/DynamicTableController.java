package demo.controller.table;

import demo.view.DynamicTableComponent;
import demo.view.table.DynamicRow;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/dynamic-table")
public class DynamicTableController {
    @RequestMapping(value="/init",  method = RequestMethod.GET)
    public DynamicTableComponent init() {
        DynamicTableComponent dynamicTableComponent = new DynamicTableComponent();

        // init checkbox1
        List<String> checkbox1 = new ArrayList<String>();
        checkbox1.add("banana");
        checkbox1.add("orange");
        dynamicTableComponent.setCheckbox1(checkbox1);

        // init checkbox2
        List<String> checkbox2 = new ArrayList<String>();
        checkbox2.add("apple");
        checkbox2.add("orange");
        dynamicTableComponent.setCheckbox2(checkbox2);

        // init checkboxData1
        List<Map> checkboxData1 = new ArrayList<Map>();
        checkboxData1.add(new HashMap() {{
            put("key", "apple");
            put("label", "apple");
        }});
        checkboxData1.add(new HashMap() {{
            put("key", "banana");
            put("label", "banana");
        }});
        checkboxData1.add(new HashMap() {{
            put("key", "orange");
            put("label", "orange");
        }});
        dynamicTableComponent.setCheckboxData1(checkboxData1);

        // init checkboxData2
        List<Map> checkboxData2 = new ArrayList<Map>();
        checkboxData2.add(new HashMap() {{
            put("key", "apple");
            put("label", "apple");
        }});
        checkboxData2.add(new HashMap() {{
            put("key", "banana");
            put("label", "banana");
        }});
        checkboxData2.add(new HashMap() {{
            put("key", "orange");
            put("label", "orange");
        }});
        dynamicTableComponent.setCheckboxData2(checkboxData2);

        //init table1 data
        List<DynamicRow> dynamicRows = new ArrayList<DynamicRow>();
        DynamicRow dynamicRow = new DynamicRow();
        dynamicRow.setFruitName("fruit-1");
        dynamicRow.setApple("apple-10 ");
        dynamicRow.setBanana("banana-10 ");
        dynamicRow.setOrange("orange-10 ");
        dynamicRows.add(dynamicRow);
        dynamicRow = new DynamicRow();
        dynamicRow.setFruitName("fruit-2");
        dynamicRow.setApple("apple-20 ");
        dynamicRow.setBanana("banana-20 ");
        dynamicRow.setOrange("orange-20 ");
        dynamicRows.add(dynamicRow);
        dynamicTableComponent.setTableData1(dynamicRows);

        //init table2 data
        List<DynamicRow> dynamicRows2 = new ArrayList<DynamicRow>();
        dynamicRow = new DynamicRow();
        dynamicRow.setFruitName("fruit-1");
        dynamicRow.setApple("apple-10 ");
        dynamicRow.setBanana("banana-10 ");
        dynamicRow.setOrange("orange-10 ");
        dynamicRows2.add(dynamicRow);
        dynamicRow = new DynamicRow();
        dynamicRow.setFruitName("fruit-2");
        dynamicRow.setApple("apple-20 ");
        dynamicRow.setBanana("banana-20 ");
        dynamicRow.setOrange("orange-20 ");
        dynamicRows2.add(dynamicRow);
        dynamicTableComponent.setTableData2(dynamicRows2);
        return dynamicTableComponent;
    }
}
