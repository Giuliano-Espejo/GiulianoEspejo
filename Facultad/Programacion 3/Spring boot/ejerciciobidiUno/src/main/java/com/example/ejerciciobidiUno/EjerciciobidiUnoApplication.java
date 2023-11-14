package com.example.ejerciciobidiUno;

import com.example.ejerciciobidiUno.Entity.Domicilio;
import com.example.ejerciciobidiUno.Entity.Persona;
import com.example.ejerciciobidiUno.Repository.DomicilioRepository;
import com.example.ejerciciobidiUno.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjerciciobidiUnoApplication {
	@Autowired
	PersonaRepository personaRepository;
	@Autowired
	DomicilioRepository domicilioRepository;

	public static void main(String[] args) {
		SpringApplication.run(EjerciciobidiUnoApplication.class, args);
		System.out.println("Estoy funcionando con bidireccionalidad");
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo,DomicilioRepository domicilioRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			/*El método builder() se genera automáticamente por Lombok
y te permite crear una instancia de Persona.Builder.
Luego, puedes encadenar llamadas a los métodos
setters generados automáticamente para establecer los
valores de los atributos de la clase.
Finalmente, build() crea la instancia
 de la clase Persona con los valores proporcionados. */

			Domicilio domicilio = Domicilio.builder()
					.calle("Suipacha")
					.numero(30)
					.build();

			Persona persona = Persona.builder()
					.nombre("Juan")
					.apellido("Perez")
					.edad(30)
					.build();

			// Asocio el domicilio
			persona.setDomicilio(domicilio);

			// Asocio la persona
			domicilio.setPersona(persona);

			// Guardar el objeto Persona en la base de datos
			personaRepository.save(persona);

			// Recuperar el objeto Persona desde la base de datos
			Persona personaRecuperada = personaRepository.findById(persona.getId()).orElse(null);
			if (personaRecuperada != null) {
				System.out.println("Nombre: " + personaRecuperada.getNombre());
				System.out.println("Apellido: " + personaRecuperada.getApellido());
				System.out.println("Edad: " + personaRecuperada.getEdad());
				System.out.println("Calle : " + personaRecuperada.getDomicilio().getCalle());
				System.out.println("Número :" + personaRecuperada.getDomicilio().getNumero());
			}

			System.out.println("......  Muestro la bidireccionalidad.......");
			// Recuperar el objeto Persona desde la base de datos
			Domicilio domicilioRecuperado = domicilioRepository.findById(persona.getId()).orElse(null);
			if (domicilioRecuperado!= null) {
				System.out.println("Nombre: " + domicilioRecuperado.getPersona().getNombre());
				System.out.println("Apellido: " + domicilioRecuperado.getPersona().getApellido());
				System.out.println("Edad: " + domicilioRecuperado.getPersona().getEdad());
				System.out.println("Calle : " + domicilioRecuperado.getCalle());
				System.out.println("Número :" + domicilioRecuperado.getNumero());
			}
		};
	}
}
