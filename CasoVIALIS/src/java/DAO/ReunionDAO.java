/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Reunion;
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
public class ReunionDAO {

    private Conexion conn;

    public ReunionDAO() {
        conn = new Conexion();
    }

    public String agendarReunion(Reunion reu) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("INSERT INTO REUNION (ESTADO_REUNION, "
                            + "FECHA_REUNION, LUGAR_REUNION, ENCARGADO_REUNION,"
                            + "ID_PROYECTO, DESCRIPCION_INICIAL, HORA, MINUTO, DESCRIPCION_FINAL) "
                            + "VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setString(1, reu.getEstadoReunion());
            ps.setDate(2, reu.getFechaReunion());
            ps.setString(3, reu.getLugarReunion());
            ps.setString(4, reu.getEncargadoReunion());
            ps.setInt(5, reu.getIdProyecto());
            ps.setString(6, reu.getDescripcionInicial());
            ps.setInt(7, reu.getHora());
            ps.setInt(8, reu.getMin());
            ps.setString(9, reu.getDescripcionFinal());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Reunión Agendada Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al INGRESAR Reunión" + ex.getMessage();
        }

        return respuesta;
    }

    public Reunion buscarReunion(int codigoReunion) {
        Reunion reunion = null;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM REUNION REU JOIN \n"
                    + "PROYECTO PRO ON (REU.ID_PROYECTO = PRO.ID) WHERE REU.ID = ?");
            ps.setInt(1, codigoReunion);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                reunion = new Reunion();
                reunion.setIdReunion(rs.getInt("ID"));
                reunion.setEstadoReunion(rs.getString("ESTADO_REUNION"));
                reunion.setFechaReunion(rs.getDate("FECHA_REUNION"));
                reunion.setLugarReunion(rs.getString("LUGAR_REUNION"));
                reunion.setEncargadoReunion(rs.getString("ENCARGADO_REUNION"));
                reunion.setIdProyecto(rs.getInt("ID_PROYECTO"));
                reunion.setDescripcionInicial(rs.getString("DESCRIPCION_INICIAL"));
                reunion.setDescripcionFinal(rs.getString("DESCRIPCION_FINAL"));
                reunion.setHora(rs.getInt("HORA"));
                reunion.setMin(rs.getInt("MINUTO"));
                reunion.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));

                return reunion;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reunion;
    }

    public String modificarReunion(Reunion reu) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps = acceso.prepareStatement("UPDATE REUNION SET "
                    + "ESTADO_REUNION= ?, LUGAR_REUNION= ?, FECHA_REUNION= ?,"
                    + " ENCARGADO_REUNION= ?, DESCRIPCION_FINAL= ?, HORA= ?, "
                    + "MINUTO=? WHERE ID = ? ");
            ps.setString(1, reu.getEstadoReunion());
            ps.setString(2, reu.getLugarReunion());
            ps.setDate(3, reu.getFechaReunion());
            ps.setString(4, reu.getEncargadoReunion());
            ps.setString(5, reu.getDescripcionFinal());
            ps.setInt(6, reu.getHora());
            ps.setInt(7, reu.getMin());
            ps.setInt(8, reu.getIdReunion());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Reunión Modificado Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al MODIFICAR REUNIÓN" + ex.getMessage();
        }

        return respuesta;
    }

    public List<Reunion> ListarReuniones() {
        Reunion reunion = null;
        List<Reunion> listaReunion = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM REUNION REU "
                    + "JOIN PROYECTO PRO ON "
                    + "(REU.ID_PROYECTO = PRO.ID) WHERE REU.ESTADO_REUNION != 'NOACTIVO' "
                    + "ORDER BY REU.ID ASC");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reunion = new Reunion();
                reunion.setIdReunion(rs.getInt("ID"));
                reunion.setEstadoReunion(rs.getString("ESTADO_REUNION"));
                reunion.setFechaReunion(rs.getDate("FECHA_REUNION"));
                reunion.setLugarReunion(rs.getString("LUGAR_REUNION"));
                reunion.setEncargadoReunion(rs.getString("ENCARGADO_REUNION"));
                reunion.setIdProyecto(rs.getInt("ID_PROYECTO"));
                reunion.setDescripcionInicial(rs.getString("DESCRIPCION_INICIAL"));
                reunion.setDescripcionFinal(rs.getString("DESCRIPCION_FINAL"));
                reunion.setHora(rs.getInt("HORA"));
                reunion.setMin(rs.getInt("MINUTO"));
                reunion.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));

                listaReunion.add(reunion);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReunion;
    }

    public String eliminarReunion(int codigoReunion) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps = acceso.prepareStatement(""
                    + "UPDATE REUNION SET "
                    + "ESTADO_REUNION= 'NOACTIVO' "
                    + " WHERE ID = ?");
            ps.setInt(1, codigoReunion);

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Reunión Anulada Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al ANULAR REUNION" + ex.getMessage();
        }

        return respuesta;
    }

    public List<Reunion> buscarReunionesPorProyecto(int codigoProyecto) {
        
        List<Reunion> listaReunion = new ArrayList();
        listaReunion = null;
        Reunion reunion = null;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM REUNION REU "
                    + "JOIN PROYECTO PRO ON "
                    + "(REU.ID_PROYECTO = PRO.ID) WHERE REU.ESTADO_REUNION != 'NOACTIVO' AND ID_PROYECTO = ? "
                    + "ORDER BY REU.ID ASC");
            ps.setInt(1, codigoProyecto);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                reunion = new Reunion();
                reunion.setIdReunion(rs.getInt("ID"));
                reunion.setEstadoReunion(rs.getString("ESTADO_REUNION"));
                reunion.setFechaReunion(rs.getDate("FECHA_REUNION"));
                reunion.setLugarReunion(rs.getString("LUGAR_REUNION"));
                reunion.setEncargadoReunion(rs.getString("ENCARGADO_REUNION"));
                reunion.setIdProyecto(rs.getInt("ID_PROYECTO"));
                reunion.setDescripcionInicial(rs.getString("DESCRIPCION_INICIAL"));
                reunion.setDescripcionFinal(rs.getString("DESCRIPCION_FINAL"));
                reunion.setHora(rs.getInt("HORA"));
                reunion.setMin(rs.getInt("MINUTO"));
                reunion.setNombreProyecto(rs.getString("NOMBRE_PROYECTO"));

                listaReunion.add(reunion);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaReunion;
    }

}
