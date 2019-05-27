/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import Entidades.Usuario;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
/**
 *
 * @author fmaldonc
 */
@Controller
public class ProyectoController {
    
    @RequestMapping(value="/proyecto", method = RequestMethod.GET)
    public String home(Model model, HttpServletRequest request){
       
        HttpSession session = request.getSession();
        Usuario usu = (Usuario)session.getAttribute("usu");

        if(usu == null){
            return "login";
        }
        
        return "proyecto";
    }
    
    
}
