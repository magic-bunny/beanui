package demo.view.layout.collapse;

import demo.view.layout.card.TestForm;
import org.december.beanui.element.annotation.Collapse;
import org.december.beanui.element.annotation.Component;

@Component
public class CollapseComponent {
    @Collapse(data={"$testForm", "$testForm2"})
    private String test;

    @Collapse.Item(name = "a", title = "title1")
    private TestForm testForm;

    @Collapse.Item(name = "b", title = "title2")
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

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
