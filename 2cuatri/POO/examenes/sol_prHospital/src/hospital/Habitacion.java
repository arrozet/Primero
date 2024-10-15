package hospital;

import java.util.Objects;

public class Habitacion implements Comparable<Habitacion> {
	private int planta;
	private int numero;

	public Habitacion(int pla, int num) {
		planta = pla;
		numero = num;
	}

	public int hashCode() {
		return Objects.hash(numero, planta);
	}

	public boolean equals(Object o) {
		if (!(o instanceof Habitacion))
			return false;
		Habitacion h = (Habitacion) o;
		return numero == h.numero && planta == h.planta;
	}

	public int getPlanta() {
		return planta;
	}

	public void setPlanta(int planta) {
		this.planta = planta;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int compareTo(Habitacion o) {
		int r = Integer.compare(planta, o.planta);
		if (r == 0)
			r = Integer.compare(numero, o.numero);
		return r;
	}

	@Override
	public String toString() {
		return "Habitacion [planta=" + planta + ", numero=" + numero + "]";
	}

}
