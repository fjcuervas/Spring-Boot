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
public class Equipo {
	
	public interface AtributoBasico {}
	public interface AtributoJugador {}
	
	@JsonView(AtributoBasico.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@JsonView(AtributoBasico.class)
	private String nombre;
	
	@JsonView(AtributoBasico.class)
	private int clasificacion;

	@JsonView(AtributoJugador.class)
	@ManyToMany(mappedBy="equipos")
	private List<Jugador> jugadores = new ArrayList<>();

	protected Equipo() {
	}

	public Equipo(String name, int ranking) {
		this.nombre = name;
		this.clasificacion = ranking;
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

	public int getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(int clasificacion) {
		this.clasificacion = clasificacion;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	@Override
	public String toString() {
		return "Equipo [id=" + id + ", nombre=" + nombre + ", clasificación=" + clasificacion + "]";
	}

}