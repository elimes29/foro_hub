package com.alura.forohub.controller;

import com.alura.forohub.domain.usuario.DatosAutenticaUsuario;
import com.alura.forohub.domain.usuario.Usuario;
import com.alura.forohub.infra.security.DatosJwtToken;
import com.alura.forohub.infra.security.TokenServicio;
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

    @Autowired
    private TokenServicio tokenServicio;

@PostMapping
public ResponseEntity autentica(@RequestBody @Valid
                                DatosAutenticaUsuario datosAutenticaUsuario){
    Authentication authToken = new UsernamePasswordAuthenticationToken(datosAutenticaUsuario.nombre(),
            datosAutenticaUsuario.contrasena());
    var usuarioAutenticado = authenticationManager.authenticate(authToken);
    String jwtToken = tokenServicio.generaToken((Usuario) usuarioAutenticado.getPrincipal());
    return ResponseEntity.ok(new DatosJwtToken(jwtToken));
}

}
