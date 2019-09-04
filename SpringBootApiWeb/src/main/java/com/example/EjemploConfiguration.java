package com.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.example")
@PropertySource("classpath:infoPersona.properties")
public class EjemploConfiguration {

	@Value("${nombre}")
	private String nombre;
	
}
