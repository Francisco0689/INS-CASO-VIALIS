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
public class Documento implements Serializable {

    private int idDocumento;
    private String nombreDocumento;
    private String tipoDocumento;
    private String rutaDocumento;
    private int idTrabajador;
    private int idProyecto;
    private int idCotizacion;

    public Documento() {
    }

    public Documento(int idDocumento, String nombreDocumento, String tipoDocumento, String rutaDocumento, int idTrabajador, int idProyecto, int idCotizacion) {
        this.idDocumento = idDocumento;
        this.nombreDocumento = nombreDocumento;
        this.tipoDocumento = tipoDocumento;
        this.rutaDocumento = rutaDocumento;
        this.idTrabajador = idTrabajador;
        this.idProyecto = idProyecto;
        this.idCotizacion = idCotizacion;
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

    public String getRutaDocumento() {
        return rutaDocumento;
    }

    public void setRutaDocumento(String rutaDocumento) {
        this.rutaDocumento = rutaDocumento;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    @Override
    public String toString() {
        return "Documento{" + "idDocumento=" + idDocumento + ", nombreDocumento="
                + nombreDocumento + ", tipoDocumento=" + tipoDocumento
                + ", rutaDocumento=" + rutaDocumento + ", idTrabajador="
                + idTrabajador + ", idProyecto=" + idProyecto + ", idCotizacion="
                + idCotizacion + '}';
    }

}
