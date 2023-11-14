package com.proma.demopro3ma.Models;

public record ClienteModel(String nombre,
                           String apellido,
                           int dni,
                           DomicilioModel domicilio) {
}
