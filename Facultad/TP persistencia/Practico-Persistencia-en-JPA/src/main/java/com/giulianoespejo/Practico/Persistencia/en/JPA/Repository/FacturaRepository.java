package com.giulianoespejo.Practico.Persistencia.en.JPA.Repository;

import com.giulianoespejo.Practico.Persistencia.en.JPA.Entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
