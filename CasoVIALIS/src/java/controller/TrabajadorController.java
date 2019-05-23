/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.TrabajadorDAO;
import Entidades.Trabajador;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
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
    public String trabajador(Model model) {
        
        List<Trabajador> trabajadores = traDAO.ListarTrabajadores();
        model.addAttribute("trabajadores", trabajadores);

        return "trabajador";
    }

    @RequestMapping(value = "/agregar-trabajador", method = RequestMethod.POST)
    public String agregarTrabajador(Model model, RedirectAttributes ra,
            @RequestParam("txtNombre") String nombre,
            @RequestParam("txtApellido") String apellido,
            @RequestParam("txtRut") int rut,
            @RequestParam("txtDv") int dv,
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
    
    
    @RequestMapping(value="/eliminar-trabajador", method = RequestMethod.GET)
    public String eliminarProducto(Model model, RedirectAttributes re, HttpServletRequest request,
            @RequestParam("rutTrabajador") int rutTrabajador){
        
        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rutTrabajador);
        
        if(trabajadorExistente==null){
            re.addFlashAttribute("mensaje", "El Trabajador no Existe");
            return "redirect:trabajador";
        }
        
        String mensaje = traDAO.eliminarTrabajador(trabajadorExistente);
        
        re.addFlashAttribute("mensaje", mensaje);
        
        return "redirect:trabajador";
    }
    
    
    
}
