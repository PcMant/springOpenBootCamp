package com.example.ejerciciosSesiones4_5_6.repository;

import com.example.ejerciciosSesiones4_5_6.entities.Latop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LatopRepository extends JpaRepository<Latop, Long> {
}
