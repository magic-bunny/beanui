package demo.view.layout.card;

import org.december.beanui.element.annotation.Card;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Subplot;
import org.december.beanui.element.annotation.Tabs;

@Component
public class CardComponent {
    @Subplot({1, 2, 1})
    @Card(title = "layout")
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
