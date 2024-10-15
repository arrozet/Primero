package libreria;

import java.util.Arrays;

public class LibreriaOferta extends Libreria {
	private double porcDescuento;
	private String[] autoresOferta;
	public LibreriaOferta(double desc, String[] autores) {
		super();
		porcDescuento = desc;
		autoresOferta = autores;
	}
	
	public void setOferta(double desc, String[] newAutores) {
		porcDescuento = desc;
		autoresOferta = newAutores;
	}
	public String[] getOferta(){
		return autoresOferta;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	@Override
	public void addLibro(String autor_busq, String titulo, double precio) {
		Libro l;
		if(buscarAutorOferta(autor_busq) != autoresOferta.length) {
			l = new LibroOferta(autor_busq,titulo,precio,porcDescuento);
		}
		else {
			l = new Libro(autor_busq,titulo,precio);
		}
		super.anyadirLibro(l);
	}
	
	@Override
	public String toString(){
		return getDescuento() + Arrays.toString(autoresOferta) + "\n" +
		super.toString();
	}
	
	private int buscarAutorOferta(String a) {
		int i=0;
		while(i<autoresOferta.length && !(autoresOferta[i].equalsIgnoreCase(a))) {
			i++;
		}
		return i;
		
	}
}
