/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Reunion;
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
            String llamada = "{ call SP_AGENDAR_REUNION(?,?,?,?,?,?,?,?,?) }";
            CallableStatement cstmt = acceso.prepareCall(llamada);

            cstmt.setString(1, reu.getEstadoReunion());
            cstmt.setDate(2, reu.getFechaReunion());
            cstmt.setString(3, reu.getLugarReunion());
            cstmt.setString(4, reu.getEncargadoReunion());
            cstmt.setInt(5, reu.getIdProyecto());
            cstmt.setString(6, reu.getDescripcionInicial());
            cstmt.setInt(7, reu.getHora());
            cstmt.setInt(8, reu.getMin());
            cstmt.setString(9, reu.getDescripcionFinal());

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Reunión Agendada Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR Reunión " + ex.getMessage());
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

            String llamada = "{ call SP_MODIFICAR_REUNION(?,?,?,?,?,?,?,?) }";
            CallableStatement cstmt = acceso.prepareCall(llamada);

            cstmt.setString(1, reu.getEstadoReunion());
            cstmt.setString(2, reu.getLugarReunion());
            cstmt.setDate(3, reu.getFechaReunion());
            cstmt.setString(4, reu.getEncargadoReunion());
            cstmt.setString(5, reu.getDescripcionFinal());
            cstmt.setInt(6, reu.getHora());
            cstmt.setInt(7, reu.getMin());
            cstmt.setInt(8, reu.getIdReunion());

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Reunión Modificada Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al MODIFICAR REUNIÓN" + ex.getMessage());
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
                    + "(REU.ID_PROYECTO = PRO.ID)"
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
                    + "ESTADO_REUNION= 'ANULADA' "
                    + " WHERE ID = ?");
            ps.setInt(1, codigoReunion);

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Reunión Anulada Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al ANULAR REUNION" + ex.getMessage());
        }

        return respuesta;
    }

    public List<Reunion> buscarReunionesPorProyecto(int codigoProyecto) {

        List<Reunion> listaReunion = new ArrayList();
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
