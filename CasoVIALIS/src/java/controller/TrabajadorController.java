/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.TrabajadorDAO;
import Entidades.Trabajador;
import Entidades.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fmaldonc
 */
@Controller
public class TrabajadorController {

    private TrabajadorDAO traDAO = new TrabajadorDAO();

    @RequestMapping(value = "/trabajador", method = RequestMethod.GET)
    public String trabajador(Model model, HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        Usuario usu = (Usuario)session.getAttribute("usu");

        if(usu == null){
            return "login";
        }
        return "trabajador";
    }

    @RequestMapping(value = "/listaTrabajador", method = RequestMethod.GET)
    public String listaTrabajador(Model model, HttpServletRequest request) {
        
        HttpSession session = request.getSession();
        Usuario usu = (Usuario)session.getAttribute("usu");

        if(usu == null){
            return "login";
        }

        List<Trabajador> trabajadores = traDAO.ListarTrabajadores();

        model.addAttribute("trabajadores", trabajadores);

        return "listaTrabajador";
    }

    @RequestMapping(value = "/modificarTrabajador", method = RequestMethod.GET)
    public String modificarTrabajador(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario)session.getAttribute("usu");

        if(usu == null){
            return "login";
        }
        
        return "modificarTrabajador";
    }
    
    @RequestMapping(value = "/modificarTrabajadorDesdeListar", method = RequestMethod.GET)
    public String modificarTrabajadorDesdeListar(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarRut") int rutTrabajador) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario)session.getAttribute("usu");

        if(usu == null){
            return "login";
        }
        
        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rutTrabajador);

        if (trabajadorExistente == null) {
            ra.addFlashAttribute("mensaje", "Trabajador NO Exite en la Base de Datos");
            return "redirect:modificarTrabajador";
        }

        ra.addFlashAttribute("trabajador", trabajadorExistente);
        
        return "redirect:modificarTrabajador";
    }

    @RequestMapping(value = "/buscar-trabajador", method = RequestMethod.POST)
    public String buscarTrabajador(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarRut") int rutTrabajador) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rutTrabajador);

        if (trabajadorExistente == null) {
            ra.addFlashAttribute("mensaje", "Trabajador NO Exite en la Base de Datos");
            return "redirect:modificarTrabajador";
        }

        ra.addFlashAttribute("trabajador", trabajadorExistente);
        
        return "redirect:modificarTrabajador";
    }

    @RequestMapping(value = "/agregar-trabajador", method = RequestMethod.POST)
    public String agregarTrabajador(Model model, RedirectAttributes ra,
            @RequestParam("txtNombre") String nombre,
            @RequestParam("txtApellido") String apellido,
            @RequestParam("txtRut") int rut,
            @RequestParam("txtDv") String dv,
            @RequestParam("cboEstadoCivil") String estadoCivil,
            @RequestParam("txtDireccion") String direccion,
            @RequestParam("txtTelefono") int telefono,
            @RequestParam("txtNacionalidad") String nacionalidad,
            @RequestParam("txtEstadoExtranjero") String estadoExtranjero,
            @RequestParam("txtEspecialidad") String especialidad,
            HttpServletRequest request) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rut);
        if (trabajadorExistente != null) {
            ra.addFlashAttribute("mensaje", "Trabajador Ya Exite en la Base de Datos");
            return "redirect:trabajador";
        }

        Trabajador trabajadorNuevo = new Trabajador();
        trabajadorNuevo.setNombreTrabajador(nombre);
        trabajadorNuevo.setApellidoTrabajador(apellido);
        trabajadorNuevo.setRutTrabajador(rut);
        trabajadorNuevo.setDvTrabajador(dv);
        trabajadorNuevo.setEstadoCivilTrabajador(estadoCivil);
        trabajadorNuevo.setDireccionTrabajador(direccion);
        trabajadorNuevo.setTelefonoTrabajador(telefono);
        trabajadorNuevo.setNacionalidadTrabajador(nacionalidad);
        trabajadorNuevo.setEstadoTrabajador("ACTIVO");
        trabajadorNuevo.setCondicionExtranjeroTrabajador(estadoExtranjero);
        trabajadorNuevo.setEspecialidadTrabajador(especialidad);

        String agregado = traDAO.agregarTrabajador(trabajadorNuevo);
        if (agregado == null) {
            ra.addFlashAttribute("mensaje", "No se ah podido agregar Trabajador");
            return "redirect:trabajador";
        } else {
            ra.addFlashAttribute("mensaje", "Trabajador Agregado Exitosamente");
        }

        return "redirect:trabajador";
    }

    @RequestMapping(value = "/eliminar-trabajador", method = RequestMethod.GET)
    public String eliminarTrabajador(Model model, RedirectAttributes re, HttpServletRequest request,
            @RequestParam("rutTrabajador") int rutTrabajador) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rutTrabajador);

        if (trabajadorExistente == null) {
            re.addFlashAttribute("mensaje", "El Trabajador no Existe");
            return "redirect:listaTrabajador";
        }

        String mensaje = traDAO.eliminarTrabajador(trabajadorExistente);

        re.addFlashAttribute("mensaje", mensaje);

        return "redirect:listaTrabajador";
    }

    @RequestMapping(value = "/modificar-trabajador", method = RequestMethod.POST)
    public String modificarTrabajador(Model model, RedirectAttributes ra,
            @RequestParam("txtNombre") String nombre,
            @RequestParam("txtApellido") String apellido,
            @RequestParam("txtRut") int rut,
            @RequestParam("txtDv") String dv,
            @RequestParam("cboEstadoCivil") String estadoCivil,
            @RequestParam("txtDireccion") String direccion,
            @RequestParam("txtTelefono") int telefono,
            @RequestParam("txtNacionalidad") String nacionalidad,
            @RequestParam("txtEstadoExtranjero") String estadoExtranjero,
            @RequestParam("txtEspecialidad") String especialidad,
            HttpServletRequest request) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rut);
        if (trabajadorExistente == null) {
            ra.addFlashAttribute("mensaje", "Trabajador NO Exite en la Base de Datos");
            return "redirect:modificarTrabajador";
        }

        Trabajador trabajadorNuevo = new Trabajador();
        trabajadorNuevo.setNombreTrabajador(nombre);
        trabajadorNuevo.setApellidoTrabajador(apellido);
        trabajadorNuevo.setRutTrabajador(rut);
        trabajadorNuevo.setDvTrabajador(dv);
        trabajadorNuevo.setEstadoCivilTrabajador(estadoCivil);
        trabajadorNuevo.setDireccionTrabajador(direccion);
        trabajadorNuevo.setTelefonoTrabajador(telefono);
        trabajadorNuevo.setNacionalidadTrabajador(nacionalidad);
        trabajadorNuevo.setEstadoTrabajador("ACTIVO");
        trabajadorNuevo.setCondicionExtranjeroTrabajador(estadoExtranjero);
        trabajadorNuevo.setEspecialidadTrabajador(especialidad);

        String agregado = traDAO.modificarEmpleado(trabajadorNuevo);
        if (agregado == null) {
            ra.addFlashAttribute("mensaje", "No se ah podido modificar Trabajador");
            return "redirect:trabajador";
        } else {
            ra.addFlashAttribute("mensaje", "Trabajador modificado Exitosamente");
        }

        return "redirect:modificarTrabajador";
    }

}
