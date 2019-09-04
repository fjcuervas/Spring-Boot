package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.transaction.Transactional;

@Entity
@Transactional
public class Usuario {

	//Si usamos @ManyToOne, la anotación @JoinColumn no haría falta porque spring por defecto crea una columna perfil_id
	//sin embargo si queremos darle otro nombre o alguna característica más, tendríamos que usarla
	//Aunque por algún motivo, si no la uso, me crea un campo perfil_id_perfil_id pero no se por qué así que la dejo puesta.
	@JoinColumn(name = "perfil_id", nullable = false)
	@ManyToOne(optional = false, fetch = FetchType.EAGER)
	private Perfil perfil;

	@Id
	@Column(length = 9)
	private String dni;
	
	@Column(name="nombre_usuario")
	private String nombreUsuario;
	
	private String contraseña;
	private String apellido1;
	private String apellido2;
	
	@Column(name="fecha_alta")
	private LocalDateTime fechaAlta;
	
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Perfil getPerfilId() {
		return perfil;
	}
	public void setPerfilId(Perfil perfil) {
		this.perfil = perfil;
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
		return "Usuario [perfil=" + perfil + ", dni=" + dni + ", nombreUsuario="
				+ nombreUsuario + ", contraseña=" + contraseña + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", fechaAlta=" + fechaAlta + "]";
	}


	
}
