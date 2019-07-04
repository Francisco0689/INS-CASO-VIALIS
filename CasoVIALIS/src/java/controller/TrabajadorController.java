/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.DocumentoDAO;
import DAO.ProyectoDAO;
import DAO.RolDAO;
import DAO.TrabajadorDAO;
import Entidades.Documento;
import Entidades.FileService;
import Entidades.Rol;
import Entidades.Trabajador;
import Entidades.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.context.annotation.Bean;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author fmaldonc
 */
@Controller
public class TrabajadorController {

    private TrabajadorDAO traDAO = new TrabajadorDAO();
    private FileService fileService = new FileService();
    private DocumentoDAO docuDAO = new DocumentoDAO();
    private ProyectoDAO proDAO = new ProyectoDAO();
    private RolDAO rolDAO = new RolDAO();

    @RequestMapping(value = "/trabajador", method = RequestMethod.GET)
    public String trabajador(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }
        return "trabajador";
    }

    @RequestMapping(value = "/gestionarContrato", method = RequestMethod.GET)
    public String gestionarContrato(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }
        return "gestionarContrato";
    }

    @RequestMapping(value = "/listaTrabajador", method = RequestMethod.GET)
    public String listaTrabajador(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        List<Trabajador> trabajadores = traDAO.ListarTrabajadores();

        model.addAttribute("trabajadores", trabajadores);

        return "listaTrabajador";
    }

    @RequestMapping(value = "/modificarTrabajador", method = RequestMethod.GET)
    public String modificarTrabajador(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        return "modificarTrabajador";
    }

    @RequestMapping(value = "/modificarTrabajadorDesdeListar", method = RequestMethod.GET)
    public String modificarTrabajadorDesdeListar(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarRut") int rutTrabajador) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rutTrabajador);

        if (trabajadorExistente == null) {
            ra.addFlashAttribute("mensaje", "NO Exite trabajador ingresado con ese rut. Favor ingrese rut válido.");
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
            ra.addFlashAttribute("mensaje", "NO Exite trabajador ingresado con ese rut. Favor ingrese rut válido.");
            return "redirect:modificarTrabajador";
        }

        ra.addFlashAttribute("trabajador", trabajadorExistente);

        return "redirect:modificarTrabajador";
    }

    @RequestMapping(value = "/buscar-trabajador-contrato", method = RequestMethod.POST)
    public String buscarTrabajadorContrato(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarRut") int rutTrabajador) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rutTrabajador);

        if (trabajadorExistente == null) {
            ra.addFlashAttribute("mensaje", "NO Exite trabajador ingresado con ese rut. Favor ingrese rut válido.");
            return "redirect:gestionarContrato";
        }

        ra.addFlashAttribute("trabajador", trabajadorExistente);
        ra.addFlashAttribute("documentos", docuDAO.ListarDocumentoAsociados(trabajadorExistente.getIdTrabajador()));
        ra.addFlashAttribute("proyectos", proDAO.ListarProyectos());

        return "redirect:gestionarContrato";
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
            @RequestParam("txtResponsabilidad") String responsabilidad,
            @RequestParam("txtSueldo") int sueldo,
            HttpServletRequest request) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rut);
        if (trabajadorExistente != null) {
            ra.addFlashAttribute("mensaje", "YA Exite trabajador ingresado con ese rut. Favor ingrese rut válido.");
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
        trabajadorNuevo.setResponsabilidadTrabajador(responsabilidad);
        trabajadorNuevo.setSueldoTrabajador(sueldo);

        String agregado = traDAO.agregarTrabajador(trabajadorNuevo);
        if (agregado == null) {
            ra.addFlashAttribute("mensaje", "NO se pudo ingresar trabajador al sistema. Favor, verifique los datos ingresados.");
            return "redirect:trabajador";
        } else {
            ra.addFlashAttribute("mensaje", agregado);
        }

        return "redirect:trabajador";
    }

    @RequestMapping(value = "/eliminar-trabajador", method = RequestMethod.GET)
    public String eliminarTrabajador(Model model, RedirectAttributes re, HttpServletRequest request,
            @RequestParam("rutTrabajador") int rutTrabajador) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rutTrabajador);

        if (trabajadorExistente == null) {
            re.addFlashAttribute("mensaje", "NO Exite trabajador ingresado con ese rut. Favor ingrese rut válido.");
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
            @RequestParam("txtResponsabilidad") String responsabilidad,
            @RequestParam("txtSueldo") int sueldo,
            HttpServletRequest request) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajador(rut);
        if (trabajadorExistente == null) {
            ra.addFlashAttribute("mensaje", "NO Exite trabajador ingresado con ese rut. Favor ingrese rut válido.");
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
        trabajadorNuevo.setResponsabilidadTrabajador(responsabilidad);
        trabajadorNuevo.setSueldoTrabajador(sueldo);

        String agregado = traDAO.modificarEmpleado(trabajadorNuevo);
        if (agregado == null) {
            ra.addFlashAttribute("mensaje", "NO se pudo modificar trabajador seleccionado. Favor ingrese datos correctos.");
            return "redirect:modificarTrabajador";
        } else {
            ra.addFlashAttribute("mensaje", agregado);
            ra.addFlashAttribute("trabajador", trabajadorNuevo);
        }

        return "redirect:modificarTrabajador";
    }

    @Bean(name = "multipartResolver")
    @RequestMapping(value = "/gestionar-contrato", method = RequestMethod.POST)
    public String gestionarContrato(Model model, RedirectAttributes ra,
            HttpServletRequest request,
            @RequestParam("txtNombreDocumento") String nombreDocumento,
            @RequestParam("txtTipoDocumento") String tipoDocumento,
            @RequestParam("txtIdTrabajador") int idTrabajador,
            @RequestParam("cboProyecto") int idProyecto,
            @RequestParam("txtDocumento") MultipartFile multipartFile) throws ServletException, IOException {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajadorPorCodigoInterno(idTrabajador);
        DocumentoDAO docDAO = new DocumentoDAO();
        Documento doc = new Documento();
        doc.setTipoDocumento(tipoDocumento);
        doc.setIdTrabajador(idTrabajador);
        doc.setNombreDocumento(nombreDocumento);
        doc.setIdProyecto(idProyecto);

        String agregado = null;

        String addFile = fileService.saveFile(multipartFile);

        if (addFile != null) {
            doc.setRutaDocumento(addFile);
            agregado = docDAO.agregarDocumento(doc);
        }

        if (agregado == null) {
            ra.addFlashAttribute("mensaje", "No se pudo Gestionar Contrato");
            return "redirect:gestionarContrato";
        } else {
            ra.addFlashAttribute("mensaje", agregado);
            ra.addFlashAttribute("documentos", docuDAO.ListarDocumentoAsociados(idTrabajador));
            ra.addFlashAttribute("trabajador", trabajadorExistente);
            ra.addFlashAttribute("proyectos", proDAO.ListarProyectos());
        }

        return "redirect:gestionarContrato";
    }

    @RequestMapping(value = "/eliminar-documento", method = RequestMethod.GET)
    public String eliminarDocumento(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("idTrabajador") int idTrabajador,
            @RequestParam("idDocumento") int idDocumento) {

        Trabajador trabajadorExistente = traDAO.mostrarTrabajadorPorCodigoInterno(idTrabajador);
        String mensaje = null;

        if (trabajadorExistente == null) {
            ra.addFlashAttribute("mensaje", "NO Exite trabajador ingresado con ese rut. Favor ingrese rut válido.");
            return "redirect:gestionarContrato";
        }

        mensaje = docuDAO.eliminarDocumento(idDocumento);

        if (mensaje == null) {
            mensaje = "No se puedo eliminar documento en Sistema VIALIS. Favor intente más tarde.";
        }
        ra.addFlashAttribute("trabajador", trabajadorExistente);
        ra.addFlashAttribute("documentos", docuDAO.ListarDocumentoAsociados(trabajadorExistente.getIdTrabajador()));
        ra.addFlashAttribute("proyectos", proDAO.ListarProyectos());
        ra.addFlashAttribute("mensaje", mensaje);

        return "redirect:gestionarContrato";
    }


}
