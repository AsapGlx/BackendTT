package com.escom.health;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.escom.health")
public class HealthApplication {

	public static void main(String[] args) {

		SpringApplication.run(HealthApplication.class, args);
	}

}
