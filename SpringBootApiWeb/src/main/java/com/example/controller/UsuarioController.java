package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Usuario;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	@RequestMapping("/listar")
	public String listar(Model model) {
		
		List<Usuario> usuarios = new ArrayList<>();
		Usuario usuario = new Usuario();
		usuario.setNombreUsuario("Javi");
		usuario.setApellido1("Cuervas");
		usuario.setDni("53270546q");
		usuario.setFechaAlta(LocalDateTime.now());
		usuario.setPerfilId(1);
		usuario.setUsuarioId(1);
		
		usuarios.add(usuario);
		
		usuario = new Usuario();
		usuario.setNombreUsuario("Julio");
		usuario.setApellido1("Moo");
		usuario.setDni("28874568q");
		usuario.setFechaAlta(LocalDateTime.now());
		usuario.setPerfilId(1);
		usuario.setUsuarioId(2);
		
		usuarios.add(usuario);
		
		model.addAttribute("usuarios",usuarios);
		return "usuarios";
	}
	
}
