package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String inicio() {
		//Con redirect podemos redireccionar a una URL externa, cosa que no podemos hacer con forward
		//return "redirect:/index";
		//Con forward se mantienen los parámetros del request porque se realiza la redirección de forma asíncrona sin reiniciar la página
		//Lo que hace internamente es un RequestDispatcher.forward()
		return "forward:/index"; 
	}
}
