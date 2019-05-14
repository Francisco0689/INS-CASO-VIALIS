/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Maquinaria;

/**
 *
 * @author fmaldonc
 */
public class MaquinariaDAO extends Modelo<Maquinaria>{

    @Override
    public String getNombreModelo() {
        return "Maquinaria";
    }
    
}
