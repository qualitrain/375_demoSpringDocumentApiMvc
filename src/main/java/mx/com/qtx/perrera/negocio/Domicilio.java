package mx.com.qtx.perrera.negocio;

public class Domicilio {
	private int idPersona;
	private String calle;
	private String numExt;
	private String numInt;
	private String colonia;
	private String delMunicipio;
	private String estado;

	public Domicilio() {
		super();
	}
	public Domicilio(int idPersona, String calle, String numExt, String numInt,
			String colonia, String delMunicipio, String estado) {
		super();
		this.idPersona = idPersona;
		this.calle = calle;
		this.numExt = numExt;
		this.numInt = numInt;
		this.colonia = colonia;
		this.delMunicipio = delMunicipio;
		this.estado = estado;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumExt() {
		return numExt;
	}
	public void setNumExt(String numExt) {
		this.numExt = numExt;
	}
	public String getNumInt() {
		return numInt;
	}
	public void setNumInt(String numInt) {
		this.numInt = numInt;
	}
	public String getColonia() {
		return colonia;
	}
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}
	public String getDelMunicipio() {
		return delMunicipio;
	}
	public void setDelMunicipio(String delMunicipio) {
		this.delMunicipio = delMunicipio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Domicilio [idPersona=" + idPersona + ", calle=" + calle
				+ ", numExt=" + numExt + ", numInt=" + numInt + ", colonia="
				+ colonia + ", delMunicipio=" + delMunicipio + ", estado="
				+ estado + "]";
	}
	public String toJSON(){
		String json = "";
		json += "{"
			 + "\"id\":" + this.idPersona
			 + ",\"calle\":\"" + this.calle
			 + "\",\"numExt\":\"" + this.numExt
			 + "\",\"numInt\":\"" + this.numInt
			 + "\",\"colonia\":\"" + this.colonia
			 + "\",\"delMunicipio\":\"" + this.delMunicipio
			 + "\",\"estado\":\"" + this.estado
			 + "\"" 
			 + "}";
		return json;
	}
}
