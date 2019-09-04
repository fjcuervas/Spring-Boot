package es.urjc.code.daw;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.daw.model.Curso;
import es.urjc.code.daw.model.Estudiante;

@RestController
public class EstudianteController {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private EstudianteRepository estudianteRepository;

	@PostConstruct
	public void crearBaseDatos() {

		//Si usamos el cascadaType.ALL en Student, no es necesario guardar previamente el proyecto porque tienen el mismo ciclo de vida. 
		//Con lo que podríamos hacer directamente: 
		/*
		 * 	Estudiante estudiante1 = new Estudiante("Julio", "Fernandez Muñoz");
		 * 	estudiante1.setProject(new Curso("Java",4));
		 *  estudianteRepository.save(estudiante1);
		 */
		
		Curso curso = new Curso("Java",4);
		cursoRepository.save(curso);
		
		Estudiante estudiante1 = new Estudiante("Julio", "Fernandez Muñoz");
		estudiante1.setProject(curso);
		
		Estudiante estudiante2 = new Estudiante("Pedro", "Martinez Martín");	
		
		estudianteRepository.save(estudiante1);
		estudianteRepository.save(estudiante2);		
	}

	@RequestMapping("/estudiantes/")
	public List<Estudiante> consultarEstudiantes() throws Exception {
		return estudianteRepository.findAll();
	}
}
