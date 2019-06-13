/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Documento;
import Modelo.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 *
 * @author fmaldonc
 */
public class DocumentoDAO {

    private Conexion conn;

    public DocumentoDAO() {
        conn = new Conexion();
    }

    public String agregarDocumento(Documento documento) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            PreparedStatement ps
                    = acceso.prepareStatement("INSERT INTO DOCUMENTO (NOMBRE_DOCUMENTO, "
                            + "TIPO_DOCUMENTO, RUTA_DOCUMENTO, ID_TRABAJADOR, ID_PROYECTO) "
                            + "VALUES (?,?,?,?,?)");
            ps.setString(1, documento.getNombreDocumento());
            ps.setString(2, documento.getTipoDocumento());
            ps.setString(3, documento.getRutadocumento());
            ps.setInt(4, documento.getIdTrabajador());
            ps.setInt(5, documento.getIdProyecto());

            int rs = ps.executeUpdate();
            if (rs > 0) {
                respuesta = "* Documento Agregado Correctamente";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }

    public List<Documento> ListarDocumentoAsociados(int codigoTrabajador) {
        
        Documento documento = null;
        List<Documento> listaDocumentos = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM DOCUMENTO"
                    + " WHERE ID_TRABAJADOR = ?");
            ps.setInt(1, codigoTrabajador);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                documento = new Documento();
                documento.setIdDocumento(rs.getInt("ID"));
                documento.setNombreDocumento(rs.getString("NOMBRE_DOCUMENTO"));
                documento.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                documento.setIdDocumento(rs.getInt("ID_TRABAJADOR"));
                documento.setIdProyecto(rs.getInt("ID_PROYECTO"));
                documento.setRutadocumento(rs.getString("RUTA_DOCUMENTO"));

                listaDocumentos.add(documento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaDocumentos;
    }

}
