package com.galindodiego.registrarlogar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsuarioController {

    @GetMapping("/registrar")
    public String getPaginaRegistro(){
        return "pagina_registro";
    }

    @GetMapping("/login")
    public String getPaginaLogin(){
        return "pagina_logar";
    }
}
