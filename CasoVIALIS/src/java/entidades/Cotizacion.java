/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fmaldonc
 */
public class Cotizacion implements Serializable {

    private int idCotizacion;
    private String estadoCotizacion;
    private String proveedor;
    private String herramienta;
    private String material;
    private String maquinaria;
    private String servicioExterno;
    private int idProyectoRelacionado;
    private String nombreProyectoRelacionado;
    private List<Documento> documentos;

    public Cotizacion() {
    }

    public Cotizacion(int idCotizacion, String estadoCotizacion, String proveedor, String herramienta, String material, String maquinaria, String servicioExterno, int idProyectoRelacionado, String nombreProyectoRelacionado, List<Documento> documentos) {
        this.idCotizacion = idCotizacion;
        this.estadoCotizacion = estadoCotizacion;
        this.proveedor = proveedor;
        this.herramienta = herramienta;
        this.material = material;
        this.maquinaria = maquinaria;
        this.servicioExterno = servicioExterno;
        this.idProyectoRelacionado = idProyectoRelacionado;
        this.nombreProyectoRelacionado = nombreProyectoRelacionado;
        this.documentos = documentos;
    }

    public int getIdCotizacion() {
        return idCotizacion;
    }

    public void setIdCotizacion(int idCotizacion) {
        this.idCotizacion = idCotizacion;
    }

    public String getEstadoCotizacion() {
        return estadoCotizacion;
    }

    public void setEstadoCotizacion(String estadoCotizacion) {
        this.estadoCotizacion = estadoCotizacion;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String Material) {
        this.material = Material;
    }

    public String getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(String maquinaria) {
        this.maquinaria = maquinaria;
    }

    public String getServicioExterno() {
        return servicioExterno;
    }

    public void setServicioExterno(String servicioExterno) {
        this.servicioExterno = servicioExterno;
    }

    public int getIdProyectoRelacionado() {
        return idProyectoRelacionado;
    }

    public void setIdProyectoRelacionado(int idProyectoRelacionado) {
        this.idProyectoRelacionado = idProyectoRelacionado;
    }

    public String getNombreProyectoRelacionado() {
        return nombreProyectoRelacionado;
    }

    public void setNombreProyectoRelacionado(String nombreProyectoRelacionado) {
        this.nombreProyectoRelacionado = nombreProyectoRelacionado;
    }

    public List<Documento> getDocumentos() {
        return documentos;
    }

    public void setDocumentos(List<Documento> documentos) {
        this.documentos = documentos;
    }

    @Override
    public String toString() {
        return "Cotizacion{" + "idCotizacion=" + idCotizacion + ", estadoCotizacion="
                + estadoCotizacion + ", proveedor=" + proveedor + ", herramienta="
                + herramienta + ", Material=" + material + ", maquinaria="
                + maquinaria + ", servicioExterno=" + servicioExterno
                + ", idProyectoRelacionado=" + idProyectoRelacionado
                + ", nombreProyectoRelacionado=" + nombreProyectoRelacionado
                + ", documentos=" + documentos + '}';
    }

}
