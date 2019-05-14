/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.Empleado;
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
public class EmpleadoDAO {

    private Conexion conn;

    public EmpleadoDAO() {
        conn = new Conexion();
    }

    public String insertarEmpleado(Empleado emp) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps = acceso.prepareStatement("INSERT INTO EMPLEADO (rut, nombres, apellidos, cargo, password) VALUES (?,?,?,?,?)");
            ps.setString(1, emp.getRut());
            ps.setString(2, emp.getNombres());
            ps.setString(3, emp.getApellidos());
            ps.setString(4, emp.getCargo());
            ps.setString(5, emp.getPass());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "Empleado Agregado Correctamente";
            }

        } catch (SQLException ex) {
            respuesta = "Error al INGRESAR EMPLEADO" + ex.getMessage();
        }

        return respuesta;
    }

    public Empleado mostrarEmpleado(String rut) {
        Empleado emp = new Empleado();
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("select * from empleado where rut=?");
            ps.setString(1, rut);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                emp.setRut(rs.getString("RUT"));
                emp.setNombres(rs.getString("NOMBRES"));
                emp.setApellidos(rs.getString("APELLIDOS"));
                emp.setCargo(rs.getString("CARGO"));
                emp.setPass(rs.getString("PASSWORD"));

                return emp;
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return emp;
    }

    public List<Empleado> mostrarTodoEmpleado() {
        Empleado emp = null;
        List<Empleado> listaEmpleados = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("select * from empleado");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                emp = new Empleado();
                emp.setRut(rs.getString("RUT"));
                emp.setNombres(rs.getString("NOMBRES"));
                emp.setApellidos(rs.getString("APELLIDOS"));
                emp.setCargo(rs.getString("CARGO"));
                emp.setPass(rs.getString("PASSWORD"));
                listaEmpleados.add(emp);
            }

        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaEmpleados;
    }

    public String modificarEmpleado(Empleado emp) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps = acceso.prepareStatement("UPDATE EMPLEADO SET NOMBRES=?, APELLIDOS=?, CARGO=?, PASSWORD=? WHERE RUT = ?");
            ps.setString(1, emp.getNombres());
            ps.setString(2, emp.getApellidos());
            ps.setString(3, emp.getCargo());
            ps.setString(4, emp.getPass());
            ps.setString(5, emp.getRut());

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
