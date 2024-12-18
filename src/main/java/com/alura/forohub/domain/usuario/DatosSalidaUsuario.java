package com.alura.forohub.domain.usuario;

import com.alura.forohub.domain.perfil.Perfil;

import java.util.List;

public record DatosSalidaUsuario(Long id, String nombre, List<Perfil> perfiles) {

    public DatosSalidaUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNombre(), usuario.getPerfiles());
    };
}
