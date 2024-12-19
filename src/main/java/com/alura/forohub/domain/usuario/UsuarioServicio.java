package com.alura.forohub.domain.usuario;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServicio {
    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario buscarAutor(@NotNull Long id) {
        Optional<Usuario> autorOpcional = usuarioRepository.findById(id);
        if (autorOpcional.isPresent()){
            return autorOpcional.get();
        }else {
            throw new RuntimeException("Autor no encontrado");
        }
    }
}
