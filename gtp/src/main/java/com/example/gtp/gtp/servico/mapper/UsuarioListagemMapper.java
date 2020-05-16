package com.example.gtp.gtp.servico.mapper;

import com.example.gtp.gtp.dominio.Usuario;
import com.example.gtp.gtp.servico.dto.UsuarioListagemDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioListagemMapper extends EntityMapper<UsuarioListagemDTO, Usuario> {
}
