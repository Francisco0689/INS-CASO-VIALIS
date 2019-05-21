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
public class PedidoMaterial {
    
    private int idPedidoMaterial;
    private int idMaterial;
    private int idProyecto;
    private int idHerramienta;
    private int idMaquinaria;

    public PedidoMaterial() {
    }

    public PedidoMaterial(int idPedidoMaterial, int idMaterial, int idProyecto, int idHerramienta, int idMaquinaria) {
        this.idPedidoMaterial = idPedidoMaterial;
        this.idMaterial = idMaterial;
        this.idProyecto = idProyecto;
        this.idHerramienta = idHerramienta;
        this.idMaquinaria = idMaquinaria;
    }

    public int getIdPedidoMaterial() {
        return idPedidoMaterial;
    }

    public void setIdPedidoMaterial(int idPedidoMaterial) {
        this.idPedidoMaterial = idPedidoMaterial;
    }

    public int getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(int idMaterial) {
        this.idMaterial = idMaterial;
    }

    public int getIdProyecto() {
        return idProyecto;
    }

    public void setIdProyecto(int idProyecto) {
        this.idProyecto = idProyecto;
    }

    public int getIdHerramienta() {
        return idHerramienta;
    }

    public void setIdHerramienta(int idHerramienta) {
        this.idHerramienta = idHerramienta;
    }

    public int getIdMaquinaria() {
        return idMaquinaria;
    }

    public void setIdMaquinaria(int idMaquinaria) {
        this.idMaquinaria = idMaquinaria;
    }

    @Override
    public String toString() {
        return "PedidoMaterial{" + "idPedidoMaterial=" + idPedidoMaterial 
                + ", idMaterial=" + idMaterial + ", idProyecto=" + idProyecto 
                + ", idHerramienta=" + idHerramienta + ", idMaquinaria=" 
                + idMaquinaria + '}';
    }
    
    
    
}
