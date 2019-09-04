package es.urjc.code.daw.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Estudiante {

	public interface AtributoBasico {}
	public interface AtributoCurso {}
	
	@JsonView(AtributoBasico.class)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@JsonView(AtributoBasico.class)
	private String nombre;
	
	@JsonView(AtributoBasico.class)
	private String apellidos;

	@JsonView(AtributoCurso.class)
	@OneToOne(cascade = CascadeType.ALL)
	//Esta anotación no sería necesaria. Lo único que podemos darle un nombre al campo con la clave foránea
	@JoinColumn(name = "FK_ESTUDIANTE_CURSO", referencedColumnName = "id") 
	private Curso curso;

	protected Estudiante() {
	}

	public Estudiante(String name, String apellidos) {
		this.nombre = name;
		this.apellidos = apellidos;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return nombre;
	}

	public void setName(String author) {
		this.nombre = author;
	}

	public String getYear() {
		return apellidos;
	}

	public void setYear(String apellidos) {
		this.apellidos = apellidos;
	}

	public Curso getProject() {
		return curso;
	}

	public void setProject(Curso curso) {
		this.curso = curso;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}

}
