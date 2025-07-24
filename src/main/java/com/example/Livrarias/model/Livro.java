package com.example.Livrarias.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Data
@Table(name = "livro", schema = "public")
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column(name = "isbn", length = 20, nullable = false)
    private String isbn;

    @Column(name = "titulo", length = 150, nullable = false)
    private String titulo;

    @Column(name = "data_publicaçao", nullable = false)
    private LocalDate dataPublicaçao;

    @Column(name = "genero", length = 30, nullable = false)
    private String genero;

    @Column(name = "preço", precision = 18, scale = 2)
    private BigDecimal preço;

    @ManyToOne
    @JoinColumn(name = "id_autor")
    private Autor autor;

    public Livro() {}

}
