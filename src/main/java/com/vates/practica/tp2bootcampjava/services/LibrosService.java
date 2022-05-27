package com.vates.practica.tp2bootcampjava.services;

import com.vates.practica.tp2bootcampjava.entities.Autor;
import com.vates.practica.tp2bootcampjava.entities.Libro;
import com.vates.practica.tp2bootcampjava.repositories.LibrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Collection;

@Service
@ApplicationScope
public class LibrosService {

    @Autowired
    private LibrosRepository repoLibros;

    public void registrarLibro(Libro nuevoLibro) {
    }

    public Libro consultarLibro(int idLibro) {
        return repoLibros.findById(idLibro).orElse(null);
    }

    public Collection<Libro> consultarLibros() {
        return repoLibros.findAll();
    }

    public void eliminarLibro(int idLibro) {
    }
}
