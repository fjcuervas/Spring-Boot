package es.urjc.code.daw;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.daw.model.Equipo;

public interface EquipoRepository extends JpaRepository<Equipo, Long> {
	
}