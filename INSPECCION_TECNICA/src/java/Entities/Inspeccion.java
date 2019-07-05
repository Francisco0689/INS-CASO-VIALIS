/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.io.Serializable;

/**
 *
 * @author Francisco Maldonado
 */
public class Inspeccion implements Serializable {

    private int idInspeccion;
    private String nombreDocumento;
    private String tipoDocumento;
    private String rutaDocumento;

    public Inspeccion() {
    }

    public Inspeccion(int idInspeccion, String nombreDocumento, String tipoDocumento, String rutaDocumento) {
        this.idInspeccion = idInspeccion;
        this.nombreDocumento = nombreDocumento;
        this.tipoDocumento = tipoDocumento;
        this.rutaDocumento = rutaDocumento;
    }

    public int getIdInspeccion() {
        return idInspeccion;
    }

    public void setIdInspeccion(int idInspeccion) {
        this.idInspeccion = idInspeccion;
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

    public String getRutaDocumento() {
        return rutaDocumento;
    }

    public void setRutaDocumento(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    @Override
    public String toString() {
        return "Inspeccion{" + "idInspeccion=" + idInspeccion
                + ", nombreDocumento=" + nombreDocumento + ", tipoDocumento="
                + tipoDocumento + ", rutaDocumento=" + rutaDocumento + '}';
    }

}
