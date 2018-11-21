package demo.view.component;

import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.MarkdownEditor;

@Component
@Form
public class MarkdownEditorComponent {
    @MarkdownEditor
    private String content = "**this is layout**\n" +
            "\n" +
            "* vue\n" +
            "* element\n" +
            "* webpack\n" +
            "\n" +
            "## Simplemde";

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
