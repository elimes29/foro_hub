package com.alura.forohub.controller;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.curso.CursoRepository;
import com.alura.forohub.domain.respuesta.Respuesta;
import com.alura.forohub.domain.respuesta.RespuestaRepository;
import com.alura.forohub.domain.topico.*;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.domain.usuario.UsuarioRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    CursoRepository cursoRepository;

    @Autowired
    RespuestaRepository respuestaRepository;

    @Autowired
    TopicoRepository topicoRepository;


    @GetMapping()
    public ResponseEntity<Page<DatosSalidaTopico>> obtenerTopicos(Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion)
                .map(t -> new DatosSalidaTopico(t.getId(),
                        t.getTitulo(),
                        t.getMensaje(),
                        t.getFechaCreacion(),
                        t.getStatus(),
                        t.getAutor().getId(),
                        t.getCurso().getId())));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DatosSalidaTopico> registraTopico(
            @RequestBody @Valid DatosRegistraTopico datosRegistraTopico,
            UriComponentsBuilder uriComponentsBuilder){
        System.out.println("estos son los datos: " + datosRegistraTopico );
        //setea fecha del post
        LocalDateTime fecha = LocalDateTime.now();
        //Asgna Activo al status
        String status = "Activo";
        //Buscamos el autor
        Usuario autor = new Usuario();
        Optional<Usuario> autorOpcional = usuarioRepository.findById(datosRegistraTopico.idAutor());
        if (autorOpcional.isPresent()){
            autor = autorOpcional.get();
        }else {
            throw new RuntimeException("Autor no encontrado");
        }

        //Buscamos el curso
        Curso curso = new Curso();
        Optional<Curso> cursoOpcional = cursoRepository.findById(datosRegistraTopico.idCurso());
        if (autorOpcional.isPresent()){
            curso = cursoOpcional.get();
        }else {
            throw new RuntimeException("Curso no encontrado");
        }
        //Creamos una lista de respuesta vacia
        List<Respuesta> respuestas = new ArrayList<>();
        //Crea el tópico
        Topico topico = new Topico(null, datosRegistraTopico.titulo(), datosRegistraTopico.mensaje(), fecha, status, autor, curso, respuestas);

        //Salvamos el topico
        topicoRepository.save(topico);
        //Creamos url
        URI uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DatosSalidaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getAutor().getId(),
                topico.getCurso().getId()));
    }

}
