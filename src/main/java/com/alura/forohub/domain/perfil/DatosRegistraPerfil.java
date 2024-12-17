package com.alura.forohub.domain.perfil;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistraPerfil(
        @NotBlank String nombre
) {
}
