package com.example.ejerciciounoaMuchosuni.Repository;

import com.example.ejerciciounoaMuchosuni.Entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
