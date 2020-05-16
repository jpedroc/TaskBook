package com.example.gtp.gtp.servico.impl;

import com.example.gtp.gtp.dominio.Tarefa;
import com.example.gtp.gtp.repositorio.TarefaRepositorio;
import com.example.gtp.gtp.servico.Exception.MyException;
import com.example.gtp.gtp.servico.TarefaServico;
import com.example.gtp.gtp.servico.dto.TarefaDTO;
import com.example.gtp.gtp.servico.dto.TarefaListagemDTO;
import com.example.gtp.gtp.servico.mapper.TarefaListagemMapper;
import com.example.gtp.gtp.servico.mapper.TarefaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class TarefaServicoImpl implements TarefaServico {

    private final TarefaListagemMapper tarefaListagemMapper;
    private final TarefaMapper tarefaMapper;
    private final TarefaRepositorio tarefaRepositorio;

    @Override
    public List<TarefaListagemDTO> listar(Long id) {
        return  tarefaListagemMapper.toDto(tarefaRepositorio.findAllByUsuarioId(id));
    }

    @Override
    public TarefaListagemDTO salvar(TarefaDTO tarefaDTO) {
        Tarefa tarefa = tarefaMapper.toEntity(tarefaDTO);
        tarefaRepositorio.save(tarefa);
        return tarefaListagemMapper.toDto(tarefa);
    }

    @Override
    public void deletar(Long id) {
        Tarefa tarefa = tarefaRepositorio.findById(id).orElseThrow(() -> new MyException("Tarefa não encontrada"));
        tarefaRepositorio.delete(tarefa);
    }
}
