package com.alura.forohub.controller;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.curso.CursoRepository;
import com.alura.forohub.domain.curso.DatosSalidaCurso;
import com.alura.forohub.domain.curso.DatosRegistraCurso;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.net.URI;

@RestController
@RequestMapping("/cursos")
@SecurityRequirement(name = "bearer-key")
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosSalidaCurso> guardaCurso(@RequestBody @Valid DatosRegistraCurso datosRegistraCurso,
                                                        UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoRepository.save(new Curso(datosRegistraCurso.id(),
                datosRegistraCurso.nombre(),
                datosRegistraCurso.categoria()));
        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosSalidaCurso(curso.getId(), curso.getNombre(), curso.getCategoria()));
    }

    @GetMapping
    public ResponseEntity<Page<DatosSalidaCurso>> obtenerDatos(Pageable paginacion){
        return ResponseEntity.ok( cursoRepository.findAll(paginacion)
                .map(c -> new DatosSalidaCurso(
                        c.getId()
                        , c.getNombre()
                        , c.getCategoria())));
    }


}
