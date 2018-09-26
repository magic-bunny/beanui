package demo.view;

import demo.view.form.TestForm;
import org.december.beanui.element.annotation.Card;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Subplot;

@Component(title = "demo", path = "menu2", icon = "qq", superTitle = "test", superIcon = "lock")
public class TestComponent {
    @Subplot({1, 2, 1})
    @Card(title = "test")
    private TestForm testForm;

    @Subplot({1, 2, 2})
    @Card
    private TestForm testForm2;

    public TestForm getTestForm() {
        return testForm;
    }

    public void setTestForm(TestForm testForm) {
        this.testForm = testForm;
    }

    public TestForm getTestForm2() {
        return testForm2;
    }

    public void setTestForm2(TestForm testForm2) {
        this.testForm2 = testForm2;
    }
}
