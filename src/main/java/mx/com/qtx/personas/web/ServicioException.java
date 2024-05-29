package mx.com.qtx.personas.web;

public class ServicioException extends RuntimeException {
	private ErrorRest error;

	public ServicioException(ErrorRest error) {
		super();
		this.error = error;
	}

	public ErrorRest getError() {
		return error;
	}

	public void setError(ErrorRest error) {
		this.error = error;
	}



}
