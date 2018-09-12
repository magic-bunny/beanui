package org.december.beanui.plugin.tool;

import org.december.beanui.plugin.tool.exception.SpringReaderException;

import java.util.Map;

public interface RestReader {
    public Map readResourceSetting(Class clazz, String func) throws SpringReaderException;
}
