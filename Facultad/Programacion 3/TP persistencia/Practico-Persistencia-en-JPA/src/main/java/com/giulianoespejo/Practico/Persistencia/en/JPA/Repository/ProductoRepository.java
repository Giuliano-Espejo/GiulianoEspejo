package com.giulianoespejo.Practico.Persistencia.en.JPA.Repository;

import com.giulianoespejo.Practico.Persistencia.en.JPA.Entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
