package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Perfil;

@Repository
public interface PerfilDao extends JpaRepository<Perfil, Integer>{

	
	
}