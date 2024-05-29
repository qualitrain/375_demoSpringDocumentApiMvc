package mx.com.qtx.personas.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import mx.com.qtx.personas.entidades.Persona;

@RestController
@CrossOrigin
public class PersonasController {
	
	private static Logger bitacora = LoggerFactory.getLogger(PersonasController.class);
	
	@Autowired
	private IServicioPersonas servicioPersonas;
	
	public PersonasController() {
		bitacora.info("PersonasController()");
	}
	
	@GetMapping(path = "/personas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> getPersonas() {
		bitacora.info("getPersonas()");
		List<Persona> personas = this.servicioPersonas.getPersonasTodas();
		return personas;
	}
	
	@GetMapping(path = "/personas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Persona getPersona(
			@PathVariable("id")
			Long id) {
		bitacora.info("getPersona("+ id + ")");
		
		Persona persona = this.servicioPersonas.getPersona(id);
		return persona;
	}
}
