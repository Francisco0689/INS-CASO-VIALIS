/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Proyecto;

/**
 *
 * @author fmaldonc
 */
public class ProyectoDAO extends Modelo<Proyecto>{

    @Override
    public String getNombreModelo() {
        return "Proyecto";
    }
    
}
