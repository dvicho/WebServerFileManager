package com.devicho.portal.serverfilemanager.components;

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import java.io.IOException;
import java.io.Writer;

/**
 * Creado por vicho el día 21/10/16.
 */
public class Log extends Component {

    private String value;

    public Log(ValueStack stack) {
        super(stack);
    }

    public boolean start(Writer writer) {

        try {
            writer.write(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
