package mx.com.qtx.perrera.negocio;

public class PersonaPlana {
	private int idPersona;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private char genero;
	public PersonaPlana(Persona persona) {
		super();
		this.idPersona = persona.getIdPersona();
		this.nombre = persona.getNombre();
		this.apellidoPaterno = persona.getApellidoPaterno();
		this.apellidoMaterno = persona.getApellidoMaterno();
		this.genero = persona.getGenero();
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}
	public char getGenero() {
		return genero;
	}
	public void setGenero(char genero) {
		this.genero = genero;
	}

}
