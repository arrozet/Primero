//APELLIDOS Y NOMBRE: 		Oliva Zamora, Rubén
//GRADO: 					Ingeniería del software
//GRUPO: 					A

package hospital;

import java.util.Objects;
import java.util.StringJoiner;

public class Habitacion implements Comparable<Habitacion>{
	private int planta;
	private int numero;
	
	public Habitacion(int planta, int numero) {
		this.planta = planta;
		this.numero = numero;
	}

	public int getPlanta() {
		return planta;
	}

	public int getNumero() {
		return numero;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Habitacion) {
			Habitacion h = (Habitacion) obj;
			res = planta == h.planta && numero == h.numero;
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(planta, numero);
	}
	
	@Override
	public int compareTo(Habitacion o) {
		int res = Integer.compare(planta, o.planta);
		if(res==0) {
			res = Integer.compare(numero, o.numero);
		}
		
		return res;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",", "[", "]");
		sj.add("planta=" + planta);
		sj.add("numero=" + numero);
		return "Habitacion" + sj.toString();
	}
}
