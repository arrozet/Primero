package cuentapalabras;

import java.util.Objects;

public class PalabraEnTexto {
	private String palabra;
	private int veces;
	
	public PalabraEnTexto(String pal) {
		palabra = pal.toUpperCase();
		veces = 1;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof PalabraEnTexto) {
			res = palabra.equals(((PalabraEnTexto) obj).palabra);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(palabra);
		
	}
	
	public void incrementa() {
		veces++;
	}
	
	@Override
	public String toString() {
		return palabra + ": " + veces;
	}
}
