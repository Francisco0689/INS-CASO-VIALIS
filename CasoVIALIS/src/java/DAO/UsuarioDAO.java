/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Usuario;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fmaldonc
 */
public class UsuarioDAO {

    private Conexion conn;

    public UsuarioDAO() {
        conn = new Conexion();
    }

    public Usuario mostrarUsuario(String user, String pass) {
        Usuario usuario = null;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM USUARIO USU\n"
                    + "JOIN TRABAJADOR TRA ON (TRA.ID = USU.ID_TRABAJADOR)\n"
                    + "WHERE TRA.ESTADO_TRABAJADOR = 'ACTIVO' AND USU.NOMBRE_USUARIO = ? AND USU.PASSWORD_USUARIO = ?");
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setPasswordUsuario(rs.getString("PASSWORD_USUARIO"));
                usuario.setIdUsuario(rs.getInt("ID"));
                usuario.setIdTrabajador(rs.getInt("ID_TRABAJADOR"));
                usuario.setIdRol(rs.getInt("ID_ROL"));

                return usuario;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }

    public String agregarUsuario(Usuario usuario) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("INSERT INTO USUARIO (NOMBRE_USUARIO, PASSWORD_USUARIO, ID_TRABAJADOR, ID_ROL)"
                            + "VALUES (?,?,?,?)");
            ps.setString(1, usuario.getNombreUsuario());
            ps.setString(2, usuario.getPasswordUsuario());
            ps.setInt(3, usuario.getIdTrabajador());
            ps.setInt(4, usuario.getIdRol());

            int rs = ps.executeUpdate();

            if (rs > 0) {
                respuesta = "* Usuario Agregado Correctamente";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR USUARIO" + ex.getMessage());
        }

        return respuesta;
    }

    public int mostrarUsuarioExistente(int idTrabajador) {
        int respuesta = 0;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT COUNT(*) AS EXISTENTE FROM USUARIO WHERE ID_TRABAJADOR = ?");
            ps.setInt(1, idTrabajador);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                respuesta = rs.getInt("EXISTENTE");

                return respuesta;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;
    }

    public String modificarUsuario(String password, int IdUsuario) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("UPDATE USUARIO SET PASSWORD_USUARIO = ? WHERE ID = ?");
            ps.setString(1, password);
            ps.setInt(2, IdUsuario);

            int rs = ps.executeUpdate();

            if (rs > 0) {
                respuesta = "* Usuario Modificado Correctamente. Favor ingrese con sus nuevas credenciales.";
            }

        } catch (SQLException ex) {
            System.out.println("Error al MODIFICAR USUARIO" + ex.getMessage());
        }

        return respuesta;
    }

    public int mostrarNombreUsuarioExistente(String nombreUsuario) {
        int respuesta = 0;
        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT COUNT(*) AS EXISTENTE FROM USUARIO WHERE NOMBRE_USUARIO = '?' ");
            ps.setString(1, nombreUsuario);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                respuesta = rs.getInt("EXISTENTE");

                return respuesta;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return respuesta;
    }
}
