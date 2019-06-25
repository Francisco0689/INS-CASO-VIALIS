/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CotizacionDAO;
import DAO.DocumentoDAO;
import DAO.ProyectoDAO;
import Entidades.Cotizacion;
import Entidades.Documento;
import Entidades.FileService;
import Entidades.Proyecto;
import Entidades.Usuario;
import Servicio.Proveedor;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fmaldonc
 */
@Controller
public class CotizacionController {

    ProyectoDAO proDAO = new ProyectoDAO();
    CotizacionDAO cotDAO = new CotizacionDAO();
    DocumentoDAO docDAO = new DocumentoDAO();

    @RequestMapping(value = "/cotizacion", method = RequestMethod.GET)
    public String cotizacion(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        Servicio.ProveedoresWS_Service service = new Servicio.ProveedoresWS_Service();

        try {

            List<Proveedor> proveedores = service.getProveedoresWSPort().mostrarTodosProveedores();
            List<Proyecto> proyectos = proDAO.ListarProyectos();
            model.addAttribute("proyectos", proyectos);
            model.addAttribute("proveedores", proveedores);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "cotizacion";
    }

    @RequestMapping(value = "/agregar-cotizacion", method = RequestMethod.POST)
    public String agregarCotizacion(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("cboProveedor") String proveedor,
            @RequestParam("txtHerramientas") String herramientas,
            @RequestParam("txtMateriales") String materiales,
            @RequestParam("txtMaquinaria") String maquinaria,
            @RequestParam("txtServicioExterno") String servicioExterno,
            @RequestParam("cboProyecto") int idProyectoRelacionado,
            @RequestParam("txtNombreDocumento") String nombreDocumento,
            @RequestParam("txtTipoDocumento") String tipoDocumento,
            @RequestParam("txtDocumento") MultipartFile documento) {

        Cotizacion newCotizacion = new Cotizacion();
        FileService fileService = new FileService();
        Documento document = new Documento();

        newCotizacion.setProveedor(proveedor);
        newCotizacion.setHerramienta(herramientas);
        newCotizacion.setMaterial(materiales);
        newCotizacion.setMaquinaria(maquinaria);
        newCotizacion.setServicioExterno(servicioExterno);
        newCotizacion.setIdProyectoRelacionado(idProyectoRelacionado);
        newCotizacion.setEstadoCotizacion("ENVIADA");

        String agregado = cotDAO.agregarCotizacion(newCotizacion);

        if (agregado == null) {
            ra.addFlashAttribute("mensaje", "NO se pudo enviar cotización al Sistema VIALIS. Favor, verifique los datos ingresados.");
            return "redirect:cotizacion";
        } else {
            document.setRutaDocumento(fileService.saveFileCotizacion(documento));
            document.setNombreDocumento(nombreDocumento);
            document.setTipoDocumento(tipoDocumento);
            document.setIdDocumento(0);
            document.setIdProyecto(0);
            document.setIdTrabajador(0);
            int idCotizacion = cotDAO.idMaxCotizacion();
            document.setIdCotizacion(idCotizacion);
            agregado += " " + docDAO.agregarDocumento(document);
            ra.addFlashAttribute("mensaje", agregado);
        }

        return "redirect:cotizacion";
    }

    @RequestMapping(value = "/listaCotizaciones", method = RequestMethod.GET)
    public String listaCotizaciones(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        if (usu == null) {
            return "login";
        }

        List<Cotizacion> cotizaciones = cotDAO.ListarCotizaciones();

        model.addAttribute("cotizaciones", cotizaciones);

        return "listaCotizaciones";
    }

    @RequestMapping(value = "/aprobar-cotizacion", method = RequestMethod.GET)
    public String aprobarCotizacion(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("idCotizacion") int idCotizacion) {

        String aprobada = cotDAO.aprobarCotizacion(idCotizacion);
        if (aprobada == null) {
            ra.addFlashAttribute("mensaje", "NO se pudo APROBAR Cotización en Sistema VIALIS. Favor, verifique los datos ingresados.");
            return "redirect:listaCotizaciones";
        }
        ra.addFlashAttribute("mensaje", aprobada);
        ra.addFlashAttribute("cotizaciones", cotDAO.ListarCotizaciones());

        return "redirect:listaCotizaciones";
    }

    @RequestMapping(value = "/rechazar-cotizacion", method = RequestMethod.GET)
    public String rechazarCotizacion(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("idCotizacion") int idCotizacion) {

        String rechazada = cotDAO.rechazarCotizacion(idCotizacion);
        if (rechazada == null) {
            ra.addFlashAttribute("mensaje", "NO se pudo RECHAZAR Cotización en Sistema VIALIS. Favor, verifique los datos ingresados.");
            return "redirect:listaCotizaciones";
        }
        ra.addFlashAttribute("mensaje", rechazada);
        ra.addFlashAttribute("cotizaciones", cotDAO.ListarCotizaciones());

        return "redirect:listaCotizaciones";
    }

    @RequestMapping(value = "/modificarCotizacion", method = RequestMethod.GET)
    public String modificarCotizacion(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        Servicio.ProveedoresWS_Service service = new Servicio.ProveedoresWS_Service();

        try {

            List<Proveedor> proveedores = service.getProveedoresWSPort().mostrarTodosProveedores();
            List<Proyecto> proyectos = proDAO.ListarProyectos();
            model.addAttribute("proyectos", proyectos);
            model.addAttribute("proveedores", proveedores);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "modificarCotizacion";
    }

    @RequestMapping(value = "/modificar-cotizacion", method = RequestMethod.POST)
    public String modificarCotizacionFinal(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("cboProveedor") String proveedor,
            @RequestParam("txtHerramientas") String herramientas,
            @RequestParam("txtMateriales") String materiales,
            @RequestParam("txtMaquinaria") String maquinaria,
            @RequestParam("txtServicioExterno") String servicioExterno,
            @RequestParam("cboProyecto") int idProyectoRelacionado,
            @RequestParam("txtIdCotizacion") int idCotizacion) {

        Cotizacion newCotizacion = new Cotizacion();

        newCotizacion.setIdCotizacion(idCotizacion);
        newCotizacion.setProveedor(proveedor);
        newCotizacion.setHerramienta(herramientas);
        newCotizacion.setMaterial(materiales);
        newCotizacion.setMaquinaria(maquinaria);
        newCotizacion.setServicioExterno(servicioExterno);
        newCotizacion.setIdProyectoRelacionado(idProyectoRelacionado);

        String modificado = cotDAO.modificarCotizacionFinal(newCotizacion);

        if (modificado == null) {
            ra.addFlashAttribute("mensaje", "NO se pudo MODIFICAR cotización al Sistema VIALIS. Favor, verifique los datos ingresados.");
            return "redirect:modificarCotizacion";
        }
        ra.addFlashAttribute("mensaje", modificado);
        ra.addFlashAttribute("cotizacion", newCotizacion);

        return "redirect:modificarCotizacion";
    }

    @RequestMapping(value = "/agregar-documento-cotizacion", method = RequestMethod.POST)
    public String agregarDocumentoCotizacion(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtNombreDocumento") String nombreDocumento,
            @RequestParam("txtTipoDocumento") String tipoDocumento,
            @RequestParam("txtIdCotizacion") int idCotizacion,
            @RequestParam("txtDocumento") MultipartFile documento) {

        FileService fileService = new FileService();
        Documento document = new Documento();

        document.setRutaDocumento(fileService.saveFileCotizacion(documento));
        document.setNombreDocumento(nombreDocumento);
        document.setTipoDocumento(tipoDocumento);
        document.setIdDocumento(0);
        document.setIdProyecto(0);
        document.setIdTrabajador(0);
        document.setIdCotizacion(idCotizacion);
        String agregado = docDAO.agregarDocumento(document);

        if (agregado == null) {
            ra.addFlashAttribute("mensaje", "NO se pudo MODIFICAR cotización al Sistema VIALIS. Favor, verifique los datos ingresados.");
            return "redirect:modificarCotizacion";
        } else {
            ra.addFlashAttribute("cotizacion", cotDAO.BuscarCotizacionPorId(idCotizacion));
            ra.addFlashAttribute("mensaje", agregado);
        }

        return "redirect:modificarCotizacion";
    }

    @RequestMapping(value = "/buscar-cotizacion", method = RequestMethod.POST)
    public String buscarTrabajador(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtBuscarCotizacion") int idCotizacion) {

        Cotizacion cotizacionExistente = cotDAO.BuscarCotizacionPorId(idCotizacion);

        if (cotizacionExistente == null) {
            ra.addFlashAttribute("mensaje", "NO Exite Cotización ingresada con ese código. Favor ingrese código válido.");
            return "redirect:modificarCotizacion";
        }

        ra.addFlashAttribute("cotizacion", cotizacionExistente);

        return "redirect:modificarCotizacion";
    }

    @RequestMapping(value = "/modificarCotizacionDesdeListar", method = RequestMethod.GET)
    public String modificarCotizacionDesdeListar(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("idCotizacion") int codigoCotizacion) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }
        Cotizacion cotizacionExistente = cotDAO.BuscarCotizacionPorId(codigoCotizacion);

        if (cotizacionExistente == null) {
            ra.addFlashAttribute("mensaje", "NO Exite Cotización agendada con el código ingresado. Favor intente otro código.");
            return "redirect:modificarCotizacion";
        }

        ra.addFlashAttribute("cotizacion", cotizacionExistente);

        return "redirect:modificarCotizacion";
    }

    @RequestMapping(value = "/eliminar-documento-cotizacion", method = RequestMethod.GET)
    public String eliminarDocumento(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("idCotizacion") int idCotizacion,
            @RequestParam("idDocumento") int idDocumento) {

        DocumentoDAO docuDAO = new DocumentoDAO();
        String mensaje = null;
        mensaje = docuDAO.eliminarDocumento(idDocumento);
        Cotizacion cotizacionExistente = cotDAO.BuscarCotizacionPorId(idCotizacion);
        if (mensaje == null) {
            mensaje = "No se puedo eliminar documento en Sistema VIALIS. Favor intente más tarde.";
        }
        if (cotizacionExistente == null) {
            ra.addFlashAttribute("mensaje", "NO Exite Cotización Ingresado con ese código. Favor ingrese rut válido.");
            return "redirect:modificarCotizacion";
        }

        ra.addFlashAttribute("cotizacion", cotizacionExistente);
        ra.addFlashAttribute("mensaje", mensaje);

        return "redirect:modificarCotizacion";
    }

}
