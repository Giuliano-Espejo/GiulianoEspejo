package com.example.ejercicioMuchosaMuchos.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Domicilio extends BaseEntidad {

    private String calle;

    private int numero;

    @ManyToMany(mappedBy = "domicilios")
// OJO NO OLVIDARSE DE ESTO PORQUE NO LE GUSTA A LOMBOCK
    @Builder.Default
    private Set<Persona> personas = new HashSet<>();

}