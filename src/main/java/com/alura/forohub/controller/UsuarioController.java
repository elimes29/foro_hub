package com.alura.forohub.controller;


import com.alura.forohub.domain.perfil.DatosSalidaPerfil;
import com.alura.forohub.domain.perfil.Perfil;
import com.alura.forohub.domain.perfil.PerfilRepository;
import com.alura.forohub.domain.usuario.DatosRegistraUsuario;
import com.alura.forohub.domain.usuario.DatosSalidaUsuario;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.domain.usuario.UsuarioRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/usuarios")
@SecurityRequirement(name = "bearer-key")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PerfilRepository perfilRepository;

    @GetMapping
    public ResponseEntity<Page<DatosSalidaUsuario>> obtenerUsuarios(Pageable paginacion){
        return  ResponseEntity.ok(usuarioRepository.findAll(paginacion)
                .map(u -> new DatosSalidaUsuario(
                        u.getId(),
                        u.getNombre(),
                        u.getPerfiles()
                                .stream().map(p -> new DatosSalidaPerfil(
                                        p.getId(),
                                        p.getNombre())).toList())));
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> guardaUsuario(@RequestBody @Valid DatosRegistraUsuario datosRegistraUsuario,
                                           UriComponentsBuilder uriComponentsBuilder) {
        // Usuario por defecto id 1
        Optional<Perfil> perfilOpcional = perfilRepository.findById(1L);

        if (perfilOpcional.isPresent()) {
            // Crear una nueva instancia de Usuario a partir de los datos de la solicitud
            Usuario usuario = new Usuario(datosRegistraUsuario);

            List<Perfil> perfiles = new ArrayList<>();
            perfiles.add(perfilOpcional.get());
            // Agregar el perfil encontrado al usuario
            usuario.setPerfiles(perfiles);

            // Guardar el usuario (esto también actualizará la tabla intermedia usuarios_perfiles)
            usuarioRepository.save(usuario);
            //Creamos la URL de la dirección del usuario creado
            URI uri = uriComponentsBuilder.path("/perfiles/{id}").buildAndExpand(usuario.getId()).toUri();
            // Respuesta exitosa
            return ResponseEntity.created(uri).body(new DatosSalidaUsuario(usuario.getId(), usuario.getNombre(), (List<DatosSalidaPerfil>) usuario.getPerfiles().stream().map(p -> new DatosSalidaPerfil(p.getId(), p.getNombre())).toList()));
        } else {
            // Si no se encuentra el perfil, devolver un error
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Perfil no encontrado");
        }
    }


}
