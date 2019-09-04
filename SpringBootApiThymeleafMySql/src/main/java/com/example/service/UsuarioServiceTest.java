package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.dao.UsuarioDao;
import com.example.model.Usuario;

//@Component("usuarioServiceTest")
public class UsuarioServiceTest implements IUsuarioService{
	
	@Autowired
	private UsuarioDao usuarioDao;

	@Override
	public List<Usuario> findAll() {
		return usuarioDao.findAll();
	}
	
	

}
