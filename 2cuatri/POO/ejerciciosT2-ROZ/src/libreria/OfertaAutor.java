
package libreria;

import java.util.Arrays;

public class OfertaAutor implements OfertaFlex {
	private double porcDescuento;
	private String[] autoresOferta;
	public OfertaAutor(double desc, String[] a) {
		porcDescuento = desc;
		autoresOferta = a;
	}
	@Override
	public double getDescuento(Libro lb) {
		double d = 0;
		if (buscarAutorOferta(lb.getAutor()) >= 0) {
			d = porcDescuento;
		}
		return d;
	}
	@Override
	public String toString() {
		return porcDescuento+"%"+Arrays.toString(autoresOferta);
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
