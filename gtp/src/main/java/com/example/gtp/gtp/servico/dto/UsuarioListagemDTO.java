package com.example.gtp.gtp.servico.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UsuarioListagemDTO {

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3, max = 80, message = "Nome inválido")
    private String nome;

    @NotNull
    @Email(message = "Email inválido")
    private String email;
}
