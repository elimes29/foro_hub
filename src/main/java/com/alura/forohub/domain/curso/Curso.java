package com.alura.forohub.domain.curso;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
@Entity(name = "Curso")
@Table(name = "cursos")
@Getter
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String categoria;

    public Curso() {
    }

    public Curso(Long id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }
}
