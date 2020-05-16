package com.example.gtp.gtp.servico;

import com.example.gtp.gtp.servico.dto.UsuarioDTO;
import com.example.gtp.gtp.servico.dto.UsuarioListagemDTO;

import java.util.List;

public interface UsuarioServico {

    public List<UsuarioListagemDTO> listar();

    public UsuarioListagemDTO salvar(UsuarioDTO usuarioDTO);

    public void deletar(Long id);

    public UsuarioListagemDTO buscarPorId(Long id);
}
