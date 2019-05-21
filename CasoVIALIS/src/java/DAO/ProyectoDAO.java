/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Proyecto;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fmaldonc
 */
public class ProyectoDAO {
    
    
    private Conexion conn;

    public ProyectoDAO() {
        conn = new Conexion();
    }

    public String agregarTrabajador(Proyecto proyec) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("INSERT INTO PROYECTO (NOMBRE_PROYECTO, "
                            + "TIPO_PROYECTO, ESTADO_PROYECTO, ENCARGADO_PROYECTO, DIRECCION_PROYECTO) "
                            + "VALUES (?,?,?,?,?)");
            ps.setString(1, proyec.getNombreProyecto());
            ps.setString(2, proyec.getTipoProyecto());
            ps.setString(3, proyec.getEstadoProyecto());
            ps.setString(4, proyec.getEncargadoProyecto());
            ps.setString(5, proyec.getDireccionProyecto());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Proyecto Agregado Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al INGRESAR Proyecto" + ex.getMessage();
        }

        return respuesta;
    }

    public Proyecto mostrarProyecto(int codigoProyecto) {
        Proyecto proyecto = new Proyecto();
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM PROYECTO WHERE ID=?");
            ps.setInt(1, codigoProyecto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proyecto.setIdProyecto(rs.getInt("ID"));
                proyecto.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));
                proyecto.setTipoProyecto(rs.getString("TIPO_PROYECTO"));
                proyecto.setEstadoProyecto(rs.getString("ESTADO_PROYECTO"));
                proyecto.setEncargadoProyecto(rs.getString("ENCARGADO_PROYECTO"));
                proyecto.setDireccionProyecto(rs.getString("DIRECCION_PROYECTO"));

                return proyecto;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return proyecto;
    }

    public List<Proyecto> ListarProyectos() {
        Proyecto proyecto = null;
        List<Proyecto> listaProyectos = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM PROYECTO");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                proyecto = new Proyecto();
                proyecto.setIdProyecto(rs.getInt("ID"));
                proyecto.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));
                proyecto.setTipoProyecto(rs.getString("TIPO_PROYECTO"));
                proyecto.setEstadoProyecto(rs.getString("ESTADO_PROYECTO"));
                proyecto.setEncargadoProyecto(rs.getString("ENCARGADO_PROYECTO"));
                proyecto.setDireccionProyecto(rs.getString("DIRECCION_PROYECTO"));
                
                listaProyectos.add(proyecto);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProyectos;
    }

    public String modificarProyecto(Proyecto proyect) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps = acceso.prepareStatement("UPDATE PROYECTO SET "
                    + "NOMBRE_PROYECTO =?, TIPO_PROYECTO =?, ESTADO_PROYECTO =?, "
                    + "ENCARGADO_PROYECTO =?, DIRECCION_PROYECTO =?"
                    + " WHERE ID = ?");
            ps.setString(1, proyect.getNombreProyecto());
            ps.setString(2, proyect.getTipoProyecto());
            ps.setString(3, proyect.getEstadoProyecto());
            ps.setString(4, proyect.getEncargadoProyecto());
            ps.setString(5, proyect.getDireccionProyecto());
            ps.setInt(5, proyect.getIdProyecto());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Proyecto Modificado Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al MODIFICAR PROYECTO" + ex.getMessage();
        }

        return respuesta;
    }
    
}
