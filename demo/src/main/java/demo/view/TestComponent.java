package demo.view;

import demo.view.form.TestForm;
import org.december.beanui.element.annotation.Card;
import org.december.beanui.element.annotation.Component;

@Component(title = "demo", path = "menu2", icon = "qq", superTitle = "test", superIcon = "lock")
public class TestComponent {
    @Card(title = "test")
    private TestForm testForm;

    public TestForm getTestForm() {
        return testForm;
    }

    public void setTestForm(TestForm testForm) {
        this.testForm = testForm;
    }
}
