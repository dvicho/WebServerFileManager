package com.devicho.portal.serverfilemanager.actions;

import com.devicho.portal.serverfilemanager.facade.BusquedasFacade;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

/**
 * Created by vicho on 18/10/16.
 */
public class BusquedaAction extends ActionSupport {

    private int tipo = 0;
    private List<String> listaArchivos;
    private boolean verEnSubdirectorios = false;
    private int numeroLineas = 100;

    public String execute() {
        BusquedasFacade busquedas = new BusquedasFacade();

        listaArchivos = busquedas.listarArchivos(tipo, verEnSubdirectorios);

        if (listaArchivos != null) {
            return Action.SUCCESS;
        } else {
            return Action.ERROR;
        }
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public List<String> getListaArchivos() {
        return listaArchivos;
    }

    public void setListaArchivos(List<String> listaArchivos) {
        this.listaArchivos = listaArchivos;
    }

    public boolean isVerEnSubdirectorios() {
        return verEnSubdirectorios;
    }

    public void setVerEnSubdirectorios(boolean verEnSubdirectorios) {
        this.verEnSubdirectorios = verEnSubdirectorios;
    }

    public int getNumeroLineas() {
        return numeroLineas;
    }

    public void setNumeroLineas(int numeroLineas) {
        this.numeroLineas = numeroLineas;
    }
}
