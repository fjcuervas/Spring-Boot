package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Perfil;
import com.example.model.Usuario;

@Service
public interface IPerfilService {
	
	public List<Perfil> findAll();
	
	public Perfil findById(Integer id);
}
