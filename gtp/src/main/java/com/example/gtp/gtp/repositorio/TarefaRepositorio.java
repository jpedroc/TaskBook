package com.example.gtp.gtp.repositorio;

import com.example.gtp.gtp.dominio.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepositorio extends JpaRepository<Tarefa,Long> {
    List<Tarefa> findAllByUsuarioId(Long id);
}
