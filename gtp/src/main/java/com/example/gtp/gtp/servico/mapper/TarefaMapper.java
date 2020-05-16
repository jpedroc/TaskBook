package com.example.gtp.gtp.servico.mapper;

import com.example.gtp.gtp.dominio.Tarefa;
import com.example.gtp.gtp.servico.dto.TarefaDTO;
import com.example.gtp.gtp.servico.dto.TarefaListagemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TarefaMapper extends EntityMapper<TarefaDTO, Tarefa> {

    @Override
    @Mapping(source = "idUsuario", target = "usuario.id")
    Tarefa toEntity(TarefaDTO dto);
}
