package indices;

import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class IndiceContador extends IndiceAbstracto{
	private SortedMap<String, Integer> indice;
	
	public IndiceContador() {
		indice = new TreeMap<>();
	}
	
	@Override
	public void resolver(String del) {
		int frec;
		indice.clear();
		for (String frase : frases) {
			try (Scanner sc = new Scanner(frase.toLowerCase())) {
				sc.useDelimiter(del);
				while(sc.hasNext()) {
					String clave = sc.next();
					frec = indice.getOrDefault(clave, 0);
					indice.put(clave, frec+1);
				}
			}
		}
		
		
	}
	
	@Override
	public void presentarIndice(PrintWriter pw) {
		for(Map.Entry<String,Integer> par:indice.entrySet()) {
			pw.format("%-15s%d\n", par.getKey(), par.getValue());
//			pw.println(par.getKey()+":\t"+par.getValue());
		}
	}
}
