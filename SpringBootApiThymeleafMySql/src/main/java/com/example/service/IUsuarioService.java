package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Usuario;

@Service
public interface IUsuarioService {
	
	public List<Usuario> findAll();

}
