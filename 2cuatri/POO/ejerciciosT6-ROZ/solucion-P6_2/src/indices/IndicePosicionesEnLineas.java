package indices;

import java.io.PrintWriter;
import java.util.StringJoiner;
import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class IndicePosicionesEnLineas extends IndiceAbstracto {
	private SortedMap<String, SortedMap<Integer, SortedSet<Integer>>> indice;

	public IndicePosicionesEnLineas() {
		super();
		indice = new TreeMap<>();
	}

	@Override
	public void resolver(String delim) {
		indice.clear();
		int numLinea = 0;
		for (String linea : texto) {
			++numLinea;
			String[] palabras = linea.split(delim);
			int numPos = 0;
			for (String p : palabras) {
				++numPos;
				anyadir(p, numLinea, numPos);
			}
		}
	}

	private void anyadir(String palabra, int numLinea, int numPos) {
		if (!palabra.isEmpty()) {
			palabra = palabra.toLowerCase();
			SortedMap<Integer, SortedSet<Integer>> map = indice.get(palabra); // Se obtiene la correspondencia (valor) asociado a la palabra (clave)
			if (map == null) { // Si map es null, quiere decir que la palabra es la primera vez que aparece en el texto y no hay aún una entrada en el indice para ella.
				map = new TreeMap<>(); 
				indice.put(palabra, map); // Se crea una entrada para la nueva palabra
			}
			SortedSet<Integer> set = map.get(numLinea); // Se obtiene el valor asociado a la línea en la que aparece la palabra
			if (set == null) { // Si set es null, quiere decir que es la primera vez que la palabra aparece en esa línea y, por tanto, hay que crear una entrada para esa línea
				set = new TreeSet<>();
				map.put(numLinea, set);
			}
			set.add(numPos); // Se añade al conjunto la posición que ocupa la palabra dentro de la línea
		}
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		for (Map.Entry<String, SortedMap<Integer, SortedSet<Integer>>> e : indice.entrySet()) {
			pw.println(e.getKey());
			presLnPos(pw, e.getValue());
		}
	}

	private void presLnPos(PrintWriter pw, SortedMap<Integer, SortedSet<Integer>> mp) {
		for (Map.Entry<Integer, SortedSet<Integer>> e : mp.entrySet()) {
			pw.printf("%10s %4d %s\n", "", e.getKey(), col2str(e.getValue()));
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
