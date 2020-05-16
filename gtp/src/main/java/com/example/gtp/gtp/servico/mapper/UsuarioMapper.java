package com.example.gtp.gtp.servico.mapper;

import com.example.gtp.gtp.dominio.Usuario;
import com.example.gtp.gtp.servico.dto.UsuarioDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper extends EntityMapper<UsuarioDTO, Usuario> {
}
