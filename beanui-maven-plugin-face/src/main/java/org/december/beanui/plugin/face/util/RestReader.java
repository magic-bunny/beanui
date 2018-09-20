package org.december.beanui.plugin.face.util;

import org.december.beanui.plugin.face.exception.SpringReaderException;

import java.util.Map;

public interface RestReader {
    public Map readResourceSetting(Class clazz, String func) throws SpringReaderException;
}
