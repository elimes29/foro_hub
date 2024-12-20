package com.alura.forohub.controller;

import com.alura.forohub.domain.perfil.DatosSalidaPerfil;
import com.alura.forohub.domain.perfil.DatosRegistraPerfil;
import com.alura.forohub.domain.perfil.Perfil;
import com.alura.forohub.domain.perfil.PerfilRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/perfiles")
@SecurityRequirement(name = "bearer-key")
public class PerfilController {

    @Autowired
    PerfilRepository perfilRepository;

    @GetMapping()
    public ResponseEntity<Page<DatosSalidaPerfil>> obtenerPerfiles(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(perfilRepository.findAll(paginacion).map(DatosSalidaPerfil::new));
    }

    @Transactional
    @PostMapping()
    public ResponseEntity<DatosSalidaPerfil> guardaPerfil(@RequestBody @Valid DatosRegistraPerfil datosRegistraPerfil, UriComponentsBuilder uriComponentsBuilder){
        //convierte de DTO a prefil
        Perfil perfil = new Perfil(datosRegistraPerfil);
        System.out.println(perfil.getId());
        perfilRepository.save(perfil);
    URI uri = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(perfil.getId()).toUri();
    return ResponseEntity.created(uri).body(new DatosSalidaPerfil(perfil.getId(), perfil.getNombre()));
    }

    @Override
    public String toString() {
        return "PerfilController{" +
                "perfilRepository=" + perfilRepository +
                '}';
    }
}
