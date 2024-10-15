package nombres;
public class Nombre implements Comparable<Nombre>{
	private char genero;
	private String nombre;
	public Nombre(String nombre, char genero) {
		if (nombre ==null || nombre.length()==0) {
			throw new RegistroCivilException("ERROR: el nombre no puede estar vacío");
		}
		if (genero != 'F' && genero != 'M') {
			throw new RegistroCivilException("ERROR: género es 'F' o 'M'");
		}
		this.genero = genero;
		this.nombre = nombre;	
	}
	
	public char getGenero() {
		return genero;
	}

	public String getNombre() {
		return nombre;
	}

	
	public String toString() {
		return "("+nombre+","+genero+")";
	}
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Nombre) {
			Nombre other = (Nombre) o;
			res = this.genero==other.genero && this.nombre.equalsIgnoreCase(other.nombre);
		}
		return res;
	}
	public int hasCode() {
		return this.nombre.toUpperCase().hashCode() + Character.hashCode(this.genero);
	}

	@Override
	public int compareTo(Nombre other) {
		int res = this.nombre.compareToIgnoreCase(other.getNombre());
		if (res==0) {
			res = Character.compare(this.genero,other.genero);
		}
		return res;
	}
	
}
