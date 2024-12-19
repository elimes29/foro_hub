package com.alura.forohub.domain.curso;

import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CursoServicio {

    @Autowired
    CursoRepository cursoRepository;


    public Curso buscarCurso(@NotNull Long id) {
        Optional<Curso> cursoOpcional = cursoRepository.findById(id);
        if (cursoOpcional.isPresent()){
            return cursoOpcional.get();
        }else {
            throw new RuntimeException("Curso no encontrado");
        }
    }
}
