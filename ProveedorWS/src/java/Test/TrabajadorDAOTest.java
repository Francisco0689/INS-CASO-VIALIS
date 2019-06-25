/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import DAO.ProveedorDAO;
import Entities.Proveedor;


/**
 *
 * @author fmaldonc
 */
public class TrabajadorDAOTest {
    
    public static void main (String[] args){
    
        ProveedorDAO proDAO = new ProveedorDAO();
        
        for(Proveedor t: proDAO.ListaProveedores()){
            System.out.println(t.getNombreProveedor());
        }
    }
    
}
