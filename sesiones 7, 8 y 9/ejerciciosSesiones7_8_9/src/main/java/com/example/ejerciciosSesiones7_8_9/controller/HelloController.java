package com.example.ejerciciosSesiones7_8_9.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String hola(){
        return "Hola, que tal?";
    }
}
