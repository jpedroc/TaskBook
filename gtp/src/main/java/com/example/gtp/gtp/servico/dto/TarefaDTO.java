package com.example.gtp.gtp.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
public class TarefaDTO {

    private Long id;

    @NotNull
    @Size(min=3, max=80, message = "Título inválido")
    private String titulo;

    @NotNull
    @Size(max=400, message = "Descrição inválido")
    private String descricao;

    @NotNull(message = "Data inválida")
    private LocalDate data;

    @NotNull
    @Size(min=1, max=3, message = "Importancia inválida")
    private Integer importancia;

    @NotNull(message = "Usuário inválido")
    private Long idUsuario;

}
