/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Trabajador;
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
public class TrabajadorDAO {

    private Conexion conn;

    public TrabajadorDAO() {
        conn = new Conexion();
    }

    public String agregarTrabajador(Trabajador emp) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("INSERT INTO TRABAJADOR"
                            + " (NOMBRE_TRABAJADOR, APELLIDO_TRABAJADOR, RUT_TRABAJADOR,"
                            + "DV_TRABAJADOR, ESTADO_CIVIL_TRABAJADOR, DIRECCION_TRABAJADOR,"
                            + "TELEFONO_TRABAJADOR, ESTADO_TRABAJADOR, NACIONALIDAD_TRABAJADOR,"
                            + "CONDICION_EXTRANJERO_TRAB, ESPECIALIDAD_TRABAJADOR)"
                            + " VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, emp.getNombreTrabajador());
            ps.setString(2, emp.getApellidoTrabajador());
            ps.setInt(3, emp.getRutTrabajador());
            ps.setInt(4, emp.getDvTrabajador());
            ps.setString(5, emp.getEstadoCivilTrabajador());
            ps.setString(6, emp.getDireccionTrabajador());
            ps.setInt(7, emp.getTelefonoTrabajador());
            ps.setString(8, emp.getEstadoTrabajador());
            ps.setString(9, emp.getNacionalidadTrabajador());
            ps.setString(10, emp.getCondicionExtranjeroTrabajador());
            ps.setString(11, emp.getEspecialidadTrabajador());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Empleado Agregado Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al INGRESAR EMPLEADO" + ex.getMessage();
        }

        return respuesta;
    }

    public Trabajador mostrarTrabajador(int rut) {
        Trabajador trabajador = new Trabajador();
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM TRABAJADOR WHERE RUT_TRABAJADOR=?");
            ps.setInt(1, rut);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                trabajador.setIdTrabajador(rs.getInt("ID"));
                trabajador.setNombreTrabajador(rs.getString("NOMBRE_TRABAJADOR"));
                trabajador.setApellidoTrabajador(rs.getString("APELLIDO_TRABAJADOR"));
                trabajador.setRutTrabajador(rs.getInt("RUT_TRABAJADOR"));
                trabajador.setDvTrabajador(rs.getInt("DV_TRABAJADOR"));
                trabajador.setEstadoCivilTrabajador(rs.getString("ESTADO_CIVIL_TRABAJADOR"));
                trabajador.setDireccionTrabajador(rs.getString("DIRECCION_TRABAJADOR"));
                trabajador.setTelefonoTrabajador(rs.getInt("TELEFONO_TRABAJADOR"));
                trabajador.setEstadoTrabajador(rs.getString("ESTADO_TRABAJADOR"));
                trabajador.setNacionalidadTrabajador(rs.getString("NACIONALIDAD_TRABAJADOR"));
                trabajador.setCondicionExtranjeroTrabajador(rs.getString("CONDICION_EXTRANJERO_TRAB"));
                trabajador.setEspecialidadTrabajador(rs.getString("ESPECIALIDAD_TRABAJADOR"));

                return trabajador;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return trabajador;
    }

    public List<Trabajador> ListarTrabajadores() {
        Trabajador trabajador = null;
        List<Trabajador> listaEmpleados = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM TRABAJADOR");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setIdTrabajador(rs.getInt("ID"));
                trabajador.setNombreTrabajador(rs.getString("NOMBRE_TRABAJADOR"));
                trabajador.setApellidoTrabajador(rs.getString("APELLIDO_TRABAJADOR"));
                trabajador.setRutTrabajador(rs.getInt("RUT_TRABAJADOR"));
                trabajador.setDvTrabajador(rs.getInt("DV_TRABAJADOR"));
                trabajador.setEstadoCivilTrabajador(rs.getString("ESTADO_CIVIL_TRABAJADOR"));
                trabajador.setDireccionTrabajador(rs.getString("DIRECCION_TRABAJADOR"));
                trabajador.setTelefonoTrabajador(rs.getInt("TELEFONO_TRABAJADOR"));
                trabajador.setEstadoTrabajador(rs.getString("ESTADO_TRABAJADOR"));
                trabajador.setNacionalidadTrabajador(rs.getString("NACIONALIDAD_TRABAJADOR"));
                trabajador.setCondicionExtranjeroTrabajador(rs.getString("CONDICION_EXTRANJERO_TRAB"));
                trabajador.setEspecialidadTrabajador(rs.getString("ESPECIALIDAD_TRABAJADOR"));
                listaEmpleados.add(trabajador);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEmpleados;
    }

    public String modificarEmpleado(Trabajador emp) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps = acceso.prepareStatement(""
                    + "UPDATE EMPLEADO SET NOMBRE_TRABAJADOR=?, APELLIDO_TRABAJADOR=?, "
                    + "ESTADO_CIVIL_TRABAJADOR=?, DIRECCION_TRABAJADOR=?, TELEFONO_TRABAJADOR=?,"
                    + "ESTADO_TRABAJADOR=?, NACIONALIDAD_TRABAJADOR=?, CONDICION_EXTRANJERO_TRAB=?,"
                    + "ESPECIALIDAD_TRABAJADOR=?"
                    + " WHERE RUT_TRABAJADOR = ?");
            ps.setString(1, emp.getNombreTrabajador());
            ps.setString(2, emp.getApellidoTrabajador());
            ps.setString(3, emp.getEstadoCivilTrabajador());
            ps.setString(4, emp.getDireccionTrabajador());
            ps.setInt(5, emp.getTelefonoTrabajador());
            ps.setString(6, emp.getEstadoTrabajador());
            ps.setString(7, emp.getNacionalidadTrabajador());
            ps.setString(8, emp.getCondicionExtranjeroTrabajador());
            ps.setString(9, emp.getEspecialidadTrabajador());
            ps.setInt(10, emp.getRutTrabajador());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Empleado Modificado Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al MODIFICAR EMPLEADO" + ex.getMessage();
        }

        return respuesta;
    }
}
