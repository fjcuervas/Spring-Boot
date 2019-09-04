package com.example.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {
	
	@Value("${texto.indexcontroller.titulo}")
	String titulo;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return titulo;
	}
	
	@GetMapping({"/index",""})
	public String inicio() {
		return "index";
	}
}
