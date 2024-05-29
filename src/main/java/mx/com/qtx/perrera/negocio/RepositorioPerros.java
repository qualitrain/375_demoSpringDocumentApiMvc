package mx.com.qtx.perrera.negocio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

@Component
public class RepositorioPerros {
	private Map<Integer,Perro> perros;
	private Map<Integer,Persona> personas;
	private Map<Integer,Domicilio> domicilios;
	
	public RepositorioPerros() {
		super();
		this.perros = new TreeMap<Integer,Perro>();
		this.personas = new TreeMap<Integer,Persona>();
		this.domicilios = new TreeMap<Integer,Domicilio>();
		this.cargarPerrera();
	}
	public void agregarPerro(Perro perro){
		this.perros.put(perro.getId(), perro);
	}
	public Perro getXid(int id){
		RepositorioPerros.pausaAleatoria();
		return this.perros.get(id);
	}
	public void cargarPerrera(){
		Persona carlos = new Persona(1,"Carlos","Barrera","Carpio",'M');
		carlos.setDomicilio(new Domicilio(carlos.getIdPersona(),
								"Av. Torres Adalid","235","",
								"Del Valle","Benito Juarez","Cd Mx"));
		this.personas.put(carlos.getIdPersona(), carlos);
		this.domicilios.put(carlos.getIdPersona(), carlos.getDomicilio());
		
		Persona moni = new Persona(2,"Monica","Villanueva","Barrios",'F');
		moni.setDomicilio(new Domicilio(moni.getIdPersona(),
								"Marsella","233","201-A",
								"Juarez","Cuauhtemoc","Cd Mx"));
		this.personas.put(moni.getIdPersona(), moni);
		this.domicilios.put(moni.getIdPersona(), moni.getDomicilio());
		
		Persona david = new Persona(3,"David","Almena","Marcos",'M');
		david.setDomicilio(new Domicilio(david.getIdPersona(),
								"Sonora","500","5",
								"Condesa","Cuauhtemoc","Cd Mx"));
		this.personas.put(david.getIdPersona(), david);
		this.domicilios.put(david.getIdPersona(), david.getDomicilio());
		
		Persona lore = new Persona(4,"Lorena","De la Cruz","Almazo",'F');
		lore.setDomicilio(new Domicilio(lore.getIdPersona(),
								"Sonora","300","2",
								"Condesa","Cuauhtemoc","Cd Mx"));
		this.personas.put(lore.getIdPersona(), lore);
		this.domicilios.put(lore.getIdPersona(), lore.getDomicilio());
		
		Persona agus = new Persona(5,"Agustin","Martinez","Bernal",'M');
		agus.setDomicilio(new Domicilio(agus.getIdPersona(),
								"Dr Lavista","123","501",
								"De los doctores","Cuauhtemoc","Cd Mx"));
		this.personas.put(agus.getIdPersona(), agus);
		this.domicilios.put(agus.getIdPersona(), agus.getDomicilio());
			
		this.agregarPerro(new Perro(1,"Firulais","French Poodle",3,moni));
		this.agregarPerro(new Perro(2,"Fido","Pastor Mexicano",7, agus));
		this.agregarPerro(new Perro(3,"Champ","Dalmata",2, carlos));
		this.agregarPerro(new Perro(4,"Fifi","French Poodle",10, david));
		this.agregarPerro(new Perro(5,"Trump","Boxer",3, carlos));
		this.agregarPerro(new Perro(6,"Babas","Chihuahua",3, david));
		this.agregarPerro(new Perro(8,"Fakir","French Poodle",3, carlos));
		this.agregarPerro(new Perro(9,"Frijolito","Criollo",3, lore));
		this.agregarPerro(new Perro(12,"Killer","Doberman",3, agus));
	}
	public List<Perro> getXnombre(String nombre){
		List<Perro> perrosN = new ArrayList<Perro>();
		for(Perro perroI : this.perros.values()){
			if(perroI.getNombre().equalsIgnoreCase(nombre))
				perrosN.add(perroI);
		}
		return perrosN;
	}
	public List<Perro> getTodos(){
		return new ArrayList<Perro>(this.perros.values());
	}
	public String getTodosJSON(){
		String json = "[";
		List<Perro> lstPerros = this.getTodos();
		for(int i=0; i < (lstPerros.size() - 1) ; i++){
			json += lstPerros.get(i).toJSON() + ",";
		}
		json += lstPerros.get(lstPerros.size() - 1).toJSON() + "]";
		
		return json;
	}
	public Persona getPropietarioXid(int idPropietario){
		RepositorioPerros.pausaAleatoria();
		return this.personas.get(idPropietario);
	}
	public Domicilio getDomicilioXid(int idPropietario){
		RepositorioPerros.pausaAleatoria();
		return this.domicilios.get(idPropietario);
	}

	public void borrar(int id){
		this.perros.remove(id);
		System.out.println(this.perros.size());
	}
	
	public int getIdMaxPerros() {
		Optional<Integer> idMax = this.perros.keySet()
		           				             .stream()
		           				             .max( (a,b) -> a > b ? 1 : -1 );
		return idMax.orElse(0);
	}
	
	public static void pausaAleatoria(){
		int ms = ( Math.round((float) Math.random() * 10000 ) % 25 ) * 100;
		System.out.println("pausa de " + ms + " ms");
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			System.out.println("Excepcion en Perrera.pausa: "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Version simplificada: uni-dimensional 
	public PerroPlano actualizarPerroPlano(Perro perroActual, PerroPlano perro) {
		Perro perroNvo = this.perros.get(perroActual.getId());
		perroNvo.setNombre(perro.getNombre());
		perroNvo.setEdad(perro.getEdad());
		perroNvo.setRaza(perro.getRaza());
		return perroNvo.toPerroPlano();
	}
}
