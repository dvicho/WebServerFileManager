package com.devicho.portal.serverfilemanager.tags;

import com.devicho.portal.serverfilemanager.components.Properties;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creado por vicho el día 21/10/16.
 */
public class PropertiesTag extends ComponentTagSupport {

    private String value;
    private String classKey;
    private String classValue;
    private String classComment;
    private String classEqual;

    @Override
    public Component getBean(ValueStack valueStack,
                             HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse) {
        return new Properties(valueStack);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Properties properties = (Properties) component;

        properties.setValue(value);
        properties.setClassKey(classKey);
        properties.setClassValue(classValue);
        properties.setClassComment(classComment);
        properties.setClassEqual(classEqual);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setClassKey(String classKey) {
        this.classKey = classKey;
    }

    public void setClassValue(String classValue) {
        this.classValue = classValue;
    }

    public void setClassComment(String classComment) {
        this.classComment = classComment;
    }

    public void setClassEqual(String classEqual) {
        this.classEqual = classEqual;
    }
}
