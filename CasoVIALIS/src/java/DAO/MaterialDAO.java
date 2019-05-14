/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Material;

/**
 *
 * @author fmaldonc
 */
public class MaterialDAO extends Modelo<Material>{

    @Override
    public String getNombreModelo() {
        return "Material";
    }
    
}
