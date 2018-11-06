package demo.view.component;

import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.WordEditor;

@Component
@Form
public class WordEditorComponent {
    @WordEditor
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
