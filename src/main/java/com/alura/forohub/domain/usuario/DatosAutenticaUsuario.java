package com.alura.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DatosAutenticaUsuario(
        @NotBlank String nombre,
        @NotBlank @Pattern(regexp = ".{6,}",
                message = "La contraseña debe tener al menos 6 caracteres.")
        String contrasena
        ) {
}
