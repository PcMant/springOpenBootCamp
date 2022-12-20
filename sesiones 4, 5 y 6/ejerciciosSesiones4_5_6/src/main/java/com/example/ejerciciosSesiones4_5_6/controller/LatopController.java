package com.example.ejerciciosSesiones4_5_6.controller;

import com.example.ejerciciosSesiones4_5_6.entities.Latop;
import com.example.ejerciciosSesiones4_5_6.repository.LatopRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LatopController {

    private LatopRepository latopRepository;

    public LatopController(LatopRepository latopRepository) {
        this.latopRepository = latopRepository;
    }

    @GetMapping("/api/latops")
    public List<Latop> findAll(){
        return latopRepository.findAll();
    }
}
