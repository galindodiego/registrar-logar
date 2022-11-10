package com.galindodiego.registrarlogar.service;

import com.galindodiego.registrarlogar.model.Usuario;
import com.galindodiego.registrarlogar.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario registrarUsuario(String nome,String email,String login,String password){
        if(login != null && password != null){
            Usuario usuario = new Usuario();
            usuario.setNome(nome);
            usuario.setLogin(login);
            usuario.setPassword(password);
            usuario.setEmail(email);
            return usuarioRepository.save(usuario);
        }else {
            return null;
        }
    }

    public Usuario autenticacao(String login,String password){
        return usuarioRepository.findByLoginAndPassword(login,password).orElse(null);
    }

}
