package com.giulianoespejo.Practico.Persistencia.en.JPA.Entity;


import com.giulianoespejo.Practico.Persistencia.en.JPA.Enum.TipoProducto;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Producto extends BaseEntidad{

    @Enumerated(EnumType.STRING)
    private TipoProducto tipo;

    private int tiempoEstimadoCocina;

    private String denominacion;

    private Double precioVenta;

    private Double precioCompra;

    private int stockActual;

    private int stockMinimo;

    private String unidadMedida;

    private String foto;

    private String receta;
}
