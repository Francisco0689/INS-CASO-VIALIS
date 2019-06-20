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

    @RequestMapping(value = "/aprobar-cotizacion", method = RequestMethod.POST)
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

    @RequestMapping(value = "/rechazar-cotizacion", method = RequestMethod.POST)
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

    @RequestMapping(value = "/modificar-cotizacion", method = RequestMethod.POST)
    public String modificarCotizacion(Model model, RedirectAttributes ra, HttpServletRequest request,
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

}
