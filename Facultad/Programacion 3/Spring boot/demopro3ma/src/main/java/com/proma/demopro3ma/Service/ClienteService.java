package com.proma.demopro3ma.Service;

import ch.qos.logback.core.net.server.Client;
import com.proma.demopro3ma.Models.ClienteModel;
import com.proma.demopro3ma.entites.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    public List<Cliente> findAll();
    public Optional<Cliente> findById(Long id);
    public void crear(ClienteModel cliente);
}
