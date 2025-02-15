package com.eventos.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "cidades")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String uf;
}
