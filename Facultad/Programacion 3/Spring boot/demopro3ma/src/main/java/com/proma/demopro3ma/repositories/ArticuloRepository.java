package com.proma.demopro3ma.repositories;

import com.proma.demopro3ma.entites.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
    public Optional<Articulo> findById(Long id);
}
