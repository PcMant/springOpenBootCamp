package com.example.ejerciciosSesiones7_8_9.repository;

import com.example.ejerciciosSesiones7_8_9.entities.Latop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatopRepository extends JpaRepository<Latop, Long> {
}
