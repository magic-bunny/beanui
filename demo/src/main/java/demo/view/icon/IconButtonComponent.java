package demo.view.icon;

import org.december.beanui.element.Icon;
import org.december.beanui.element.annotation.Button;
import org.december.beanui.element.annotation.Component;
import org.december.beanui.element.annotation.Form;
import org.december.beanui.element.annotation.FormItem;

@Component
@Form
public class IconButtonComponent {
    @FormItem(prop = "line1")
    @Button(icon = Icon.INFO)
	private String info = "info";

    @FormItem(prop = "line1")
    @Button(icon = Icon.ERROR)
	private String error = "error";

    @FormItem(prop = "line1")
    @Button(icon = Icon.SUCCESS)
	private String success = "success";

    @FormItem(prop = "line1")
    @Button(icon = Icon.WARNING)
	private String warning = "warning";

    @FormItem(prop = "line1")
    @Button(icon = Icon.QUESTION)
	private String question = "question";

    @FormItem(prop = "line1")
    @Button(icon = Icon.BACK)
	private String back = "back";

    @FormItem(prop = "line2")
    @Button(icon = Icon.ARROW_LEFT)
	private String arrow_left = "arrow_left";

    @FormItem(prop = "line2")
    @Button(icon = Icon.ARROW_DOWN)
	private String arrow_down = "arrow_down";

    @FormItem(prop = "line2")
    @Button(icon = Icon.ARROW_RIGHT)
	private String arrow_right = "arrow_right";

    @FormItem(prop = "line2")
    @Button(icon = Icon.ARROW_UP)
	private String arrow_up = "arrow_up";

    @FormItem(prop = "line2")
    @Button(icon = Icon.CARET_LEFT)
	private String caret_left = "caret_left";

    @FormItem(prop = "line2")
    @Button(icon = Icon.CARET_BOTTOM)
	private String caret_bottom = "caret_bottom";

    @FormItem(prop = "line3")
    @Button(icon = Icon.CARET_TOP)
	private String caret_top = "caret_top";

    @FormItem(prop = "line3")
    @Button(icon = Icon.CARET_RIGHT)
	private String caret_right = "caret_right";

    @FormItem(prop = "line3")
    @Button(icon = Icon.D_ARROW_LEFT)
	private String d_arrow_left = "d_arrow_left";

    @FormItem(prop = "line3")
    @Button(icon = Icon.D_ARROW_RIGHT)
	private String d_arrow_right = "d_arrow_right";

    @FormItem(prop = "line3")
    @Button(icon = Icon.MINUS)
	private String minus = "minus";

    @FormItem(prop = "line3")
    @Button(icon = Icon.PLUS)
	private String plus = "plus";

    @FormItem(prop = "line4")
    @Button(icon = Icon.REMOVE )
	private String remove = "remove";

    @FormItem(prop = "line4")
    @Button(icon = Icon.CIRCLE_PLUS)
	private String circle_plus = "circle_plus";

    @FormItem(prop = "line4")
    @Button(icon = Icon.REMOVE_OUTLINE)
	private String remove_outline = "remove_outline";

    @FormItem(prop = "line4")
    @Button(icon = Icon.CIRCLE_PLUS_OUTLINE)
	private String circle_plus_outline = "circle_plus_outline";

    @FormItem(prop = "line4")
    @Button(icon = Icon.CLOSE)
	private String close = "close";

    @FormItem(prop = "line4")
    @Button(icon = Icon.CHECK)
	private String check = "check";

    @FormItem(prop = "line5")
    @Button(icon = Icon.CIRCLE_CLOS)
	private String circle_clos = "circle_close";

    @FormItem(prop = "line5")
    @Button(icon = Icon.CIRCLE_CHECK)
	private String circle_check = "circle_check";

    @FormItem(prop = "line5")
    @Button(icon = Icon.CIRCLE_CLOSE_OUTLINE)
	private String circle_close_outline = "circle_close_outline";

    @FormItem(prop = "line5")
    @Button(icon = Icon.CIRCLE_CHECK_OUTLINE)
	private String circle_check_outline = "circle_check_outline";

    @FormItem(prop = "line5")
    @Button(icon = Icon.ZOOM_OUT)
	private String zoom_out = "zoom_out";

    @FormItem(prop = "line5")
    @Button(icon = Icon.ZOOM_IN)
	private String zoom_in = "zoom_in";

    @FormItem(prop = "line6")
    @Button(icon = Icon.D_CARET)
	private String d_caret = "d_caret";

    @FormItem(prop = "line6")
    @Button(icon = Icon.SORT)
	private String sort = "sort";

    @FormItem(prop = "line6")
    @Button(icon = Icon.SORT_DOWN)
	private String sort_down = "sort_down";

    @FormItem(prop = "line6")
    @Button(icon = Icon.SORT_UP)
	private String sort_up = "sort_up";

    @FormItem(prop = "line6")
    @Button(icon = Icon.TICKET )
	private String ticket = "tickets";

    @FormItem(prop = "line6")
    @Button(icon = Icon.DOCUMENT)
	private String document = "document";

