package com.alura.forohub.controller;

import com.alura.forohub.domain.usuario.DatosAutenticaUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    private AuthenticationManager authenticationManager;

@PostMapping
public ResponseEntity autentica(@RequestBody @Valid
                                DatosAutenticaUsuario datosAutenticaUsuario){
    Authentication token = new UsernamePasswordAuthenticationToken(datosAutenticaUsuario.nombre(),
            datosAutenticaUsuario.contrasena());
    authenticationManager.authenticate(token);
    return ResponseEntity.ok().build();
}

}
