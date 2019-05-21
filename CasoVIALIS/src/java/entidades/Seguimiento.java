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
public class Seguimiento {
    
    private int idSeguimiento;
    private String estadoSeguimientoProyecto;
    private int idProyecto;

    public Seguimiento() {
    }

    public Seguimiento(int idSeguimiento, String estadoSeguimientoProyecto, int idProyecto) {
        this.idSeguimiento = idSeguimiento;
        this.estadoSeguimientoProyecto = estadoSeguimientoProyecto;
        this.idProyecto = idProyecto;
    }

    public int getIdSeguimiento() {
        return idSeguimiento;
    }

    public void setIdSeguimiento(int idSeguimiento) {
        this.idSeguimiento = idSeguimiento;
    }

    public String getEstadoSeguimientoProyecto() {
        return estadoSeguimientoProyecto;
    }

    public void setEstadoSeguimientoProyecto(String estadoSeguimientoProyecto) {
        this.estadoSeguimientoProyecto = estadoSeguimientoProyecto;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "Seguimiento{" + "idSeguimiento=" + idSeguimiento + 
                ", estadoSeguimientoProyecto=" + estadoSeguimientoProyecto 
                + ", idProyecto=" + idProyecto + '}';
    }
    
    
    
}
