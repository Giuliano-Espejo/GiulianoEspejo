package com.example.ejerciciounoaMuchosuni.Entity;

import jakarta.persistence.Entity;
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

}