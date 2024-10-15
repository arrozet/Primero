package parrillatv;

/**
 * Clase para representar parrillas de TV, donde se añade una cuña publicitaria de 5 minutos 
 * tras cualquier programa que se añada. Las cuñas publicitarias son considerados también 
 * instancias de la clase Programa.
 * 
 * @author POO
 *
 */
public class ProgramacionTVPublicidad extends ProgramacionTV {
	
	@Override
	/**
	 * Redefinición del método agregar, para añadir justo detrás del programa una 
	 * cuña de publicidad con denominación "Publicidad" y duración de 5 minutos.
	 */
	public void agregar(String cadenaTV, ProgramaTV prog) {
		super.agregar(cadenaTV, prog);
		ProgramaTV publicidad = new ProgramaTV("Publicidad",prog.getHoraFin(),5);
		super.agregar(cadenaTV, publicidad);
	}
}
