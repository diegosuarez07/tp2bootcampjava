package com.vates.practica.tp2bootcampjava.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idLibro;

    @Column(name = "titulo")
    private String tituloLibro;


    @ManyToOne(fetch = FetchType.LAZY)
    //nombre de columna como esta en el sql
    @JoinColumn(name = "id_autor")
    @JsonBackReference
    private Autor autor;

    public Libro(int idLibro, String tituloLibro, Autor autor) {
        this.idLibro = idLibro;
        this.tituloLibro = tituloLibro;
        this.autor = autor;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public String getTituloLibro() {
        return tituloLibro;
    }

    public void setTituloLibro(String tituloLibro) {
        this.tituloLibro = tituloLibro;
    }

    public Autor getIdAutor() {
        return autor;
    }

    public void setIdAutor(Autor idAutor) {
        this.autor = autor;
    }
}
