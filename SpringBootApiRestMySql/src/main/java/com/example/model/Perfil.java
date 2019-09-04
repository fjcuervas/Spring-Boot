package com.example.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Perfil implements Serializable  {
    
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name="perfil_id")
	private Integer perfilId;
    
    public Perfil() {
	}

	@Column(name="tipo_perfil", length=50)
    private String tipoPerfil;
	/*
	@JoinColumn(name = "usuario_id", nullable = false) 
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//@JsonManagedReference
	private Usuario  usuarioId;
	
/*
	@OneToMany(mappedBy = "usuarioId")	
	@JsonBackReference
	private List<Usuario> usuarios;
	
/*
	@OneToOne(mappedBy = "perfil_id")
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
*/
	public Integer getPerfilId() {
		return perfilId;
	}

	public void setPerfilId(Integer perfilId) {
		this.perfilId = perfilId;
	}

	public String getTipoPerfil() {
		return tipoPerfil;
	}

	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
    
}
