package demo.view.component;

import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.JsonEditor;

import java.util.HashMap;
import java.util.Map;

@Component
@Form
public class JsonEditorComponent {
    @JsonEditor
    private Map json = new HashMap() {{
        put("aaaaaa", "111111");
        put("bbbbbb", "111111");
        put("cccccc", "111111");
        put("dddddd", "111111");
    }};

    public Map getJson() {
        return json;
    }

    public void setJson(Map json) {
        this.json = json;
    }
}
