
package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
	private double porcDescuento;
	private String[] autoresOferta;
	public LibreriaOferta(double d, String[] a) {
		super();
		porcDescuento = d;
		autoresOferta = a;
	}
	public void setOferta(double d, String[] a) {
		porcDescuento = d;
		autoresOferta = a;
	}
	public String[] getOferta() {
		return autoresOferta;
	}
	public double getDescuento() {
		return porcDescuento;
	}
	@Override
	public void addLibro(String a, String t, double p) {
		if (buscarAutorOferta(a) >= 0) {
			anyadirLibro(new LibroOferta(a, t, p, porcDescuento));
		} else {
			anyadirLibro(new Libro(a, t, p));
		}
	}
	@Override
	public String toString() {
		String str = getDescuento() + "%" + Arrays.toString(autoresOferta);
		return str + "\n" + super.toString();
	}
	private int buscarAutorOferta(String a) {
		int i = 0;
		while ((i < autoresOferta.length)
			   && ! autoresOferta[i].equalsIgnoreCase(a)) {
			++i;
		}
		return (i < autoresOferta.length) ? i : -1;
	}
}
