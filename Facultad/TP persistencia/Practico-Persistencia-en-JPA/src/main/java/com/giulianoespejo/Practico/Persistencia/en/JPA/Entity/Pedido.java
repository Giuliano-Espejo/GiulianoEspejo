package com.giulianoespejo.Practico.Persistencia.en.JPA.Entity;

import com.giulianoespejo.Practico.Persistencia.en.JPA.Enum.Estado;
import com.giulianoespejo.Practico.Persistencia.en.JPA.Enum.TipoEnvio;
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
public class Pedido extends BaseEntidad{

    private String fecha;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    private String horaEstimadaEntrega;

    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    private Double total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    public void addDetallePedido(DetallePedido detallePedido){
        detallePedidos.add(detallePedido);
    }

    public void mostarDetalles(){
        System.out.println("Detalles del pedido");
        System.out.println("---------------------------");
        for (DetallePedido d: detallePedidos) {
            System.out.println("\t Foto producto: " +d.getProducto().getFoto());
            System.out.println("\t Cantidad: " + d.getCantidad());
            System.out.println("\t Subtotal: " + d.getSubtotal());
            System.out.println("---------------------------");
        }
    }

    public void mostarFactura(){
        System.out.println("Factura: ");
        System.out.println("---------------------------");
        System.out.println("\t Fecha: " + factura.getFecha());
        System.out.println("\t Descuento: " + factura.getDescuento());
        System.out.println("\t Total: " + factura.getTotal());
        System.out.println("\t Numero: " + factura.getNumero());
        System.out.println("\t Forma de pago: " + factura.getFormaPago().toString().toLowerCase());
        System.out.println("---------------------------");
    }

    public void mostrarPedido(){
        System.out.println("Fecha: " + fecha);
        System.out.println("Estado " + estado.toString().toLowerCase());
        System.out.println("Hora estimada de entrega " + horaEstimadaEntrega);
        System.out.println("Tipo de envio " + tipoEnvio.toString().toLowerCase());
        System.out.println("Total: " + total);
        mostarFactura();
        mostarDetalles();
    }

}
