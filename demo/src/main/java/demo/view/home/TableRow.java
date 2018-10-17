package demo.view.home;

import org.december.beanui.element.Size;
import org.december.beanui.element.Type;
import org.december.beanui.element.annotation.Button;
import org.december.beanui.element.annotation.TableColum;
import org.december.beanui.element.annotation.Tag;

public class TableRow {
    @TableColum(label = "Order_No", width = "300")
    private String orderNumber;
    @Tag(type = Type.INFO, size = Size.MINI)
    @TableColum(label = "Price", prop = "price", width = "150")
    private String currency;
    @TableColum(label = "Price", prop = "price")
    private double price;
    @Tag(type = "$success")
    @TableColum(label = "Status")
    private String status;

    private String success;

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
