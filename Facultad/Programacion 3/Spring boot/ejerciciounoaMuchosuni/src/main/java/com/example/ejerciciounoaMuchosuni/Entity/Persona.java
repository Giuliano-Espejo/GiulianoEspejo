package com.example.ejerciciounoaMuchosuni.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Persona extends BaseEntidad{
    private String nombre;

    private String apellido;

    private int edad;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "persona_id")
    private List<Domicilio> domicilioList = new ArrayList<>();

    public void agregarDomicilio(Domicilio domicilio){
        domicilioList.add(domicilio);
    }
    public void mostrarDomiclilios(){
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");
        for (Domicilio domicilio : domicilioList) {
            System.out.println("Calle: " + domicilio.getCalle() + ", Número: " + domicilio.getNumero());
        }
    }
}
