package mx.com.qtx.perrera.negocio;

public class Perro {
	private int id;
	private String nombre;
	private String raza;
	private int edad;
	private Persona propietario;
	
	public Perro(){
		
	}
	public Perro(int id, String nombre, String raza, int edad,
			Persona propietario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.propietario = propietario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRaza() {
		return raza;
	}
	public void setRaza(String raza) {
		this.raza = raza;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public Persona getPropietario() {
		return propietario;
	}
	public void setPropietario(Persona propietario) {
		this.propietario = propietario;
	}
	@Override
	public String toString() {
		return "Perro [id=" + id + ", nombre=" + nombre + ", raza=" + raza
				+ ", edad=" + edad + "]";
	}

	public String toHtml() {
		   String perroHtml = "<html><head>";
		   perroHtml += "<title>Perro</title></head>";
		   perroHtml += "<body>";
		   perroHtml += "<p><strong>Id</strong>:"
		   		+ this.getId() +"</p>";
		   perroHtml += "<p><strong>Nombre</strong>:"
			   		+ this.getNombre() +"</p>";
		   perroHtml += "<p><strong>Raza</strong>:"
				   	+ this.getRaza() +"</p>";
		   perroHtml += "<p><strong>Edad</strong>:"
				   	+ this.getEdad() +"</p>";
		   perroHtml += "</body></html>";
		   	   
		   return perroHtml;
	}
	public String toJSON(){
		String json = "";
		json += "{"
			 + "\"id\":" + this.id
			 + ",\"nombre\":\"" + this.nombre
			 + "\",\"raza\":\"" + this.raza
			 + "\",\"edad\":" + this.edad
			 + ",\"propietario\":" + this.propietario.getIdPersona()
			 + "}";
		return json;
	}
	
	public PerroPlano toPerroPlano() {
		return new PerroPlano(this.id, this.nombre, this.raza, this.edad, this.propietario != null ? propietario.getIdPersona() : 0);
	}

	
}
