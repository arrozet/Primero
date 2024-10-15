package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class IndiceContador extends IndiceAbstracto {
	private SortedMap<String, Integer> indice;

	public IndiceContador() {
		super();
		indice = new TreeMap<>();
	}

	@Override
	public void resolver(String delim) {
		indice.clear();
		for(String linea : texto) {
			String[] palabras = linea.split(delim);
			for(String p: palabras) {
				anyadir(p);
			}
		}
	}
	
	private void anyadir(String palabra) {
		if (!palabra.isEmpty() ) {
			palabra = palabra.toLowerCase();
			Integer cnt = indice.getOrDefault(palabra, 0);
			indice.put(palabra, cnt+1);
		}
	}

    @Override
	public void presentarIndice(PrintWriter pw) {
		// Alternativa usando keySet (conjunto de claves)
    	// for(String palabra : indice.keySet()) {
		//	  pw.printf("%-10s %4d\n", palabra, indice.get(palabra));
		// }
    	// Implementación usando entrySet (conjunto de pares clave-valor)
		for(Map.Entry<String,Integer> e : indice.entrySet()) {
			pw.printf("%-10s %4d\n", e.getKey(), e.getValue());
		}
	}
}
