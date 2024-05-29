package mx.com.qtx.personas.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class CatalogosController {
	
	@Autowired
	private IServicioCatalogos servicioCatalogos;
	private static Logger bitacora = LoggerFactory.getLogger(CatalogosController.class);

	public CatalogosController() {
		bitacora.info("CatalogosController()");
	}
	
	@GetMapping(path = "/catalogos/apellidos", produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<String> getApellidos() {		
		bitacora.info("getApellidos()");
		List<String> apellidos = this.servicioCatalogos.getApellidosSugeridos("");
		if(apellidos == null) {
			ErrorRest err = ErrorRest.crearErrorRest("Falló el sistema subyacente", ErrorRest.ERR_FALLA_SERVICIO);
			throw new ServicioException(err);
		}
		return apellidos;		
	}
	
	@GetMapping(path = "/catalogos/apellidos/{inicio}", produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<String> getApellidosQueInicienCon(
			@PathVariable("inicio")
			String inicio) {
		
		bitacora.info("getApellidosQueInicienCon(" + inicio + ")");
		List<String> apellidos = this.servicioCatalogos.getApellidosSugeridos(inicio);
		if(apellidos == null) {
			ErrorRest err = ErrorRest.crearErrorRest("Falló el sistema subyacente", ErrorRest.ERR_FALLA_SERVICIO);
			throw new ServicioException(err);
		}
		return apellidos;
		
	}
	
	@GetMapping(path = "/catalogos/nombres/{inicio}", produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<String> getNombresQueInicienCon(
			@PathVariable("inicio")
			String inicio){
		bitacora.info("getNombresQueInicienCon(" + inicio + ")");
		List<String> nombres = this.servicioCatalogos.getNombresSugeridos(inicio);
		if(nombres == null) {
			ErrorRest err = ErrorRest.crearErrorRest("Falló el sistema subyacente", ErrorRest.ERR_FALLA_SERVICIO);
			throw new ServicioException(err);
		}
		return nombres;
	}
	
	@GetMapping(path = "/catalogos/nombres", produces = MediaType.APPLICATION_JSON_VALUE)	
	public List<String> getNombres(){
		bitacora.info("getNombres()");
		List<String> nombres = this.servicioCatalogos.getNombresSugeridos("");
		if(nombres == null) {
			ErrorRest err = ErrorRest.crearErrorRest("Falló el sistema subyacente", ErrorRest.ERR_FALLA_SERVICIO);
			throw new ServicioException(err);
		}
		return nombres;
	}
	
	@ExceptionHandler
	public ResponseEntity<ErrorRest> manejarExcepcion(ServicioException servEx){
		ErrorRest err = servEx.getError();
		return new ResponseEntity<ErrorRest>(err,HttpStatus.BAD_REQUEST);
	}
}
