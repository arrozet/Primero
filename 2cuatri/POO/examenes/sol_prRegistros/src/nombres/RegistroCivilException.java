package nombres;

// NOTA: decidir si en ambos exámenes la ponemos comprobada o no comprobada
public class RegistroCivilException extends RuntimeException { 
	private static final long serialVersionUID = 1L;
	public RegistroCivilException() {
		super();
	}
	public RegistroCivilException(String mensaje) {
		super(mensaje);
	}
}
