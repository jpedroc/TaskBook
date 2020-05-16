package com.example.gtp.gtp.servico.mapper;

import com.example.gtp.gtp.dominio.Tarefa;
import com.example.gtp.gtp.servico.dto.TarefaListagemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TarefaListagemMapper extends EntityMapper<TarefaListagemDTO, Tarefa> {
}
