package hospital;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
//import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Hospital {
	protected Map<Paciente, Habitacion> habitaciones;
	protected SortedSet<Habitacion> libres;
	private int plantas;
	private String nombre;

	/**
	 * Crea un hospital.
	 * 
	 * @param nombre       nombre del hospital
	 * @param plantas      número de plantas con que se crea el hospital
	 * @param habitaciones número de habitaciones por planta con que se crea el
	 *                     hospital
	 * @throws HospitalException si el nombre es null o vacío o si el número de
	 *                           plantas o habitaciones por planta es negativo
	 */
	public Hospital(String nombre, int plantas, int habitaciones) throws HospitalException {
		if (nombre == null || nombre.isEmpty() || plantas <= 0 || habitaciones <= 0)
			throw new HospitalException("Nombre incorrecto");
		this.nombre = nombre;
		this.habitaciones = new HashMap<>();
		libres = new TreeSet<>();
		for (int p = 0; p < plantas; p++)
			for (int h = 0; h < habitaciones; h++)
				libres.add(new Habitacion(p, h));
		this.plantas = plantas;
	}

	/**
	 * Ingresa un nuevo paciente en el hospital. Se le asigna una habitación libre.
	 * 
	 * @param p paciente a ingresar
	 * @throws HospitalException si el paciente es null o ya está ingresado en el
	 *                           hospital, o si no hay habitaciones libres
	 */
	public void alta(Paciente p) throws HospitalException {
		if (p == null)
			throw new HospitalException("paciente null");
		if (habitaciones.keySet().contains(p))
			throw new HospitalException("paciente ya ingresado");
		if (libres.size() == 0)
			throw new HospitalException("no hay habitaciones libres");
//		Iterator<Habitacion> it = libres.iterator();
//		Habitacion h = it.next();
//		it.remove();
		Habitacion h = libres.first();
		libres.remove(h);
		habitaciones.put(p, h);
	}

	/**
	 * Libera la habitación ocupada por un paciente.
	 * 
	 * @param nuss NUSS del paciente a dar de baja
	 * @return el paciente dado de baja, null si no hay paciente con dicho NUSS
	 */
	public Paciente baja(String nuss) {
		Paciente p = null;
		boolean encontrado = false;
		Iterator<Paciente> it = habitaciones.keySet().iterator();
		while (it.hasNext() && !encontrado) {
			p = it.next();
			encontrado = p.getNuss().equals(nuss);
		}
		if (encontrado) {
			libres.add(habitaciones.get(p));
			habitaciones.remove(p);
		}
		return p;
	}

	/**
	 * Devuelve un conjunto con los pacientes de una planta
	 * 
	 * @param p planta de los pacientes a devolver
	 * @return conjunto de pacientes en la planta especificada
	 * 
	 *         <pre>
	 *         public Set<Paciente> planta(int p) {
	 *         	if (p < 0 || p > plantas)
	 *         		throw new IllegalArgumentException();
	 *         	Set<Paciente> set = new HashSet<>();
	 *         	for (Paciente pac : habitaciones.keySet()) {
	 *         		if (habitaciones.get(pac).getPlanta() == p)
	 *         			set.add(pac);
	 *         	}
	 *         	return set;
	 *         }
	 *         </pre>
	 */

	/**
	 * Devuelve un array con los pacientes que cumplen el criterio proporcionado
	 * 
	 * @param criterio Criterio que deben cumplir los pacientes a devolver
	 * @return Paciente[] array de pacientes que cumplen el criterio
	 */
	public Paciente[] seleccion(Criterio criterio) {
		int DEFAULT_SIZE = 10;
		Paciente[] pacientes = new Paciente[DEFAULT_SIZE];
		int numPacientes = 0;
		for (Entry<Paciente, Habitacion> e : habitaciones.entrySet())
			if (criterio.cumpleCondicion(e.getKey(), e.getValue())) {
				if (numPacientes == pacientes.length)
					pacientes = Arrays.copyOf(pacientes, pacientes.length + DEFAULT_SIZE);
				pacientes[numPacientes] = e.getKey();
				numPacientes++;
			}
		return Arrays.copyOf(pacientes, numPacientes);
	}

	/**
	 * Lee la información de pacientes a ingresar en el hospital.
	 * 
	 * @param fileName nombre del fichero del que leer la información
	 */
	public void leePacientes(String fileName) throws FileNotFoundException {
		try (Scanner sc = new Scanner(new File(fileName))) {
			leePacientes(sc);
		}
	}

	private void leePacientes(Scanner sc) {
		while (sc.hasNextLine()) {
			String l = sc.nextLine();
			try (Scanner scc = new Scanner(l)) {
				scc.useDelimiter("[,]");
				String nombre = scc.next();
				String apellidos = scc.next();
				String nuss = scc.next();
				int ano = scc.nextInt();
				alta(new Paciente(nombre, apellidos, nuss, ano));
			} catch (HospitalException | NoSuchElementException | NumberFormatException | IndexOutOfBoundsException e) {
				// se descarta
			}
		}
	}

	/**
	 * Crea un fichero de salida con los pacientes agrupados por planta. Se escribe
	 * un paciente por línea utilizando su representación como cadena de caracteres.
	 * 
	 * @param fileName nombre del fichero donde escribir la salida
	 * @throws FileNotFoundException
	 */
	public void escribePacientes(String fileName) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(fileName)) {
			escribePacientes(pw);
		}
	}

	private void escribePacientes(PrintWriter pw) {
		for (int i = 0; i < plantas; i++) {
			pw.println("Planta " + i + ":");
			for (Paciente c : seleccion(new MismaPlanta(i)))
				pw.println(c);
		}
	}

	@Override
	public String toString() {
		return "Hospital [nombre=" + nombre + ", pacientes=" + habitaciones + ", libres=" + libres + "]";
	}
}
