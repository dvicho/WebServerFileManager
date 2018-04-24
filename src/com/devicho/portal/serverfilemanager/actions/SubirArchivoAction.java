package com.devicho.portal.serverfilemanager.actions;

import com.devicho.portal.serverfilemanager.facade.SubirArchivoFacade;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.deploy.net.HttpResponse;
import org.apache.struts2.ServletActionContext;

import java.io.*;

/**
 * Creado por vicho el día 21/10/16.
 */
public class SubirArchivoAction extends ActionSupport {

    private final String DEST_CONFIG = "config";
    private final String DEST_LOG = "log";

    private File archivo;
    private String nombreArchivo;
    private String tipoArchivo;
    private String nombreArchivoGuardarComo;
    private int destino;

    public String execute() {

        String dest = destino == 2 ? DEST_LOG : DEST_CONFIG;

        SubirArchivoFacade facade = new SubirArchivoFacade();
    
        boolean exito = false;
        try {
            exito = facade.subirArchivos(archivo, nombreArchivoGuardarComo, dest);
        } catch (FileNotFoundException e) {
            addActionError("Problema durante la carga del archivo. " + e.getMessage());
        }
    
        if (exito) {
            addActionMessage("Archivo cargado correctamente");
        } else {
            addActionError("Problema al subir archivo");
        }

        return exito ? Action.SUCCESS : Action.ERROR;
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
    
    @Override
    public void validate() {
        if (this.archivo == null) {
            addFieldError("archivo", "No hay un archivo que subir.");
        } else if (this.nombreArchivo == null) {
            this.nombreArchivo = this.archivo.getName();
        }
    }
}
