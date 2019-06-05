/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

    package Entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fmaldonc
 */
public class Proyecto implements Serializable{
    
    private int idProyecto;
    private String nombreProyecto;
    private String tipoProyecto;
    private String estadoProyecto;
    private String encargadoProyecto;
    private String direccionProyecto;
    private List<Hito> hitos;

    public Proyecto() {
    }

    public Proyecto(int idProyecto, String nombreProyecto, String tipoProyecto, String estadoProyecto, String encargadoProyecto, String direccionProyecto, List<Hito> hitos) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.tipoProyecto = tipoProyecto;
        this.estadoProyecto = estadoProyecto;
        this.encargadoProyecto = encargadoProyecto;
        this.direccionProyecto = direccionProyecto;
        this.hitos = hitos;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public String getTipoProyecto() {
        return tipoProyecto;
    }

    public void setTipoProyecto(String tipoProyecto) {
        this.tipoProyecto = tipoProyecto;
    }

    public String getEstadoProyecto() {
        return estadoProyecto;
    }

    public void setEstadoProyecto(String estadoProyecto) {
        this.estadoProyecto = estadoProyecto;
    }

    public String getEncargadoProyecto() {
        return encargadoProyecto;
    }

    public void setEncargadoProyecto(String encargadoProyecto) {
        this.encargadoProyecto = encargadoProyecto;
    }

    public String getDireccionProyecto() {
        return direccionProyecto;
    }

    public void setDireccionProyecto(String direccionProyecto) {
        this.direccionProyecto = direccionProyecto;
    }

    public List<Hito> getHitos() {
        return hitos;
    }

    public void setHitos(List<Hito> hitos) {
        this.hitos = hitos;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "idProyecto=" + idProyecto + ", nombreProyecto=" + 
                nombreProyecto + ", tipoProyecto=" + tipoProyecto + ", "
                + "estadoProyecto=" + estadoProyecto + ", encargadoProyecto=" +
                encargadoProyecto + ", direccionProyecto=" + direccionProyecto + 
                ", hitos=" + hitos + '}';
    }

    
    
}
    
