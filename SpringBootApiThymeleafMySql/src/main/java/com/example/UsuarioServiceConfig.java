package com.example;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.service.IUsuarioService;
import com.example.service.UsuarioService;
import com.example.service.UsuarioServiceTest;

//esta clase es otra forma declarar un Bean. A parte de poder definirlo en un XML o mediante anotaciones en las propias
//clases, se pueden definir en un fichero Java con la anotación @Configuration y @Bean para los objetos que queramos
@Configuration
public class UsuarioServiceConfig {

	//En el caso de existir más de un Bean con una misma implementación, se puede indicar en la misma anotación @Bean
	//el nombre que hace referencia en la anotación @Component de la clase
	@Bean("usuarioService")
	public IUsuarioService registrarUsuarioService() {
		return new UsuarioService();
	}
	
	//También podríamos utilizar la anotación @Primary para que Spring solo tenga en cuenta dicho Bean
	@Bean("usuarioServiceTest")
	public IUsuarioService registrarUsuarioServiceTest() {
		return new UsuarioServiceTest();
	}
}
