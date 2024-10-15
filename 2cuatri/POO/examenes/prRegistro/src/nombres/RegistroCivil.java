package nombres;

import java.io.IOException;
import java.nio.file.Path;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class RegistroCivil {
	private String estado;
	private SortedMap<Nombre, SortedMap<Integer, Integer>> registro;
	
	public RegistroCivil(String codigo, String fichero) {
		if(codigo.isEmpty() || codigo == null) {
			throw new RegistroCivilException("El codigo esta vacio o es nulo");
		}
		this.estado = codigo;
		registro = new TreeMap<>();
		leerFichero(fichero);
	}
	private void leerFichero(String fichero) {
		Path path = Path.of(fichero);
		try (Scanner sc = new Scanner(path)){
			while(sc.hasNextLine()) {
				procesar(sc.nextLine());
			}
		} catch (IOException e) {
			throw new RegistroCivilException("No puede abrirse el fichero " + fichero);
		}
	}
	
	private void procesar(String linea) {
		try(Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("[;]");
			String estado = sc.next();
			if(this.estado.equals(estado)) {
				char genero = sc.next().toCharArray()[0];		// esto es asi??
				int ano = sc.nextInt();
				String nombre = sc.next();
				int num_repe = sc.nextInt();
				
				Nombre n = new Nombre(genero, nombre);
//				System.out.println(n);
				agregar(n,ano,num_repe);
			}
		} catch (NoSuchElementException e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void agregar(Nombre nombre, int ano, int repe) {
		SortedMap<Integer, Integer> map = registro.getOrDefault(nombre, new TreeMap<>());
		map.put(ano, repe);
		registro.put(nombre, map);
	}
	public String getEstado() {
		return estado;
	}
	public SortedMap<Nombre, SortedMap<Integer, Integer>> getRegistro() {
		return registro;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(estado + "\n");
		for(Nombre n:registro.keySet()) {
			sb.append(n+":\t\t");
			sb.append(registro.get(n) + "\n");
		}
		return sb.toString();
	}
	
	public SortedSet<String> selecciona(Filtro f){
		SortedSet<String> s = new TreeSet<>();
		for (Nombre n : registro.keySet()) {
			if(f.criterio(n)) {
				s.add(n.getNombre());
			}
		}
		return s;
	}
	
	
}
