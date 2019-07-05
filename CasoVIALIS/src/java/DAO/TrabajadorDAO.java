/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Trabajador;
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
            String llamada = "{ call SP_AGREGAR_TRABAJADOR(?,?,?,?,?,?,?,?,?,?,?,?,?) }";
            CallableStatement cstmt = acceso.prepareCall(llamada);

            cstmt.setString(1, emp.getNombreTrabajador());
            cstmt.setString(2, emp.getApellidoTrabajador());
            cstmt.setInt(3, emp.getRutTrabajador());
            cstmt.setString(4, emp.getDvTrabajador());
            cstmt.setString(5, emp.getEstadoCivilTrabajador());
            cstmt.setString(6, emp.getDireccionTrabajador());
            cstmt.setInt(7, emp.getTelefonoTrabajador());
            cstmt.setString(8, emp.getEstadoTrabajador());
            cstmt.setString(9, emp.getNacionalidadTrabajador());
            cstmt.setString(10, emp.getCondicionExtranjeroTrabajador());
            cstmt.setString(11, emp.getEspecialidadTrabajador());
            cstmt.setString(12, emp.getResponsabilidadTrabajador());
            cstmt.setInt(13, emp.getSueldoTrabajador());

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Trabajador Ingresado Correctamente al Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR EMPLEADO" + ex.getMessage());
        }

        return respuesta;
    }

    public Trabajador mostrarTrabajador(int rut) {
        Trabajador trabajador = null;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM TRABAJADOR WHERE RUT_TRABAJADOR=?");
            ps.setInt(1, rut);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setIdTrabajador(rs.getInt("ID"));
                trabajador.setNombreTrabajador(rs.getString("NOMBRE_TRABAJADOR"));
                trabajador.setApellidoTrabajador(rs.getString("APELLIDO_TRABAJADOR"));
                trabajador.setRutTrabajador(rs.getInt("RUT_TRABAJADOR"));
                trabajador.setDvTrabajador(rs.getString("DV_TRABAJADOR"));
                trabajador.setEstadoCivilTrabajador(rs.getString("ESTADO_CIVIL_TRABAJADOR"));
                trabajador.setDireccionTrabajador(rs.getString("DIRECCION_TRABAJADOR"));
                trabajador.setTelefonoTrabajador(rs.getInt("TELEFONO_TRABAJADOR"));
                trabajador.setEstadoTrabajador(rs.getString("ESTADO_TRABAJADOR"));
                trabajador.setNacionalidadTrabajador(rs.getString("NACIONALIDAD_TRABAJADOR"));
                trabajador.setCondicionExtranjeroTrabajador(rs.getString("CONDICION_EXTRANJERO_TRAB"));
                trabajador.setEspecialidadTrabajador(rs.getString("ESPECIALIDAD_TRABAJADOR"));
                trabajador.setResponsabilidadTrabajador(rs.getString("RESPONSABILIDAD"));
                trabajador.setSueldoTrabajador(rs.getInt("SUELDO"));

                return trabajador;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return trabajador;
    }

    public Trabajador mostrarTrabajadorPorCodigoInterno(int codigoTrabajador) {
        Trabajador trabajador = null;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM TRABAJADOR WHERE ID=?");
            ps.setInt(1, codigoTrabajador);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setIdTrabajador(rs.getInt("ID"));
                trabajador.setNombreTrabajador(rs.getString("NOMBRE_TRABAJADOR"));
                trabajador.setApellidoTrabajador(rs.getString("APELLIDO_TRABAJADOR"));
                trabajador.setRutTrabajador(rs.getInt("RUT_TRABAJADOR"));
                trabajador.setDvTrabajador(rs.getString("DV_TRABAJADOR"));
                trabajador.setEstadoCivilTrabajador(rs.getString("ESTADO_CIVIL_TRABAJADOR"));
                trabajador.setDireccionTrabajador(rs.getString("DIRECCION_TRABAJADOR"));
                trabajador.setTelefonoTrabajador(rs.getInt("TELEFONO_TRABAJADOR"));
                trabajador.setEstadoTrabajador(rs.getString("ESTADO_TRABAJADOR"));
                trabajador.setNacionalidadTrabajador(rs.getString("NACIONALIDAD_TRABAJADOR"));
                trabajador.setCondicionExtranjeroTrabajador(rs.getString("CONDICION_EXTRANJERO_TRAB"));
                trabajador.setEspecialidadTrabajador(rs.getString("ESPECIALIDAD_TRABAJADOR"));
                trabajador.setResponsabilidadTrabajador(rs.getString("RESPONSABILIDAD"));
                trabajador.setSueldoTrabajador(rs.getInt("SUELDO"));

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
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM TRABAJADOR WHERE ESTADO_TRABAJADOR = 'ACTIVO' ORDER BY ID ASC");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                trabajador = new Trabajador();
                trabajador.setIdTrabajador(rs.getInt("ID"));
                trabajador.setNombreTrabajador(rs.getString("NOMBRE_TRABAJADOR"));
                trabajador.setApellidoTrabajador(rs.getString("APELLIDO_TRABAJADOR"));
                trabajador.setRutTrabajador(rs.getInt("RUT_TRABAJADOR"));
                trabajador.setDvTrabajador(rs.getString("DV_TRABAJADOR"));
                trabajador.setEstadoCivilTrabajador(rs.getString("ESTADO_CIVIL_TRABAJADOR"));
                trabajador.setDireccionTrabajador(rs.getString("DIRECCION_TRABAJADOR"));
                trabajador.setTelefonoTrabajador(rs.getInt("TELEFONO_TRABAJADOR"));
                trabajador.setEstadoTrabajador(rs.getString("ESTADO_TRABAJADOR"));
                trabajador.setNacionalidadTrabajador(rs.getString("NACIONALIDAD_TRABAJADOR"));
                trabajador.setCondicionExtranjeroTrabajador(rs.getString("CONDICION_EXTRANJERO_TRAB"));
                trabajador.setEspecialidadTrabajador(rs.getString("ESPECIALIDAD_TRABAJADOR"));
                trabajador.setResponsabilidadTrabajador(rs.getString("RESPONSABILIDAD"));
                trabajador.setSueldoTrabajador(rs.getInt("SUELDO"));
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
                    + "UPDATE TRABAJADOR SET NOMBRE_TRABAJADOR=?, APELLIDO_TRABAJADOR=?, "
                    + "ESTADO_CIVIL_TRABAJADOR=?, DIRECCION_TRABAJADOR=?, TELEFONO_TRABAJADOR=?,"
                    + "ESTADO_TRABAJADOR=?, NACIONALIDAD_TRABAJADOR=?, CONDICION_EXTRANJERO_TRAB=?,"
                    + "ESPECIALIDAD_TRABAJADOR=?, RESPONSABILIDAD=?, SUELDO=?"
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
            ps.setString(10, emp.getResponsabilidadTrabajador());
            ps.setInt(11, emp.getSueldoTrabajador());
            ps.setInt(12, emp.getRutTrabajador());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Trabajador Modificado Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al MODIFICAR EMPLEADO" + ex.getMessage());
        }

        return respuesta;
    }

    public String eliminarTrabajador(Trabajador emp) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps = acceso.prepareStatement(""
                    + "UPDATE TRABAJADOR SET "
                    + "ESTADO_TRABAJADOR= 'NOACTIVO' "
                    + " WHERE RUT_TRABAJADOR = ?");
            ps.setInt(1, emp.getRutTrabajador());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Trabajador Eliminado Correctamente en Sistema VIALIS";
            }

        } catch (SQLException ex) {
            System.out.println("Error al MODIFICAR EMPLEADO" + ex.getMessage());
        }

        return respuesta;
    }

}
