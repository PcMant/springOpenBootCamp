package com.example.obrestdatajpa.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Schema(description = "Entidad libro como representar un elemento didáctico copuesto por láminas de celulosa macerada en Puerto Rico")
@Table(name = "books")
public class Book {

    // atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Clave ficticia autoincremental tipo Long")
    private Long id;
    private String title;
    private String author;
    private Integer pages;
    @Schema(description = "Precio en rupias, con dos decimales utilizando el . como separador")
    private Double price;
    private LocalDate release;
    private Boolean online;

    // constructores
    /* Conviene crear un constructor vacio, lo normal es tener un constructor vacio, porque
    * este tipo de frameworks que tienen persistencia para los metodos set crean objetos vacios.
    * */
    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate release, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.release = release;
        this.online = online;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getRelease() {
        return release;
    }

    public void setRelease(LocalDate release) {
        this.release = release;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }

}