    @FormItem(prop = "line7")
    @Button(icon = Icon.GOODS)
	private String goods = "goods";

    @FormItem(prop = "line7")
    @Button(icon = Icon.SOLD_OUT)
	private String sold_out = "sold_out";

    @FormItem(prop = "line7")
    @Button(icon = Icon.NEWS)
	private String news = "news";

    @FormItem(prop = "line7")
    @Button(icon = Icon.MESSAGE)
	private String message = "message";

    @FormItem(prop = "line7")
    @Button(icon = Icon.DATE)
	private String date = "date";

    @FormItem(prop = "line7")
    @Button(icon = Icon.PRINTER)
	private String printer = "printer";

    @FormItem(prop = "line8")
    @Button(icon = Icon.TIME)
	private String time = "time";

    @FormItem(prop = "line8")
    @Button(icon = Icon.BELL)
	private String bell = "bell";

    @FormItem(prop = "line8")
    @Button(icon = Icon.MOBILE_PHONE)
	private String mobile_phone = "mobile_phone";

    @FormItem(prop = "line8")
    @Button(icon = Icon.SERVICE)
	private String service = "service";

    @FormItem(prop = "line8")
    @Button(icon = Icon.VIEW)
	private String view = "view";

    @FormItem(prop = "line8")
    @Button(icon = Icon.MENU)
	private String menu = "menu";

    @FormItem(prop = "line9")
    @Button(icon = Icon.MORE)
	private String more = "more";

    @FormItem(prop = "line9")
    @Button(icon = Icon.MORE_OUTLINE)
	private String more_outline = "more_outline";

    @FormItem(prop = "line9")
    @Button(icon = Icon.STAR_ON)
	private String star_on = "star_on";

    @FormItem(prop = "line9")
    @Button(icon = Icon.STAR_OFF)
	private String star_off = "star_off";

    @FormItem(prop = "line9")
    @Button(icon = Icon.LOCATION)
	private String location = "location";

    @FormItem(prop = "line9")
    @Button(icon = Icon.LOCATION_OUTLINE)
	private String location_outline = "location_outline";

    @FormItem(prop = "line10")
    @Button(icon = Icon.ICON_PHONE)
	private String icon_phone = "phone";

    @FormItem(prop = "line10")
    @Button(icon = Icon.PHONE_OUTLINE)
	private String phone_outline = "phone_outline";

    @FormItem(prop = "line10")
    @Button(icon = Icon.PICTUR )
	private String pictur = "picture";

    @FormItem(prop = "line10")
    @Button(icon = Icon.PICTURE_OUTLINE)
	private String picture_outline = "picture_outline";

    @FormItem(prop = "line10")
    @Button(icon = Icon.DELETE )
	private String delete = "delete";

    @FormItem(prop = "line10")
    @Button(icon = Icon.SEARCH )
	private String search = "search";

    @FormItem(prop = "line11")
    @Button(icon = Icon.EDIT )
	private String edit = "edit";

    @FormItem(prop = "line11")
    @Button(icon = Icon.EDIT_OUTLINE)
	private String edit_outline = "edit_outline";

    @FormItem(prop = "line11")
    @Button(icon = Icon.RANK)
	private String rank = "rank";

    @FormItem(prop = "line11")
    @Button(icon = Icon.REFRESH)
	private String refresh = "refresh";

    @FormItem(prop = "line11")
    @Button(icon = Icon.SHARE)
	private String share = "share";

    @FormItem(prop = "line11")
    @Button(icon = Icon.SETTING)
	private String setting = "setting";

    @FormItem(prop = "line12")
    @Button(icon = Icon.UPLOAD )
	private String upload = "upload";

    @FormItem(prop = "line12")
    @Button(icon = Icon.UPLOAD2)
	private String upload2 = "upload2";

    @FormItem(prop = "line12")
    @Button(icon = Icon.DOWNLOAD)
	private String download = "download";

    @FormItem(prop = "line12")
    @Button(icon = Icon.LOADING)
	private String loading = "loading";

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getArrow_left() {
        return arrow_left;
    }

    public void setArrow_left(String arrow_left) {
        this.arrow_left = arrow_left;
    }

    public String getArrow_down() {
        return arrow_down;
    }

    public void setArrow_down(String arrow_down) {
        this.arrow_down = arrow_down;
    }

    public String getArrow_right() {
        return arrow_right;
    }

    public void setArrow_right(String arrow_right) {
        this.arrow_right = arrow_right;
    }

    public String getArrow_up() {
        return arrow_up;
    }

    public void setArrow_up(String arrow_up) {
        this.arrow_up = arrow_up;
    }

    public String getCaret_left() {
        return caret_left;
    }

    public void setCaret_left(String caret_left) {
        this.caret_left = caret_left;
    }

    public String getCaret_bottom() {
        return caret_bottom;
    }

    public void setCaret_bottom(String caret_bottom) {
        this.caret_bottom = caret_bottom;
    }

    public String getCaret_top() {
        return caret_top;
    }

    public void setCaret_top(String caret_top) {
        this.caret_top = caret_top;
    }

    public String getCaret_right() {
        return caret_right;
    }

    public void setCaret_right(String caret_right) {
        this.caret_right = caret_right;
    }

