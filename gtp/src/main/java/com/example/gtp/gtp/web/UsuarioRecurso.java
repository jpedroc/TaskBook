package com.example.gtp.gtp.web;

import com.example.gtp.gtp.servico.UsuarioServico;
import com.example.gtp.gtp.servico.dto.UsuarioDTO;
import com.example.gtp.gtp.servico.dto.UsuarioListagemDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioRecurso {

    private final UsuarioServico usuarioServico;

    @GetMapping
    public ResponseEntity<List<UsuarioListagemDTO>> listar(){
        List<UsuarioListagemDTO> usuarios = usuarioServico.listar();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("{id}")
    public ResponseEntity<UsuarioListagemDTO> buscarPorId(@PathVariable Long id){
        UsuarioListagemDTO usuario = usuarioServico.buscarPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public  ResponseEntity<UsuarioListagemDTO> cadastrar(@Valid @RequestBody UsuarioDTO usuarioDTO) throws URISyntaxException {
        UsuarioListagemDTO usuario = usuarioServico.salvar(usuarioDTO);
        return ResponseEntity.created(new URI("/usuarios/" + usuario.getId())).body(usuario);
    }

    @PutMapping
    public ResponseEntity<UsuarioListagemDTO> alterar(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        UsuarioListagemDTO usuario = usuarioServico.salvar(usuarioDTO);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        usuarioServico.deletar(id);
        return ResponseEntity.ok(null);
    }

}
