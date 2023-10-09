package com.giulianoespejo.Practico.Persistencia.en.JPA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Cliente extends BaseEntidad{

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
    }

    public void mostrarCliente(){
        System.out.println("Nombre: " + nombre);
        System.out.println("Apeliido: " + apellido);
        System.out.println("Telefono: " + telefono);
        System.out.println("Email " + email);
        mostrarPedidos();
    }

    public void mostrarPedidos(){
        System.out.println("---------------------------");
        System.out.println("Pedidos: ");
        System.out.println("---------------------------");
        for (Pedido p : pedidos) {
            System.out.println("\t Fecha: " + p.getFecha());
            System.out.println("\t Estado: "+ p.getEstado().toString().toLowerCase());
            System.out.println("\t Total: " + p.getTotal());
            System.out.println("\t Hora estima de entrega: " + p.getHoraEstimadaEntrega());
            System.out.println("\t Tipo de envio: " + p.getTipoEnvio().toString().toLowerCase());
            System.out.println("---------------------------");
        }
    }
}
