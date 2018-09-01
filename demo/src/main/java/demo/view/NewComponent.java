package demo.view;

import org.december.beanui.element.annotation.Component;

@Component
public class NewComponent {
    private TestForm testForm;

    public TestForm getTestForm() {
        return testForm;
    }

    public void setTestForm(TestForm testForm) {
        this.testForm = testForm;
    }
}