    public String getD_arrow_left() {
        return d_arrow_left;
    }

    public void setD_arrow_left(String d_arrow_left) {
        this.d_arrow_left = d_arrow_left;
    }

    public String getD_arrow_right() {
        return d_arrow_right;
    }

    public void setD_arrow_right(String d_arrow_right) {
        this.d_arrow_right = d_arrow_right;
    }

    public String getMinus() {
        return minus;
    }

    public void setMinus(String minus) {
        this.minus = minus;
    }

    public String getPlus() {
        return plus;
    }

    public void setPlus(String plus) {
        this.plus = plus;
    }

    public String getRemove() {
        return remove;
    }

    public void setRemove(String remove) {
        this.remove = remove;
    }

    public String getCircle_plus() {
        return circle_plus;
    }

    public void setCircle_plus(String circle_plus) {
        this.circle_plus = circle_plus;
    }

    public String getRemove_outline() {
        return remove_outline;
    }

    public void setRemove_outline(String remove_outline) {
        this.remove_outline = remove_outline;
    }

    public String getCircle_plus_outline() {
        return circle_plus_outline;
    }

    public void setCircle_plus_outline(String circle_plus_outline) {
        this.circle_plus_outline = circle_plus_outline;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }

    public String getCircle_clos() {
        return circle_clos;
    }

    public void setCircle_clos(String circle_clos) {
        this.circle_clos = circle_clos;
    }

    public String getCircle_check() {
        return circle_check;
    }

    public void setCircle_check(String circle_check) {
        this.circle_check = circle_check;
    }

    public String getCircle_close_outline() {
        return circle_close_outline;
    }

    public void setCircle_close_outline(String circle_close_outline) {
        this.circle_close_outline = circle_close_outline;
    }

    public String getCircle_check_outline() {
        return circle_check_outline;
    }

    public void setCircle_check_outline(String circle_check_outline) {
        this.circle_check_outline = circle_check_outline;
    }

    public String getZoom_out() {
        return zoom_out;
    }

    public void setZoom_out(String zoom_out) {
        this.zoom_out = zoom_out;
    }

    public String getZoom_in() {
        return zoom_in;
    }

    public void setZoom_in(String zoom_in) {
        this.zoom_in = zoom_in;
    }

    public String getD_caret() {
        return d_caret;
    }

    public void setD_caret(String d_caret) {
        this.d_caret = d_caret;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSort_down() {
        return sort_down;
    }

    public void setSort_down(String sort_down) {
        this.sort_down = sort_down;
    }

    public String getSort_up() {
        return sort_up;
    }

    public void setSort_up(String sort_up) {
        this.sort_up = sort_up;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public String getSold_out() {
        return sold_out;
    }

    public void setSold_out(String sold_out) {
        this.sold_out = sold_out;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getBell() {
        return bell;
    }

    public void setBell(String bell) {
        this.bell = bell;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getMore() {
        return more;
    }

    public void setMore(String more) {
        this.more = more;
    }

    public String getMore_outline() {
        return more_outline;
    }

    public void setMore_outline(String more_outline) {
        this.more_outline = more_outline;
    }

    public String getStar_on() {
        return star_on;
    }

    public void setStar_on(String star_on) {
        this.star_on = star_on;
    }

    public String getStar_off() {
        return star_off;
    }

    public void setStar_off(String star_off) {
        this.star_off = star_off;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation_outline() {
        return location_outline;
    }

    public void setLocation_outline(String location_outline) {
        this.location_outline = location_outline;
    }

    public String getIcon_phone() {
        return icon_phone;
    }

    public void setIcon_phone(String icon_phone) {
        this.icon_phone = icon_phone;
    }

    public String getPhone_outline() {
        return phone_outline;
    }

    public void setPhone_outline(String phone_outline) {
        this.phone_outline = phone_outline;
    }

    public String getPictur() {
        return pictur;
    }

    public void setPictur(String pictur) {
        this.pictur = pictur;
    }

    public String getPicture_outline() {
        return picture_outline;
    }

    public void setPicture_outline(String picture_outline) {
        this.picture_outline = picture_outline;
    }

    public String getDelete() {
        return delete;
    }

    public void setDelete(String delete) {
        this.delete = delete;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public String getEdit() {
        return edit;
    }

    public void setEdit(String edit) {
        this.edit = edit;
    }

    public String getEdit_outline() {
        return edit_outline;
    }

    public void setEdit_outline(String edit_outline) {
        this.edit_outline = edit_outline;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRefresh() {
        return refresh;
    }

    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }

    public String getShare() {
        return share;
    }

    public void setShare(String share) {
        this.share = share;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public String getUpload() {
        return upload;
    }

    public void setUpload(String upload) {
        this.upload = upload;
    }

    public String getUpload2() {
        return upload2;
    }

    public void setUpload2(String upload2) {
        this.upload2 = upload2;
    }

    public String getDownload() {
        return download;
    }

    public void setDownload(String download) {
        this.download = download;
    }

    public String getLoading() {
        return loading;
    }

    public void setLoading(String loading) {
        this.loading = loading;
    }
}
