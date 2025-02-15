package com.eventos.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "eventos")
public class Eventos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private Date dataEvento;

    @Column(nullable = false)
    private String classificacao;

    @Column(nullable = false)
    private LocalTime hora_inicio;

    @Column(nullable = false)
    private LocalTime hora_fim;

    @Column(nullable = false)
    private LocalTime hora_abertura;

    @Column(nullable = false)
    private String imagem;

    @ManyToOne
    @JoinColumn(name = "enderecos_id", nullable = false)
    private Endereco endereco;

    @ManyToOne
    @JoinColumn(name = "produtoras_id", nullable = false)
    private Produtora produtora;

    @ManyToMany
    @JoinTable(
            name = "usuarios_eventos",
            joinColumns = @JoinColumn(name = "evento_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )
    private List<Usuario> usuarios;
}
