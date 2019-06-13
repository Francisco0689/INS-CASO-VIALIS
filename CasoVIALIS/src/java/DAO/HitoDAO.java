/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Hito;
import Modelo.Conexion;
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

            PreparedStatement ps
                    = acceso.prepareStatement("INSERT INTO HITO (NOMBRE_HITO, "
                            + "FECHA_HITO, ID_PROYECTO) "
                            + "VALUES (?,?,?)");
            ps.setString(1, hito.getNombreHito());
            ps.setDate(2, hito.getFechaHito());
            ps.setInt(3, hito.getIdProyecto());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = " *Hito Agregado Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }


}
