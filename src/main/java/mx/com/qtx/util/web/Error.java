package mx.com.qtx.util.web;

import jakarta.servlet.http.HttpServletRequest;

public class Error {
	private String metodoHttp;
	private String uri;
	private String mensaje;
	private String excepcion;
	private String excepcionAnidada;

	public Error() {
	}

	public static Error getError(HttpServletRequest req, Exception ex) {
		Error err = new Error();
		
		err.mensaje = ex.getMessage();
		err.excepcion = ex.getClass().getName();
		if(ex.getCause() != null)
			err.excepcionAnidada = ex.getCause().getClass().getName() 
					                + ":" + ex.getCause().getMessage();
		else
			err.excepcionAnidada="";
		err.setMetodoHttp(req.getMethod());
		err.uri = req.getRequestURI();
		if (req.getQueryString() != null)
			err.uri += "?" + req.getQueryString();
		return err;
	}
	
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public String getExcepcion() {
		return excepcion;
	}

	public void setExcepcion(String excepcion) {
		this.excepcion = excepcion;
	}

	public String getExcepcionAnidada() {
		return excepcionAnidada;
	}

	public void setExcepcionAnidada(String excepcionAnidada) {
		this.excepcionAnidada = excepcionAnidada;
	}

	public String getMetodoHttp() {
		return metodoHttp;
	}

	public void setMetodoHttp(String metodoHttp) {
		this.metodoHttp = metodoHttp;
	}

}
