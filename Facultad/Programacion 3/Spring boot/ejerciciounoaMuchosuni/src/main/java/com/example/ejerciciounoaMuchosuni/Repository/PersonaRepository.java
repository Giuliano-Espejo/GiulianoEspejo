package com.example.ejerciciounoaMuchosuni.Repository;

import com.example.ejerciciounoaMuchosuni.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
