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
public class Documento {
    
    private int idDocumento;
    private String nombreDocumento;
    private String tipoDocumento;
    private String codigoDocumento;

    public Documento() {
    }

    public Documento(int idDocumento, String nombreDocumento, String tipoDocumento, String codigoDocumento) {
        this.idDocumento = idDocumento;
        this.nombreDocumento = nombreDocumento;
        this.tipoDocumento = tipoDocumento;
        this.codigoDocumento = codigoDocumento;
    }

    public int getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(int idDocumento) {
        this.idDocumento = idDocumento;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getCodigoDocumento() {
        return codigoDocumento;
    }

    public void setCodigoDocumento(String codigoDocumento) {
        this.codigoDocumento = codigoDocumento;
    }

    @Override
    public String toString() {
        return "Documento{" + "idDocumento=" + idDocumento + ", nombreDocumento=" 
                + nombreDocumento + ", tipoDocumento=" + tipoDocumento + ", codigoDocumento="
                + codigoDocumento + '}';
    }
    
    
    
}
