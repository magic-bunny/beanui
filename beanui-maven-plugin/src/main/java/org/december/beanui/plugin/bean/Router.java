package org.december.beanui.plugin.bean;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Router {
    @JsonProperty
    private String path;
    @JsonProperty
    private String title;
    @JsonProperty
    private String component;
    @JsonProperty
    private String icon;
    @JsonProperty
    private List<Router> children;

    public List<Router> getChildren() {
        return children;
    }

    public void setChildren(List<Router> children) {
        this.children = children;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
