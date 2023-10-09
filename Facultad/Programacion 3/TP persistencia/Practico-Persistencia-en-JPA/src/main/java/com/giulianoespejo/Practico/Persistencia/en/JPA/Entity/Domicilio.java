package com.giulianoespejo.Practico.Persistencia.en.JPA.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = true)
public class Domicilio extends BaseEntidad {

    private String calle;

    private String numero;

    private String localidad;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "domicilio_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void addPedido(Pedido pedido){
        pedidos.add(pedido);
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

    public void mostrarCliente(){
        System.out.println("Cliente: ");
        System.out.println("---------------------------");
        System.out.println("\t Nombre: " + cliente.getNombre());
        System.out.println("\t Apellido: " + cliente.getApellido());
        System.out.println("\t Email: " + cliente.getEmail());
        System.out.println("\t Telefono: " + cliente.getTelefono());
        System.out.println("---------------------------");
    }
}
