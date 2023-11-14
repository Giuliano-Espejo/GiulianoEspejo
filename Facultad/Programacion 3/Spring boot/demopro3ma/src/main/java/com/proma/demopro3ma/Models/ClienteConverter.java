package com.proma.demopro3ma.Models;

import com.proma.demopro3ma.entites.Cliente;

public class ClienteConverter {

    public static Cliente toEntity(ClienteModel clienteModel){
        Cliente cliente = new Cliente();
        cliente.setNombre(clienteModel.nombre());
        cliente.setApellido(clienteModel.apellido());
        cliente.setDni(clienteModel.dni());
        cliente.setDomicilio(DomicilioConverter.toEntity(clienteModel.domicilio()));

        return cliente;
    }
}
