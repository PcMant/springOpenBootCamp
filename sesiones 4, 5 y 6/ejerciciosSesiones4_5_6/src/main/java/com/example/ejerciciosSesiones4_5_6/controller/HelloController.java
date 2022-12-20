package com.example.ejerciciosSesiones4_5_6.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hola")
    public String hola(){
        return "Hola, que tal?";
    }
}
