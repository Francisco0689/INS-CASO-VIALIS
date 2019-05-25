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
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM USUARIO USU\n" +
                                                           "JOIN TRABAJADOR TRA ON (TRA.ID = USU.ID_TRABAJADOR)\n" +
                                                           "WHERE TRA.ESTADO_TRABAJADOR = 'ACTIVO' AND USU.NOMBRE_USUARIO = ? AND USU.PASSWORD_USUARIO = ?");
            ps.setString(1, user);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNombreUsuario(rs.getString("NOMBRE_USUARIO"));
                usuario.setPasswordUsuario(rs.getString("PASSWORD_USUARIO"));

                return usuario;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return usuario;
    }
    
}
