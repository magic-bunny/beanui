package org.december.beanui.plugin.bean;

import java.util.List;
import java.util.Map;

public class Element {
    private String id;
    private String i18n;
    private String type;
    private String tag;
    private Map content;
    private List<Map> events;
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

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
