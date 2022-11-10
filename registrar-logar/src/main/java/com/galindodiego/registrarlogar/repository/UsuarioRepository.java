package com.galindodiego.registrarlogar.repository;

import com.galindodiego.registrarlogar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLoginAndPassword(String login,String password); // Metodo recebe argumentos e retorna o objeto do tipo Usuario
}
