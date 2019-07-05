/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Hito;
import Entidades.Proyecto;
import Modelo.Conexion;
import java.sql.CallableStatement;
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

    public String agregarProyecto(Proyecto proyec) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            String llamada = "{ call SP_AGREGAR_PROYECTO(?,?,?,?,?) }";
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setString(1, proyec.getNombreProyecto());
            cstmt.setString(2, proyec.getTipoProyecto());
            cstmt.setString(3, proyec.getEstadoProyecto());
            cstmt.setString(4, proyec.getEncargadoProyecto());
            cstmt.setString(5, proyec.getDireccionProyecto());

            if (cstmt.executeUpdate() > 0) {
                respuesta = " *Proyecto Agregado Correctamente al Sistema VIALIS ";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }

    public Proyecto mostrarProyectoPorCodigo(int codigoProyecto) {
        Proyecto proyecto = null;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM PROYECTO WHERE ID=?");
            ps.setInt(1, codigoProyecto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proyecto = new Proyecto();
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

    public Proyecto mostrarProyectoPorNombre(String nombreProyecto) {
        Proyecto proyecto = null;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM PROYECTO WHERE NOMBRE_PROYECTO = ?");
            ps.setString(1, nombreProyecto);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                proyecto = new Proyecto();
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
        Proyecto proyecto;
        Hito hito;
        List<Proyecto> listaProyectos = new ArrayList();
        List<Hito> listaHitos;

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM PROYECTO ORDER BY ID");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                proyecto = new Proyecto();
                proyecto.setIdProyecto(rs.getInt("ID"));
                proyecto.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));
                proyecto.setTipoProyecto(rs.getString("TIPO_PROYECTO"));
                proyecto.setEstadoProyecto(rs.getString("ESTADO_PROYECTO"));
                proyecto.setEncargadoProyecto(rs.getString("ENCARGADO_PROYECTO"));
                proyecto.setDireccionProyecto(rs.getString("DIRECCION_PROYECTO"));

                PreparedStatement ps2 = acceso.prepareStatement("SELECT * FROM HITO WHERE ID_PROYECTO = ? ORDER BY ID");
                ps2.setInt(1, proyecto.getIdProyecto());
                ResultSet rs2 = ps2.executeQuery();
                listaHitos = new ArrayList();

                    while (rs2.next()) {
                        hito = new Hito();
                        hito.setIdHito(rs2.getInt("ID"));
                        hito.setNombreHito(rs2.getString("NOMBRE_HITO"));
                        hito.setFechaHito(rs2.getDate("FECHA_HITO"));
                        hito.setIdProyecto(rs2.getInt("ID_PROYECTO"));

                        listaHitos.add(hito);
                    }
                    
                proyecto.setHitos(listaHitos);
                
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

            String llamada = "{ call SP_MODIFICAR_PROYECTO(?,?,?,?,?,?) }";
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setString(1, proyect.getNombreProyecto());
            cstmt.setString(2, proyect.getTipoProyecto());
            cstmt.setString(3, proyect.getEstadoProyecto());
            cstmt.setString(4, proyect.getEncargadoProyecto());
            cstmt.setString(5, proyect.getDireccionProyecto());
            cstmt.setInt(6, proyect.getIdProyecto());

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Proyecto Modificado Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return respuesta;
    }

    public int obtenerIdUltimoProyectoAgregado() {
        Connection acceso = conn.getCnn();
        int codigoUltimoProyecto = 0;

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT MAX(ID) AS ID FROM PROYECTO");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                codigoUltimoProyecto = rs.getInt("ID");

                return codigoUltimoProyecto;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return codigoUltimoProyecto;
    }

}
