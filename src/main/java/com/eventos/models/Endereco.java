package com.eventos.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "enderecos")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = true)
    private String rua;

    @Column(nullable = true)
    private String numero;

    @Column(nullable = true)
    private String bairro;

    private String complemento;





}
