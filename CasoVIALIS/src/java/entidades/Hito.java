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
public class Hito {
    
    private int idHito;
    private String nombreHito;
    private Date fechaHito;
    private int idProyecto;

    public Hito() {
    }

    public Hito(int idHito, String nombreHito, Date fechaHito, int idProyecto) {
        this.idHito = idHito;
        this.nombreHito = nombreHito;
        this.fechaHito = fechaHito;
        this.idProyecto = idProyecto;
    }

    public int getIdHito() {
        return idHito;
    }

    public void setIdHito(int idHito) {
        this.idHito = idHito;
    }

    public String getNombreHito() {
        return nombreHito;
    }

    public void setNombreHito(String nombreHito) {
        this.nombreHito = nombreHito;
    }

    public Date getFechaHito() {
        return fechaHito;
    }

    public void setFechaHito(Date fechaHito) {
        this.fechaHito = fechaHito;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "Hito{" + "idHito=" + idHito + ", nombreHito=" + nombreHito +
                ", fechaHito=" + fechaHito + ", idProyecto=" + idProyecto + '}';
    }
    
    
    
}
