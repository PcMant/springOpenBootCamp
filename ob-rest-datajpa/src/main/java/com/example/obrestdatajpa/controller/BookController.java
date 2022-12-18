package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    // atributos
    private BookRepository bookRepository;

    // constructore
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    // CRUD sobre la entidad Book

    // Buscar todos los libros (lista de libnros)
    @GetMapping("/api/books")
    public List<Book> findAll(){
        // recuperar y devolver los libros de base de datos
        return bookRepository.findAll();
    }

    // buscar un solo libro en case de datos segun id
//    public Book findOneById(Long id){
//        return bookRepository.find
//    }

    // crear un nuevo libro en base de datos

    // actualizar un libro existente en base de datos

    // borrar un libro en base de datos
}
