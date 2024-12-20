package com.alura.forohub.controller;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.curso.CursoServicio;
import com.alura.forohub.domain.topico.*;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.domain.usuario.UsuarioServicio;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    TopicoRepository topicoRepository;

    @Autowired
    UsuarioServicio usuarioServicio;

    @Autowired
    CursoServicio cursoServicio;

    @Autowired
    TopicoServicio topicoServicio;

    @GetMapping()
    public ResponseEntity<Page<DatosSalidaTopico>> obtenerTopicos(
            @RequestParam(required = false) String nombreCurso,
            @RequestParam(required = false) Integer anio,
            @PageableDefault(size = 10, page = 0, sort = "fechaCreacion", direction = Sort.Direction.ASC) Pageable paginacion) {

        Page<Topico> topicos;

        // Lógica para determinar el tipo de búsqueda según los parámetros
        if (nombreCurso != null && anio != null) {
            topicos = topicoRepository.findByCursoNombreAndFechaCreacionYear(nombreCurso, anio, paginacion);
        } else if (nombreCurso != null) {
            topicos = topicoRepository.findByCursoNombre(nombreCurso, paginacion);
        } else if (anio != null) {
            topicos = topicoRepository.findByFechaCreacionYear(anio, paginacion);
        } else {
            topicos = topicoRepository.findAll(paginacion);
        }

        Page<DatosSalidaTopico> datosSalida = topicos.map(t -> new DatosSalidaTopico(
                t.getId(),
                t.getTitulo(),
                t.getMensaje(),
                t.getFechaCreacion(),
                t.getStatus(),
                t.getAutor().getId(),
                t.getCurso().getId()
        ));

        return ResponseEntity.ok(datosSalida);
    }


    @PostMapping
    @Transactional
    public ResponseEntity<DatosSalidaTopico> registraTopico(
            @RequestBody @Valid DatosRegistraTopico datosRegistraTopico,
            UriComponentsBuilder uriComponentsBuilder){
        //Chequeamos mensaje y título de típico
        topicoServicio.validarTopico(datosRegistraTopico.titulo(), datosRegistraTopico.mensaje());

        //Buscamos el autor
        Usuario autor = usuarioServicio.buscarAutor(datosRegistraTopico.idAutor());
        //Buscamos el curso
        Curso curso = cursoServicio.buscarCurso(datosRegistraTopico.idCurso());
        //Creamos tópico
        Topico topico = new Topico();
        //Seteamos status, fecha de creación, curso, mensaje y titulo y autor
        topico.agregaFechaStatusCursoAutor(curso, autor, datosRegistraTopico.mensaje(), datosRegistraTopico.titulo());
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

    @GetMapping("/{id}")
    public ResponseEntity<DatosSalidaTopico> obtenTopico(@PathVariable Long id){
        Optional<Topico> topicoOpcional = topicoRepository.findById(id);
        if (topicoOpcional.isPresent()) {
            Topico topico = topicoOpcional.get();
            return ResponseEntity.ok(new DatosSalidaTopico(
                    topico.getId(),
                    topico.getTitulo(),
                    topico.getMensaje(),
                    topico.getFechaCreacion(),
                    topico.getStatus(),
                    topico.getAutor().getId(),
                    topico.getCurso().getId()));

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DatosSalidaTopico> actualizaTopico(
            @PathVariable Long id,
            @RequestBody @Valid DatosActualizaTopico datosActualizaTopico,
            UriComponentsBuilder uriComponentsBuilder){
        //Chequeamos mensaje y título de típico
        topicoServicio.validarTopico(datosActualizaTopico.titulo(), datosActualizaTopico.mensaje());

        //Buscamo el tópico a modificar
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        Topico topico = new Topico();
        if (topicoOptional.isPresent()){
            topico = topicoOptional.get();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

        //Cambiamos  mensaje y titulo
        if (datosActualizaTopico.mensaje()==null && datosActualizaTopico.titulo()==null ){
            return ResponseEntity.status(400).body(null);
        } else if (datosActualizaTopico.mensaje()==null) {
            topico.cambiaTitulo( datosActualizaTopico.titulo());
        } else if (datosActualizaTopico.titulo()==null) {
            topico.cambiaMensaje(datosActualizaTopico.mensaje());
        }else{
            topico.cambiaMensajeTitulo(datosActualizaTopico.mensaje(), datosActualizaTopico.titulo());
        }

        //Actualizamos el topico
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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> eliminaTopico(@PathVariable Long id){
        //Buscamo el tópico a eliminar
        Optional<Topico> topicoOptional = topicoRepository.findById(id);
        Topico topico = new Topico();
        if (topicoOptional.isPresent()){
            topicoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null);
        }

    }


}
