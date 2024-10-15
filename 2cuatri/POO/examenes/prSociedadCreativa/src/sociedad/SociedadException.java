//NOMBRE:		Oliva Zamora, Rubén 
//TITULACIÓN:	Ingeniería del Software
//GRUPO:		A

package sociedad;

public class SociedadException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	// para que no salga warning
	SociedadException() {
		super();
	}
	SociedadException(String msg) {
		super(msg);
	}
}
