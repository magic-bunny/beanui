package demo.view.layout.tabs;

import demo.view.layout.card.TestForm;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Tabs;

@Component
public class TabsComponent {
    @Tabs(data={"$testForm", "$testForm2"}, type = Tabs.Type.CARD)
    private String test;

    @Tabs.Item(name = "a", label = "title1")
    private TestForm testForm;

    @Tabs.Item(name = "b", label = "title2")
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
