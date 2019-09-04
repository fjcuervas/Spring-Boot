package es.urjc.code.daw;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import es.urjc.code.daw.model.Curso;
import es.urjc.code.daw.model.Estudiante;

@RestController
public class EstudianteController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@PostConstruct
	public void init() {

		Estudiante s1 = new Estudiante("Julio", "Fernandez Muñoz");
		s1.setProject(new Curso("Java", 4));
		estudianteRepository.save(s1);
		
		Estudiante s2 = new Estudiante("Pedro", "Martinez Martín");		
		estudianteRepository.save(s2);	
		
	}

	interface EstudianteView extends Estudiante.AtributoBasico, Estudiante.AtributoCurso, Curso.AtributoBasico {}
	
	@JsonView(EstudianteView.class)
	@RequestMapping("/estudiantes/")
	public List<Estudiante> getEstudiantes() throws Exception {
		return estudianteRepository.findAll();
	}
	
	@JsonView(EstudianteView.class)
	@RequestMapping("/estudiantes/{id}")
	public Estudiante getEstudiante(@PathVariable long id) throws Exception {
		return estudianteRepository.findOne(id);
	}
	
	@JsonView(EstudianteView.class)
	@RequestMapping("/estudiantes/delete/{id}")
	public void deleteEstudiante(@PathVariable long id) throws Exception {
		estudianteRepository.delete(id);
	}
	
	interface ProjectView extends Curso.AtributoBasico, Curso.AtributoEstudiante, Estudiante.AtributoBasico {}
	
	@JsonView(ProjectView.class)
	@RequestMapping("/cursos/")
	public List<Curso> getProjects() throws Exception {
		return cursoRepository.findAll();
	}
	
	@JsonView(ProjectView.class)
	@RequestMapping("/cursos/{id}")
	public Curso getProject(@PathVariable long id) throws Exception {
		return cursoRepository.findOne(id);
	}	
}
