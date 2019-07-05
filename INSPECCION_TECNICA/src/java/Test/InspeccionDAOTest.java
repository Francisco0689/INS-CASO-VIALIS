/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.InspeccionDAO;
import Entities.Inspeccion;


/**
 *
 * @author fmaldonc
 */
public class InspeccionDAOTest {
    
    public static void main (String[] args){
    
        InspeccionDAO insDAO = new InspeccionDAO();
        
        for(Inspeccion t: insDAO.ListaInspeccion()){
            System.out.println(t.getNombreDocumento());
        }
    }
    
}
