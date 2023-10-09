package com.giulianoespejo.Practico.Persistencia.en.JPA.Repository;

import com.giulianoespejo.Practico.Persistencia.en.JPA.Entity.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RubroRepository extends JpaRepository<Rubro, Long> {
}
