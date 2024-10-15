//NOMBRE:		Oliva Zamora, Rubén 
//TITULACIÓN:	Ingeniería del Software
//GRUPO:		A

package sociedad;
import java.util.Set;

public class SociedadLimitada extends Sociedad{
	private int positionsLimit;
	
	public SociedadLimitada(int numeroDePlazas) {
		super();
		if(numeroDePlazas<=0) {
			throw new SociedadException("El numero de plazas no puede ser 0 o negativo");
		}
		positionsLimit = numeroDePlazas;
	}
	
	@Override
	public void inscribir(String nombre, int identidicador, String actividad) {
		Set<Socio> plazas = inscritos(actividad);
		
		if(plazas==null || plazas.size()<positionsLimit ) {
			super.inscribir(nombre, identidicador, actividad);
		}
		else {
			throw new SociedadException("Todas las plazas ya han sido reservadas para la actividad "+ actividad);
		}
		
	}
}
