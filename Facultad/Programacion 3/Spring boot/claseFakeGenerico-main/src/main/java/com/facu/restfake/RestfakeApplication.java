package com.facu.restfake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestfakeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfakeApplication.class, args);
		System.out.println("Corriendo mi Fake Api");
	}

}
