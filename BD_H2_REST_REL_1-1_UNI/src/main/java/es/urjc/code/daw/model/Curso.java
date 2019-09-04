package es.urjc.code.daw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) //La librería de Jackson nos permite ocultar los objetos null en la vista que devuelve el controlador
@Entity
public class Curso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	private String nombre;
	
	private int duracion;


	protected Curso() {
	}

	public Curso(String title, int calification) {
		this.nombre = title;
		this.duracion = calification;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return nombre;
	}

	public void setTitle(String title) {
		this.nombre = title;
	}

	public int getCalification() {
		return duracion;
	}

	public void setCalification(int calification) {
		this.duracion = calification;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}

}