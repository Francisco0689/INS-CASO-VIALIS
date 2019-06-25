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
public class Proveedor implements Serializable {

    private int idProveedor;
    private String rutProveedor;
    private String nombreProveedor;
    private String direccionProveedor;
    private String especialidadProveedor;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String rutProveedor, String nombreProveedor, String direccionProveedor, String especialidadProveedor) {
        this.idProveedor = idProveedor;
        this.rutProveedor = rutProveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionProveedor = direccionProveedor;
        this.especialidadProveedor = especialidadProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRutProveedor() {
        return rutProveedor;
    }

    public void setRutProveedor(String rutProveedor) {
        this.rutProveedor = rutProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionProveedor() {
        return direccionProveedor;
    }

    public void setDireccionProveedor(String direccionProveedor) {
        this.direccionProveedor = direccionProveedor;
    }

    public String getEspecialidadProveedor() {
        return especialidadProveedor;
    }

    public void setEspecialidadProveedor(String especialidadProveedor) {
        this.especialidadProveedor = especialidadProveedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "idProveedor=" + idProveedor + ", rutProveedor="
                + rutProveedor + ", nombreProveedor=" + nombreProveedor
                + ", direccionProveedor=" + direccionProveedor + ", especialidadProveedor="
                + especialidadProveedor + '}';
    }

}
