package org.december.beanui.plugin.exception;

public class ComponentBuilderException extends BuilderException {
    public ComponentBuilderException() {
    }

    public ComponentBuilderException(Throwable throwable) {
        super(throwable);
    }

    public ComponentBuilderException(String s) {
        super(s);
    }

    public ComponentBuilderException(Exception e) {
        super(e);
    }
}
