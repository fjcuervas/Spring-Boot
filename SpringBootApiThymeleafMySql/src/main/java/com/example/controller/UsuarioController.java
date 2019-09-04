package com.example.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Usuario;
import com.example.service.IUsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	private static final Logger LOG = Logger.getLogger(UsuarioController.class);

	//Si no usamos un fichero de configuración para definir el Bean y hay más de una clase que implementa la interfaz,
	//tendremos que hacer uso de la anotación @Qualifier para referirnos al nombre del Bean que pusimos en @Component
	//o bien ponerle @Primary al que nos interese
	@Autowired
	IUsuarioService usuarioService;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "Welcome to Spring Boot with Thymeleaf";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Usuario> usuarios = usuarioService.findAll();
		model.addAttribute("usuarios",usuarios);
		return "listadoUsuarios";
	}
}
