package com.example.ejerciciobidiUno.Repository;

import com.example.ejerciciobidiUno.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona , Long> {
}
