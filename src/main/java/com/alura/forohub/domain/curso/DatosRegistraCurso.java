package com.alura.forohub.domain.curso;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistraCurso(
        Long id, @NotBlank String nombre, @NotBlank String categoria
) {
}
