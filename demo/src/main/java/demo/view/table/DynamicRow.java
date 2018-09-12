package demo.view.table;

import org.december.beanui.element.annotation.I18N;
import org.december.beanui.element.annotation.TableColum;

public class DynamicRow {
    @I18N(en = "fruit name", zh_CN = "水果名称")
    @TableColum(label = "fruit name")
    private String fruitName;
    @I18N(en = "fruit name", zh_CN = "苹果")
    @TableColum(label = "apple")
    private String apple;
    @I18N(en = "fruit name", zh_CN = "香蕉")
    @TableColum(label = "banana")
    private String banana;
    @I18N(en = "fruit name", zh_CN = "橘子")
    @TableColum(label = "orange")
    private String orange;

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getApple() {
        return apple;
    }

    public void setApple(String apple) {
        this.apple = apple;
    }

    public String getBanana() {
        return banana;
    }

    public void setBanana(String banana) {
        this.banana = banana;
    }

    public String getOrange() {
        return orange;
    }

    public void setOrange(String orange) {
        this.orange = orange;
    }
}
