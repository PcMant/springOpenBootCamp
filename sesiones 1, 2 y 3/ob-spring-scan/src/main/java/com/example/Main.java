package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args){

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        // Opción1. Crear un objeto de forma normal
        // Calculadora service = new Calculadora();

        // Opción 2. Recibir un objeto de spring, spring es el framework que nos va crear los objetos y nos lo va a pasar
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        String texto = calculadora.holaMundo();
        System.out.println(texto);

        Calculadora calculadora2 = (Calculadora) context.getBean("calculadora");

        texto = calculadora2.holaMundo();
        System.out.println(texto);

        // Ejemplo 2: Cargar un bean dentro de otro Bean
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());

        // CONCEPTO 3: Scope o alcance
        /*
        Los beans por defecto son singleton, se crea el objeto y se reutiliza para toda la aplicación
        podemos cambiarlo a scope="prototype" si queremos que se cree un objeto nuevo cada vez.
        Verificando como se ejecuta varias veces un constructor.
        */

    }
}
