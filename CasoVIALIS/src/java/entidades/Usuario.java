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
public class Usuario implements Serializable {

    private int idUsuario;
    private String nombreUsuario;
    private String passwordUsuario;
    private int idTrabajador;
    private int idRol;

    public Usuario() {
    }

    public Usuario(int idUsuario, String nombreUsuario, String passwordUsuario, int idTrabajador, int idRol) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.passwordUsuario = passwordUsuario;
        this.idTrabajador = idTrabajador;
        this.idRol = idRol;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPasswordUsuario() {
        return passwordUsuario;
    }

    public void setPasswordUsuario(String passwordUsuario) {
        this.passwordUsuario = passwordUsuario;
    }

    public int getIdTrabajador() {
        return idTrabajador;
    }

    public void setIdTrabajador(int idTrabajador) {
        this.idTrabajador = idTrabajador;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", nombreUsuario="
                + nombreUsuario + ", passwordUsuario=" + passwordUsuario
                + ", idTrabajador=" + idTrabajador + ", idRol=" + idRol + '}';
    }

}
