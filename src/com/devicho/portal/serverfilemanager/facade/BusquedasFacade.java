package com.devicho.portal.serverfilemanager.facade;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por vicho el día 18/10/16.
 */
public class BusquedasFacade {

    private final String separador = System.getProperty("file.separator");

    public List<String> listarArchivos(int tipo, boolean verEnSubdirectorios) {
        List<String> archivos = null;
        String pathBase = System.getProperty("jboss.server.base.dir");

        switch (tipo) {
            case 1:
                archivos = ls(new File(pathBase + separador + "config"), verEnSubdirectorios);
                break;
            case 2:
                archivos = ls(new File(pathBase + separador + "log"), verEnSubdirectorios);
                break;
            default:
                archivos = null;
        }

        return archivos;
    }

    private List<String> ls(final File folder, boolean verEnSubdirectorios) {
        List<String> lista = new ArrayList<>();

        if (folder != null && folder.listFiles() != null) {
            for (final File fileEntry : folder.listFiles()) {
                if (fileEntry.isDirectory() && verEnSubdirectorios) {
                    lista.addAll(ls(fileEntry, true));
                } else {
                    lista.add(folder.getAbsoluteFile() + separador + fileEntry.getName());
                }
            }
        }
        return lista;
    }
}
