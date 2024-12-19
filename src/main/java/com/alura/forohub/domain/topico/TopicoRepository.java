package com.alura.forohub.domain.topico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface TopicoRepository extends JpaRepository<Topico, Long> {
    Optional<Topico> findByTituloAndMensaje(String titulo, String mensaje);

    @Query("""
            SELECT t FROM Topico t 
            WHERE 
            t.curso.nombre = :nombreCurso 
            AND YEAR(t.fechaCreacion) = :anio
            """)
    Page<Topico> findByCursoNombreAndFechaCreacionYear(
            @Param("nombreCurso") String nombreCurso,
            @Param("anio") int anio,
            Pageable pageable);

    @Query("""
            SELECT t FROM Topico t 
            WHERE YEAR(t.fechaCreacion) = :anio
            """)
    Page<Topico> findByFechaCreacionYear(@Param("anio") int anio, Pageable pageable);

    @Query("""
            SELECT t FROM Topico t 
            WHERE t.curso.nombre = :nombreCurso
            """)
    Page<Topico> findByCursoNombre(@Param("nombreCurso") String nombreCurso, Pageable pageable);
}

