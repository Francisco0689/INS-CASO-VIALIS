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
public class Maquinaria implements Serializable{
    
    private int idMaquinaria;
    private String nombreMaquinaria;
    private String tipoMaquinaria;
    private int costoMaquinaria;
    private int stockMaquinaria;
    private String codigoMaquinaria;

    public Maquinaria() {
    }

    public Maquinaria(int idMaquinaria, String nombreMaquinaria, String tipoMaquinaria, int costoMaquinaria, int stockMaquinaria, String codigoMaquinaria) {
        this.idMaquinaria = idMaquinaria;
        this.nombreMaquinaria = nombreMaquinaria;
        this.tipoMaquinaria = tipoMaquinaria;
        this.costoMaquinaria = costoMaquinaria;
        this.stockMaquinaria = stockMaquinaria;
        this.codigoMaquinaria = codigoMaquinaria;
    }

    public int getIdMaquinaria() {
        return idMaquinaria;
    }

    public void setIdMaquinaria(int idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    public String getNombreMaquinaria() {
        return nombreMaquinaria;
    }

    public void setNombreMaquinaria(String nombreMaquinaria) {
        this.nombreMaquinaria = nombreMaquinaria;
    }

    public String getTipoMaquinaria() {
        return tipoMaquinaria;
    }

    public void setTipoMaquinaria(String tipoMaquinaria) {
        this.tipoMaquinaria = tipoMaquinaria;
    }

    public int getCostoMaquinaria() {
        return costoMaquinaria;
    }

    public void setCostoMaquinaria(int costoMaquinaria) {
        this.costoMaquinaria = costoMaquinaria;
    }

    public int getStockMaquinaria() {
        return stockMaquinaria;
    }

    public void setStockMaquinaria(int stockMaquinaria) {
        this.stockMaquinaria = stockMaquinaria;
    }

    public String getCodigoMaquinaria() {
        return codigoMaquinaria;
    }

    public void setCodigoMaquinaria(String codigoMaquinaria) {
        this.codigoMaquinaria = codigoMaquinaria;
    }

    @Override
    public String toString() {
        return "Maquinaria{" + "idMaquinaria=" + idMaquinaria + ", "
                + "nombreMaquinaria=" + nombreMaquinaria + ", tipoMaquinaria=" +
                tipoMaquinaria + ", costoMaquinaria=" + costoMaquinaria + ", "
                + "stockMaquinaria=" + stockMaquinaria + ", codigoMaquinaria=" 
                + codigoMaquinaria + '}';
    }

    
    
}
