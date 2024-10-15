package nombres;

import java.util.Objects;

public class Nombre implements Comparable<Nombre>{
	private char genero;
	private String nombre;
	
	public Nombre(char gen, String nom) {
		if(!(gen=='F' || gen=='M')) {
			throw new RegistroCivilException("El genero debe ser 'F' o 'M'");
		}
		else if (nom.isEmpty() || nom==null) {
			throw new RegistroCivilException("El nombre debe ser valido");
		}
		this.genero = gen;
		this.nombre = nom;
	}

	public char getGenero() {
		return genero;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Nombre) {
			Nombre n = (Nombre) obj;
			res = nombre.equalsIgnoreCase(n.nombre) && genero == n.genero;
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase(), genero);
	}

	@Override
	public int compareTo(Nombre o) {
		int res = nombre.compareToIgnoreCase(o.nombre);
		if(res==0) {
			res=Character.compare(genero, o.genero);
		}
		return res;
	}
	
	@Override
	public String toString() {
		return "(" + nombre + ", " + genero + ")";
	}
	
	
	
}
