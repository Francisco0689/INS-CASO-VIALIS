/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Hito;
import Modelo.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author fmaldonc
 */
public class HitoDAO {

    private Conexion conn;

    public HitoDAO() {
        conn = new Conexion();
    }

    public String agregarHito(Hito hito) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            String llamada = "{ call SP_AGREGAR_HITO(?,?,?) }";
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setString(1, hito.getNombreHito());
            cstmt.setDate(2, hito.getFechaHito());
            cstmt.setInt(3, hito.getIdProyecto());

            if (cstmt.executeUpdate() > 0) {
                respuesta = " *Hito Agregado Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }


}
