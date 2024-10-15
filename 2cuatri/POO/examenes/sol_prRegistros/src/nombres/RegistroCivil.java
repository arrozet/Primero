package nombres;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class RegistroCivil {
	private String estado;
	private SortedMap<Nombre, SortedMap<Integer, Integer>> registro;

	public RegistroCivil(String estado, String fichero) {
		if (estado == null || estado.length() == 0) {
			throw new RegistroCivilException("ERROR: el nombre del estado no puede estar vacío.");
		}
		this.estado = estado;
		registro = new TreeMap<>();
		leerFichero(fichero);
	}


	private void leerFichero(String fichero) {
		try (Scanner sc = new Scanner(new File(fichero))) {
			while (sc.hasNextLine()) {
				procesar(sc.nextLine());
			}
		} catch (FileNotFoundException e) {
			throw new RegistroCivilException("ERROR: el fichero " + fichero + " no se ha podido abrir.");
		}
	}

	private void procesar(String linea) {
		String[] datos = linea.split("[;]");
		if (datos[0].equals(estado)) {
			try {
				int año = Integer.parseInt(datos[2]);
				int numero = Integer.parseInt(datos[4]);
				if (datos[1].length()!=1) {
					throw new RegistroCivilException("ERROR: género 'F' o 'M'");
				} 
				Nombre n = new Nombre(datos[3], datos[1].charAt(0));
				agregar(n, año, numero);
			} catch (ArrayIndexOutOfBoundsException e) {
				// Ignorar
				System.err.println(linea);
			} catch (NumberFormatException e) {
				// Ignorar
				System.err.println(linea);
			} catch (RegistroCivilException e) {
				// Ignorar
				System.err.println(linea);
			}
		}
	}

	private void agregar(Nombre nombre, int a, int num) {
		SortedMap<Integer, Integer> map = registro.get(nombre);
		if (map==null) {
			map = new TreeMap<>();
			registro.put(nombre, map);
		}
		map.put(a, num);
		
	}

	public String getEstado() {
		return estado;
	}

	public Set<Nombre> getNombres() {
		return registro.keySet();
	}

	public SortedSet<String> selecciona(Filtro f) {
		SortedSet<String> conjunto = new TreeSet<>();
		for (Nombre nombre : this.getNombres())
			if (f.criterio(nombre)) {
				conjunto.add(nombre.getNombre());
			}
		return conjunto;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder(estado);
		sb.append("\n");
		Set<Nombre> nombres = registro.keySet();
		for (Nombre nombre : nombres) {
			sb.append(nombre);
			sb.append(":\t");
			sb.append(registro.get(nombre));
			sb.append("\n");
		}
		return sb.toString();
	}
}
