package com.devicho.portal.serverfilemanager.actions;

import com.opensymphony.xwork2.Action;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Creado por vicho el día 18/10/16.
 */
public class MostrarArchivoAction implements Action {

    private String nombreArchivo;
    private List<String> lineas;
    private String mensajeError;
    private long lineasTotales = 0;
    private int numeroLineas = 100;
    private int tipoArchivo;

    @Override
    public String execute() {
        String actionResult;
        File file = new File(nombreArchivo);
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(file));
            String linea;
            lineas = new ArrayList<>();

            if (file.getName().toLowerCase().endsWith(".properties")) {
                tipoArchivo = 1;
            } else if (file.getName().toLowerCase().endsWith(".log")) {
                tipoArchivo = 2;
            } else {
                tipoArchivo = 0;
            }

            while ((linea = br.readLine()) != null) {
                lineas.add(linea);

                if (tipoArchivo == 2 && lineas.size() > numeroLineas) {
                    lineas.remove(0);
                }

                lineasTotales++;
            }

            actionResult = Action.SUCCESS;
        } catch (FileNotFoundException e) {
            mensajeError = "No se encontró el archivo.";
            actionResult = Action.ERROR;
        } catch (IOException e) {
            mensajeError = "Ocurrió un problema leyendo el archivo.";
            actionResult = Action.ERROR;
        } catch (NullPointerException e) {
            mensajeError = "Ocurrió un error de null pointer exception.";
            actionResult = Action.ERROR;
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return actionResult;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public List<String> getLineas() {
        return lineas;
    }

    public void setLineas(List<String> lineas) {
        this.lineas = lineas;
    }

    public String getMensajeError() {
        return mensajeError;
    }

    public void setMensajeError(String mensajeError) {
        this.mensajeError = mensajeError;
    }

    public long getLineasTotales() {
        return lineasTotales;
    }

    public void setLineasTotales(long lineasTotales) {
        this.lineasTotales = lineasTotales;
    }

    public int getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(int tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }
}
