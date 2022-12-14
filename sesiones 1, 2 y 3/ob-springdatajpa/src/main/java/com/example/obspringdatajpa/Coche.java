package com.example.obspringdatajpa;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coche {


    // Atributos encapsulados
    // Cuándo trabajamos con bases de datos es importante que podamos tener valores nulos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Es un valor numérico que permite valores nulos
    private String manufacturer;
    private String model;
    private Integer yearr;

    // Constructores

    public Coche() {
    }

    public Coche(Long id, String manufacturer, String model, Integer yearr) {
        this.id = id;
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearr = yearr;
    }

    // getter y setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearr() {
        return yearr;
    }

    public void setYearr(Integer yearr) {
        this.yearr = yearr;
    }


    // tostring, este método sirve para visualizar los datos
    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", year=" + yearr +
                '}';
    }
}
