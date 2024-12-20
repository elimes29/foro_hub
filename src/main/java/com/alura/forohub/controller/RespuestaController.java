package com.alura.forohub.controller;

import com.alura.forohub.domain.respuesta.DatosRegistraRespuesta;
import com.alura.forohub.domain.respuesta.DatosSalidaRespuesta;
import com.alura.forohub.domain.respuesta.Respuesta;
import com.alura.forohub.domain.respuesta.RespuestaRepository;
import com.alura.forohub.domain.topico.Topico;
import com.alura.forohub.domain.topico.TopicoRepository;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/respuestas")
@SecurityRequirement(name = "bearer-key")
public class RespuestaController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    @Transactional
    @PostMapping
    ResponseEntity<DatosSalidaRespuesta> guardarRespuesta(
            @RequestBody @Valid DatosRegistraRespuesta datosRegistraRespuesta,
            UriComponentsBuilder uriComponentsBuilder){
        System.out.println("Estos son los datos recibidos " + datosRegistraRespuesta);
        //Buscamos topico y usuario
        Optional<Topico> topicoOpcional = topicoRepository.findById(datosRegistraRespuesta.idTopico());
        Topico topico = new Topico();
        if (topicoOpcional.isPresent()){
            topico = topicoOpcional.get();
        }else {
            throw new RuntimeException("No se consiguió el tópico");
        }

        Optional<Usuario> usuarioOpcional = usuarioRepository.findById(datosRegistraRespuesta.idUsuario());
        Usuario usuario = new Usuario();
        if (usuarioOpcional.isPresent()){
            usuario = usuarioOpcional.get();
        }else {
            throw new RuntimeException("No se consiguió el Autor");
        }

        System.out.println("Topico "+ topico.toString());
        System.out.println(("Usuario " + usuario.toString()));

        //Creamos la respuesta
        Respuesta respuesta = new Respuesta(null,
                datosRegistraRespuesta.mensaje(),
                LocalDateTime.now(),
                topico,
                usuario,
                null);
        respuestaRepository.save(respuesta);
        //creamos URL
        URI uri = uriComponentsBuilder.path("/respuestas/{id}").buildAndExpand(respuesta.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosSalidaRespuesta(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getTopico().getId(),
                respuesta.getAutor().getId(),
                respuesta.getSolucion()
        ));
    }


}
