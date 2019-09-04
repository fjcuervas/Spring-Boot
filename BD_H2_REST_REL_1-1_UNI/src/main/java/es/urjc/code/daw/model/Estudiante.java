package es.urjc.code.daw.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Estudiante {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String nombre;
	
	private String apellidos;

	//@OneToOne(cascade = CascadeType.ALL) //Si queremos que al guardar el Student se guarde automáticamente el Project
	//Esta anotación no sería necesaria. Lo único que podemos darle un nombre al campo con la clave foránea
	//@JoinColumn(name = "FK_ESTUDIANTE_CURSO", referencedColumnName = "id") 
	@OneToOne
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
