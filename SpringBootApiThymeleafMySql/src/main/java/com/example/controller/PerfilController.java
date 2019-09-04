package com.example.controller;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.Perfil;
import com.example.service.IPerfilService;

@Controller
@RequestMapping("/perfiles")
public class PerfilController {

	private static final Logger LOG = Logger.getLogger(PerfilController.class);

	@Autowired
	IPerfilService perfilService;
	
	@ModelAttribute("titulo")
	public String titulo() {
		return "Perfiles";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Perfil> perfiles = perfilService.findAll();
		model.addAttribute("perfiles",perfiles);
		return "listadoPerfiles";
	}
	
	@GetMapping("/buscar/{id}")
	public String buscarPorVariable(@PathVariable(name = "id") Integer id, Model model) {
		Perfil perfil = perfilService.findById(id);
		model.addAttribute("perfil",perfil);
		return "formularioPerfil";
	}
	
	@GetMapping("/buscar")
	public String buscarPorParametro(@RequestParam(name = "id",defaultValue = "0") Integer id, Model model) {
		Perfil perfil = perfilService.findById(id);
		model.addAttribute("perfil",perfil);
		return "formularioPerfil";
	}
}
