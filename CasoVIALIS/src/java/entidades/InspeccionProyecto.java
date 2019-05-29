/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;

/**
 *
 * @author fmaldonc
 */
public class InspeccionProyecto implements Serializable{
    
    private int idInspeccion;
    private String estadoProyecto;
    private String encargadoInspeccion;
    private int idProyecto;

    public InspeccionProyecto() {
    }

    public InspeccionProyecto(int idInspeccion, String estadoProyecto, String encargadoInspeccion, int idProyecto) {
        this.idInspeccion = idInspeccion;
        this.estadoProyecto = estadoProyecto;
        this.encargadoInspeccion = encargadoInspeccion;
        this.idProyecto = idProyecto;
    }

    public int getIdInspeccion() {
        return idInspeccion;
    }

    public void setIdInspeccion(int idInspeccion) {
        this.idInspeccion = idInspeccion;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public String getEncargadoInspeccion() {
        return encargadoInspeccion;
    }

    public void setEncargadoInspeccion(String encargadoInspeccion) {
        this.encargadoInspeccion = encargadoInspeccion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "InspeccionProyecto{" + "idInspeccion=" + idInspeccion + ", "
                + "estadoProyecto=" + estadoProyecto + ", encargadoInspeccion=" 
                + encargadoInspeccion + ", idProyecto=" + idProyecto + '}';
    }
    
    
    
}
