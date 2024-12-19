package com.alura.forohub.domain.topico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicoServicio {
    @Autowired
    TopicoRepository topicoRepository;

    public void validarTopico(String titulo, String mensaje) {
        // Verificar si ya existe un tópico con el mismo título y mensaje
        Optional<Topico> existente = topicoRepository.findByTituloAndMensaje(titulo, mensaje);
        if (existente.isPresent()) {
            throw new IllegalArgumentException("Ya existe un tópico con el mismo título y mensaje.");
        }
        // Si no existe, guardar el nuevo tópico
        return;
    }
}
