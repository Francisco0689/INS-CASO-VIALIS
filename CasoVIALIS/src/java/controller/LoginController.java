/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.UsuarioDAO;
import Entidades.Usuario;
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
public class LoginController {
    
    UsuarioDAO usuDAO = new UsuarioDAO();
    
    @RequestMapping(value="/login", method = RequestMethod.GET)
    public String login(Model model, HttpServletRequest request){
    
        HttpSession session = request.getSession();
        session.setAttribute("usu", null);
        return "login";
    }
    
    @RequestMapping(value="/entrar", method = RequestMethod.POST)
    public String login(Model model, RedirectAttributes ra, HttpServletRequest request,
            @RequestParam("txtUser") String user,
            @RequestParam("txtPass") String pass){
        
        HttpSession session = request.getSession();
        Usuario usuarioExistente = usuDAO.mostrarUsuario(user, pass);
        String mensaje = "Credenciales Incorrectas";
        
        if (usuarioExistente != null) {
            session.setAttribute("usu", usuarioExistente);
            return "redirect:/";
        }

        ra.addFlashAttribute("mensaje", mensaje);
        
        return "redirect:login";
    }
    

    
}
