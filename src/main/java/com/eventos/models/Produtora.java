package com.eventos.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "produtoras")
public class Produtora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpfCnpj;

    @ManyToOne
    @JoinColumn(name = "usuarios_id", nullable = false)
    private Usuario usuario;
}