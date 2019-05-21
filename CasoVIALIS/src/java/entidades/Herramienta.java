/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author fmaldonc
 */
public class Herramienta {
    
    private int idHerramienta;
    private String nombreHerramienta;
    private String tipoHerramienta;
    private int costoHerramienta;
    private String estadoHerramienta;
    private int stockHerramienta;
    private String codigoHerramienta;

    public Herramienta() {
    }

    public Herramienta(int idHerramienta, String nombreHerramienta, String tipoHerramienta, int costoHerramienta, String estadoHerramienta, int stockHerramienta, String codigoHerramienta) {
        this.idHerramienta = idHerramienta;
        this.nombreHerramienta = nombreHerramienta;
        this.tipoHerramienta = tipoHerramienta;
        this.costoHerramienta = costoHerramienta;
        this.estadoHerramienta = estadoHerramienta;
        this.stockHerramienta = stockHerramienta;
        this.codigoHerramienta = codigoHerramienta;
    }

    public int getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(int idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public String getNombreHerramienta() {
        return nombreHerramienta;
    }

    public void setNombreHerramienta(String nombreHerramienta) {
        this.nombreHerramienta = nombreHerramienta;
    }

    public String getTipoHerramienta() {
        return tipoHerramienta;
    }

    public void setTipoHerramienta(String tipoHerramienta) {
        this.tipoHerramienta = tipoHerramienta;
    }

    public int getCostoHerramienta() {
        return costoHerramienta;
    }

    public void setCostoHerramienta(int costoHerramienta) {
        this.costoHerramienta = costoHerramienta;
    }

    public String getEstadoHerramienta() {
        return estadoHerramienta;
    }

    public void setEstadoHerramienta(String estadoHerramienta) {
        this.estadoHerramienta = estadoHerramienta;
    }

    public int getStockHerramienta() {
        return stockHerramienta;
    }

    public void setStockHerramienta(int stockHerramienta) {
        this.stockHerramienta = stockHerramienta;
    }

    public String getCodigoHerramienta() {
        return codigoHerramienta;
    }

    public void setCodigoHerramienta(String codigoHerramienta) {
        this.codigoHerramienta = codigoHerramienta;
    }

    @Override
    public String toString() {
        return "Herramienta{" + "idHerramienta=" + idHerramienta + 
                ", nombreHerramienta=" + nombreHerramienta + ", tipoHerramienta=" 
                + tipoHerramienta + ", costoHerramienta=" + costoHerramienta + 
                ", estadoHerramienta=" + estadoHerramienta + ", stockHerramienta=" 
                + stockHerramienta + ", codigoHerramienta=" + codigoHerramienta + '}';
    }

    
    
    
    
}
