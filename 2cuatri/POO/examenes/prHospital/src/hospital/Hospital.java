//APELLIDOS Y NOMBRE: 		Oliva Zamora, Rubén
//GRADO: 					Ingeniería del software
//GRUPO: 					A

package hospital;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.StringJoiner;
import java.util.TreeSet;

public class Hospital {
	protected Map<Paciente, Habitacion> habitaciones;
	protected SortedSet<Habitacion> libres;
	private int plantas;
	private String nombre;
	
	public Hospital(String nombre, int plantas, int habitacionesPorPlanta) throws HospitalException {
		if(nombre == null || nombre.length()==0) {
			throw new HospitalException("El nombre es null o vacio. Introduce un nombre valido");
		}
		else if (plantas <= 0 || habitacionesPorPlanta <=0) {
			throw new HospitalException("El numero de plantas y/o habitaciones debe ser positivo");
		}
		
		this.libres = new TreeSet<>();
		for(int i = 0; i<plantas; i++) {
			for(int j=0; j<habitacionesPorPlanta; j++) {
				libres.add(new Habitacion(i, j));
			}
		}
		
		this.nombre = nombre;
		this.plantas = plantas;
		this.habitaciones = new HashMap<>();
		
	}
	
	public void alta(Paciente p) throws HospitalException {
		if(p==null || habitaciones.containsKey(p) || libres.isEmpty()) {
			throw new HospitalException("El paciente no es válido o ya está en el hospital");
		}
		Habitacion h_libre =  libres.first();
//		System.out.println(habitaciones.containsKey(p));
		habitaciones.put(p, h_libre);
		libres.remove(h_libre);
	}
	
	public Paciente baja(String nuss) {
		Iterator<Paciente> iter = habitaciones.keySet().iterator();
		boolean encontrado = false;
		Paciente p = null;
		while(!encontrado && iter.hasNext()) {
			p = iter.next();
			if(p.getNuss().equals(nuss)) {
				encontrado = true;
			}
			else {
				p=null;
			}	
		}
		if(habitaciones.keySet().contains(p)) {
			libres.add(habitaciones.get(p));	// añadido despues
			habitaciones.remove(p);
		}
		
		return p;
	}
	
	public ArrayList<Paciente> seleccion(Criterio c) {
		ArrayList<Paciente> array_p = new ArrayList<>();
		for (Paciente p : habitaciones.keySet()) {
			if(c.cumpleCondicion(p, habitaciones.get(p))) {
				array_p.add(p);
			}
		}
		return array_p;
	}
	
	public void leePacientes(String nombreDeFichero) throws HospitalException {
		Path path = Path.of(nombreDeFichero);
		try(Scanner sc = new Scanner(path)){
			leePacientes(sc);
		} catch (IOException e) {
			System.err.println("ERROR: no se pudo leer el archivo " + nombreDeFichero);
		}
	}
	
	public void leePacientes(Scanner sc) throws HospitalException {
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
//			System.out.println(linea);
			try(Scanner sc2 = new Scanner(linea)){
				
				sc2.useDelimiter("[,]");
				String nombre = sc2.next();
				String apellido = sc2.next();
				String nuss = sc2.next();
				int ano = sc2.nextInt();

				Paciente p_añadir = new Paciente(nombre, apellido, nuss, ano);
				alta(p_añadir);
//					System.out.println(p_añadir);
			}catch (InputMismatchException e) {
//				System.err.println("ERROR: uno de los datos no coincide con el esperado " + e.getMessage());
			}catch (NoSuchElementException ee) {
//				System.err.println("ERROR: no hay siguiente elemento "+ ee.getMessage());
			}catch (HospitalException eee) {
//				System.err.println("ERROR: el paciente["+ linea +"]no puede ser añadido. " + eee.getMessage());
			}
		}
	}
	
//	private String pacientesPorPlanta() {
//		StringBuilder sb = new StringBuilder();
//		int cont = 0;
//		while(cont<habitaciones.keySet().size()) {
//			sb.append("Planta " + cont + ":\n");
//			ArrayList<Paciente> estaPlanta = this.seleccion(new MismaPlanta(cont));
//			for (Paciente p : estaPlanta) {
//				sb.append(p + "\n");
//			}
//			cont++;
//		}
//		return sb.toString();
//	}
	
	public void escribePacientes(String f) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(f)){
			escribePacientes(pw);
		}
	}
	
	public void escribePacientes(PrintWriter pw) {
//		pw.println(pacientesPorPlanta());
		for (int i = 0; i < plantas; i++) {
			pw.println("Planta " + i + ":");
			for (Paciente c : seleccion(new MismaPlanta(i)))
				pw.println(c);
		}
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",", "[", "]");
		sj.add("nombre=<" + nombre + ">");
		sj.add("pacientes=<" + habitaciones.toString() + ">");
		sj.add("libres=<" + libres.toString() + ">");
		return sj.toString();
	}

}
