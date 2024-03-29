package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiConsoleDemoApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(ApiConsoleDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ApiConsoleDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOG.info("Probando Spring Boot de tipo consola");
	}

}
