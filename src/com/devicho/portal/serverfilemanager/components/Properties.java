package com.devicho.portal.serverfilemanager.components;

import com.devicho.portal.serverfilemanager.utilidades.IMaskingLine;
import com.devicho.portal.serverfilemanager.utilidades.MaskingPropertiesLine;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import java.io.IOException;
import java.io.Writer;

/**
 * Creado por vicho el día 21/10/16.
 */
public class Properties extends Component {

    private String value;
    private String classKey;
    private String classValue;
    private String classComment;
    private String classEqual;

    public Properties(ValueStack stack) {
        super(stack);
    }

    @Override
    public boolean start(Writer writer) {

        IMaskingLine mask = MaskingPropertiesLine.getInstance();
        ((MaskingPropertiesLine) mask).setClassKey(classKey);
        ((MaskingPropertiesLine) mask).setClassValue(classValue);
        ((MaskingPropertiesLine) mask).setClassComment(classComment);
        ((MaskingPropertiesLine) mask).setClassEqual(classEqual);

        try {
            writer.write(mask.maskingLine(value));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
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
