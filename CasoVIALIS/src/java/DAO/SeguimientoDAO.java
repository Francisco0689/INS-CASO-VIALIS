/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Seguimiento;

/**
 *
 * @author fmaldonc
 */
public class SeguimientoDAO extends Modelo<Seguimiento>{

    @Override
    public String getNombreModelo() {
        return "Seguimiento";
    }
    
}
