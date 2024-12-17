package com.alura.forohub.domain.perfil;

public record DatosSalidaPerfil(Long id, String nombre) {

    public DatosSalidaPerfil(Perfil perfil) {
        this(perfil.getId(), perfil.getNombre());
    }

}
