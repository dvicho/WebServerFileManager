package com.devicho.portal.serverfilemanager.facade;

import java.io.File;
import java.util.List;

/**
 * Creado por vsuarezq el 23/04/18.
 */
public class BorrarArchivosFacade {
    
    public String borrarArchivos(List<String> archivos) {
    
        StringBuilder mensaje = new StringBuilder();
        boolean hayErrores = false;
        
        for (String archivo : archivos) {
            
            if (!borrarArchivo(archivo)) {
                mensaje.append(archivo);
                hayErrores = true;
            }
        }
    
        if (hayErrores) {
            mensaje = new StringBuilder("No se logró borrar los siguientes archivos: ");
        } else {
            mensaje = new StringBuilder("Archivo(s) borrados correctamente.");
        }
        
        return mensaje.toString();
    }
    
    private boolean borrarArchivo(String nombreArchivo) {
        File file = new File(nombreArchivo);
    
        return file.delete();
    }
}
