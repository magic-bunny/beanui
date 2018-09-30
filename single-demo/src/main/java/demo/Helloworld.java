package demo;

import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Input;
import org.december.beanui.event.annotation.Created;

@Created(rest = WebApplication.class)
@Component
@Form
public class Helloworld {
    @Input(label = "hello world")
    private String input;

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }
}
