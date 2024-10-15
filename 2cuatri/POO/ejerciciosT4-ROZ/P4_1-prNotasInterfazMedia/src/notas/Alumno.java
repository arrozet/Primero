package notas;

import java.util.Objects;

public class Alumno {
	private String dni;
	private String nombre;
	private double nota;
	
	public Alumno(String dni,String nombre,double nota) throws AlumnoException {
		if(nota<0) {
			throw new AlumnoException("La calificación no puede ser negativa ");
		}
		this.dni = dni;
		this.nombre = nombre;
		this.nota = nota;
	}
	public Alumno(String dni,String nombre) throws AlumnoException {
		this(dni, nombre, 0);
	}
	public String getDni() {
		return dni;
	}
	public String getNombre() {
		return nombre;
	}
	public double getCalificacion() {
		return nota;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof Alumno) && 
				((Alumno) obj).nombre.equalsIgnoreCase(nombre) && 
				((Alumno) obj).dni.equalsIgnoreCase(dni);
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase(), dni.toLowerCase());
	}
	
	@Override
	public String toString() {
		return getNombre() + " " + getDni();
	}
}
