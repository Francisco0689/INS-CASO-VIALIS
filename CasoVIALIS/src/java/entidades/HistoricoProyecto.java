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
public class HistoricoProyecto {
    
    private int idHistorico;
    private String nombreHistorico;
    private String estadoHistorico;
    private int idProyecto;

    public HistoricoProyecto() {
    }

    public HistoricoProyecto(int idHistorico, String nombreHistorico, String estadoHistorico, int idProyecto) {
        this.idHistorico = idHistorico;
        this.nombreHistorico = nombreHistorico;
        this.estadoHistorico = estadoHistorico;
        this.idProyecto = idProyecto;
    }

    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getNombreHistorico() {
        return nombreHistorico;
    }

    public void setNombreHistorico(String nombreHistorico) {
        this.nombreHistorico = nombreHistorico;
    }

    public String getEstadoHistorico() {
        return estadoHistorico;
    }

    public void setEstadoHistorico(String estadoHistorico) {
        this.estadoHistorico = estadoHistorico;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    @Override
    public String toString() {
        return "HistoricoProyecto{" + "idHistorico=" + idHistorico + ", "
                + "nombreHistorico=" + nombreHistorico + ", estadoHistorico=" 
                + estadoHistorico + ", idProyecto=" + idProyecto + '}';
    }
    
    
    
}
