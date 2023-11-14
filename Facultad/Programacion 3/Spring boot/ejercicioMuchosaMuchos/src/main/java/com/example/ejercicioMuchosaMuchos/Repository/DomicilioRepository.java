package com.example.ejercicioMuchosaMuchos.Repository;

import com.example.ejercicioMuchosaMuchos.Entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
