package org.december.beanui.rule;

public class RuleType{
    private RuleType() {
    }

    public static final String STRING = "string"; // Must be of type string. This is the default type.
    public static final String NUMBER = "number"; // Must be of type number.
    public static final String BOOLEAN = "boolean"; // Must be of type boolean.
    public static final String METHOD = "method"; // Must be of type function.
    public static final String REGEXP = "regexp"; // Must be an instance of RegExp or a string that does not generate an exception when creating a new RegExp.
    public static final String INTEGER = "integer"; // Must be of type number and an integer.
    public static final String FLOAT = "float"; // Must be of type number and a floating point number.
    public static final String ARRAY = "array"; // Must be an array as determined by Array.isArray.
    public static final String OBJECT = "object"; // Must be of type object and not Array.isArray.
    public static final String ENUM = "enum"; // Value must exist in the enum.
    public static final String DATE = "date"; // Value must be valid as determined by Date
    public static final String URL = "url"; // Must be of type url.
    public static final String HEX = "hex"; // Must be of type hex.
    public static final String EMAIL = "email"; // Must be of type email.
}
