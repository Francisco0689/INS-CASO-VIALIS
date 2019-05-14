/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DAO.EmpleadoDAO;
import Modelo.Empleado;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;

/**
 *
 * @author fmaldonc
 */
@WebService(serviceName = "ServicioGestionEmpleado")
public class ServicioGestionEmpleado {

    /**
     * Ingresar Nuevo Empleado
     */
    @WebMethod(operationName = "ingresarEmpleado")
    public String ingresarEmpleado(@WebParam(name = "rut") String rut,
            @WebParam(name = "nombres") String nombre,
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "cargo") String cargo,
            @WebParam(name = "password") String pass) {

        Empleado emp = new Empleado(nombre, apellidos, rut, cargo, pass);
        EmpleadoDAO empDAO = new EmpleadoDAO();

        String resp = empDAO.insertarEmpleado(emp);

        return resp;
    }

    @WebMethod(operationName = "mostrarEmpleado")
    @WebResult(name = "Empleado")
    public Empleado mostrarEmpleado(@WebParam(name = "rut") String rut) {
        EmpleadoDAO empDAO = new EmpleadoDAO();
        Empleado emp = new Empleado();

        emp = empDAO.mostrarEmpleado(rut);

        return emp;
    }

    @WebMethod(operationName = "mostrarTodosEmpleado")
    @WebResult(name = "Empleado")
    public List<Empleado> mostrarTodosEmpleado() {
        EmpleadoDAO empDAO = new EmpleadoDAO();

        List<Empleado> empList = empDAO.mostrarTodoEmpleado();

        return empList;
    }

    @WebMethod(operationName = "modificarEmpleado")
    public String modificarEmpleado(@WebParam(name = "rut") String rut,
            @WebParam(name = "nombres") String nombre,
            @WebParam(name = "apellidos") String apellidos,
            @WebParam(name = "cargo") String cargo,
            @WebParam(name = "password") String pass) {

        Empleado emp = new Empleado(nombre, apellidos, rut, cargo, pass);
        EmpleadoDAO empDAO = new EmpleadoDAO();

        String resp = empDAO.modificarEmpleado(emp);

        return resp;
    }

}
