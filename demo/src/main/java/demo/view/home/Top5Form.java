package demo.view.home;

import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.Image;
import org.december.beanui.element.annotation.Link;
import org.december.beanui.element.annotation.Progress;

@Form
public class Top5Form {
    @Image(src = "https://article-fd.zol-img.com.cn/t_s640x2000/g5/M00/0F/09/ChMkJlvD-sWIB2v2AAXSpmRRBDUAAsfUAO0r_cABdK-697.jpg")
    private String image;
    @Progress(percentage = "70", label = "Vue", text_inside = "true", stroke_width = "18")
    private int vue;
    @Progress(percentage = "18", label = "Javascript", text_inside = "true", stroke_width = "18")
    private int javascript;
    @Progress(percentage = "12", label = "Css", text_inside = "true", stroke_width = "18")
    private int css;
    @Link(to = "dynamic-table")
    @Progress(percentage = "100", label = "Eslint", status = Progress.Status.SUCCESS, text_inside = "true", stroke_width = "18")
    private int eslint;

    public int getVue() {
        return vue;
    }

    public void setVue(int vue) {
        this.vue = vue;
    }

    public int getJavascript() {
        return javascript;
    }

    public void setJavascript(int javascript) {
        this.javascript = javascript;
    }

    public int getCss() {
        return css;
    }

    public void setCss(int css) {
        this.css = css;
    }

    public int getEslint() {
        return eslint;
    }

    public void setEslint(int eslint) {
        this.eslint = eslint;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
