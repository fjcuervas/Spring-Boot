package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dao.PerfilDao;
import com.example.model.Perfil;

@Component
public class PerfilService implements IPerfilService {
	
	@Autowired
	private PerfilDao perfilDao;
	
	public List<Perfil> findAll(){
		return perfilDao.findAll();
	}
	
	public Perfil findById(Integer id) {
		return perfilDao.findById(id).orElse(null);
	}

}
