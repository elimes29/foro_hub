package com.alura.forohub.domain.topico;

import com.alura.forohub.domain.usuario.DatosRegistraUsuario;
import com.alura.forohub.domain.usuario.Usuario;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;

public record DatosRegistraTopico(
        Long id,
        @NotBlank String titulo,
        @NotBlank String mensaje,
        @NotNull Long idAutor,
        @NotNull Long idCurso
) {
}
