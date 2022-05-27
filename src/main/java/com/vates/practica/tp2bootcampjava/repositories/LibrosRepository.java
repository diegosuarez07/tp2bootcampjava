package com.vates.practica.tp2bootcampjava.repositories;

import com.vates.practica.tp2bootcampjava.entities.Autor;
import com.vates.practica.tp2bootcampjava.entities.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibrosRepository extends JpaRepository<Libro, Integer> {

    /*

     Listado de todos los libros ordenados por titulo
    - Cantidad de libros de un autor indicado por id
    - Listado de todos los libros buscando por titulo
    - Listado de todos los libros de un autor buscado por nombre

     */


}
