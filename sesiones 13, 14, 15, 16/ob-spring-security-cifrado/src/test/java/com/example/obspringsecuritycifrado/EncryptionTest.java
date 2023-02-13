package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt que genera su propio salt de 16 bytes
     *
     * El resultado de cifrado con bcrypt será un string de 60 caracteres:
     *
     * $a version
     * $10 fuerza - A más fuerza más validaciones y más seguro, pero más afecta esto al rendimiento
     * (El valor por defecto de la fuerza es 10)
     * Los 22 siguientes caracteres son el salt generado
     */
    @Test
    void bcryptTest(){

        BCryptPasswordEncoder passwordencoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordencoder.encode("admin");
        System.out.println(hashedPassword);

        boolean matches = passwordencoder.matches("adminn", hashedPassword);
        System.out.println(matches);
    }

//    @Test
//    void bcryptCheckMultiplePasswords(){
//
//        BCryptPasswordEncoder passwordencoder = new BCryptPasswordEncoder();
//        for(int i = 0; i < 30; i++)
//            // A pesar de ser la misma el hash generado va a ser distinto como medida de seguridad
//            System.out.println(passwordencoder.encode("admin"));
//    }

//    @Test
//    void pbkdf2(){
//
//        Pbkdf2PasswordEncoder passwordencoder = new Pbkdf2PasswordEncoder();
//        for(int i = 0; i < 30; i++)
//            System.out.println(passwordencoder.encode("admin"));
//    }

//    @Test
//    void argon(){
//
//        Argon2PasswordEncoder passwordencoder = new Argon2PasswordEncoder();
//        for(int i = 0; i < 30; i++)
//            System.out.println(passwordencoder.encode("admin"));
//    }

//    @Test
//    void scrypt(){
//
//        SCryptPasswordEncoder passwordencoder = new SCryptPasswordEncoder();
//        for(int i = 0; i < 30; i++)
//            System.out.println(passwordencoder.encode("admin"));
//    }

    void springPasswordEncoders(){

        // Esto lo que hace es facilitar pasar de un algoritmo a otro en caso de que este se halla roto
        String idForEncode = "bcrypt";

        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("bcrypt", new BCryptPasswordEncoder());
//        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
//        encoders.put("argon2", new Argon2PasswordEncoder());
//        encoders.put("scrypt", new SCryptPasswordEncoder());
          //noseguro:
//        //este esta deprecated y sirve para cuando no hay codificación
//        encoders.put("noop", new NoOpPasswordEncoder().getInstance());
        encoders.put("sha256", new StandardPasswordEncoder());

        PasswordEncoder passwordencoder = new DelegatingPasswordEncoder("bcrypt", encoders);

        String hashedPassword = passwordencoder.encode("admin");
        System.out.println(hashedPassword);
    }

}
