package mx.com.qtx.perrera.negocio;

public class PerroPlano {
	private int id;
	private String nombre;
	private String raza;
	private int edad;
	private int idPropietario;
	
	public PerroPlano(int id, String nombre, String raza, int edad, int idPropietario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.edad = edad;
		this.idPropietario = idPropietario;
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

	public int getIdPropietario() {
		return idPropietario;
	}

	public void setIdPropietario(int idPropietario) {
		this.idPropietario = idPropietario;
	}

	@Override
	public String toString() {
		return "PerroPlano [id=" + id + ", nombre=" + nombre + ", raza=" + raza + ", edad=" + edad + ", idPropietario="
				+ idPropietario + "]";
	}
	
}
