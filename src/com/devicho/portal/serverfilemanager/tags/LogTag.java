package com.devicho.portal.serverfilemanager.tags;

import com.devicho.portal.serverfilemanager.components.Log;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

        log.setValue(value);
    }

    public void setValue(String value) {
        this.value = value;
    }
}
