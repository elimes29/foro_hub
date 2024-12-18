package com.alura.forohub.domain.usuario;

import com.alura.forohub.domain.perfil.DatosRegistraPerfil;
import com.alura.forohub.domain.perfil.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.util.List;

public record DatosRegistraUsuario(
        Long id,
        @NotBlank String nombre,
        @NotBlank @Email @JsonProperty("correo_electronico") String correoElectronico,
        @NotBlank @Pattern(regexp = ".{6,}",
                message = "La contraseña debe tener al menos 6 caracteres.") String contrasena,
        List<DatosRegistraPerfil> perfiles
) {

}
