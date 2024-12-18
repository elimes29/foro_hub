package com.alura.forohub.domain.perfil;

import com.alura.forohub.domain.usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "Perfil")
@Table(name = "perfiles")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToMany(mappedBy = "perfiles") // Relación inversa de la relación en Usuario
    @JsonBackReference
    private List<Usuario> usuarios = new ArrayList<>();

    public Perfil(@Valid DatosRegistraPerfil datosRegistraPerfil) {
        this.nombre = datosRegistraPerfil.nombre();
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public Perfil() {
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "id=" + id +
                ", nombre='" + nombre + '\'';
    }
}
