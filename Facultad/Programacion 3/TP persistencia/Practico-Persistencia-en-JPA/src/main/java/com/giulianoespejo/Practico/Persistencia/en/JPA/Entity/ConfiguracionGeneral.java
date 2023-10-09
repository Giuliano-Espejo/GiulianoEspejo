package com.giulianoespejo.Practico.Persistencia.en.JPA.Entity;

import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConfiguracionGeneral extends BaseEntidad{

    private int cantidadCocineros;

    private String emailEmpresa;

    private String tokenMercadoPago;
}
