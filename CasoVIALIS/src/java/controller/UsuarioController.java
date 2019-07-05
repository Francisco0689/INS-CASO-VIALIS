/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.RolDAO;
import DAO.TrabajadorDAO;
import DAO.UsuarioDAO;
import Entidades.Rol;
import Entidades.Trabajador;
import Entidades.Usuario;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fmaldonc
 */
@Controller
public class UsuarioController {

    private TrabajadorDAO traDAO = new TrabajadorDAO();
    private RolDAO rolDAO = new RolDAO();
    private UsuarioDAO usuDAO = new UsuarioDAO();

    @RequestMapping(value = "/usuario", method = RequestMethod.GET)
    public String usuario(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }else if(usu.getIdRol() != 1){
            return "home";
        }

        List<Trabajador> trabajadores = traDAO.ListarTrabajadores();
        List<Rol> roles = rolDAO.ListarRoles();

        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("roles", roles);

        return "usuario";
    }

    @RequestMapping(value = "/modificarUsuario", method = RequestMethod.GET)
    public String modificarUsuario(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");

        if (usu == null) {
            return "login";
        }

        List<Trabajador> trabajadores = traDAO.ListarTrabajadores();
        List<Rol> roles = rolDAO.ListarRoles();

        model.addAttribute("trabajadores", trabajadores);
        model.addAttribute("roles", roles);
        model.addAttribute("usuario", usu);

        return "modificarUsuario";
    }

    @RequestMapping(value = "/agregar-usuario", method = RequestMethod.POST)
    public String agregarUsuario(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtNombreUsuario") String nombreUsuario,
            @RequestParam("txtTrabajador") int idTrabajador,
            @RequestParam("txtRol") int idRol) {

        int existe = usuDAO.mostrarUsuarioExistente(idTrabajador);
        if (existe > 0) {
            ra.addFlashAttribute("mensaje", "YA Existe Usuario registrado en Sistema VIALIS con el trabajador seleccionado.");
            return "redirect:usuario";
        }

        Trabajador trabajadorExistente = traDAO.mostrarTrabajadorPorCodigoInterno(idTrabajador);
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombreUsuario(nombreUsuario);
        nuevoUsuario.setPasswordUsuario(Integer.toString(trabajadorExistente.getRutTrabajador()));
        nuevoUsuario.setIdTrabajador(idTrabajador);
        nuevoUsuario.setIdRol(idRol);

        String mensaje = usuDAO.agregarUsuario(nuevoUsuario);

        if (mensaje == null) {
            mensaje = "No se pudo guardar USARIO en sistema VIALIS, Favor verifique los datos";
        }

        ra.addFlashAttribute("mensaje", mensaje);

        return "redirect:usuario";
    }

    @RequestMapping(value = "/modificar-usuario", method = RequestMethod.POST)
    public String modificarUsuario(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtPassword") String password) {

        HttpSession session = request.getSession();
        Usuario usu = (Usuario) session.getAttribute("usu");
        
        String mensaje = usuDAO.modificarUsuario(password,usu.getIdUsuario());

        if (mensaje == null) {
            mensaje = "No se pudo Modificar USARIO en sistema VIALIS, Favor verifique los datos";
            return "redirect:modificarUsuario";
        }

        ra.addFlashAttribute("mensaje2", mensaje);

        return "redirect:login";
    }

}
