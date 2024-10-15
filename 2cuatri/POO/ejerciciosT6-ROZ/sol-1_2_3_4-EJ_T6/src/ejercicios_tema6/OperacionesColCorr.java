package ejercicios_tema6;

import java.util.*;

public class OperacionesColCorr {
	
	// Paso 3.a
	
		public static double mediaVocales(Set<String> conjCadenas) {
			double media = 0;
			int numCadenas = conjCadenas.size();
			
			if (numCadenas != 0) {
				int suma = 0;
				for (String s : conjCadenas) {
					suma += cuentaVocales(s);
				}
				media = (double)suma/numCadenas;
			}
			
			return media;
		}
		
		private static int cuentaVocales(String s) {
			int res = 0;
			
			for (int cont = 0; cont < s.length(); cont++) {
				if (esVocal(s.charAt(cont))) {
					res++;
				}
			}
			
			return res;
		}
		
		private static boolean esVocal(char c) {
			c = Character.toLowerCase(c);
			return ((c == 'a') || (c == 'e') || (c == 'i') 
					   || (c == 'o') || (c == 'u'));
		}
		
	// Paso 3.b
		
		public static void eliminarCadenas(Set<String> conjCadenas,
											String cadena) {
			Iterator<String> it = conjCadenas.iterator();
			while (it.hasNext()) {
				if (it.next().startsWith(cadena)) {
					it.remove();
				}
			}
		}
		
}
