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
public class Usuario extends BaseEntidad{

    private String nombre;

    private String password;

    private String rol;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "usuario_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public void mostrarPedido(){
        System.out.println("Pedidos del usuario: ");
        System.out.println("---------------------------");
        for (Pedido p : pedidos){
            System.out.println("\t Fecha: " + p.getFecha());
            System.out.println("\t Estado: "+ p.getEstado().toString().toLowerCase());
            System.out.println("\t Total: " + p.getTotal());
            System.out.println("\t Hora estima de entrega: " + p.getHoraEstimadaEntrega());
            System.out.println("\t Tipo de envio: " + p.getTipoEnvio().toString().toLowerCase());
            System.out.println("---------------------------");
        }
    }

    public void mostrarUser(){
        System.out.println("---------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Password: " + password);
        System.out.println("Rol: " + rol);
        System.out.println("---------------------------");
        mostrarPedido();
    }
}
