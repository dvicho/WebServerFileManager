package com.devicho.portal.serverfilemanager.utilidades;

import org.apache.commons.lang3.StringUtils;

/**
 * Creado por vicho el día 21/10/16.
 */
public class SpanWrapper {

    private SpanWrapper() {
    }

    public static String wrap(String text, String cssClass) {
        StringBuilder salida = new StringBuilder();

        if (StringUtils.isNotEmpty(cssClass)) {
            salida.append("<span class=\"").append(cssClass).append("\">");
            salida.append(text);
            salida.append("</span>");
        } else {
            salida.append(text);
        }

        return salida.toString();
    }
}
