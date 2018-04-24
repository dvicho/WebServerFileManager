package com.devicho.portal.serverfilemanager.actions;

import com.devicho.portal.serverfilemanager.facade.BorrarArchivosFacade;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Creado por vsuarezq el 23/04/18.
 */
public class BorrarArchivosAction extends ActionSupport {
    
    private List<String> listaArchivos;
    private String mensajeRespuesta;
    
    @Override
    public String execute() throws Exception {
        BorrarArchivosFacade facade = new BorrarArchivosFacade();
    
        mensajeRespuesta = facade.borrarArchivos(listaArchivos);
        
        if (!mensajeRespuesta.isEmpty()) {
            addActionError(mensajeRespuesta);
        }
    
        return SUCCESS;
    }
    
    public List<String> getListaArchivos() {
        return listaArchivos;
    }
    
    public void setListaArchivos(List<String> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }
    
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }
    
    public void setMensajeRespuesta(String mensajeRespuesta) {
        this.mensajeRespuesta = mensajeRespuesta;
    }
    
}
