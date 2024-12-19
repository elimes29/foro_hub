package com.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizaTopico(
        String titulo,
        String mensaje
        //Long idAutor, no creo conveniente cambiar autor
        // Long idCurso no creo conveniente cambiar curso
) {
}
