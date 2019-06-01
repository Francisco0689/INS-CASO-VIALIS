/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ProyectoDAO;
import DAO.ReunionDAO;
import DAO.UsuarioDAO;
import Entidades.Proyecto;
import Entidades.Reunion;
import Entidades.Usuario;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
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
public class ReunionController {

    private UsuarioDAO usuDAO = new UsuarioDAO();

    @RequestMapping(value = "/reunion", method = RequestMethod.GET)
    public String reunion(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        ProyectoDAO proDAO = new ProyectoDAO();
        Date objDate = new Date();

        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        LocalDateTime locaDate = LocalDateTime.now();
        int hora = locaDate.getHour();
        int minutos = locaDate.getMinute();

        if (usu == null) {
            return "login";
        }

        List<Proyecto> proyectos = proDAO.ListarProyectos();
        model.addAttribute("proyectos", proyectos);
        model.addAttribute("fecha", objSDF.format(objDate));
        model.addAttribute("hora", hora);
        model.addAttribute("minutos", minutos);

        return "reunion";
    }

    @RequestMapping(value = "/agendar-reunion", method = RequestMethod.POST)
    public String agendarReunion(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtEstadoReunion") String estadoReunion,
            @RequestParam("txtLugar") String lugarReunion,
            @RequestParam("txtFechaReunion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaReunion,
            @RequestParam("txtHoraReunion") int horaReunion,
            @RequestParam("txtMinutoReunion") int minutosReunion,
            @RequestParam("cboProyecto") int idProyecto,
            @RequestParam("txtEncargado") String encargadoReunion,
            @RequestParam("txtTemaReunion") String temaReunion) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (usu == null) {
            return "login";
        }
        ProyectoDAO proDAO = new ProyectoDAO();
        ReunionDAO reuDAO = new ReunionDAO();
        Reunion reu = new Reunion();

        reu.setEstadoReunion(estadoReunion);
        reu.setFechaReunion(new java.sql.Date(fechaReunion.getTime()));
        reu.setLugarReunion(lugarReunion);
        reu.setEncargadoReunion(encargadoReunion);
        reu.setIdProyecto(idProyecto);
        reu.setDescripcionInicial(temaReunion);
        reu.setDescripcionFinal("AGENDADA");
        reu.setHora(horaReunion);
        reu.setMin(minutosReunion);

        String mensaje = reuDAO.agendarReunion(reu);

        if (mensaje == null) {
            mensaje = "No se ah podido agendar Reunión.";
        }

        List<Proyecto> proyectos = proDAO.ListarProyectos();
        model.addAttribute("proyectos", proyectos);
        model.addAttribute("mensaje", mensaje);
        return "reunion";
    }

    @RequestMapping(value = "/modificarReunion", method = RequestMethod.GET)
    public String modificarReunion(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (usu == null) {
            return "login";
        }
        ProyectoDAO proDAO = new ProyectoDAO();
        List<Proyecto> proyectos = proDAO.ListarProyectos();
        model.addAttribute("proyectos", proyectos);
        Date objDate = new Date();
        String strDateFormat = "yyyy-MM-dd";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        model.addAttribute("fechaActual", objSDF.format(objDate));

        return "modificarReunion";
    }

    @RequestMapping(value = "/buscar-reunion", method = RequestMethod.POST)
    public String buscarReunion(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarReunion") int codigoReunion) {

        ReunionDAO reuDAO = new ReunionDAO();
        Reunion reunionAgendada = reuDAO.buscarReunion(codigoReunion);

        if (reunionAgendada == null) {
            ra.addFlashAttribute("mensaje", "NO Exite reunión con ese código en la Base de Datos");
            return "redirect:modificarReunion";
        }

        ra.addFlashAttribute("reunion", reunionAgendada);

        return "redirect:modificarReunion";
    }

    @RequestMapping(value = "/modificar-reunion", method = RequestMethod.POST)
    public String modificarReunionPOST(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtEstadoReunion") String estadoReunion,
            @RequestParam("txtLugar") String lugarReunion,
            @RequestParam("txtFechaReunion") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fechaReunion,
            @RequestParam("txtHoraReunion") int horaReunion,
            @RequestParam("txtMinutoReunion") int minutosReunion,
            @RequestParam("txtEncargado") String encargadoReunion,
            @RequestParam("txtAcuerdo") String acuerdoReunion,
            @RequestParam("txtIdReunion") int idReunion) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (usu == null) {
            return "login";
        }
        ReunionDAO reuDAO = new ReunionDAO();
        Reunion reu = new Reunion();
        reu.setIdReunion(idReunion);
        reu.setEstadoReunion(estadoReunion);
        reu.setFechaReunion(new java.sql.Date(fechaReunion.getTime()));
        reu.setLugarReunion(lugarReunion);
        reu.setEncargadoReunion(encargadoReunion);
        reu.setDescripcionFinal(acuerdoReunion);
        reu.setHora(horaReunion);
        reu.setMin(minutosReunion);

        String mensaje = reuDAO.modificarReunion(reu);

        if (mensaje == null) {
            mensaje = "No se ah podido MODIFICAR Reunión.";
        }

        model.addAttribute("mensaje", mensaje);

        return "modificarReunion";
    }

    @RequestMapping(value = "/listaReunion", method = RequestMethod.GET)
    public String listaReunion(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (usu == null) {
            return "login";
        }

        ReunionDAO reuDAO = new ReunionDAO();
        List<Reunion> reuniones = reuDAO.ListarReuniones();

        model.addAttribute("reuniones", reuniones);

        return "listaReunion";
    }

    @RequestMapping(value = "/eliminar-reunion", method = RequestMethod.GET)
    public String eliminaReunion(Model model, RedirectAttributes re, HttpServletRequest request,
            @RequestParam("idReunion") int idReunion) {
        ReunionDAO reuDAO = new ReunionDAO();
        Reunion reunionExistente = reuDAO.buscarReunion(idReunion);

        if (reunionExistente == null) {
            re.addFlashAttribute("mensaje", "Reunión no Existe");
            return "redirect:listaReunion";
        }

        String mensaje = reuDAO.eliminarReunion(idReunion);

        re.addFlashAttribute("mensaje", mensaje);

        return "redirect:listaReunion";
    }

    @RequestMapping(value = "/modificarReunionDesdeListar", method = RequestMethod.GET)
    public String modificarReunionDesdeListar(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarReunion") int codigoReunion) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }
        ReunionDAO reuDAO = new ReunionDAO();
        Reunion reunionExistente = reuDAO.buscarReunion(codigoReunion);

        if (reunionExistente == null) {
            ra.addFlashAttribute("mensaje", "Reunión NO Exite en la Base de Datos");
            return "redirect:modificarReunion";
        }

        ra.addFlashAttribute("reunion", reunionExistente);

        return "redirect:modificarReunion";
    }

    @RequestMapping(value = "/buscar-reuniones-por-proyecto", method = RequestMethod.POST)
    public String buscarReunionesPorProyecto(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarReunion") int codigoProyecto) {

        ReunionDAO reuDAO = new ReunionDAO();
        List<Reunion> reunionesAgendadas = reuDAO.buscarReunionesPorProyecto(codigoProyecto);

        if (reunionesAgendadas == null) {
            ra.addFlashAttribute("mensaje", "NO Exiten reuniones con ese código en la Base de Datos");
            List<Reunion> reuniones = reuDAO.ListarReuniones();
            model.addAttribute("reuniones", reuniones);
            return "listaReunion";
        }

        ra.addFlashAttribute("reuniones", reunionesAgendadas);

        return "listaReunion";
    }

}
