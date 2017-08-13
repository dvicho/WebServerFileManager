package com.devicho.portal.serverfilemanager.tags;

import com.devicho.portal.serverfilemanager.components.Path;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ComponentTagSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Creado por vicho el día 20/10/16.
 */
public class PathTag extends ComponentTagSupport {

    private String value;
    private String cssClassDiretorio;
    private String cssClassSeparador;

    @Override
    public Component getBean(ValueStack valueStack,
                             HttpServletRequest httpServletRequest,
                             HttpServletResponse httpServletResponse) {
        return new Path(valueStack);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Path pathObj = (Path) component;

        pathObj.setValue(value);
        pathObj.setCssClassDiretorio(cssClassDiretorio);
        pathObj.setCssClassSeparador(cssClassSeparador);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCssClassDiretorio(String cssClassDiretorio) {
        this.cssClassDiretorio = cssClassDiretorio;
    }

    public void setCssClassSeparador(String cssClassSeparador) {
        this.cssClassSeparador = cssClassSeparador;
    }
}
