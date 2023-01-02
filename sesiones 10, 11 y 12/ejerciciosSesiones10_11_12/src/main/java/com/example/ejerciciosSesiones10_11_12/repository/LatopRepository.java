package com.example.ejerciciosSesiones10_11_12.repository;

import com.example.ejerciciosSesiones10_11_12.entities.Latop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatopRepository extends JpaRepository<Latop, Long> {
}
