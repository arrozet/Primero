import java.util.*;

import ejercicios_tema6.OperacionesColCorr;

public class PruebaOperacionesColCorr {

	public static void main(String[] args) {
		
		// Código para Paso 3
		
			Set<String> conjCadenas = new HashSet<>();
			//Set<String> conjCadenas = new TreeSet<>();
				
			conjCadenas.add("hola");
			conjCadenas.add("hello");
			conjCadenas.add("adios");
			conjCadenas.add("bye");
				
			System.out.println("PRUEBA: mediaVocales");
			System.out.println("El conjunto es: " + conjCadenas);
			System.out.println("La media de las vocales es:"
					+ OperacionesColCorr.mediaVocales(conjCadenas));
				
			System.out.println("\nPRUEBA: eliminaCadenas");
			OperacionesColCorr.eliminarCadenas(conjCadenas, "he");
			System.out.println("El conjunto tras eliminar cadenas es: " 
								+ conjCadenas);
				

	}

}
