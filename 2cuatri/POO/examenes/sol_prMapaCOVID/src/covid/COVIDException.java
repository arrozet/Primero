package covid;


/**
 * Clase que representa excepciones en el ámbito del proyecto prMapaCOVID
 */
public class COVIDException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public COVIDException() {
		super();
	}
	
	public COVIDException(String mens) {
		super(mens);
	}
}
