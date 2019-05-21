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
public class Material {
    
    private int idMaterial;
    private String nombreMaterial;
    private String tipoMaterial;
    private int costoMaterial;
    private String estadoMaterial;
    private int stockMaterial;
    private String codigoMaterial;

    public Material() {
    }

    public Material(int idMaterial, String nombreMaterial, String tipoMaterial, int costoMaterial, String estadoMaterial, int stockMaterial, String codigoMaterial) {
        this.idMaterial = idMaterial;
        this.nombreMaterial = nombreMaterial;
        this.tipoMaterial = tipoMaterial;
        this.costoMaterial = costoMaterial;
        this.estadoMaterial = estadoMaterial;
        this.stockMaterial = stockMaterial;
        this.codigoMaterial = codigoMaterial;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNombreMaterial() {
        return nombreMaterial;
    }

    public void setNombreMaterial(String nombreMaterial) {
        this.nombreMaterial = nombreMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    public void setTipoMaterial(String tipoMaterial) {
        this.tipoMaterial = tipoMaterial;
    }

    public int getCostoMaterial() {
        return costoMaterial;
    }

    public void setCostoMaterial(int costoMaterial) {
        this.costoMaterial = costoMaterial;
    }

    public String getEstadoMaterial() {
        return estadoMaterial;
    }

    public void setEstadoMaterial(String estadoMaterial) {
        this.estadoMaterial = estadoMaterial;
    }

    public int getStockMaterial() {
        return stockMaterial;
    }

    public void setStockMaterial(int stockMaterial) {
        this.stockMaterial = stockMaterial;
    }

    public String getCodigoMaterial() {
        return codigoMaterial;
    }

    public void setCodigoMaterial(String codigoMaterial) {
        this.codigoMaterial = codigoMaterial;
    }

    @Override
    public String toString() {
        return "Material{" + "idMaterial=" + idMaterial + ", nombreMaterial=" + 
                nombreMaterial + ", tipoMaterial=" + tipoMaterial + ", costoMaterial=" 
                + costoMaterial + ", estadoMaterial=" + estadoMaterial + ", stockMaterial="
                + stockMaterial + ", codigoMaterial=" + codigoMaterial + '}';
    }
    
    

}
