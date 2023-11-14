package com.example.ejerciciobidiUno.Entity;

import jakarta.persistence.*;
import lombok.*;



@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "persona")
public class Persona extends BaseEntidad{

    @Column(name = "nombre")
    private String nombre;

    private String apellido;

    private int edad;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id")
    private Domicilio domicilio;
}
