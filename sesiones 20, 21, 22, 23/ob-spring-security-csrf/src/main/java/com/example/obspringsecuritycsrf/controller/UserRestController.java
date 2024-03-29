package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    // urls permitidas
    @GetMapping("/hola")
    public String hola(){
        return "Hola mundo";
    }

    // urls autenticadas
    @GetMapping("/adios")
    public String adios(){
        return "Adios mundo";
    }
    @PostMapping("/users")
    public String save(@RequestBody UserDTO user){
        System.out.println(user);
        return "OK";
    }
}
