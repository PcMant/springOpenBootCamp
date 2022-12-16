package org.example;

import org.springframework.stereotype.Component;

@Component
public class UserService {

    private String NotificationService = "Hola, esto es un saludo";

    public String imprimirSaludo(){
        return this.NotificationService;
    }
}
