package mx.com.qtx.perrera.negocio;

public class Persona {
	private int idPersona;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private char genero;
	private Domicilio domicilio;
	
	public Persona() {
		super();
	}

	public Persona(int idPersona, String nombre, String apellidoPaterno,
			String apellidoMaterno, char genero) {
		super();
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.apellidoPaterno = apellidoPaterno;
		this.apellidoMaterno = apellidoMaterno;
		this.genero = genero;
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

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre
				+ ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno="
				+ apellidoMaterno + ", genero=" + genero + "]";
	}
	public String toJSON(){
		String json = "";
		json += "{"
			 + "\"id\":" + this.idPersona
			 + ",\"nombre\":\"" + this.nombre
			 + "\",\"apPaterno\":\"" + this.apellidoPaterno
			 + "\",\"apMaterno\":\"" + this.apellidoMaterno
			 + "\",\"genero\":\"" + this.genero
			 + "\"" 
			 + "}";
		return json;
	}

}
