package es.urjc.code.daw.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonView;

@JsonInclude(JsonInclude.Include.NON_NULL) //La librería de Jackson nos permite ocultar los objetos null en la vista que devuelve el controlador
@Entity
public class Curso {
	
	public interface AtributoBasico {}
	public interface AtributoEstudiante {}

	@JsonView(AtributoBasico.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	@JsonView(AtributoBasico.class)
	private String nombre;
	
	@JsonView(AtributoBasico.class)
	private int duracion;

	@JsonView(AtributoEstudiante.class)
	@OneToOne(mappedBy = "curso")
	private Estudiante estudiante;

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

	public Estudiante getStudent() {
		return estudiante;
	}

	public void setStudent(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", nombre=" + nombre + ", duracion=" + duracion + "]";
	}

}