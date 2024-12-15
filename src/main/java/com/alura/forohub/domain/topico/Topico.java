package com.alura.forohub.domain.topico;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.respuesta.Respuesta;
import com.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos a uno con Usuario
    @JoinColumn(name = "usuario_id")  // Columna que relaciona al usuario (autor)
    private Usuario autor;  // El autor del tópico

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos a uno con Curso
    @JoinColumn(name = "curso_id")  // Columna que relaciona al curso
    private Curso curso;  // El curso asociado al tópico

    @OneToMany(mappedBy = "topico", fetch = FetchType.LAZY)  // Relación uno a muchos con Respuesta
    private List<Respuesta> respuestas;  // Las respuestas asociadas al tópico
}
