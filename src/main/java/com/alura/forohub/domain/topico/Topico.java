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
import java.util.ArrayList;
import java.util.List;
@Entity(name = "Topico")
@Table(name = "topicos")
@Getter
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

    public Topico() {
    }

    public Topico( String titulo, String mensaje, LocalDateTime fechaCreacion, String status, Usuario autor, Curso curso) {
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }

    public Topico(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String status, Usuario autor, Curso curso, List<Respuesta> respuestas) {
        this.id = id;
        this.titulo = titulo;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.status = status;
        this.autor = autor;
        this.curso = curso;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public Usuario getAutor() {
        return autor;
    }

    public Curso getCurso() {
        return curso;
    }


    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", status='" + status + '\'' +
                ", autor=" + autor +
                ", curso=" + curso +
                '}';
    }

    public void agregaFechaStatusCursoAutor(Curso curso, Usuario autor, String mensaje, String titulo) {
        this.fechaCreacion= LocalDateTime.now();
        this.status = "Activo;";
        this.curso = curso;
        this.autor = autor;
        this.mensaje = mensaje;
        this.titulo = titulo;
    }

    public void cambiaMensajeTitulo(String mensaje, String titulo) {
        this.mensaje = mensaje;
        this.titulo = titulo;
    }

    public void cambiaTitulo(String titulo) {
        this.titulo=titulo;
    }

    public void cambiaMensaje(String mensaje) {
        this.mensaje = mensaje;
    }


}
