package ejercicios_tema6;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante>{
	private String dni;
	private String nombre;
	private double calificacion;
	
	public Estudiante(String d, String n, double c) throws EstudianteException {
		if (c < 0) {
			throw new EstudianteException("Calificación negativa al crear estudiante");
		}
		dni = d;
		nombre = n;
		calificacion = c;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Estudiante) {
			Estudiante e = (Estudiante) o;
			res = nombre.equalsIgnoreCase(e.nombre)
					&& dni.equalsIgnoreCase(e.dni);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase(),
				dni.toLowerCase());
	}
	
	@Override
	public String toString() {
		return "(" + dni + ", " + nombre + ", " +  calificacion + ")"; 
	}

	@Override
	public int compareTo(Estudiante e) {
		int resultado = dni.compareToIgnoreCase(e.dni);
		if (resultado == 0) {
			resultado = nombre.compareToIgnoreCase(e.nombre);
		} 
		return resultado;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}
	
}
