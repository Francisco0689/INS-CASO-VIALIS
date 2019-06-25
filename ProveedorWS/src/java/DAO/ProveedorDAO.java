/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Proveedor;
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
public class ProveedorDAO {

    private Conexion conn;

    public ProveedorDAO() {
        conn = new Conexion();
    }

    public List<Proveedor> ListaProveedores() {
        Proveedor proveedor = null;
        List<Proveedor> listaProveedores = new ArrayList();

        Connection acceso = conn.getCnn();

        try {
            PreparedStatement ps = acceso.prepareStatement("SELECT * FROM PROVEEDOR ORDER BY ID ASC");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                proveedor = new Proveedor();
                proveedor.setIdProveedor(rs.getInt("ID"));
                proveedor.setRutProveedor(rs.getString("RUT_PROVEEDOR"));
                proveedor.setNombreProveedor(rs.getString("NOMBRE_PROVEEDOR"));
                proveedor.setDireccionProveedor(rs.getString("DIRECCION_PROVEEDOR"));
                proveedor.setEspecialidadProveedor(rs.getString("ESPECIALIDAD_PROVEEDOR"));

                listaProveedores.add(proveedor);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProveedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaProveedores;
    }

}
