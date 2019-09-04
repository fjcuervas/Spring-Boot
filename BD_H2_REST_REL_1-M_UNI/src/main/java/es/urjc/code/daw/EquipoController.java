package es.urjc.code.daw;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.daw.model.Equipo;
import es.urjc.code.daw.model.Jugador;

@RestController
public class EquipoController {

	@Autowired
	private EquipoRepository equipoRepository;
	
	@Autowired
	private JugadorRepository jugadorRepository;

	@PostConstruct
	public void init() {

		Jugador jugador1 = new Jugador("Ramos", 3);
		Jugador jugador2 = new Jugador("Iniesta", 7);
		
		jugadorRepository.save(jugador1);
		jugadorRepository.save(jugador2);
		
		Equipo equipo = new Equipo("Selección Española", 1);
		
		equipo.getJugadores().add(jugador1);
		equipo.getJugadores().add(jugador2);

		equipoRepository.save(equipo);
	}

	@RequestMapping("/equipos/")
	public List<Equipo> getEquipos() throws Exception {
		return equipoRepository.findAll();
	}
	
	@RequestMapping("/equipos/{id}")
	public Equipo findEquipo(@PathVariable("id") long idEquipo) {
		return equipoRepository.findOne(idEquipo);
	}
	
	@RequestMapping("/equipos/delete/{id}")
	public void deleteEquipo(@PathVariable("id") long idEquipo) {
		equipoRepository.delete(idEquipo);
	}
	
	@RequestMapping("/jugadores/")
	public List<Jugador> getJugadores() throws Exception {
		return jugadorRepository.findAll();
	}
	
	@RequestMapping("/jugadores/{id}")
	public Jugador findJugador(@PathVariable("id") long idJugador) {
		return jugadorRepository.findOne(idJugador);
	}
	
	@RequestMapping("/jugadores/delete/{id}")
	public void deleteJugador(@PathVariable("id") long idJugador) {
		jugadorRepository.delete(idJugador);
	}
}
