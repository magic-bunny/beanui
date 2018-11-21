package demo.view.layout.carousel;

import demo.view.layout.card.TestForm;
import org.december.beanui.element.annotation.Carousel;
import org.december.beanui.element.annotation.Component;

@Component
public class CarouselComponent {
    @Carousel(data={"$testForm", "$testForm2"})
    private String test;

    @Carousel.Item(name = "a", label = "title1")
    private TestForm testForm;

    @Carousel.Item(name = "b", label = "title2")
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
