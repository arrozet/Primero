package ejercicios_tema4;

import java.util.Objects;

public class Estudiante {
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
}
