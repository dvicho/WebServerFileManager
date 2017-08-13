package com.devicho.portal.serverfilemanager.components;

import com.devicho.portal.serverfilemanager.utilidades.SpanWrapper;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import java.io.IOException;
import java.io.Writer;

/**
 * Creado por vicho el día 20/10/16.
 */
public class Path extends Component {

    private String value;
    private String cssClassDiretorio;
    private String cssClassSeparador;

    public Path(ValueStack stack) {
        super(stack);
    }

    @Override
    public boolean start(Writer writer) {
        try {
            String separador = System.getProperty("file.separator");

            if (value.startsWith(separador)) {
                value = value.replaceFirst(separador, "");
            }

            String[] directorios = value.split(separador);
            StringBuilder salida = new StringBuilder();

            for (String directorio : directorios) {
                salida.append(SpanWrapper.wrap(separador, cssClassSeparador));
                salida.append(SpanWrapper.wrap(directorio, cssClassDiretorio));
            }

            writer.write(salida.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    public boolean usesBody() {
        return false;
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
