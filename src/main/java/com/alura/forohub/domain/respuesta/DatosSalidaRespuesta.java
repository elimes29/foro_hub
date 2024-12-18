package com.alura.forohub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosSalidaRespuesta(
        Long id, String mensaje, LocalDateTime fechaCreacion,
        Long idTopico, Long idUsuario, String solucion
) {
}
