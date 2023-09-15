package com.giulianoespejo.Practico.Persistencia.en.JPA.Entity;

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
public class Rubro extends BaseEntidad{

    private String denominacion;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @JoinColumn(name = "rubro_id")
    private List<Producto> productos = new ArrayList<>();

    public void addProductos(Producto producto){
        productos.add(producto);
    }

    public void mostrarProductos(){
        System.out.println("Denominacion del Rubro: " + denominacion);
        System.out.println("Productos:");
        System.out.println("---------------------------");
        for (Producto p: productos){
            System.out.println("\t Denominacion: " + p.getDenominacion());
            System.out.println("\t Foto: " + p.getFoto());
            System.out.println("\t Receta: " + p.getReceta());
            System.out.println("\t Unidad de medida: " + p.getUnidadMedida());
            System.out.println("\t Precio compra: " + p.getPrecioCompra());
            System.out.println("\t Precio venta: " + p.getPrecioVenta());
            System.out.println("\t Stock actual: " + p.getStockActual());
            System.out.println("\t Stock minimo: " + p.getStockMinimo());
            System.out.println("\t Tipo: " + p.getTipo().toString().toLowerCase());
            System.out.println("\t Tiempo en cocina: " + p.getTiempoEstimadoCocina());
            System.out.println("---------------------------");
        }
    }
}
