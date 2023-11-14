package com.example.ejercicioMuchosaMuchos.Repository;

import com.example.ejercicioMuchosaMuchos.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
