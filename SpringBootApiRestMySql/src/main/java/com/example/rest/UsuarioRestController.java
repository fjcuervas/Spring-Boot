package com.example.rest;

import java.util.List;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.UsuarioDao;
import com.example.model.Usuario;

@RestController
@RequestMapping("/rest/usuario")
public class UsuarioRestController {
	
	private static final Logger LOG = Logger.getLogger(UsuarioRestController.class);

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/listar")
	public List<Usuario> listar() {
		return usuarioDao.findAll();
	}

	@PostMapping("/insertar")
	public void insertar(@RequestBody Usuario usuario) {
		LOG.info("USUARIO: " + usuario.toString());
		// usuario.setContraseña(bCryptPasswordEncoder.encode(usuario.getContraseña()));
		try {
			usuario.setContraseña(bCryptPasswordEncoder.encode(usuario.getContraseña()));
			usuarioDao.save(usuario);
		} catch (JpaObjectRetrievalFailureException e) {
			LOG.warn("Perfil no encontrado!!" + e.toString());
		}
	}
	
	@DeleteMapping("/eliminar")
	public void eliminar(@RequestBody Usuario usuario) {
		LOG.info("USUARIO: " + usuario.toString());
		try {
			usuarioDao.delete(usuario);
		} catch (Exception e) {
			LOG.warn("Perfil no encontrado!!" + e.toString());
		}
	}
	
	@PutMapping("/actualizar")
	public void actualizar(@RequestBody Usuario usuario) {
		LOG.info("USUARIO: " + usuario.toString());
		try {
			usuarioDao.save(usuario);
		} catch (Exception e) {
			LOG.warn("Perfil no encontrado!!" + e.toString());
		}
	}
}
