package com.example;

import org.springframework.stereotype.Component;

@Component
public class GestorFacturas {

    Calculadora calculadora;
    //@Value("Facturator 3000") // No me funciono en este caso, por eso quito el parámetro nombre
    String nombre;

    public GestorFacturas(Calculadora calculadora){
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;
        this.nombre = nombre;
    }


}
