/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Inspeccion;
import Model.Conexion;
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
 * @author Francisco Maldonado
 */
public class InspeccionDAO {

    private Conexion conn;

    public InspeccionDAO() {
        conn = new Conexion();
    }

    public List<Inspeccion> ListaInspeccion() {
        Inspeccion inspeccion = null;
        List<Inspeccion> listaInspecciones = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM DOCUMENTO ORDER BY ID ASC");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                inspeccion = new Inspeccion();
                inspeccion.setIdInspeccion(rs.getInt("ID"));
                inspeccion.setNombreDocumento(rs.getString("NOMBRE_DOCUMENTO"));
                inspeccion.setRutaDocumento(rs.getString("RUTA_DOCUMENTO"));
                inspeccion.setTipoDocumento(rs.getString("TIPO_DOCUMENTO"));

                listaInspecciones.add(inspeccion);
            }

        } catch (SQLException ex) {
            Logger.getLogger(InspeccionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaInspecciones;
    }

}
