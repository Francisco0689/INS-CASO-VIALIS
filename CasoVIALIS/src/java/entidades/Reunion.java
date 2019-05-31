/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author fmaldonc
 */
public class Reunion implements Serializable{
    
    private int idReunion;
    private String estadoReunion;
    private Date fechaReunion; 
    private String lugarReunion;
    private String encargadoReunion;
    private int idProyecto;
    private String descripcionInicial;
    private String descripcionFinal;
    private int hora;
    private int min;
    private String nombreProyecto;

    public Reunion() {
    }

    public Reunion(int idReunion, String estadoReunion, Date fechaReunion, String lugarReunion, String encargadoReunion, int idProyecto, String descripcionInicial, String descripcionFinal, int hora, int min, String nombreProyecto) {
        this.idReunion = idReunion;
        this.estadoReunion = estadoReunion;
        this.fechaReunion = fechaReunion;
        this.lugarReunion = lugarReunion;
        this.encargadoReunion = encargadoReunion;
        this.idProyecto = idProyecto;
        this.descripcionInicial = descripcionInicial;
        this.descripcionFinal = descripcionFinal;
        this.hora = hora;
        this.min = min;
        this.nombreProyecto = nombreProyecto;
    }

    public int getIdReunion() {
        return idReunion;
    }

    public void setIdReunion(int idReunion) {
        this.idReunion = idReunion;
    }

    public String getEstadoReunion() {
        return estadoReunion;
    }

    public void setEstadoReunion(String estadoReunion) {
        this.estadoReunion = estadoReunion;
    }

    public Date getFechaReunion() {
        return fechaReunion;
    }

    public void setFechaReunion(Date fechaReunion) {
        this.fechaReunion = fechaReunion;
    }

    public String getLugarReunion() {
        return lugarReunion;
    }

    public void setLugarReunion(String lugarReunion) {
        this.lugarReunion = lugarReunion;
    }

    public String getEncargadoReunion() {
        return encargadoReunion;
    }

    public void setEncargadoReunion(String encargadoReunion) {
        this.encargadoReunion = encargadoReunion;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public String getDescripcionInicial() {
        return descripcionInicial;
    }

    public void setDescripcionInicial(String descripcionInicial) {
        this.descripcionInicial = descripcionInicial;
    }

    public String getDescripcionFinal() {
        return descripcionFinal;
    }

    public void setDescripcionFinal(String descripcionFinal) {
        this.descripcionFinal = descripcionFinal;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    @Override
    public String toString() {
        return "Reunion{" + "idReunion=" + idReunion + ", estadoReunion=" + 
                estadoReunion + ", fechaReunion=" + fechaReunion + ", "
                + "lugarReunion=" + lugarReunion + ", encargadoReunion=" + 
                encargadoReunion + ", idProyecto=" + idProyecto + ", "
                + "descripcionInicial=" + descripcionInicial + ", "
                + "descripcionFinal=" + descripcionFinal + ", hora=" + hora +
                ", min=" + min + ", nombreProyecto=" + nombreProyecto + '}';
    }
    
    
    
}
