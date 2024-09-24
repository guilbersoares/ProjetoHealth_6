
package com.health.projetoIntegradorFinal.controller;
import com.health.projetoIntegradorFinal.entity.User;
import com.health.projetoIntegradorFinal.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Gui
 */
@Controller
public class viewController {
    @Autowired
    private UserRepository userRepository;
    
    //Mapeamento das páginas e rotas
    @GetMapping("/login")
    public String index(User user){
        return "index";
    }
    
    @GetMapping("/cadastro")
    public String cadastro(User user){
        return "cadastro";
    }
    
    @GetMapping("/homepage")
    public String home(User user){
        return "homepage";
    }
    
    @GetMapping("/cadastroFeito")
    public String cadastroFeito(User user){
        return "cadastroFeito";
    }
    
    @GetMapping("/dieta")
    public String dieta(User user){
        return "dieta";
    }
    
    
    //Controle para realizar o cadastro
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute("user") User user){
        System.out.println(user);
        String encodedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12));
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "cadastroFeito";
    }
    
    
    //Controle para o login
    @PostMapping("/login")
    public String loginProcess(@RequestParam("username") String username, 
            @RequestParam("password") String password){
        User dbUser = userRepository.findByUsername(username);
        Boolean isPasswordMatch = BCrypt.checkpw(password, dbUser.getPassword());
        if(isPasswordMatch)
           return "homepage";
        else
           return "index";      
    }
 }

