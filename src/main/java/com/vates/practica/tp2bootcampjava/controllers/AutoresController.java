package com.vates.practica.tp2bootcampjava.controllers;

import com.vates.practica.tp2bootcampjava.entities.Autor;
import com.vates.practica.tp2bootcampjava.entities.Libro;
import com.vates.practica.tp2bootcampjava.services.AutoresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/autor")
public class AutoresController {

    @Autowired
    private AutoresService gestor;

    // Para agregar o modificar un autor
    @PutMapping("/registrarAutor/{id}")
    public ResponseEntity registrarAutor(@RequestBody Autor nuevoAutor) {
        // Falta validar
        if (nuevoAutor != null && nuevoAutor.getNombreAutor() != null){ // reglas de validacion {
            gestor.registrarAutor(nuevoAutor);
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else
            return new ResponseEntity("datos invalidos", HttpStatus.BAD_REQUEST);
    }

    // Para consultar un autor por id
    @GetMapping("/{id}")
    public ResponseEntity<Autor> consultarAutor(@PathVariable int idAutor){
        Autor autorEncontrado = gestor.consultarAutor(idAutor);
        if (autorEncontrado != null)
            return ResponseEntity.ok(autorEncontrado);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Para consultar todas los autores
    @GetMapping("/autores")
    public Collection<Autor> consultarAutores(){
        return gestor.consultarAutores();
    }

    // Para borrar una persona por documento
    @DeleteMapping("/{doc}")
    public ResponseEntity borrar(@PathVariable int idAutor) {
        if (gestor.consultarAutor(idAutor) != null) {
            gestor.borrarAutor(idAutor);
            return ResponseEntity.ok().build();
        }
        else
            return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


}
