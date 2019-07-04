/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Documento;
import Entidades.Rol;
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
public class RolDAO {

    private Conexion conn;

    public RolDAO() {
        conn = new Conexion();
    }

    public String agregarRol(Rol rol) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("INSERT INTO ROLES "
                            + "(NOMBRE_ROL"
                            + "VALUES (?)");
            ps.setString(1, rol.getNombreRol());

            int rs = ps.executeUpdate();

            if (rs > 0) {
                respuesta = "* ROL Agregado Correctamente";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR ROL" + ex.getMessage());
        }

        return respuesta;
    }

    public List<Rol> ListarRoles() {

        Rol rol = null;
        List<Rol> listaRoles = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM ROLES ORDER BY ID ASC");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                rol = new Rol();
                rol.setIdRol(rs.getInt("ID"));
                rol.setNombreRol(rs.getString("NOMBRE_ROL"));

                listaRoles.add(rol);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRoles;
    }

    public String modificarRol(Rol rol) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("UPDATE ROLES "
                            + "(SET NOMBRE_ROL = ?"
                            + "WHERE ID = ?");
            ps.setString(1, rol.getNombreRol());
            ps.setInt(2, rol.getIdRol());

            int rs = ps.executeUpdate();

            if (rs > 0) {
                respuesta = "* ROL Modificado Correctamente";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR ROL" + ex.getMessage());
        }

        return respuesta;
    }

}
