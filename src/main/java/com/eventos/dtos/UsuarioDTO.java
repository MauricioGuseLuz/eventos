package com.eventos.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class UsuarioDTO {

    private Long id;

    private String nome;

    private Date data_nascimento;

    private String cpf;

    private String email;

    private String senha;

    private String perfil;

    private Boolean verificado;

}
