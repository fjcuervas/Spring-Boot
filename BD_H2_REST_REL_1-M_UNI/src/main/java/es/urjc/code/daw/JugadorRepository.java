package es.urjc.code.daw;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.daw.model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
	
}