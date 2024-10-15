package parrillatv;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProgramacionTV {
	protected Map<String, SortedSet<ProgramaTV>> cadenas;
	
	public ProgramacionTV() {
		cadenas = new HashMap<>();
	}
	
	public void agregar(String cadenaTV, ProgramaTV prog) {
		SortedSet<ProgramaTV> s_aux = new TreeSet<>();
		SortedSet<ProgramaTV> s = cadenas.getOrDefault(cadenaTV, s_aux);
		s.add(prog);
		cadenas.put(cadenaTV, s);
	}
	
	public void leerProgramas(String fichero) {
		Path fichero_path = Path.of(fichero);
		try(Scanner sc = new Scanner(fichero_path)){
			while(sc.hasNextLine()) {
				procesarLinea(sc.nextLine());
			}
		} catch (IOException e) {
			System.err.println("ERROR: no se puede leer el fichero " + fichero + "\n" + e.getMessage());
		}
	}
	
	private void procesarLinea(String linea) {
		try(Scanner sc = new Scanner(linea)) {
			sc.useDelimiter("[>@:-]+");
			while(sc.hasNext()) {
				String cadena = sc.next();
				String programa = sc.next();
				int hora = sc.nextInt();
				int minuto = sc.nextInt();
				int duracion = sc.nextInt();
				
				this.agregar(cadena, new ProgramaTV(programa, new Hora(hora, minuto), duracion));
			}
		} catch (InputMismatchException e) {
			System.err.println("El dato a convertir no es el esperado \n" + e.getMessage());
		} 
		catch (NoSuchElementException ee) {
			System.err.println("No hay más elementos a procesar \n" + ee.getMessage());
		}
	}
	
	private String imprimirCadenas(Map<String, SortedSet<ProgramaTV>> cadenas) {
		StringBuilder res = new StringBuilder();
		for (String cad : cadenas.keySet()) {
			SortedSet<ProgramaTV> s = cadenas.get(cad);
			res.append(cad + ": \n");
			for (ProgramaTV programa : s) {
				res.append("\t" + programa + "\n");
			}
		}
		
		return res.toString();
	}
	
	public void mostrarProgramas(String fichero) {
		try(PrintWriter pw = new PrintWriter(fichero)){
			pw.println(imprimirCadenas(cadenas));
		
		} catch (FileNotFoundException e) {
			System.err.println("ERROR: no se pudo encontrar el fichero " + fichero);
		}
	}
	
	public void mostrarProgramas(PrintWriter pw) {
		pw.println(imprimirCadenas(cadenas));
	}
	
	public boolean esConsistente(String cadenaTV) {
		boolean res = true;
		if(!cadenas.containsKey(cadenaTV)) {
			throw new ProgramacionTVException("ERROR: " + cadenaTV + " no aparece en la parrilla");
		}
		
		SortedSet<ProgramaTV> s = cadenas.get(cadenaTV);
		Iterator<ProgramaTV> iter = s.iterator();
		
		Hora horaFin = iter.next().getHoraFin();
		while(res && iter.hasNext()) {
			ProgramaTV p = iter.next();
			Hora horaInicio = p.getHoraInicio();
			if(horaFin.compareTo(horaInicio) > 0) {	// si la h_fin(anterior) es posterior a h_in actual
				res=false;
			}
			else {
				horaFin = p.getHoraFin();	// la nueva h_fin es la actual
			}
		}
		
		return res;
	}
	
	public SortedSet<ProgramaTV> sugerencias(SugerenciasTV seleccion){
		SortedSet<ProgramaTV> todos_programas = new TreeSet<>();
		for(SortedSet<ProgramaTV> s : cadenas.values()) {
			for(ProgramaTV p : s) {
				todos_programas.add(p);
			}
		}
		return seleccion.sugerencias(todos_programas);
	}
}
