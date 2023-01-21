package com.example.ejerciciosSesiones10_11_12.controller;

import com.example.ejerciciosSesiones10_11_12.entities.Latop;
import com.example.ejerciciosSesiones10_11_12.repository.LatopRepository;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class LatopController {

    private final Logger log = LoggerFactory.getLogger(LatopController.class);

    private LatopRepository latopRepository;

    public LatopController(LatopRepository latopRepository) {
        this.latopRepository = latopRepository;
    }

    /**
     * Obtener todas las Latops
     * @return
     */
    @GetMapping("/api/latops")
    @Operation(description = "Listar tdoas las latops")
    public List<Latop> findAll(){
        return latopRepository.findAll();
    }

    /**
     * Buscar una sola latop según id
     * @param id
     * @return
     */
    @GetMapping("/api/latops/{id}")
    @Operation(description = "Buscar un latop")
    public ResponseEntity<Latop> findOneById(@Parameter(description = "clave primaria de tipo Long") @PathVariable Long id){

        Optional<Latop> latopOpt = latopRepository.findById(id);

        if(latopOpt.isPresent()){
            return ResponseEntity.ok(latopOpt.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Crear una nueva Latop en la base de datos
     * @param latop
     * @return
     */
    @PostMapping("/api/latops")
    @Operation(description = "Crear una nueva latop en la base de datos")
    public ResponseEntity<Latop> create(@RequestBody Latop latop){

        if(latop.getId() != null){
            log.warn("Triying to create a bool with id");
            return ResponseEntity.badRequest().build();
        }

        Latop result = latopRepository.save(latop);
        return ResponseEntity.ok(result);
    }

    /**
     * Actualizar un latop de la base de datos
     * @param latop
     * @return
     */
    @PutMapping("/api/latops")
    @Operation(description = "Actualizar un latop de la base de datos")
    public ResponseEntity<Latop> update( @RequestBody Latop latop){
        if(latop.getId() == null){
            log.warn("Triying to create a non existent latop");
            return ResponseEntity.badRequest().build();
        }

        Latop result = latopRepository.save(latop);
        return ResponseEntity.ok(result);
    }

    /**
     * Eliminar una latop de la base de datos
     * @param id
     * @return
     */
    @DeleteMapping("/api/latops/{id}")
    @Operation(description = "Eliminar una latop de la base de datos")
    public ResponseEntity<Latop> delete(@Parameter(description = "Clave primaria de tipo Long") @PathVariable Long id){
        if(!latopRepository.existsById(id)){
            log.warn("Trying to delete a non existent book");
            return ResponseEntity.notFound().build();
        }

        latopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    /**
     * Eliminar todas las latops
     * @return
     */
    @Hidden
    @DeleteMapping("/api/latops")
    public ResponseEntity<Latop> deleteAll(){
        log.info("REST Request for delete all books");
        latopRepository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
