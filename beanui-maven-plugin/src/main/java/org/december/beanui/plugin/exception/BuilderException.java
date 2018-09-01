package org.december.beanui.plugin.exception;

public class BuilderException extends Exception {
    public BuilderException() {
    }

    public BuilderException(Throwable throwable) {
        super(throwable);
    }

    public BuilderException(String s) {
        super(s);
    }

    public BuilderException(Exception e) {
        super(e);
    }
}
