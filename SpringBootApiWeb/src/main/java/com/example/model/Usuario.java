package com.example.model;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Usuario {

	private Integer usuarioId;
	private Integer perfilId;
	private String dni;
	private String nombreUsuario;
	private String contraseña;
	private String apellido1;
	private String apellido2;
	private LocalDateTime fechaAlta;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public Integer getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(Integer usuarioId) {
		this.usuarioId = usuarioId;
	}
	public Integer getPerfilId() {
		return perfilId;
	}
	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public LocalDateTime getFechaAlta() {
		return fechaAlta;
	}
	public void setFechaAlta(LocalDateTime fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	@Override
	public String toString() {
		return "Usuario [usuarioId=" + usuarioId + ", perfilId=" + perfilId + ", dni=" + dni + ", nombreUsuario="
				+ nombreUsuario + ", contraseña=" + contraseña + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fechaAlta=" + fechaAlta + "]";
	}

	
}
