package com.health.projetoIntegrador.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author soare
 */
@Controller
public class viewController {
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping(method=RequestMethod.GET, value="/cadastro")
    public String telaCadastro(){
        return "cadastro";
    }
}
