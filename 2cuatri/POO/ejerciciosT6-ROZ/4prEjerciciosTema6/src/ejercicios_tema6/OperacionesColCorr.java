package ejercicios_tema6;

import java.util.Iterator;
import java.util.Set;

public class OperacionesColCorr {
	public static double mediaVocales(Set<String> conjunto) {
		double totalVocales=0;
		
		if(conjunto.isEmpty()) {
			return 0.0;
		}
		
		for (String palabra : conjunto) {
			for (char c: palabra.toCharArray()) {
				if("AEIOUaeiou".indexOf(c) != -1) {
					totalVocales++;
				}
			}
		}
		return totalVocales/conjunto.size();
	}
	
	public static void eliminarCadenas(Set<String> conjunto, String cadena) {
		Iterator<String> iter = conjunto.iterator();
		while(iter.hasNext()) {
			String aux = iter.next();
			if(aux.startsWith(cadena)){
				iter.remove();
			}
		}
	}
}
