package com.giulianoespejo.Practico.Persistencia.en.JPA;

import com.giulianoespejo.Practico.Persistencia.en.JPA.Entity.*;
import com.giulianoespejo.Practico.Persistencia.en.JPA.Enum.Estado;
import com.giulianoespejo.Practico.Persistencia.en.JPA.Enum.FormaPago;
import com.giulianoespejo.Practico.Persistencia.en.JPA.Enum.TipoEnvio;
import com.giulianoespejo.Practico.Persistencia.en.JPA.Enum.TipoProducto;
import com.giulianoespejo.Practico.Persistencia.en.JPA.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticoPersistenciaEnJpaApplication {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroRepository rubroRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {
		SpringApplication.run(PracticoPersistenciaEnJpaApplication.class, args);
		System.out.println("Estoy funcionando en el diagrama de clases UML");
	}

	@Bean
	CommandLineRunner init(DomicilioRepository domicilioRepo){
		return args -> {
			Rubro rubro1 = Rubro.builder()
					.denominacion("Consumible")
					.build();

			Producto producto1 = Producto.builder()
					.denominacion("Consumible")
					.foto("nafta.png")
					.tipo(TipoProducto.INSUMO)
					.precioCompra(100.0)
					.precioVenta(150.0)
					.receta(".")
					.stockActual(40)
					.stockMinimo(5)
					.tiempoEstimadoCocina(0)
					.unidadMedida("litros")
					.build();
			rubro1.addProductos(producto1);
			rubroRepository.save(rubro1);


			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.producto(producto1)
					.subtotal(150.0)
					.build();

			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(2)
					.producto(producto1)
					.subtotal(300.0)
					.build();

			Pedido pedido1 = Pedido.builder()
					.fecha("05/09/2023")
					.total(150.0)
					.estado(Estado.PREPARACION)
					.horaEstimadaEntrega("10:54")
					.tipoEnvio(TipoEnvio.RETIRA)
					.build();
			pedido1.addDetallePedido(detallePedido1);

			Pedido pedido2 = Pedido.builder()
					.fecha("10/09/2023")
					.total(300.0)
					.estado(Estado.PREPARACION)
					.horaEstimadaEntrega("20:30")
					.tipoEnvio(TipoEnvio.RETIRA)
					.build();
			pedido2.addDetallePedido(detallePedido2);

			Factura factura = Factura.builder()
					.numero(1)
					.formaPago(FormaPago.EFECTIVO)
					.descuento(0.0)
					.total(150)
					.fecha("05/09/2023")
					.build();
			pedido1.setFactura(factura);
			pedidoRepository.save(pedido1);

			Factura factura1 = Factura.builder()
					.numero(2)
					.formaPago(FormaPago.EFECTIVO)
					.descuento(0.0)
					.total(300)
					.fecha("10/09/2023")
					.build();
			pedido2.setFactura(factura1);
			pedidoRepository.save(pedido2);

			Cliente cliente = Cliente.builder()
					.nombre("Giuliano")
					.apellido("Espejo")
					.email("giulianoespejo@gmail.com")
					.telefono("1234567897")
					.build();
			cliente.addPedido(pedido1);
			cliente.addPedido(pedido2);
			clienteRepository.save(cliente);

			Domicilio domicilio = Domicilio.builder()
					.calle("Suipacha")
					.numero("123")
					.localidad("MDZ")
					.cliente(cliente)
					.build();
			domicilio.addPedido(pedido1);
			domicilioRepository.save(domicilio);

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Paso los Andes")
					.numero("123")
					.localidad("MDZ")
					.cliente(cliente)
					.build();
			domicilio1.addPedido(pedido2);
			domicilioRepository.save(domicilio1);

			Usuario usuario = Usuario.builder()
					.nombre("GIULIANO-USER")
					.password("123456")
					.rol("CLIENT-ROLE")
					.build();
			usuario.addPedido(pedido1);
			usuario.addPedido(pedido2);
			usuarioRepository.save(usuario);

			// Mostrando
			System.out.println();
			System.out.println("DOMICILIO 1 \n");
			Domicilio domicilioDB = domicilioRepository.findById(domicilio.getId()).orElse(null);
			if(domicilioDB != null){
				System.out.println("DOMICILIO:");
				System.out.println("\t Calle: " + domicilioDB.getCalle());
				System.out.println("\t Numero: " + domicilioDB.getNumero());
				System.out.println("\t Localidad: " + domicilioDB.getLocalidad());
				domicilioDB.mostrarPedidos();
				domicilioDB.mostrarCliente();
			}

			System.out.println();
			System.out.println("DOMICILIO 2 \n");
			Domicilio domicilioDB1 = domicilioRepository.findById(domicilio1.getId()).orElse(null);
			if(domicilioDB != null){
				System.out.println("DOMICILIO:");
				System.out.println("\t Calle: " + domicilioDB1.getCalle());
				System.out.println("\t Numero: " + domicilioDB1.getNumero());
				System.out.println("\t Localidad: " + domicilioDB1.getLocalidad());
				domicilioDB1.mostrarPedidos();
				domicilioDB1.mostrarCliente();
			}

			System.out.println();
			System.out.println("RUBRO 1 \n");
			Rubro rubroDB = rubroRepository.findById(rubro1.getId()).orElse(null);
			if(rubroDB != null){
				rubroDB.mostrarProductos();
			}

			System.out.println();
			System.out.println("USUARIO 1 \n");
			Usuario userDB = usuarioRepository.findById(usuario.getId()).orElse(null);
			if(userDB != null){
				userDB.mostrarUser();
			}
			System.out.println();
			System.out.println("PEDIDO 1 \n");
			Pedido pedidoDB = pedidoRepository.findById(pedido1.getId()).orElse(null);
			if (pedidoDB != null){
				pedidoDB.mostrarPedido();
			}

			System.out.println();
			System.out.println("PEDIDO 2 \n");
			Pedido pedidoDB2 = pedidoRepository.findById(pedido2.getId()).orElse(null);
			if(pedidoDB2 != null){
				pedidoDB2.mostrarPedido();
			}

			System.out.println();
			System.out.println("CLIENTE 1 \n");
			Cliente clienteDB = clienteRepository.findById(cliente.getId()).orElse(null);
			if(clienteDB != null){
				clienteDB.mostrarCliente();
			}
		};
	}
}
