package com.alura.forohub.controller;

import com.alura.forohub.domain.curso.Curso;
import com.alura.forohub.domain.curso.CursoRepository;
import com.alura.forohub.domain.curso.DatosCursoSalida;
import com.alura.forohub.domain.curso.DatosRegistraCurso;
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
public class CursoController {

    @Autowired
    CursoRepository cursoRepository;

    @Transactional
    @PostMapping
    public ResponseEntity<DatosCursoSalida> guardaCurso(@RequestBody @Valid DatosRegistraCurso datosRegistraCurso,
                                                        UriComponentsBuilder uriComponentsBuilder){
        Curso curso = cursoRepository.save(new Curso(datosRegistraCurso.id(),
                datosRegistraCurso.nombre(),
                datosRegistraCurso.categoria()));
        URI uri = uriComponentsBuilder.path("/cursos/{id}").buildAndExpand(curso.getId()).toUri();

        return ResponseEntity.created(uri).body(new DatosCursoSalida(curso.getId(), curso.getNombre(), curso.getCategoria()));
    }

    @GetMapping
    public ResponseEntity<Page<DatosCursoSalida>> obtenerDatos(Pageable paginacion){
        return ResponseEntity.ok( cursoRepository.findAll(paginacion)
                .map(c -> new DatosCursoSalida(c.getId()
                        , c.getNombre()
                        , c.getCategoria())));
    }


}
