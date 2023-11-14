package com.example.ejerciciobidiUno.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "domicilio")
public class Domicilio extends BaseEntidad{

    private String calle;

    private int numero;

    @OneToOne(mappedBy = "domicilio")
    private Persona persona;
}
