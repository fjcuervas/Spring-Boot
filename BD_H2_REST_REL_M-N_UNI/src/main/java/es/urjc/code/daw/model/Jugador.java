package es.urjc.code.daw.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Jugador {

	public interface AtributoBasico {}
	public interface AtributoEquipo {}

	@JsonView(AtributoBasico.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@JsonView(AtributoBasico.class)
	private String nombre;
	
	@JsonView(AtributoBasico.class)
	private int goles;

	@JsonView(AtributoEquipo.class)
	@ManyToMany
	private List<Equipo> equipos = new ArrayList<>();
	
	protected Jugador() {
	}

	public List<Equipo> getEquipos() {
		return equipos;
	}

	public void setEquipos(List<Equipo> equipos) {
		this.equipos = equipos;
	}


	public Jugador(String name, int goals) {
		super();
		this.nombre = name;
		this.goles = goals;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	@Override
	public String toString() {
		return "Jugador [id=" + id + ", name=" + nombre + ", goles=" + goles + "]";
	}

}
