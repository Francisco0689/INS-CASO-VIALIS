/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Usuario;

/**
 *
 * @author fmaldonc
 */
public class UsuarioDAO extends Modelo<Usuario>{

    @Override
    public String getNombreModelo() {
        return "Usuario"; 
    }
    
    
    
}
