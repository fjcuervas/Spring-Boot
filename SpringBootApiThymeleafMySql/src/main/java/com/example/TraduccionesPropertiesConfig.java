package com.example;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@Configuration
@PropertySources({
	@PropertySource("classpath:traducciones.properties")
})
public class TraduccionesPropertiesConfig {

	
}
