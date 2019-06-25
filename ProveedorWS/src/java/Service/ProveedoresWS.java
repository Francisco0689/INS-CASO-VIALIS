/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.ProveedorDAO;
import Entities.Proveedor;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebResult;

/**
 *
 * @author Francisco Maldonado
 */
@WebService(serviceName = "ProveedoresWS")
public class ProveedoresWS {

    @WebMethod(operationName = "MostrarTodosProveedores")
    @WebResult(name = "Proveedor")
    public List<Proveedor> mostrarTodoEmp() {

        ProveedorDAO proDAO = new ProveedorDAO();

        List<Proveedor> proveedoresList = proDAO.ListaProveedores();

        return proveedoresList;
    }

}
