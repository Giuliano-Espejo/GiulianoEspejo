package com.example.ejerciciounoaMuchosbiri.Repository;

import com.example.ejerciciounoaMuchosbiri.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
