package com.example.obrestdatajpa.controller;

import com.example.obrestdatajpa.entities.Book;
import com.example.obrestdatajpa.repository.BookRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // buscar un solo libro en case de datos segun id, entre llaves va el parámetro

    /**
     * Request
     * Response
     * @param id
     * @return
     */
    @GetMapping("/api/books/{id}")
    // Para poderle pasar el parámetro de la URL por la función hay que usar la anotación @PathVariable
    public ResponseEntity<Book> findOneById(@PathVariable Long id){

        Optional<Book> bookOpt = bookRepository.findById(id);
        // Se comprueba si existe o no el libro solicitado por id
        // Opcion 1
        /*if(bookOpt.isPresent())
            return ResponseEntity.ok(bookOpt.get());
        else
            return ResponseEntity.notFound().build();*/

        // Opción 2
//        return bookOpt.orElse(null);
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // crear un nuevo libro en base de datos
    @PostMapping("/api/books")
    public Book create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
        // guardar el libro recibido por parametro en la base de datos
        return bookRepository.save(book);
    }

    // actualizar un libro existente en base de datos

    // borrar un libro en base de datos
}
