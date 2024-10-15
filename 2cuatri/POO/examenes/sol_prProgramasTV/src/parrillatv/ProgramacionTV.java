package parrillatv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Clase para mantener información sobre la parrilla de TV de varias cadenas de televisión.
 * La información se organizará como una correspondencia entre el nombre de cada cadena (String), y 
 * una colección ordenada de programas de TV emitidos por dicha cadena. 
 * 
 * @author POO
 *
 */
public class ProgramacionTV {
	/**
	 * Estructura para almacenar los programas (ordenados según su hora de inicio), y asociados 
	 * a la cadena (String) en los que se emiten.
	 */
	protected Map<String, SortedSet<ProgramaTV>> cadenas;
	
	/**
	 * Constructor para crear parrillas de TV, inicialmente vacías.
	 */
	public ProgramacionTV() {
		cadenas = new HashMap<>();
	}

	/**
	 * Método para leer los datos de un fichero de texto con información sobre programas, e
	 * incorporarlos a la estructura que almacena la parrilla de TV.
	 * 
	 * @param fichero	Nombre del fichero de texto con la información
	 * @throws IOException 
	 */
	public void leerProgramas(String fichero) throws IOException {
		/*
		try(Scanner scFichero = new Scanner(Path.of(fichero))){
			leerProgramas(scFichero);
		}
		*/
		try {
			List<String> lineas = Files.readAllLines(Path.of(fichero));
			leerProgramas (lineas);
		} catch (IOException e) {
			System.err.println("ERROR:" + e.getMessage());
		}
		
	}

	/**
	 * Método auxiliar para incorporar a la correspondencia cadenas (Map) los programas que se proporcionan
	 * en una lista de líneas con el formato siguiente:
	 * 		Nombre de la cadena>Nombre del programa@hh:mm-minutos
	 * En caso de que el formato de una línea sea incorrecto, esta se obvia y se sigue con el resto de líneas.
	 * 
	 * @param lineas	Lista de líneas con información sobre cadenas y programas.
	 */
	private void leerProgramas(List<String> lineas) {
		for (String linea : lineas)
			leerLinea(linea);
	}
	
	/**
	 * Método auxiliar para incorporar a la correspondencia cadenas (Map) los programas que se leen del scanner sc
	 * El formato de las líneas del scanner ha de ser el siguiente:
	 * 		Nombre de la cadena>Nombre del programa@hh:mm-minutos
	 * En caso de que el formato de una línea sea incorrecto, esta se obvia y se sigue con el resto de líneas.
	 * 
	 * @param sc	 	Scanner con la información sobre cadenas y programas.
	 */
	@SuppressWarnings("unused")
	private void leerProgramas(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			leerLinea(linea);
		}
	}

	/**
	 * Método auxiliar para incorporar a la corresondencia cadenas (Map) los programas que se lean de la
	 * línea que se pasa como parámetro. La línea debe tener el siguiente formato:
	 * 		Nombre de la cadena>Nombre del programa@hh:mm-minutos
	 * En caso de que el formato de la línea no sea el correcto, se obvia.
	 * @param linea		Línea incluyendo información sobre un programa de una cadena
	 */
	private void leerLinea(String linea) {
		try (Scanner scLinea = new Scanner(linea)) {
			scLinea.useDelimiter("[>@:-]+");
			String nombreCadena = scLinea.next();
			String nombrePrograma = scLinea.next();
			int hh = scLinea.nextInt();
			int mm = scLinea.nextInt();	
			int duracion = scLinea.nextInt();
			Hora horaInicio = new Hora(hh,mm);
			ProgramaTV prog = new ProgramaTV(nombrePrograma,horaInicio,duracion);
			agregar(nombreCadena,prog);
		} catch (NoSuchElementException | ProgramacionTVException excep) {
			// En caso de que exista un error de formato en la línea, 
			// este se obvia y se siguen procesando el resto de líneas.
		}
	}
	
	/**
	 * Se añade a la cadena proporcionada como primer argumento, el programa que se pasa como 
	 * segundo argumento. 
	 * 
	 * @param cadenaTV	Nombre de la cadena
	 * @param prog			Programa a añadir a la parrilla de esa cadena
	 */
	public void agregar(String cadenaTV, ProgramaTV prog) {
		SortedSet<ProgramaTV> programas = cadenas.get(cadenaTV);
		if (programas == null) {
			programas = new TreeSet<>();
			cadenas.put(cadenaTV, programas);
		}
		programas.add(prog);
	}
	
	/** 
	 * Método que indica si la parrilla de una cadena determinada (argumento) es consistente.
	 * Una parrilla es consistente cuando ningún programa tiene una hora de finalización posterior a la
	 * hora de inicio del siguiente programa. En caso de que la cadena de TV no está en la parrilla, se
	 * lanzará una excepción ProgramacionTVException.
	 * 
	 * @param cadenaTV	Nombre de la cadena a comprobar
	 * @return			true 	si la parrilla es consistente y false en caso contrario
	 */
	public boolean esConsistente(String cadenaTV) {
		boolean consistente = true;
		SortedSet<ProgramaTV> programas = cadenas.get(cadenaTV);
		if (programas == null) throw new ProgramacionTVException("La cadena de TV indicada no aparece en la parrilla");
		Iterator<ProgramaTV> it = programas.iterator();
		// if (!it.hasNext()) throw new ProgramacionTVException("No hay programas asociados a la cadena" + cadenaTV);
		ProgramaTV prog = it.next();
		while (it.hasNext() && consistente) {
			ProgramaTV progSiguiente = it.next();
			consistente = prog.getHoraFin().compareTo(progSiguiente.getHoraInicio()) <= 0;
			prog = progSiguiente;
		}
		return consistente;
	}
	
	/**
	 * Método que devuelve un conjunto ordenado con los programas que establezca el objeto
	 * seleccion que se pasa como argumento y que implementa un criterio de selección.
	 * @param seleccion	Criterio de selección de programas
	 * @return						Conjunto ordenado de programas seleccionados
	 */
	public SortedSet<ProgramaTV> sugerencias(SugerenciasTV seleccion) {
		Collection<ProgramaTV> todosProgs = new HashSet<>();
		for (Collection<ProgramaTV> progs : cadenas.values()) {
			todosProgs.addAll(progs);
		}
		return seleccion.sugerencias(todosProgs);
	}
	
	/**
	 * Método que muestra la información de la parrilla en el fichero que se pasa como argumento
	 * @param nomFichero	Nombre del fichero donde se mostrará la parrilla
	 * @throws FileNotFoundException
	 */
	public void mostrarProgramas(String nomFichero) throws FileNotFoundException {
		try(PrintWriter pwFichero = new PrintWriter(nomFichero)){
			mostrarProgramas(pwFichero);
		}
	}

	/**
	 * Muestra sobre el flujo de salida que se pasa como argumento la información de la 
	 * parrilla televisiva, con el siguiente formato:
	 * Nombre de la cadena1:
	 * 		Programa11
	 * 		Programa12
	 * 		...
	 * 		Programa1N1
	 * Nombre de la cadena2:
	 * 		Programa21
	 * 		Programa22
	 * 		...
	 * 		Programa2N2
	 * ...
	 * 
	 * @param pw
	 */
	public void mostrarProgramas(PrintWriter pw) {
		for (String cadenaTV : cadenas.keySet()) {
			pw.println(cadenaTV + ":");
			for (ProgramaTV prog : cadenas.get(cadenaTV)) {
				pw.println("\t" + prog);
			}
		}
	}
	
}
