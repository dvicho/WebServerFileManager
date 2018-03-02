package com.devicho.portal.serverfilemanager.tags;

import com.devicho.portal.serverfilemanager.components.Log;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

/**
 * Creado por vicho el día 21/10/16.
 */
public class LogTag extends ComponentTagSupport {
    
    private String value;
    
    @Override
    public Component getBean(ValueStack valueStack,
                             HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse) {
        return new Log(valueStack);
    }
    
    @Override
    protected void populateParams() {
        super.populateParams();
        
        Log log = (Log) component;
        
        log.setValue(forXML(value));
    }
    
    public void setValue(String value) {
        this.value = value;
    }
    
    public static String forXML(String aText) {
        final StringBuilder result = new StringBuilder();
        final StringCharacterIterator iterator = new StringCharacterIterator(aText);
        char character = iterator.current();
        while (character != CharacterIterator.DONE) {
            if (character == '<') {
                result.append("&lt;");
            } else if (character == '>') {
                result.append("&gt;");
            } else if (character == '\"') {
                result.append("&quot;");
            } else if (character == '\'') {
                result.append("&#039;");
            } else if (character == '&') {
                result.append("&amp;");
            } else {
                //the char is not a special one
                //add it to the result as is
                result.append(character);
            }
            character = iterator.next();
        }
        return result.toString();
    }
}
