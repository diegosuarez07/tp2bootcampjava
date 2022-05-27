package com.vates.practica.tp2bootcampjava.services;

import com.vates.practica.tp2bootcampjava.entities.Autor;
import com.vates.practica.tp2bootcampjava.repositories.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.Collection;

@Service
@ApplicationScope
public class AutoresService {

    @Autowired
    private AutoresRepository repoAutores;

    public void registrarAutor(Autor nuevoAutor) {
        repoAutores.save(nuevoAutor);
    }

    public Autor consultarAutor(int idAutor) {
        return repoAutores.findById(idAutor).orElse(null);
    }

    public Collection<Autor> consultarAutores() {
        return repoAutores.findAll();
    }

    public void borrarAutor(int idAutor) {
        repoAutores.deleteById(idAutor);
    }
}
