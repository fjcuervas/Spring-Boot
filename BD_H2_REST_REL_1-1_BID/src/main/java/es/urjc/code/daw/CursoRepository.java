package es.urjc.code.daw;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.daw.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
	
}