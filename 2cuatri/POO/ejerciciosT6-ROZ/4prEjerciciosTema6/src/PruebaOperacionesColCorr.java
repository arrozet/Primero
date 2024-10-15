import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import ejercicios_tema6.OperacionesColCorr;

public class PruebaOperacionesColCorr {

	public static void pruebaConjunto(String cadena_elim, Set<String> conj) {
		System.out.println("PRUEBA: mediaVocales");
		System.out.println("El conjunto es " + conj);
		System.out.println("La media de las vocales es: " + OperacionesColCorr.mediaVocales(conj));
		
		System.out.println("PRUEBA: eliminaCadenas");
		OperacionesColCorr.eliminarCadenas(conj, cadena_elim);
		System.out.println("El conjunto tras eliminar las cadenas es " + conj);
	}
	
	public static void main(String[] args) {
		Set<String> conjunto = new HashSet<>();
		SortedSet<String> conjunto_ord = new TreeSet<>();
		conjunto.add("hola");
		conjunto.add("hello");
		conjunto.add("adios");
		conjunto.add("bye");
		conjunto_ord.addAll(conjunto);
		
		System.out.println("CONJUNTO SIN ORDENAR");
		pruebaConjunto("he", conjunto);
		
		System.out.println("\nCONJUNTO ORDENADO");
		pruebaConjunto("he", conjunto_ord);
		
		
	}

}
