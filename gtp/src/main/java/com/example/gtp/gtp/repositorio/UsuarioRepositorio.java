package com.example.gtp.gtp.repositorio;

import com.example.gtp.gtp.dominio.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepositorio extends JpaRepository<Usuario,Long> {
    Usuario findByEmail(String email);
}
