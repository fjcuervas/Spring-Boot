package es.urjc.code.daw;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.daw.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {
	
}