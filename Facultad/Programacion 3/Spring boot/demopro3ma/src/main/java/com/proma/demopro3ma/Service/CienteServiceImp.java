package com.proma.demopro3ma.Service;

import com.proma.demopro3ma.Models.ClienteConverter;
import com.proma.demopro3ma.Models.ClienteModel;
import com.proma.demopro3ma.Models.DomicilioConverter;
import com.proma.demopro3ma.entites.Cliente;
import com.proma.demopro3ma.entites.Domicilio;
import com.proma.demopro3ma.repositories.ClienteRepository;
import com.proma.demopro3ma.repositories.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CienteServiceImp implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private DomicilioRepository domicilioRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> findById(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public void crear(ClienteModel cliente) {
        Domicilio domicilio = DomicilioConverter.toEntity(cliente.domicilio());
        domicilioRepository.save(domicilio);
        Cliente cliente1 = ClienteConverter.toEntity(cliente);
        clienteRepository.save(cliente1);
    }
}
