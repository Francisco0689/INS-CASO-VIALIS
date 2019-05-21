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
public class Trabajador {
    
    private int idTrabajador;
    private String nombreTrabajador;
    private String apellidoTrabajador;
    private int rutTrabajador;
    private int dvTrabajador;
    private String estadoCivilTrabajador;
    private String direccionTrabajador;
    private int telefonoTrabajador;
    private String estadoTrabajador;
    private String nacionalidadTrabajador;
    private String condicionExtranjeroTrabajador;
    private String especialidadTrabajador;

    public Trabajador() {
    }

    public Trabajador(int idTrabajador, String nombreTrabajador, String apellidoTrabajador, int rutTrabajador, int dvTrabajador, String estadoCivilTrabajador, String direccionTrabajador, int telefonoTrabajador, String estadoTrabajador, String nacionalidadTrabajador, String condicionExtranjeroTrabajador, String especialidadTrabajador) {
        this.idTrabajador = idTrabajador;
        this.nombreTrabajador = nombreTrabajador;
        this.apellidoTrabajador = apellidoTrabajador;
        this.rutTrabajador = rutTrabajador;
        this.dvTrabajador = dvTrabajador;
        this.estadoCivilTrabajador = estadoCivilTrabajador;
        this.direccionTrabajador = direccionTrabajador;
        this.telefonoTrabajador = telefonoTrabajador;
        this.estadoTrabajador = estadoTrabajador;
        this.nacionalidadTrabajador = nacionalidadTrabajador;
        this.condicionExtranjeroTrabajador = condicionExtranjeroTrabajador;
        this.especialidadTrabajador = especialidadTrabajador;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public String getNombreTrabajador() {
        return nombreTrabajador;
    }

    public void setNombreTrabajador(String nombreTrabajador) {
        this.nombreTrabajador = nombreTrabajador;
    }

    public String getApellidoTrabajador() {
        return apellidoTrabajador;
    }

    public void setApellidoTrabajador(String apellidoTrabajador) {
        this.apellidoTrabajador = apellidoTrabajador;
    }

    public int getRutTrabajador() {
        return rutTrabajador;
    }

    public void setRutTrabajador(int rutTrabajador) {
        this.rutTrabajador = rutTrabajador;
    }

    public int getDvTrabajador() {
        return dvTrabajador;
    }

    public void setDvTrabajador(int dvTrabajador) {
        this.dvTrabajador = dvTrabajador;
    }

    public String getEstadoCivilTrabajador() {
        return estadoCivilTrabajador;
    }

    public void setEstadoCivilTrabajador(String estadoCivilTrabajador) {
        this.estadoCivilTrabajador = estadoCivilTrabajador;
    }

    public String getDireccionTrabajador() {
        return direccionTrabajador;
    }

    public void setDireccionTrabajador(String direccionTrabajador) {
        this.direccionTrabajador = direccionTrabajador;
    }

    public int getTelefonoTrabajador() {
        return telefonoTrabajador;
    }

    public void setTelefonoTrabajador(int telefonoTrabajador) {
        this.telefonoTrabajador = telefonoTrabajador;
    }

    public String getEstadoTrabajador() {
        return estadoTrabajador;
    }

    public void setEstadoTrabajador(String estadoTrabajador) {
        this.estadoTrabajador = estadoTrabajador;
    }

    public String getNacionalidadTrabajador() {
        return nacionalidadTrabajador;
    }

    public void setNacionalidadTrabajador(String nacionalidadTrabajador) {
        this.nacionalidadTrabajador = nacionalidadTrabajador;
    }

    public String getCondicionExtranjeroTrabajador() {
        return condicionExtranjeroTrabajador;
    }

    public void setCondicionExtranjeroTrabajador(String condicionExtranjeroTrabajador) {
        this.condicionExtranjeroTrabajador = condicionExtranjeroTrabajador;
    }

    public String getEspecialidadTrabajador() {
        return especialidadTrabajador;
    }

    public void setEspecialidadTrabajador(String especialidadTrabajador) {
        this.especialidadTrabajador = especialidadTrabajador;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "idTrabajador=" + idTrabajador + ", nombreTrabajador=" 
                + nombreTrabajador + ", apellidoTrabajador=" + apellidoTrabajador + ","
                + " rutTrabajador=" + rutTrabajador + ", dvTrabajador=" + dvTrabajador 
                + ", estadoCivilTrabajador=" + estadoCivilTrabajador + ", direccionTrabajador="
                + direccionTrabajador + ", telefonoTrabajador=" + telefonoTrabajador + ", "
                + "estadoTrabajador=" + estadoTrabajador + ", nacionalidadTrabajador=" + 
                nacionalidadTrabajador + ", condicionExtranjeroTrabajador=" + condicionExtranjeroTrabajador 
                + ", especialidadTrabajador=" + especialidadTrabajador + '}';
    }
    
    
    
    
}
