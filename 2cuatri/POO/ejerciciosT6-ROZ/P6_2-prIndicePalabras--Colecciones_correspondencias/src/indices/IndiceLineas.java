package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeMap;
import java.util.TreeSet;

public class IndiceLineas extends IndiceAbstracto{
	private SortedMap<String, SortedSet<Integer>> indice;
	
	public IndiceLineas() {
		indice = new TreeMap<>();
	}
	@Override
	public void resolver(String del) {
		SortedSet<Integer> s;
		int cont=0;
		
		indice.clear();
		for (String frase : frases) {
			try (Scanner sc = new Scanner(frase.toLowerCase())) {
				sc.useDelimiter(del);
				cont++;
				while(sc.hasNext()) {
					String clave = sc.next();
					SortedSet<Integer> s_aux = new TreeSet<>();
					
					s = indice.getOrDefault(clave, s_aux);
					s.add(cont);
					indice.put(clave, s);
				}
			}
		}
		
	}

	@Override
	public void presentarIndice(PrintWriter pw) {
		for(Map.Entry<String,SortedSet<Integer>> par:indice.entrySet()) {
			StringJoiner sj = new StringJoiner(", ", "<", ">");
			for(Integer entero: par.getValue()) {
				sj.add(entero.toString());
			}
			pw.format("%-15s%s\n", par.getKey(), sj.toString());
//			pw.println(par.getKey()+":\t"+par.getValue());
		}
	}
	
}
