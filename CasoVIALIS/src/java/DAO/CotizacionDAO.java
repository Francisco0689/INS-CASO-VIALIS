/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entidades.Cotizacion;
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
public class CotizacionDAO {

    private Conexion conn;

    public CotizacionDAO() {
        conn = new Conexion();
    }

    public String agregarCotizacion(Cotizacion cotizacion) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            String llamada = "{ call SP_AGREGAR_COTIZACION(?,?,?,?,?,?,?) }";   
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setString(1, cotizacion.getProveedor());
            cstmt.setString(2, cotizacion.getHerramienta());
            cstmt.setString(3, cotizacion.getMaterial());
            cstmt.setString(4, cotizacion.getMaquinaria());
            cstmt.setString(5, cotizacion.getServicioExterno());
            cstmt.setInt(6, cotizacion.getIdProyectoRelacionado());
            cstmt.setString(7, cotizacion.getEstadoCotizacion());

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Cotización Enviada Correctamente.";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }

    public String modificarCotizacionFinal(Cotizacion cotizacion) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            String llamada = "{ call SP_MODIFICAR_COTIZACION(?,?,?,?,?,?,?) }";   
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setString(1, cotizacion.getProveedor());
            cstmt.setString(2, cotizacion.getHerramienta());
            cstmt.setString(3, cotizacion.getMaterial());
            cstmt.setString(4, cotizacion.getMaquinaria());
            cstmt.setString(5, cotizacion.getServicioExterno());
            cstmt.setInt(6, cotizacion.getIdProyectoRelacionado());
            cstmt.setInt(7, cotizacion.getIdCotizacion());

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Cotización modificada Correctamente en Sistema VIALIS.";
            }

        } catch (SQLException ex) {
            System.out.println("Error al INGRESAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }

    public List<Cotizacion> ListarCotizaciones() {
        Cotizacion cotizacion = null;
        Documento documento = null;
        List<Cotizacion> listaCotizaciones = new ArrayList();
        List<Documento> listaDocumentos;

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM COTIZACION COT "
                    + "JOIN PROYECTO PRO ON (COT.ID_PROYECTO_RELACIONADO = PRO.ID) ORDER BY COT.ID ASC");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cotizacion = new Cotizacion();
                cotizacion.setIdCotizacion(rs.getInt("ID"));
                cotizacion.setEstadoCotizacion(rs.getString("ESTADO_COTIZACION"));
                cotizacion.setProveedor(rs.getString("PROVEEDOR"));
                cotizacion.setHerramienta(rs.getString("HERRAMIENTAS"));
                cotizacion.setMaterial(rs.getString("MATERIALES"));
                cotizacion.setMaquinaria(rs.getString("MAQUINARIA"));
                cotizacion.setServicioExterno(rs.getString("SERVICIO_EXTERNO"));
                cotizacion.setIdProyectoRelacionado(rs.getInt("ID_PROYECTO_RELACIONADO"));
                cotizacion.setNombreProyectoRelacionado(rs.getString("NOMBRE_PROYECTO"));

                PreparedStatement ps2 = acceso.prepareStatement("SELECT * FROM DOCUMENTO WHERE ID_COTIZACION = ? ORDER BY ID ASC");
                ps2.setInt(1, cotizacion.getIdCotizacion());
                ResultSet rs2 = ps2.executeQuery();
                listaDocumentos = new ArrayList();

                while (rs2.next()) {
                    documento = new Documento();
                    documento.setIdDocumento(rs2.getInt("ID"));
                    documento.setNombreDocumento(rs2.getString("NOMBRE_DOCUMENTO"));
                    documento.setTipoDocumento(rs2.getString("TIPO_DOCUMENTO"));
                    documento.setRutaDocumento(rs2.getString("RUTA_DOCUMENTO"));
                    documento.setIdCotizacion(rs2.getInt("ID_COTIZACION"));

                    listaDocumentos.add(documento);
                }

                cotizacion.setDocumentos(listaDocumentos);

                listaCotizaciones.add(cotizacion);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return listaCotizaciones;
    }

    public int idMaxCotizacion() {

        int idCotizacion = 0;

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT MAX(ID) AS ID FROM COTIZACION");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                idCotizacion = rs.getInt("ID");

                return idCotizacion;
            }

        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return idCotizacion;
    }

    public String aprobarCotizacion(int idCotizacion) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            String llamada = "{ call SP_APROBAR_COTIZACION(?) }";   
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setInt(1, idCotizacion);

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Cotización APROBADA en Sistema VIALIS.";
            }

        } catch (SQLException ex) {
            System.out.println("Error al APROBAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }

    public String rechazarCotizacion(int idCotizacion) {

        //Abrir Conexion
        Connection acceso = conn.getCnn();
        String respuesta = null;

        try {

            String llamada = "{ call SP_RECHAZAR_COTIZACION(?) }";   
            CallableStatement cstmt = acceso.prepareCall(llamada);
            
            cstmt.setInt(1, idCotizacion);

            if (cstmt.executeUpdate() > 0) {
                respuesta = "Cotización RECHAZADA en Sistema VIALIS.";
            }

        } catch (SQLException ex) {
            System.out.println("Error al RECHAZAR Proyecto" + ex.getMessage());
        }

        return respuesta;
    }

    public Cotizacion BuscarCotizacionPorId(int idCotizacion) {
        Cotizacion cotizacion = null;
        Documento documento = null;
        List<Documento> listaDocumentos;

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM COTIZACION COT JOIN PROYECTO PRO ON (COT.ID_PROYECTO_RELACIONADO = PRO.ID) WHERE COT.ID = ? ORDER BY COT.ID ASC");
            ps.setInt(1, idCotizacion);
            
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                cotizacion = new Cotizacion();
                cotizacion.setIdCotizacion(rs.getInt("ID"));
                cotizacion.setEstadoCotizacion(rs.getString("ESTADO_COTIZACION"));
                cotizacion.setProveedor(rs.getString("PROVEEDOR"));
                cotizacion.setHerramienta(rs.getString("HERRAMIENTAS"));
                cotizacion.setMaterial(rs.getString("MATERIALES"));
                cotizacion.setMaquinaria(rs.getString("MAQUINARIA"));
                cotizacion.setServicioExterno(rs.getString("SERVICIO_EXTERNO"));
                cotizacion.setIdProyectoRelacionado(rs.getInt("ID_PROYECTO_RELACIONADO"));
                cotizacion.setNombreProyectoRelacionado(rs.getString("NOMBRE_PROYECTO"));

                PreparedStatement ps2 = acceso.prepareStatement("SELECT * FROM DOCUMENTO WHERE ID_COTIZACION = ? ORDER BY ID ASC");
                ps2.setInt(1, idCotizacion);
                ResultSet rs2 = ps2.executeQuery();
                listaDocumentos = new ArrayList();

                while (rs2.next()) {
                    documento = new Documento();
                    documento.setIdDocumento(rs2.getInt("ID"));
                    documento.setNombreDocumento(rs2.getString("NOMBRE_DOCUMENTO"));
                    documento.setTipoDocumento(rs2.getString("TIPO_DOCUMENTO"));
                    documento.setRutaDocumento(rs2.getString("RUTA_DOCUMENTO"));
                    documento.setIdCotizacion(rs2.getInt("ID_COTIZACION"));

                    listaDocumentos.add(documento);
                }

                cotizacion.setDocumentos(listaDocumentos);

            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return cotizacion;
    }

}
