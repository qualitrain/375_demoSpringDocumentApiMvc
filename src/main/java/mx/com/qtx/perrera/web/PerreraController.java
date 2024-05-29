package mx.com.qtx.perrera.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.qtx.perrera.negocio.Domicilio;
import mx.com.qtx.perrera.negocio.RepositorioPerros;
import mx.com.qtx.perrera.negocio.Perro;
import mx.com.qtx.perrera.negocio.PerroPlano;
import mx.com.qtx.perrera.negocio.Persona;
import mx.com.qtx.perrera.negocio.PersonaPlana;
import mx.com.qtx.util.web.Error;

@RestController
@CrossOrigin
public class PerreraController {
	@Autowired
	private RepositorioPerros perros;
	private static Logger log = LoggerFactory.getLogger(PerreraController.class);
	
	public PerreraController() {
		super();
		log.info("PerreraController()");
	}

	@GetMapping(path = "/perros/perro", produces = MediaType.APPLICATION_JSON_VALUE)
	public PerroPlano getPerroXId(@RequestParam(name="id")
	                         int id) {
		log.info("PerreraController.getPerroXId(" + id + ")");
		Perro perro = perros.getXid(id);
		if(perro != null)
			return perro.toPerroPlano();
		return null;
	}
	
	@GetMapping(path = "/perros/propietario", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonaPlana getPersonaXId(@RequestParam(value="id", defaultValue = "0") 
	                             int idPersona) {
		log.info("PerreraController.getPersonaXId(" + idPersona + ")");
		Persona persona = this.perros.getPropietarioXid(idPersona);
		if(persona != null)
			return new PersonaPlana(persona);
		return null;
	}
	
	@GetMapping(path = "/perros/domicilio", produces = MediaType.APPLICATION_JSON_VALUE)
	public Domicilio getDomicilioXId(@RequestParam(defaultValue = "0") 
	                                 int id) {
		log.info("PerreraController.getDomicilioXId(" + id + ")");
		Domicilio domicilio = this.perros.getDomicilioXid(id);
		return domicilio;
	}
	
	@GetMapping(path = "/perros/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public PerroPlano getPerroXId02(@PathVariable()
	                                int id) {
		log.info("PerreraController.getPerroXId02(" + id + ")");
		Perro perro = perros.getXid(id);
		if(perro != null)
			return perro.toPerroPlano();
		return null;
	}
	
	@GetMapping(path = "/perros", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Perro> getPerros() {
		log.info("PerreraController.getPerros()");
		return this.perros.getTodos();
	}
	
	@PostMapping(path = "/perros", produces = MediaType.APPLICATION_JSON_VALUE, 
			                               consumes = MediaType.APPLICATION_JSON_VALUE)
	public PerroPlano postPerroPlano(@RequestBody PerroPlano perro) {
		log.info("PerreraController.postPerroPlano(" + perro + ")");
		int id = this.perros.getIdMaxPerros() + 1;
		perro.setId(id);
		Perro nvoPerro = new Perro(id, perro.getNombre(), perro.getRaza(), perro.getEdad(), null);
		this.perros.agregarPerro(nvoPerro);
		return perro;
	}
	
	@PutMapping(path = "/perros", produces = MediaType.APPLICATION_JSON_VALUE, 
            consumes = MediaType.APPLICATION_JSON_VALUE)
	public PerroPlano putPerroPlano(@RequestBody PerroPlano perro) {
		log.info("PerreraController.putPerroPlano(" + perro + ")");
		Perro perroActual = this.perros.getXid(perro.getId());
		if(perroActual == null)
			return null;
		return this.perros.actualizarPerroPlano(perroActual, perro);
	}
	
	@DeleteMapping(path = "/perros/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Perro deletePerro(@PathVariable()
    							  int id) {
		log.info("PerreraController.deletePerro(" + id + ")");
		Perro perroActual = this.perros.getXid(id);
		if(perroActual == null)
			return null;
		this.perros.borrar(id);
		return perroActual;
	}
	
	@ExceptionHandler
	public ResponseEntity<Error> manejarErrorFormatoUri(MethodArgumentTypeMismatchException matmex, HttpServletRequest req) {
		Error err = Error.getError(req, matmex);
		ResponseEntity<Error> reErr = new ResponseEntity<Error>(err,HttpStatus.BAD_REQUEST);
		return reErr;		
	}

	@ExceptionHandler
	public ResponseEntity<Error> manejarErrorFormatoUri(Exception matmex, HttpServletRequest req) {
		Error err = Error.getError(req, matmex);
		ResponseEntity<Error> reErr = new ResponseEntity<Error>(err,HttpStatus.BAD_REQUEST);
		return reErr;		
	}
	
}