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
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String mensaje;
    private LocalDateTime fechaCreacion;

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos a uno con Usuario (autor)
    @JoinColumn(name = "usuario_id")  // Columna que relaciona al usuario (autor)
    private Usuario autor;  // El autor de la respuesta

    @ManyToOne(fetch = FetchType.LAZY)  // Relación muchos a uno con Topico
    @JoinColumn(name = "topico_id")  // Columna que relaciona al tópico
    private Topico topico;  // El tópico al que pertenece la respuesta

    private String solucion;  // Indica si la respuesta es una solución
}
