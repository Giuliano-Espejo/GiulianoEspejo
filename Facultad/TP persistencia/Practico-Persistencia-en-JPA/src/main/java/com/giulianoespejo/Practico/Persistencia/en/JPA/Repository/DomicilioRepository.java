package com.giulianoespejo.Practico.Persistencia.en.JPA.Repository;

import com.giulianoespejo.Practico.Persistencia.en.JPA.Entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
