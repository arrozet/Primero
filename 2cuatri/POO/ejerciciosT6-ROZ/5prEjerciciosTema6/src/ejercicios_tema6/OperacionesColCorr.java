package ejercicios_tema6;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class OperacionesColCorr {
	// 4a
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
	
	// 4b
	public static void eliminarCadenas(Set<String> conjunto, String cadena) {
		Iterator<String> iter = conjunto.iterator();
		while(iter.hasNext()) {
			String aux = iter.next();
			if(aux.startsWith(cadena)){
				iter.remove();
			}
		}
	}
	
	// 5a
	public static void intercambiarContiguos(List<Integer> lista) {
		int tam = lista.size();
		if(tam%1==1) {	// si la lista es impar, que no se toque el ultimo
			tam--;
		}
		
		int i=0;
		while(i<tam) {
			if((i+1)<tam) {	// si no se sale del indice la comparación
				int aux = lista.get(i);
				lista.set(i, lista.get(i+1));
				lista.set(i+1, aux);
				i+=2;
			}
			else {
				i++;	// si se sale, es que el siguiente es exactamente tam
			}
		}
		
		}
	
	// 5b
	public static void eliminarDuplicados(List<String> lista) {
		lista.sort(null);
		
		int i=0;
		while(i<lista.size()) {
			if((i+1)<lista.size()) {	// si no se sale del indice la comparación
				if(lista.get(i).equals(lista.get(i+1))) {
					lista.remove(i);
				}
				else {	// al eliminar un elemento, se desplaza toda la fila 1 pos a la izq. mirar la siguiente pos seria mirar i+=2
					i++;
				}
			}
			else {
				i++;
			}
		}
	}
	
	//5c
	public static Set<Integer> superInterseccion(List<Set<Integer>> lista) {
		Set<Integer> res = new HashSet<>();
		Iterator<Set<Integer>> iter = lista.iterator();
		
		res.addAll(iter.next());	// se añade al resultado el primer conjunto
		while(iter.hasNext()) {
			res.retainAll(iter.next());	// se hace la interseccion de todos, iterativamente
		}
		
		return res;
	}
	
	
	//5d
	public static void eliminarConjDePares(List<Set<Integer>> lista) {
		Iterator<Set<Integer>> iter = lista.iterator();
		
		while(iter.hasNext()) {
			if(todosPares(iter.next())) {
				iter.remove();
			}
		}
	}
	
	private static boolean todosPares(Set<Integer> conjunto) {
		
		boolean par = true;
		Iterator<Integer> iter_conj = conjunto.iterator();
		
		while(iter_conj.hasNext() && par) {
			if(iter_conj.next()%2!=0) {	// si uno no es par, que se pare
				par=false;
			}
		}
		return par;
	}
}
