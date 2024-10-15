package alturas;


import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Mundo {
	private List<Pais> paises;
	
	public static <K,V> void presentaEnPW(PrintWriter pw, Map<K, V> map) {
		if(!map.isEmpty()) {
			for (K element : map.keySet()) {
				pw.println(element + "\t" + map.get(element));
			}
		}
		
	}
	
	public static <K, V> void presentaEnConsola(Map<K, V> map) {
		PrintWriter pw = new PrintWriter(System.out, true);
		
		presentaEnPW(pw, map);
	}
	
	public Mundo() {
		paises = new ArrayList<>();
	}

	public List<Pais> getPaises() {
		return paises;
	}
	
	public void cargar(String file){
		paises.clear();
		
		Path fichero = Path.of("alturas.txt");
		try(Scanner sc = new Scanner(fichero)){
			while(sc.hasNextLine()) {
				procesarLinea(sc.nextLine());
			}
		}catch (IOException e) {
			System.err.println("No se pudo leer el fichero");
		}
	}
	
	private void procesarLinea(String linea) {
		try(Scanner sc = new Scanner(linea)){	
			sc.useDelimiter(",");
			sc.useLocale(Locale.ENGLISH);
			paises.add(new Pais(sc.next(), sc.next(),sc.nextDouble()));
		} 
		catch (NoSuchElementException e) {
		}
		catch(NumberFormatException ee) {
			
		}
	
	}
	
	public SortedMap<String, Integer> numeroDePaisesPorContinente(){
		SortedMap<String, Integer> map = new TreeMap<>();
		for(Pais pais:paises) {
			int frec=map.getOrDefault(pais.getContinente(),0);
			map.put(pais.getContinente(), frec+1);
		}
		return map;
	}
	
	public SortedMap<Double, List<Pais>> paisesPorAltura(){
		SortedMap<Double, List<Pais>> map = new TreeMap<>();
		for(Pais pais:paises) {
			double altura_truncada = ((int) (pais.getAltura()*10)) /10.0;
			List<Pais> l = map.getOrDefault(altura_truncada, new ArrayList<>());
			l.add(pais);
			map.put(altura_truncada, l);
		}
		
		return map;
	}
	
	public SortedMap<String, SortedSet<Pais>> paisesPorContinente(){
		SortedMap<String, SortedSet<Pais>> map = new TreeMap<>();
		for(Pais pais:paises) {
			SortedSet<Pais> s_aux = new TreeSet<>();
			SortedSet<Pais> s = map.getOrDefault(pais.getContinente(), s_aux);
			s.add(pais);
			map.put(pais.getContinente(), s);
		}
		return map;
	}
	
	public SortedMap<Character, SortedSet<Pais>> paisesPorInicial(){
		SortedMap<Character, SortedSet<Pais>> map = new TreeMap<>();
		for(Pais pais:paises) {
			char primer_letra = pais.getNombre().charAt(0);
			SortedSet<Pais> s_aux = new TreeSet<>();
			SortedSet<Pais> s = map.getOrDefault(primer_letra, s_aux);
			s.add(pais);
			map.put(primer_letra, s);
		}
		return map;
	}
	
	public SortedMap<String, Double> mediaPorContinente(){		// debe usar paisesPorContinente()
		SortedMap<String, Double> map = new TreeMap<>();
		SortedMap<String, SortedSet<Pais>> map_cont = paisesPorContinente();
		for(String continente: map_cont.keySet()) {
			SortedSet<Pais> paises=map_cont.get(continente);
			double media=0;
			for(Pais pais: paises) {
				media+=pais.getAltura();
			}
			media/=paises.size();
			map.put(continente, media);
		}
		return map;
	}
	
	public List<String> continentesConMasPaises(){				// debe usar numerodePaisesPorContinente()
		List<String> lista = new ArrayList<>();
		SortedMap<String, Integer> map_num = numeroDePaisesPorContinente();
		int valor=-1;
		
		
		for(String continente:map_num.keySet()) {
			int valor_nuevo=map_num.get(continente);
			if(valor_nuevo>valor) {
				lista.clear();	// si hay uno nuevo, la lista anterior se vacia (incluso si hay iguales)
				valor=valor_nuevo;
				lista.add(continente);
			}
			else if (valor_nuevo==valor) {
				lista.add(continente);
			}
		}
		
		return lista;
	}
	
	public SortedSet<Pais> paisesOrdenadosPorAltura(){
		Comparator<Pais> ordAlt = new OrdenAlternativoPais();
		SortedSet<Pais> s = new TreeSet<>(ordAlt);
		s.addAll(paises);
		return s;
	}
	
	public SortedMap<String, SortedSet<Pais>> paisesPorContinenteAltura(){
		// copypaste de paisesPorContinente
		SortedMap<String, SortedSet<Pais>> map = new TreeMap<>();
		for(Pais pais:paises) {
			SortedSet<Pais> s_aux = new TreeSet<>(new OrdenAlternativoPais());
			SortedSet<Pais> s = map.getOrDefault(pais.getContinente(), s_aux);
			s.add(pais);
			map.put(pais.getContinente(), s);
		}
		return map;
	}
	
	public SortedMap<String, SortedSet<Pais>> paisesPorContinenteAlturaDec(){
		SortedMap<String, SortedSet<Pais>> map = new TreeMap<>();
		for(Pais pais:paises) {
			SortedSet<Pais> s_aux = new TreeSet<>(new OrdenAlternativoPais().reversed());
			SortedSet<Pais> s = map.getOrDefault(pais.getContinente(), s_aux);
			s.add(pais);
			map.put(pais.getContinente(), s);
		}
		return map;
	}
}
