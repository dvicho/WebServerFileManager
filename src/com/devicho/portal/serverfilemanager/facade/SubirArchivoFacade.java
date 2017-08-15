package com.devicho.portal.serverfilemanager.facade;

import java.io.*;

/**
 * Creado por vicho el día 13/08/17.
 */
public class SubirArchivoFacade {

    private final String separador = System.getProperty("file.separator");

    public boolean subirArchivos(File archivo, String nombreArchivo, String carpetaDestino) {
        String pathBase = System.getProperty("jboss.server.base.dir");
        String fullName = pathBase + separador + carpetaDestino + separador + nombreArchivo;

        boolean exito = false;

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(archivo);
            outputStream = new FileOutputStream(fullName);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            exito = true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return exito;
    }
}
