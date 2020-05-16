package com.example.gtp.gtp.servico.impl;

import com.example.gtp.gtp.dominio.Usuario;
import com.example.gtp.gtp.repositorio.UsuarioRepositorio;
import com.example.gtp.gtp.servico.Exception.MyException;
import com.example.gtp.gtp.servico.UsuarioServico;
import com.example.gtp.gtp.servico.dto.UsuarioDTO;
import com.example.gtp.gtp.servico.dto.UsuarioListagemDTO;
import com.example.gtp.gtp.servico.mapper.UsuarioListagemMapper;
import com.example.gtp.gtp.servico.mapper.UsuarioMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class UsuarioServicoImpl implements UsuarioServico {

    private final UsuarioListagemMapper usuarioListagemMapper;
    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepositorio usuarioRepositorio;

    @Override
    public List<UsuarioListagemDTO> listar() {
        return usuarioListagemMapper.toDto(usuarioRepositorio.findAll());
    }

    @Override
    public UsuarioListagemDTO salvar(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);

        verificarEmail(usuario);

        usuarioRepositorio.save(usuario);

        return usuarioListagemMapper.toDto(usuario);
    }

    private void verificarEmail(Usuario usuario) {
        Usuario usuarioBusca = usuarioRepositorio.findByEmail(usuario.getEmail());
        if(!(usuarioBusca == null || usuarioBusca.getId().equals(usuario.getId()))){
            throw new MyException("Email existente");
        }
    }

    @Override
    public void deletar(Long id) {
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        usuarioRepositorio.delete(usuario.get());
    }

    @Override
    public UsuarioListagemDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepositorio.findById(id).orElseThrow(() -> new MyException("Usuário inválido"));
        return usuarioListagemMapper.toDto(usuario);
    }
}
