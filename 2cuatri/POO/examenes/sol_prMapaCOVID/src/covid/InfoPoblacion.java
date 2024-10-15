package covid;


import java.util.Set;
import java.util.TreeSet;

public class InfoPoblacion implements InfoCOVID {
	/**
	 * Variables que determinan el rango de población
	 */
	private int minPoblacion, maxPoblacion;
	
	/**
	 * Constructor para crear objetos que determinen el conjunto de distritos sanitarios
	 * con una población atendida entre el mínimo y el máximo proporcionados como 
	 * argumentos.
	 * 
	 * @param minPob	Límite inferior de la población
	 * @param maxPob	Límite superior de la población
	 */
	public InfoPoblacion(int minPob, int maxPob) {
		if (minPob > maxPob) throw new COVIDException("El límite de población debe ser positivo");
		minPoblacion = minPob;
		maxPoblacion = maxPob;
	}

	@Override
	public Set<String> obtenerInfo(MapaCOVID mapa) {
		Set<String> res = new TreeSet<>();
		for(DistritoSanitario distrito : mapa.getDistritos()) {
			int poblacion = distrito.getPoblacion();
			if(poblacion >= minPoblacion && poblacion < maxPoblacion)
				res.add(distrito.getDistrito());
		}
		return res;
	}
}
