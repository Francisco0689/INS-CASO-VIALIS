/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import entidades.Documento;

/**
 *
 * @author fmaldonc
 */
public class DocumentoDAO extends Modelo<Documento>{

    @Override
    public String getNombreModelo() {
        return "Documento";
    }
    
    
}
