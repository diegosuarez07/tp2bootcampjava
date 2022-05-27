package com.vates.practica.tp2bootcampjava.controllers;

import com.vates.practica.tp2bootcampjava.entities.Autor;
import com.vates.practica.tp2bootcampjava.entities.Libro;
import com.vates.practica.tp2bootcampjava.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/libro")
public class LibrosController {

    @Autowired
    private LibrosService gestor;

    // Para agregar o modificar un libro
    @PutMapping("/registrarLibro/{id}")
    public ResponseEntity registrarLibro(@RequestBody Libro nuevoLibro) {
        if (nuevoLibro != null && nuevoLibro.getTituloLibro() != null){
            gestor.registrarLibro(nuevoLibro);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity("datos invalidos", HttpStatus.BAD_REQUEST);
    }

    // Para consultar un libro por id
    @GetMapping("/{id}")
    public ResponseEntity<Libro> consultarLibro(@PathVariable int idLibro){
        Libro libroEncontrado = gestor.consultarLibro(idLibro);
        if (libroEncontrado != null)
            return ResponseEntity.ok(libroEncontrado);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Para consultar todas los libros
    @GetMapping("/libros")
    public Collection<Libro> consultarLibros(){
        return gestor.consultarLibros();
    }

    // Para borrar un libro por id
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarLibro(@PathVariable int idLibro) {
        if (gestor.consultarLibro(idLibro) != null) {
            gestor.eliminarLibro(idLibro);
            return ResponseEntity.ok().build();
        }
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }





}
