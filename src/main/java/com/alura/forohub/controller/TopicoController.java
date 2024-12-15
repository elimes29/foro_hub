package com.alura.forohub.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @GetMapping()
    public void obtenerTopicos(){
        System.out.println( "estamos llegando");
    }
}
