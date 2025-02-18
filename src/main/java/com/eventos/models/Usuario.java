package com.eventos.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Data
@Table(name = "usuarios")
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private Date data_nascimento;

    private String cpf;

    private String email;

    private String senha;

    private String perfil;

    private Boolean verificado;

}
