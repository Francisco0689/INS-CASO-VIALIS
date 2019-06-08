/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.HitoDAO;
import DAO.ProyectoDAO;
import Entidades.Hito;
import Entidades.Proyecto;
import Entidades.Usuario;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.format.annotation.DateTimeFormat;
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
public class ProyectoController {

    ProyectoDAO proDAO = new ProyectoDAO();

    @RequestMapping(value = "/proyecto", method = RequestMethod.GET)
    public String proyecto(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        return "proyecto";
    }

    @RequestMapping(value = "/agregar-proyecto", method = RequestMethod.POST)
    public String agregarProyecto(Model model, RedirectAttributes ra,
            HttpServletRequest request,
            @RequestParam("txtNombreProyecto") String nombreProyecto,
            @RequestParam("txtTipoProyecto") String tipoProyecto,
            @RequestParam("txtEstadoProyecto") String estadoProyecto,
            @RequestParam("txtEncargadoProyecto") String encargadoProyecto,
            @RequestParam("txtDireccionProyecto") String direccionProyecto
    ) {

        Proyecto proyectoExistente = proDAO.mostrarProyectoPorNombre(nombreProyecto);
        if (proyectoExistente != null) {
            model.addAttribute("mensaje", "Proyecto Ya Exite en la Base de Datos");
            return "proyecto";
        }

        Proyecto nuevoProyecto = new Proyecto();
        nuevoProyecto.setNombreProyecto(nombreProyecto);
        nuevoProyecto.setTipoProyecto(tipoProyecto);
        nuevoProyecto.setEstadoProyecto(estadoProyecto);
        nuevoProyecto.setEncargadoProyecto(encargadoProyecto);
        nuevoProyecto.setDireccionProyecto(direccionProyecto);

        String agregado = proDAO.agregarProyecto(nuevoProyecto);
        if (agregado == null) {
            model.addAttribute("mensaje", "No se ah podido agregar Proyecto");
            return "proyecto";
        } else {
            int codigoProyectoAgregado = proDAO.obtenerIdUltimoProyectoAgregado();
            if (codigoProyectoAgregado > 0) {
                HitoDAO hitoDAO = new HitoDAO();
                Date fecha = Date.valueOf(LocalDate.now());
                Hito hito = new Hito();
                hito.setNombreHito("CREACIÓN DEL PROYECTO");
                hito.setFechaHito(fecha);
                hito.setIdProyecto(codigoProyectoAgregado);
                agregado += hitoDAO.agregarHito(hito);
                model.addAttribute("mensaje", agregado);
            }
        }
        return "proyecto";
    }

    @RequestMapping(value = "/listaProyecto", method = RequestMethod.GET)
    public String listaProyectos(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (usu == null) {
            return "login";
        }

        List<Proyecto> proyectos = proDAO.ListarProyectos();

        model.addAttribute("proyectos", proyectos);

        return "listaProyecto";
    }

    @RequestMapping(value = "/modificarProyecto", method = RequestMethod.GET)
    public String modificarProyecto(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        return "modificarProyecto";
    }

    @RequestMapping(value = "/buscar-proyecto", method = RequestMethod.POST)
    public String buscarProyecto(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarProyecto") int codigoProyecto) {

        Proyecto proyecto = proDAO.mostrarProyectoPorCodigo(codigoProyecto);

        if (proyecto == null) {
            model.addAttribute("mensaje", "NO Exite proyecto con ese código en la Base de Datos");
            return "modificarProyecto";
        }

        model.addAttribute("proyecto", proyecto);

        return "modificarProyecto";
    }

    @RequestMapping(value = "/modificar-proyecto", method = RequestMethod.POST)
    public String modificarProyectoPOST(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtIdProyecto") int idProyecto,
            @RequestParam("txtNombreProyecto") String nombreProyecto,
            @RequestParam("txtTipoProyecto") String tipoProyecto,
            @RequestParam("txtEstadoProyecto") String estadoProyecto,
            @RequestParam("txtEncargadoProyecto") String encargadoProyecto,
            @RequestParam("txtDireccionProyecto") String direccionProyecto) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (usu == null) {
            return "login";
        }

        Proyecto pro = new Proyecto();
        pro.setIdProyecto(idProyecto);
        pro.setNombreProyecto(nombreProyecto);
        pro.setTipoProyecto(tipoProyecto);
        pro.setEstadoProyecto(estadoProyecto);
        pro.setEncargadoProyecto(encargadoProyecto);
        pro.setDireccionProyecto(direccionProyecto);

        String mensaje = proDAO.modificarProyecto(pro);

        if (mensaje == null) {
            mensaje = "No se ah podido MODIFICAR Proyecto.";
        }

        model.addAttribute("mensaje", mensaje);

        return "modificarProyecto";
    }

    @RequestMapping(value = "/agregar-hito", method = RequestMethod.POST)
    public String agregarHito(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtIdProyecto") int codigoProyecto,
            @RequestParam("txtNombreHito") String nombreHito,
            @RequestParam("txtFechaHito") @DateTimeFormat(pattern = "yyyy-MM-dd") java.util.Date fechaHito) {
        
        Proyecto pro = proDAO.mostrarProyectoPorCodigo(codigoProyecto);
        if(pro == null){
        model.addAttribute("mensaje", "Debe ingresar un código de proyecto válido");
        return "modificarProyecto";
        }

        Hito hito = new Hito();
        HitoDAO hitoDAO = new HitoDAO();

        hito.setIdProyecto(codigoProyecto);
        hito.setNombreHito(nombreHito);
        hito.setFechaHito(new java.sql.Date(fechaHito.getTime()));

        String respuesta = hitoDAO.agregarHito(hito);

        model.addAttribute("mensaje", respuesta);

        return "modificarProyecto";
    }

}
