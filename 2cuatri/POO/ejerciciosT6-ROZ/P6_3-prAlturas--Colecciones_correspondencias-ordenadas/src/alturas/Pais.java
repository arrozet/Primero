package alturas;

import java.util.Objects;

public class Pais implements Comparable<Pais>{
	private String nombre;
	private String continente;
	private double altura;
	
	public Pais(String nombre, String continente, double altura) {
		this.nombre = nombre;
		this.continente = continente;
		this.altura = altura;
	}

	public String getNombre() {
		return nombre;
	}

	public String getContinente() {
		return continente;
	}

	public double getAltura() {
		return altura;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Pais) {
			Pais p = (Pais) obj;
			res = p.getNombre().equals(nombre);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	
	@Override
	public int compareTo(Pais o) {
		return nombre.compareTo(o.getNombre());
	}
	
	@Override
	public String toString() {
		return "Pais(" + nombre + ", " + continente + ", " + altura +")";
	}
	
}
