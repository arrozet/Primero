package ejercicios_tema6;

import java.util.Objects;

public class Estudiante implements Comparable<Estudiante>{
	private String dni;
	private String nombre;
	private double calificacion;
	
	public Estudiante(String dni, String nombre, double calificacion) throws EstudianteException{
		if (calificacion<0) {
			throw new EstudianteException("La calificación media final no puede ser negativa");
		}
		
		this.dni = dni;
		this.nombre = nombre;
		this.calificacion = calificacion;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	@Override
	public boolean equals(Object obj) {
		boolean res=false;
		if(obj instanceof Estudiante) {
			res = ((Estudiante) obj).dni.equalsIgnoreCase(dni) && 
					((Estudiante) obj).nombre.equalsIgnoreCase(nombre);
		}
		return res;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase(), dni.toLowerCase());
	}
	@Override
	public String toString() {
		return "("+dni+", "+nombre+", "+calificacion+")";
	}
	@Override
	public int compareTo(Estudiante est) {
		int res = dni.compareToIgnoreCase(est.dni);
		if(res==0) {
			res = nombre.compareToIgnoreCase(est.nombre);
		}
		return res;
	}
}
