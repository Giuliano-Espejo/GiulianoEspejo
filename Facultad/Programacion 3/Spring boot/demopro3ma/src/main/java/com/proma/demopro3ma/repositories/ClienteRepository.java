package com.proma.demopro3ma.repositories;

import com.proma.demopro3ma.entites.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    List<Cliente> findAll();
    Optional<Cliente> findById(Long id);
}
