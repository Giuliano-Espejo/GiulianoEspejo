package com.proma.demopro3ma.Models;

import com.proma.demopro3ma.entites.Domicilio;

public class DomicilioConverter {
    public static Domicilio toEntity(DomicilioModel domicilioModel){
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle(domicilioModel.calle());
        domicilio.setNumero(domicilioModel.numero());

        return domicilio;
    }
}
