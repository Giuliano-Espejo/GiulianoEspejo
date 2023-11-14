package com.example.ejerciciounoaMuchosbiri.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends BaseEntidad {

    private String calle;

    private int numero;

    @ManyToOne()
    @JoinColumn(name = "persona_id")
    private Persona persona;

}