package com.alura.forohub.domain.respuesta;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosRegistraRespuesta(
        @NotBlank String mensaje,
        //LocalDateTime fechaCreacion, se obtiene cuando se crea la respuesta en la DB
        @NotNull Long idTopico,
        @NotNull Long idUsuario,
        String solucion
) {
}
