/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Documento;
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

            String llamada = "{ call SP_AGREGAR_DOCUMENTO(?,?,?,?,?,?) }";
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setString(1, documento.getNombreDocumento());
            cstmt.setString(2, documento.getTipoDocumento());
            cstmt.setString(3, documento.getRutaDocumento());
            cstmt.setInt(4, documento.getIdTrabajador());
            cstmt.setInt(5, documento.getIdProyecto());
            cstmt.setInt(6, documento.getIdCotizacion());

            if (cstmt.executeUpdate() > 0) {
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
                    + " WHERE ID_TRABAJADOR = ? ORDER BY ID ASC");
            ps.setInt(1, codigoTrabajador);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                documento = new Documento();
                documento.setIdDocumento(rs.getInt("ID"));
                documento.setNombreDocumento(rs.getString("NOMBRE_DOCUMENTO"));
                documento.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                documento.setIdTrabajador(rs.getInt("ID_TRABAJADOR"));
                documento.setIdProyecto(rs.getInt("ID_PROYECTO"));
                documento.setRutaDocumento(rs.getString("RUTA_DOCUMENTO"));
                documento.setIdCotizacion(rs.getInt("ID_COTIZACION"));

                listaDocumentos.add(documento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaDocumentos;
    }

    public String eliminarDocumento(int codigoDocumento) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            String llamada = "{ call SP_ELIMINAR_DOCUMENTO(?) }";   
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setInt(1, codigoDocumento);

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Documento Eliminado Correctamente en Sistema VIALIS";
            }
            return respuesta;
        } catch (SQLException ex) {
            System.out.println("Error al MODIFICAR EMPLEADO" + ex.getMessage());
        }

        return respuesta;

    }

    public List<Documento> ListarDocumentoAsociadosPorCotizacion(int codigoCotizacion) {

        Documento documento = null;
        List<Documento> listaDocumentos = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM DOCUMENTO"
                    + " WHERE ID_COTIZACION = ? ORDER BY ID ASC");
            ps.setInt(1, codigoCotizacion);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                documento = new Documento();
                documento.setIdDocumento(rs.getInt("ID"));
                documento.setNombreDocumento(rs.getString("NOMBRE_DOCUMENTO"));
                documento.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));
                documento.setIdTrabajador(rs.getInt("ID_TRABAJADOR"));
                documento.setIdProyecto(rs.getInt("ID_PROYECTO"));
                documento.setRutaDocumento(rs.getString("RUTA_DOCUMENTO"));
                documento.setIdCotizacion(rs.getInt("ID_COTIZACION"));

                listaDocumentos.add(documento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaDocumentos;
    }

}
