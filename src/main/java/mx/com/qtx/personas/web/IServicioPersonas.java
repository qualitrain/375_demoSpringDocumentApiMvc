package mx.com.qtx.personas.web;

import java.util.List;

import mx.com.qtx.personas.entidades.Persona;

public interface IServicioPersonas {
	public List<Persona> getPersonasTodas();
	public Persona getPersona(long id);
}
