package com.example.ejerciciounoaMuchosbiri;

import com.example.ejerciciounoaMuchosbiri.Entity.Domicilio;
import com.example.ejerciciounoaMuchosbiri.Entity.Persona;
import com.example.ejerciciounoaMuchosbiri.Repository.DomicilioRepository;
import com.example.ejerciciounoaMuchosbiri.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class EjerciciounoaMuchosbiriApplication {

	@Autowired
	PersonaRepository personaRepository;

	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {
		SpringApplication.run(EjerciciounoaMuchosbiriApplication.class, args);
		System.out.println("Estoy funcionando con One to Many bidirecciona");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo, DomicilioRepository domicilioRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

/*El método builder() se genera automáticamente por Lombok
y te permite crear una instancia de Persona.Builder.
Luego, puedes encadenar llamadas a los métodos
setters generados automáticamente para establecer los
valores de los atributos de la clase.
Finalmente, build() crea la instancia
 de la clase Persona con los valores proporcionados.
 */
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 1")
					.numero(123)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Calle 2")
					.numero(456)
					.build();

			// Crear instancia de Persona y agregar domicilios
			Persona persona = Persona.builder()
					.nombre("Juan")
					.apellido("Pérez")
					.edad(30)
					.build();

			persona.agregarDomicilio(domicilio1);
			persona.agregarDomicilio(domicilio2);

			// Asignar la persona a los domicilios
			domicilio1.setPersona(persona);
			domicilio2.setPersona(persona);

			// Guardar el objeto Persona en la base de datos
			personaRepository.save(persona);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
				System.out.println("----------------------------------------");
				personaRecuperada.mostrarDomicilios();
				System.out.println(" ------ finalicé desde persona");
			}

			System.out.println("......  Muestro la bidireccionalidad.......");
			// Recuperar los domicilios de la base de datos
			List<Domicilio> domiciliosRecuperados = domicilioRepository.findAll();

			if (domiciliosRecuperados!= null) {
				// Iterar a través de los domicilios y mostrar información
				System.out.println("Información de los Domicilios:");
				for (Domicilio domicilio : domiciliosRecuperados) {
					System.out.println("Domicilio en " + domicilio.getCalle() + " " + domicilio.getNumero());
					System.out.println("Perteneciente a " + domicilio.getPersona().getNombre() + " " + domicilio.getPersona().getApellido());
				}
			}
		};
	}
}
