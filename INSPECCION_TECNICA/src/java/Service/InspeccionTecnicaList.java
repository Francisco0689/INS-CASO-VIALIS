/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.InspeccionDAO;
import Entities.Inspeccion;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebResult;

/**
 *
 * @author Francisco Maldonado
 */
@WebService(serviceName = "InspeccionWS")
public class InspeccionTecnicaList {

    @WebMethod(operationName = "MostrarTodasInspecciones")
    @WebResult(name = "Inspeccion")
    public List<Inspeccion> mostrarTodaInspeccion() {

        InspeccionDAO insDAO = new InspeccionDAO();

        List<Inspeccion> inspeccionesList = insDAO.ListaInspeccion();

        return inspeccionesList;
    }

}
