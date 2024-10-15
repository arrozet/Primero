package ejercicios_tema4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
//import java.util.Scanner;
//import java.util.InputMismatchException;
//import java.util.Locale;
//import java.util.NoSuchElementException;
//import java.util.Scanner;
import java.util.StringJoiner;

public class Asignatura {
	private ArrayList<Estudiante> estudiantes;
	
	public Asignatura() {
		estudiantes = new ArrayList<>();
	}
	
	public void escribirEstudiantes(String n_fichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(n_fichero)){
			for(int i=0; i<estudiantes.size(); i++) {
				pw.println(estudiantes.get(i));
			}
		}
		catch (FileNotFoundException e) {
			System.err.println("ERROR. No se puede escribir en el fichero: "+e.getMessage());
		}
	}
	
	public void leerEstudiantes(String n_fichero) throws EstudianteException {
//		VERSIÓN 1 - FILES
		Path fichero = Path.of(n_fichero);
		try (BufferedReader br = Files.newBufferedReader(fichero)){
			String linea = br.readLine();
			while(linea != null) {
				try {
					añadirEstudiante(linea);
				} catch (EstudianteException e) {
					System.err.println(e.getMessage());
				}
				linea = br.readLine();
			}
			
		} catch (IOException e) {
			System.err.println("ERROR. No se puede leer el fichero " + n_fichero);
		}
//		
//		VERSIÓN 2 - SCANNER
//		Path fichero = Path.of(n_fichero);
//		try (Scanner sc = new Scanner(fichero)){
//			
//			while(sc.hasNextLine()) {
//				try {
//					añadirEstudiante(sc.nextLine());
//				} catch (EstudianteException e) {
//					System.err.println(e.getMessage());
//				}
//			}
//			
//		} catch (IOException e) {
//			System.err.println("ERROR. No se puede leer el fichero " + n_fichero);
//		}
	}
	
	public void almacenarEstudiante(Estudiante e) {
		int pos = estudiantes.indexOf(e);
		
		if(pos == -1) {
			estudiantes.add(e);
		}
		else {
			estudiantes.set(pos, e);
		}
	}
	
	public void añadirEstudiante(String info) throws EstudianteException {
		String dni, nombre;
		double notas=0;
//		//VERSIÓN 1 - SCANNER
//		Scanner sc = new Scanner(info);
//		
//		sc.useDelimiter(";");
//		sc.useLocale(Locale.ENGLISH);
//		
//		try {
//			dni = sc.next();
//			nombre = sc.next();
//			for(int i=0; i<3; i++) {
//				notas += sc.nextDouble();
//			}
//			notas /= 3;
//			almacenarEstudiante(new Estudiante(dni, nombre, notas));
//			sc.close();
//		} catch (InputMismatchException e) {
//			throw new EstudianteException("Algún dato no es del tipo correcto");
//		} catch (NoSuchElementException e) {
//			throw new EstudianteException("Faltan elementos. La información está incompleta");
//		}
		
		// VERSIÓN 2 - SPLIT
		String[] tokens = info.split(";"); 
		try {
			dni = tokens[0];
			nombre = tokens[1];
			for(int i=0; i<3; i++) {
				notas += Double.parseDouble(tokens[i+2]);
			}
			notas /= 3;
			almacenarEstudiante(new Estudiante(dni, nombre, notas));
		} catch (NumberFormatException e) {
			throw new EstudianteException("Algún dato no es del tipo correcto." + info);
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new EstudianteException("Faltan elementos. La información está incompleta " + info);
		}catch (EstudianteException e) {
			throw new EstudianteException(e.getMessage() + ": " + info);
		}
		
		
	}
	
	// hay que hacerlo con String, StringBuilder y StringJoiner
	
	// String
//	@Override
//	public String toString() {
//		String res = "{";
//		for(int i=0; i<estudiantes.size(); i++) {
//			if(i==estudiantes.size()-1) {
//				res += estudiantes.get(i);
//			}
//			else {
//				res += estudiantes.get(i) + " - ";
//			}
//		}
//		res += "}";
//		
//		return res;
//	}
	
	// StringBuilder
//	@Override
//	public String toString() {
//		StringBuilder res = new StringBuilder("{");
//		for(int i=0; i<estudiantes.size(); i++) {
//			if(i==estudiantes.size()-1) {
//				res.append(estudiantes.get(i));
//			}
//			else {
//				res.append(estudiantes.get(i) + " - ");
//			}
//		}
//		res.append("}");
//		return res.toString();
//	}
	
	// StringJoiner
	@Override
	public String toString() {
		StringJoiner res = new StringJoiner(" - ", "{", "}");
		String aux = "";
		for(int i=0; i<estudiantes.size(); i++) {
			aux = "";
			aux += estudiantes.get(i);
			res.add(aux);
		}
		return res.toString();
	}
}
