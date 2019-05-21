/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.TrabajadorDAO;
import DAO.UsuarioDAO;
import Entidades.Trabajador;
import Entidades.Usuario;

/**
 *
 * @author fmaldonc
 */
public class TrabajadorDAOTest {
    
    public static void main (String[] args){
    
        TrabajadorDAO tDAO = new TrabajadorDAO();
        
        for(Trabajador t: tDAO.ListarTrabajadores()){
            System.out.println(t.getNombreTrabajador());
        }
    }
    
}
