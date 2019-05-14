/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author fmaldonc
 */
public class Empleado {
    
    private String nombres;
    private String apellidos;
    private String rut;
    private String cargo;
    private String pass;

    public Empleado() {
    }

    public Empleado(String nombres, String apellidos, String rut, String cargo, String pass) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rut = rut;
        this.cargo = cargo;
        this.pass = pass;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Empleado{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", rut=" + rut + ", cargo=" + cargo + ", pass=" + pass + '}';
    }
    
    
    
}
