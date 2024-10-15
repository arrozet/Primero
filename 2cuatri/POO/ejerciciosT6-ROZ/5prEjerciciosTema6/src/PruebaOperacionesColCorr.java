import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
		
		// EJERCICIO 5
		// a
		System.out.println("\nPRUEBA: intercambiarContiguos");
		List<Integer> lista_enteros = new ArrayList<>();
		lista_enteros.add(3);
		lista_enteros.add(2);
		lista_enteros.add(7);
		lista_enteros.add(3);
		lista_enteros.add(4);
		lista_enteros.add(8);
		lista_enteros.add(7);
		System.out.println(lista_enteros);
		OperacionesColCorr.intercambiarContiguos(lista_enteros);
		System.out.println(lista_enteros);
		
		// b
		System.out.println("\nPRUEBA: eliminarDuplicados");
		List<String> lista_string = new ArrayList<>();
		lista_string.add("esto");
		lista_string.add("es");
		lista_string.add("esto");
		lista_string.add("un");
		lista_string.add("ejemplo");
		lista_string.add("ejemplo");
		lista_string.add("un");
		System.out.println(lista_string);
		OperacionesColCorr.eliminarDuplicados(lista_string);
		System.out.println(lista_string);
		
		// c
		System.out.println("\nPRUEBA: superInterseccion");
		Set<Integer> s1 = new HashSet<>();
		s1.add(3);
		s1.add(8);
		s1.add(2);
		Set<Integer> s2 = new HashSet<>();
		s2.add(8);
		s2.add(7);
		s2.add(3);
		Set<Integer> s3 = new HashSet<>();
		s3.add(4);
		s3.add(2);
		s3.add(3);
		
		List<Set<Integer>> lista_conjuntos = new ArrayList<>();
		lista_conjuntos.add(s1);
		lista_conjuntos.add(s2);
		lista_conjuntos.add(s3);
		System.out.println(lista_conjuntos);
		System.out.println(OperacionesColCorr.superInterseccion(lista_conjuntos));
		
		//d
		System.out.println("\nPRUEBA: eliminarConjDePares");
		Set<Integer> p1 = new HashSet<>();
		p1.add(4);
		p1.add(8);
		p1.add(2);
		Set<Integer> p2 = new HashSet<>();
		p2.add(8);
		p2.add(6);
		p2.add(3);
		Set<Integer> p3 = new HashSet<>();
		p3.add(1);
		p3.add(2);
		p3.add(8);
		
		List<Set<Integer>> lista_pares = new ArrayList<>();
		lista_pares.add(p1);
		lista_pares.add(p2);
		lista_pares.add(p3);
		System.out.println(lista_pares);
		OperacionesColCorr.eliminarConjDePares(lista_pares);
		System.out.println(lista_pares);
	}

}
