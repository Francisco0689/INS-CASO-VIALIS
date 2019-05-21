/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.sql.Date;

/**
 *
 * @author fmaldonc
 */
public class Reunion {
    
    private int idReunion;
    private String estadoReunion;
    private Date fechaReunion; 
    private String lugarReunion;
    private String encargadoReunion;

    public Reunion() {
    }

    public Reunion(int idReunion, String estadoReunion, Date fechaReunion, String lugarReunion, String encargadoReunion) {
        this.idReunion = idReunion;
        this.estadoReunion = estadoReunion;
        this.fechaReunion = fechaReunion;
        this.lugarReunion = lugarReunion;
        this.encargadoReunion = encargadoReunion;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getEstadoReunion() {
        return estadoReunion;
    }

    public void setEstadoReunion(String estadoReunion) {
        this.estadoReunion = estadoReunion;
    }

    public Date getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(Date fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public String getLugarReunion() {
        return lugarReunion;
    }

    public void setLugarReunion(String lugarReunion) {
        this.lugarReunion = lugarReunion;
    }

    public String getEncargadoReunion() {
        return encargadoReunion;
    }

    public void setEncargadoReunion(String encargadoReunion) {
        this.encargadoReunion = encargadoReunion;
    }

    @Override
    public String toString() {
        return "Reunion{" + "idReunion=" + idReunion + ", estadoReunion=" + 
                estadoReunion + ", fechaReunion=" + fechaReunion + ", lugarReunion=" 
                + lugarReunion + ", encargadoReunion=" + encargadoReunion + '}';
    }
    
    
    
}
