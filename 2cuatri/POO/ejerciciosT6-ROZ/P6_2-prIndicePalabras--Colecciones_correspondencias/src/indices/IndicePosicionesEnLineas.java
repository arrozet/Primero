package indices;

import java.io.PrintWriter;
import java.util.Map;
//import java.util.Map.Entry;
import java.util.Scanner;
//import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndicePosicionesEnLineas extends IndiceAbstracto {
	private SortedMap<String, SortedMap<Integer, SortedSet<Integer>>> indice;
	
	public IndicePosicionesEnLineas() {
		indice = new TreeMap<>();
	}
	
	@Override
	public void resolver(String del) {
		SortedMap<Integer,SortedSet<Integer>> m; // map auxiliar
		SortedSet<Integer> s;
		int cont=0;	// contador de lineas
		int pos=0;	// frec de claves
		
		indice.clear();
		for (String frase : frases) {
			try (Scanner sc = new Scanner(frase.toLowerCase())) {
				sc.useDelimiter(del);
				cont++;	// aumentamos linea
				pos=0;	// reiniciamos pos
				while(sc.hasNext()) {
					pos++;
					String clave = sc.next();
					
					SortedMap<Integer, SortedSet<Integer>> m_aux = new TreeMap<>();
					SortedSet<Integer> s_aux = new TreeSet<>();
					
					// pilla el map, y si no hay crea uno y pilla ese
					m = indice.getOrDefault(clave, m_aux);
					s = m.getOrDefault(cont, s_aux);
					s.add(pos);
					m.put(cont, s);
					indice.put(clave, m);
				}
			}
		}
		
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		
		for(Map.Entry<String, SortedMap<Integer, SortedSet<Integer>>> par:indice.entrySet()) {
			pw.println(par.getKey());	// printeo clave
			
			String valores = printearFilaPos(par.getValue());
			pw.printf(valores);
		}
	}
	
	private String printearFilaPos(SortedMap<Integer, SortedSet<Integer>> par) {
		String res="";
		for(Integer fila : par.keySet()) {  // enteros en conjunto filas
			SortedSet<Integer> s = par.get(fila);	// cojo el valor de la fila para el par correspondiente
				StringJoiner sj = new StringJoiner(", ", "<", ">");
				for (Integer entero : s) {
					sj.add(entero.toString());
				}
				res+=String.format("%15s %s\n", fila, sj.toString());
		}
		return res;
	}
}
