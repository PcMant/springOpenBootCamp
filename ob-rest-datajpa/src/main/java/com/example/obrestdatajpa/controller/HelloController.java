package com.example.obrestdatajpa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* Los controladores reciben las rutas, la anotación RestController sirve para respuestas en JSON mientras que
* la anotación Controller se usa para devolver HTML
* */
@RestController
public class HelloController {

    // La anotación GetMapping se utiliza para mapear rutas y existen de varios tipos
    @GetMapping("/hola")
    public String holamundo(){
        return "Hola mundo que tal vamos!!! Hasta luego!";
    }

    @GetMapping("/boostrap")
    public String bootstrap(){
        // Los template string similares a los de python son compatibles a partir de Java 15
        /* Por poder se puede programar HTML directamente en java pero no es lo recomendable ya que el dia que cambie algo
        hay que recompilar todo el código, para ello mejor utilizar un motor de plantillas */
        return """
                <!doctype html>
                <html lang="es">
                  <head>
                    <meta charset="utf-8">
                    <meta name="viewport" content="width=device-width, initial-scale=1">
                    <title>Bootstrap demo</title>
                    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
                  </head>
                  <body>
                    <h1>Hola mundo desde Spring Boot!</h1>
                    <a class="btn btn-primary" href="https://google.es" target="_blank">Google</a>
                    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
                  </body>
                </html>           
                         
                """;
    }
}
