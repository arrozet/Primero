package indices;

import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class IndiceLineas extends IndiceAbstracto {
	private SortedMap<String, SortedSet<Integer> > indice;

	public IndiceLineas() {
		super();
		indice = new TreeMap<>();
	}

	
	@Override
	public void resolver(String delim) {
		indice.clear();
		int numLinea = 0;
		indice.clear();
		for(String linea : texto) {
			++numLinea;
			String[] palabras = linea.split(delim);
			for(String p: palabras) {
				anyadir(p, numLinea);
			}
		}
	}
	
	private void anyadir(String palabra, int numLinea) {
		if ( ! palabra.isEmpty() ) {
			palabra = palabra.toLowerCase();
			SortedSet<Integer> set = indice.get(palabra); // Se obtiene el conjunto (valor) asociado a la palabra (clave)
			if (set == null) { // Si set es null, quiere decir que la palabra es la primera vez que aparece en el texto y no hay aún una entrada en el indice para ella.
				set = new TreeSet<>(); // Se crea un conjunto vacío para los números de línea
				indice.put(palabra, set); // Se crea una entrada con la palabra como clave y el valor el conjunto vacío. 
			}
			set.add(numLinea); // Se añade el número de línea al conjunto asociado a la palabra.
		}
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		for(Map.Entry<String, SortedSet<Integer>> e : indice.entrySet()) {
			pw.printf("%-10s %s\n", e.getKey(), col2str(e.getValue()));
		}
	}

	private String col2str(Collection<Integer> c) {
		StringJoiner sj = new StringJoiner(",", "<", ">");
		for (Integer i : c) {
			sj.add(i.toString());
		}
		return sj.toString();
	}
}
