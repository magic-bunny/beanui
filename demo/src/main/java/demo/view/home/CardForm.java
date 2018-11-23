package demo.view.home;

import org.december.beanui.element.annotation.CardPanel;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.FormItem;

@Form
public class CardForm {
    @FormItem(prop = "line1")
    @CardPanel(title = "New Visits", endVal = "102400", svg = "peoples")
    private String card1;

    @FormItem(prop = "line1")
    @CardPanel(title = "Messages", endVal = "81212", svg = "message")
    private String card2;

    @FormItem(prop = "line1")
    @CardPanel(title = "Purchases", endVal = "9280", svg = "money")
    private String card3;

    @FormItem(prop = "line1")
    @CardPanel(title = "Shoppings", endVal = "13600", svg = "shoppingCard")
    private String card4;

    public String getCard1() {
        return card1;
    }

    public void setCard1(String card1) {
        this.card1 = card1;
    }

    public String getCard2() {
        return card2;
    }

    public void setCard2(String card2) {
        this.card2 = card2;
    }

    public String getCard3() {
        return card3;
    }

    public void setCard3(String card3) {
        this.card3 = card3;
    }

    public String getCard4() {
        return card4;
    }

    public void setCard4(String card4) {
        this.card4 = card4;
    }
}
