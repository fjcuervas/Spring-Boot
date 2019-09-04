package com.example.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Usuario;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioRestController {

	@GetMapping("/listar")
	public List<Usuario> listar(){
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
		return usuarios;
	}
}
