package org.december.beanui.plugin.face.bean;

import java.util.List;
import java.util.Map;

public class Element {
    private String id;
    private String i18n;
    private String type;
    private Map content;
    private Map badge;
    private Map tooltip;
    private Map link;
    private List<Map> events;
    private String rules;
    private int[] subplot;
    private String init;
    private List<Element> children;

    public Element() {
    }

    public Element(String id, String type, Map content) {
        this.id = id;
        this.type = type;
        this.content = content;
    }

    public Element(String id, String type, Map content, List<Element> children) {
        this.id = id;
        this.type = type;
        this.content = content;
        this.children = children;
    }

    public List<Element> getChildren() {
        return children;
    }

    public void setChildren(List<Element> children) {
        this.children = children;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map getContent() {
        return content;
    }

    public void setContent(Map content) {
        this.content = content;
    }

    public List<Map> getEvents() {
        return events;
    }

    public void setEvents(List<Map> events) {
        this.events = events;
    }

    public String getI18n() {
        return i18n;
    }

    public void setI18n(String i18n) {
        this.i18n = i18n;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Map getBadge() {
        return badge;
    }

    public void setBadge(Map badge) {
        this.badge = badge;
    }

    public int[] getSubplot() {
        return subplot;
    }

    public void setSubplot(int[] subplot) {
        this.subplot = subplot;
    }

    public Map getTooltip() {
        return tooltip;
    }

    public void setTooltip(Map tooltip) {
        this.tooltip = tooltip;
    }

    public Map getLink() {
        return link;
    }

    public void setLink(Map link) {
        this.link = link;
    }

    public String getInit() {
        return init;
    }

    public void setInit(String init) {
        this.init = init;
    }
}
