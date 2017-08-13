package com.devicho.portal.serverfilemanager.actions;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.io.File;

/**
 * Creado por vicho el día 21/10/16.
 */
public class SubirArchivoFormAction extends ActionSupport {

    private File archivo;
    private String nombreArchivo;
    private String tipoArchivo;
    private String nombreArchivoGuardarComo;
    private int destino;

    public String execute() {

        return Action.SUCCESS;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getTipoArchivo() {
        return tipoArchivo;
    }

    public void setTipoArchivo(String tipoArchivo) {
        this.tipoArchivo = tipoArchivo;
    }

    public String getNombreArchivoGuardarComo() {
        return nombreArchivoGuardarComo;
    }

    public void setNombreArchivoGuardarComo(String nombreArchivoGuardarComo) {
        this.nombreArchivoGuardarComo = nombreArchivoGuardarComo;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }
}
