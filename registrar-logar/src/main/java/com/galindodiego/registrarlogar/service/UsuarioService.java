package com.galindodiego.registrarlogar.service;

import com.galindodiego.registrarlogar.model.Usuario;
import com.galindodiego.registrarlogar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository; // Cria um objeto do tipo UsuarioRepositorio com anotação @Autowired para ser utilizada seus serviços

    public Usuario registrarUsuario(String nome,String email,String login,String password){//Meto salva os parametros passados em um objeto to tipo Usuario
        if(login != null && password != null){ //Testa se as variaveis login e password são nulas
            Usuario usuario = new Usuario(); //Cria um objeto do tipo Usuario
            usuario.setNome(nome); //atribui o valor da variavel na variavel do objeto Usuario
            usuario.setLogin(login); //atribui o valor da variavel na variavel do objeto Usuario
            usuario.setPassword(password); //atribui o valor da variavel na variavel do objeto Usuario
            usuario.setEmail(email); //atribui o valor da variavel na variavel do objeto Usuario
            return usuarioRepository.save(usuario); //Metodo da classe Repository salva o objeto Usuario e retorna.
        }else {
            return null;
        }
    }

    public Usuario autenticacao(String login,String password){ //Metodo recebe os argumentos e retorna se foi encontrado na base de dados
        return usuarioRepository.findByLoginAndPassword(login,password).orElse(null);
    }

}
