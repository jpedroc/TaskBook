package com.example.gtp.gtp.servico;

import com.example.gtp.gtp.servico.dto.TarefaDTO;
import com.example.gtp.gtp.servico.dto.TarefaListagemDTO;

import java.util.List;

public interface TarefaServico {

    public List<TarefaListagemDTO> listar(Long id);

    public TarefaListagemDTO salvar(TarefaDTO tarefaDTO);

    public void deletar(Long id);
}
