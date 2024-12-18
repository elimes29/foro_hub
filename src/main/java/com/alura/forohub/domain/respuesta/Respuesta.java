package com.alura.forohub.domain.respuesta;

import com.alura.forohub.domain.topico.Topico;
import com.alura.forohub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Entity(name = "Respuesta")
@Table(name = "respuestas")
@Getter
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos a uno con Topico (topico)
    @JoinColumn(name = "topico_id")  // Columna que relaciona al topico (topico)
    private Topico topico;  // El tópico de la respuesta

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos a uno con Usuario (autor)
    @JoinColumn(name = "usuario_id")  // Columna que relaciona al usuario (autor)
    private Usuario autor;  // El autor de la respuesta
    private String solucion;  // Indica si la respuesta es una solución

    public Respuesta() {
    }

    public Long getId() {
        return id;
    }


    public Respuesta(Long id, String mensaje, LocalDateTime fechaCreacion, Topico topico, Usuario autor, String solucion) {
        this.id = id;
        this.mensaje = mensaje;
        this.fechaCreacion = fechaCreacion;
        this.topico = topico;
        this.autor = autor;
        this.solucion = solucion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public Usuario getAutor() {
        return autor;
    }

    public String getSolucion() {
        return solucion;
    }

    public Topico getTopico() {
        return topico;
    }
}
