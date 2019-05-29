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
public class Cotizacion implements Serializable{
    
    private int idCotizacion;
    private String tipoCotizacion;
    private int totalCotizacion;
    private int idProyecto;

    public Cotizacion() {
    }

    public Cotizacion(int idCotizacion, String tipoCotizacion, int totalCotizacion, int idProyecto) {
        this.idCotizacion = idCotizacion;
        this.tipoCotizacion = tipoCotizacion;
        this.totalCotizacion = totalCotizacion;
        this.idProyecto = idProyecto;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getTipoCotizacion() {
        return tipoCotizacion;
    }

    public void setTipoCotizacion(String tipoCotizacion) {
        this.tipoCotizacion = tipoCotizacion;
    }

    public int getTotalCotizacion() {
        return totalCotizacion;
    }

    public void setTotalCotizacion(int totalCotizacion) {
        this.totalCotizacion = totalCotizacion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "Cotizacion{" + "idCotizacion=" + idCotizacion + ", tipoCotizacion=" 
                + tipoCotizacion + ", totalCotizacion=" + totalCotizacion + ", idProyecto=" 
                + idProyecto + '}';
    }
    
    
    
}
