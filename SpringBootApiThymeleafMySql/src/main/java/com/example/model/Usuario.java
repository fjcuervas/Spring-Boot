package com.example.model;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.transaction.Transactional;

import org.hibernate.validator.constraints.UniqueElements;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Transactional
public class Usuario {

	/*
	 * @Column(name="usuario_id")
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private Integer
	 * usuarioId;
	 */

	// Si usamos @ManyToOne, la anotación @JoinColumn no haría falta porque spring
	// por defecto crea una columna perfil_id
	// sin embargo si queremos darle otro nombre o alguna característica más,
	// tendríamos que usarla
	// Aunque por algún motivo, si no la uso, me crea un campo perfil_id_perfil_id
	// pero no se por qué así que la dejo puesta.
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "perfil_id", nullable = false)
	private Perfil perfil;
	/*
	 * @OneToOne(mappedBy = "usuario_id") private Perfil perfil;
	 */
	@Id
	@Column(length = 9)
	private String dni;

	@Column(name = "nombre_usuario")
	private String nombreUsuario;

	private String password;
	private String apellido1;
	private String apellido2;

	@Column(name = "fecha_alta")
	private LocalDateTime fechaAlta;

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		return "Usuario [perfil=" + perfil + ", dni=" + dni + ", nombreUsuario=" + nombreUsuario + ", contraseña="
				+ password + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", fechaAlta=" + fechaAlta + "]";
	}

}
