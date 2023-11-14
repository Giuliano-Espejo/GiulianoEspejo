package com.example.ejercicioMuchosaMuchos;

import com.example.ejercicioMuchosaMuchos.Entity.Domicilio;
import com.example.ejercicioMuchosaMuchos.Entity.Persona;
import com.example.ejercicioMuchosaMuchos.Repository.DomicilioRepository;
import com.example.ejercicioMuchosaMuchos.Repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EjercicioMuchosaMuchosApplication {
	@Autowired
	PersonaRepository personaRepository;

	public static void main(String[] args) {
		SpringApplication.run(EjercicioMuchosaMuchosApplication.class, args);
	}

	@Bean
	CommandLineRunner init(PersonaRepository personaRepo) {
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

			// Crear instancias de Domicilio
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Calle 1")
					.numero(123)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Calle 2")
					.numero(456)
					.build();

			// Crear instancias de Persona y agregar domicilios
			Persona persona1 = Persona.builder()
					.nombre("Juan")
					.apellido("Pérez")
					.edad(30)
					.build();


			// Agregar domicilios a las personas
			persona1.agregarDomicilio(domicilio1);
			persona1.agregarDomicilio(domicilio2);
			// Asignar las personas a los domicilios
			domicilio1.getPersonas().add(persona1);
			domicilio2.getPersonas().add(persona1);
			// Guardar las personas y los domicilios en la base de datos
			personaRepository.save(persona1);

		};
	}
}
