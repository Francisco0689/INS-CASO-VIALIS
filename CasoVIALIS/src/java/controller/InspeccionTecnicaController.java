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
import service.Inspeccion;

/**
 *
 * @author fmaldonc
 */
@Controller
public class InspeccionTecnicaController {

    @RequestMapping(value = "/inspeccionTecnica", method = RequestMethod.GET)
    public String cotizacion(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        service.InspeccionWS service = new service.InspeccionWS();

        try {

            List<Inspeccion> inspecciones = service.getInspeccionTecnicaListPort().mostrarTodasInspecciones();

            model.addAttribute("inspecciones", inspecciones);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "inspeccionTecnica";
    }

}
