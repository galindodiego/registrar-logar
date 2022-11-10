package com.galindodiego.registrarlogar.controller;

import com.galindodiego.registrarlogar.model.Usuario;
import com.galindodiego.registrarlogar.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller //Define que a classe é Controller
public class UsuarioController {

    @Autowired
    private final UsuarioService usuarioService; // Cria um objeto do tipo UsuarioService com anotação @Autowired para ser utilizada seus serviços

    public UsuarioController(UsuarioService usuarioService) {//Construtor da classe com parametro usuarioService
        this.usuarioService = usuarioService;
    }


    @GetMapping("/register") //Define a URL que quando requisitada chamara o metodo
    public String getPaginaRegistro(Model model){ //Chama o metodo com o parametro do tipo Model
        model.addAttribute("registerRequest", new Usuario()); //objeto model irá adicionar atributos para a View
        return "pagina_registro";//Retorna a view que deve ser chamada (pagina-registro.html)
    }

    @GetMapping("/login") //Define a URL que quando requisitada chamara o metodo
    public String getPaginaLogin(Model model){ //Chama o metodo com o parametro do tipo Model
        model.addAttribute("loginRequest",new Usuario()); //objeto model irá adicionar atributos para a View
        return "pagina_logar"; //Retorna a view que deve ser chamada (pagina-logar.html)
    }

    @GetMapping("/cadastrado") //Define a URL que quando requisitada chamara o metodo
    private String cadastrado(){
            return "pagina_cadastrado"; //Retorna a view que deve ser chamada (pagina-cadastro.html)
        }

    @PostMapping("/register") //Define a URL que quando requisitada chamara o metodo
    public String registrar(@ModelAttribute Usuario usuario){ //Chama o metodo com o parametro do tipo Usuario e com a anotação para atribuição para a View
        System.out.println("register request "+ usuario);
       Usuario usuarioRegistrado = usuarioService.registrarUsuario(usuario.getNome(),usuario.getEmail(),usuario.getLogin(),usuario.getPassword());//Chama o metodo da classe de Serviços com os parametros do usuario e guarda em um objeto do tipo Usuario
      return usuarioRegistrado == null ? "pagina_error" : "redirect:/cadastrado";//(Teste ternario) se o obejto é null, se SIM chama a pagina_error, se NÂO chama redireciona para pagina_cadastro

    }

    @PostMapping("/login") //Define a URL que quando requisitada chamara o metodo
    public String login(@ModelAttribute Usuario usuario, Model model){ //Chama o metodo com o parametro do tipo Usuario e Model, com a anotação para atribuição para a View
        System.out.println("login request: "+ usuario);
        Usuario usuarioAutenticado = usuarioService.autenticacao(usuario.getLogin(),usuario.getPassword());// Chama o metodo autenticacao com os parametros e adiciona o resultado no objeto do tipo Usuario
        if(usuarioAutenticado != null){ // Testa se o objeto é null
            model.addAttribute("userLogin",usuarioAutenticado.getLogin()); //objeto model irá adicionar atributos para a View
            return "pagina_logado"; //Caso o objeto seja diferente de Null, Retorna a view (pagina-logado.html)
        }else {
            return "pagina_error"; //Caso o objeto seja Null, Retorna a view (pagina-error.html)
        }

    }
}
