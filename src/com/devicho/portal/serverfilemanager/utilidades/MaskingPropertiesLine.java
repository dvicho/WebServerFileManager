package com.devicho.portal.serverfilemanager.utilidades;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creado por vicho el día 19/10/16.
 */
public class MaskingPropertiesLine implements IMaskingLine {

    private String classComment;
    private String classKey;
    private String classValue;
    private String classEqual;

    private MaskingPropertiesLine() {
    }

    public static MaskingPropertiesLine getInstance() {
        return new MaskingPropertiesLine();
    }

    @Override
    public String maskingLine(String linea) {
        if (linea == null) {
            return null;
        }

        Pattern keyValuePattern = Pattern.compile("(^[A-Z0-9.\\-_]+)(\\s*=\\s*)(.+)", Pattern.CASE_INSENSITIVE);
        Matcher keyValueMatcher = keyValuePattern.matcher(linea);

        Pattern multilinePattern = Pattern.compile("^\\s*\\\\.*");
        Matcher multilineMatcher = multilinePattern.matcher(linea);

        Pattern commentPattern = Pattern.compile("^\\s*[#!].*");
        Matcher commentMatcher = commentPattern.matcher(linea);

        if (keyValueMatcher.find()) {

            linea = SpanWrapper.wrap(keyValueMatcher.group(1), classKey) +
                    SpanWrapper.wrap(keyValueMatcher.group(2), classEqual) +
                    SpanWrapper.wrap(keyValueMatcher.group(3), classValue);
        } else if (commentMatcher.find()) {
            linea = SpanWrapper.wrap(linea, classComment);
        } else if (multilineMatcher.find()) {
            linea = SpanWrapper.wrap(linea, classValue);
        }

        return linea;
    }

    public void setClassComment(String classComment) {
        this.classComment = classComment;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public void setClassValue(String classValue) {
        this.classValue = classValue;
    }

    public void setClassEqual(String classEqual) {
        this.classEqual = classEqual;
    }

    public static void main(String[] args) {
        MaskingPropertiesLine maskingPropertiesLine = MaskingPropertiesLine.getInstance();
        maskingPropertiesLine.setClassKey("key");
        maskingPropertiesLine.setClassValue("value");
        maskingPropertiesLine.setClassComment("comment");

        String value1 = "name = 123";
        String value2 = "name.qwe = 123";
        String value3 = "# un comentario";
        String value4 = "! un comentario";
        String value5 = "   \\ multilínea";

        System.out.println(maskingPropertiesLine.maskingLine(value1));
        System.out.println(maskingPropertiesLine.maskingLine(value2));
        System.out.println(maskingPropertiesLine.maskingLine(value3));
        System.out.println(maskingPropertiesLine.maskingLine(value4));
        System.out.println(maskingPropertiesLine.maskingLine(value5));

        System.exit(1);
    }
}
