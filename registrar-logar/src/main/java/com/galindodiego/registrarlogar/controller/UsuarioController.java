package com.galindodiego.registrarlogar.controller;

import com.galindodiego.registrarlogar.model.Usuario;
import com.galindodiego.registrarlogar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @GetMapping("/register")
    public String getPaginaRegistro(Model model){
        model.addAttribute("registerRequest", new Usuario());
        return "pagina_registro";
    }

    @GetMapping("/login")
    public String getPaginaLogin(Model model){
        model.addAttribute("loginRequest",new Usuario());
        return "pagina_logar";
    }

    @GetMapping("/cadastrado")
    private String cadastrado(){
            return "pagina_cadastrado";
        }

    @PostMapping("/register")
    public String registrar(@ModelAttribute Usuario usuario){
        System.out.println("register request "+ usuario);
       Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario.getNome(),usuario.getEmail(),usuario.getLogin(),usuario.getPassword());
      return usuarioRegistrado == null ? "pagina_error" : "redirect:/cadastrado";

    }

    @PostMapping("/login")
    public String login(@ModelAttribute Usuario usuario, Model model){
        System.out.println("login request: "+ usuario);
        Usuario usuarioAutenticado = usuarioService.autenticacao(usuario.getLogin(),usuario.getPassword());
        if(usuarioAutenticado != null){
            model.addAttribute("userLogin",usuarioAutenticado.getLogin());
            return "pagina_logado";
        }else {
            return "pagina_error";
        }

    }
}
