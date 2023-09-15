package com.giulianoespejo.Practico.Persistencia.en.JPA.Repository;

import com.giulianoespejo.Practico.Persistencia.en.JPA.Entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
