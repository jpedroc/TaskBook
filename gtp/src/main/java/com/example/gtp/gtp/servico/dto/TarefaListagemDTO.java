package com.example.gtp.gtp.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class TarefaListagemDTO {

    private Long id;
    private String titulo;
    private LocalDate data;

}
