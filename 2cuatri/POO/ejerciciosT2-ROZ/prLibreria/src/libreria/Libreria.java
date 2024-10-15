
package libreria;

import java.util.ArrayList;

public class Libreria {
	private ArrayList<Libro> libs;
	public Libreria() {
		libs = new ArrayList<>();
	}
	/**
	 * añade libro
	 * @param a
	 * @param t
	 * @param p
	 */
	public void addLibro(String a, String t, double p) {
		anyadirLibro(new Libro(a, t, p));
	}
	public void remLibro(String a, String t) {
		int i = buscarLibro(a, t);
		if (i < 0) {
			throw new RuntimeException("Libro no encontrado ("+a+", "+t+")");
		}
		libs.remove(i);
	}
	public double getPrecioFinal(String a, String t) {
		int i = buscarLibro(a, t);
		if (i < 0) {
			throw new RuntimeException("Libro no encontrado ("+a+", "+t+")");
		}
		return libs.get(i).getPrecioFinal();
	}
	@Override
	public String toString() {
		return libs.toString();
	}
	protected void anyadirLibro(Libro lb) {
		int i = buscarLibro(lb.getAutor(), lb.getTitulo());
		if (i < 0) {
			libs.add(lb);
		} else {
			libs.set(i, lb);
		}
	}
	private int buscarLibro(String a, String t) {
		int i = 0;
		while ((i < libs.size())
			   && !(libs.get(i).getAutor().equalsIgnoreCase(a)
					 && libs.get(i).getTitulo().equalsIgnoreCase(t))) {
			++i;
		}
		return (i < libs.size()) ? i : -1;
	}
}
