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
	public double getDescuento(Libro l) {
		double d = 0;
		if(buscarAutorOferta(l.getAutor())!=autoresOferta.length) {
			d=porcDescuento;
		}
		
		return d;
	}
	
	@Override
	public String toString() {
		return porcDescuento + "%" + Arrays.toString(autoresOferta);
	}
	
	private int buscarAutorOferta(String a) {
		int i=0;						// me faltó el !. SEGUÍA SOLO SI EL DEL PARAMETRO ERA IGUAL AL DEL ARRAY. DEBE SEGUIR <--> !al buscado
		while(i<autoresOferta.length && !(autoresOferta[i].equalsIgnoreCase(a))) {
			i++;
		}
		return i;
		
	}
}
