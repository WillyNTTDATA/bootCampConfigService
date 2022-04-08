package com.nttdata.bootcamp.actuator.actuactor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class ActuactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActuactorApplication.class, args);
	}

}
