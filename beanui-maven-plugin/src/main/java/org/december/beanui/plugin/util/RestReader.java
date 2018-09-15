package org.december.beanui.plugin.util;

import org.december.beanui.plugin.exception.SpringReaderException;

import java.util.Map;

public interface RestReader {
    public Map readResourceSetting(Class clazz, String func) throws SpringReaderException;
}
