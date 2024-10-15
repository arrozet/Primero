package ejercicio3_tema2;

import java.util.ArrayList;

public class Coleccion {
	protected ArrayList<Punto> puntos;
	
	public Coleccion() {
		puntos = new ArrayList<>();
	}
	
	public int numElem() {
		return puntos.size();
	}
	
	public boolean vacia() {
		return puntos.isEmpty();
	}
	
	public void vaciar() {
		puntos.clear();
	}
	
	public void añadir(Punto p) {
		puntos.add(p);
	}
	
	private int buscarInd(Punto p) {
		int i=0;
		while(i<puntos.size() && 
				!(puntos.get(i).abscisa() == p.abscisa() && puntos.get(i).ordenada() == p.ordenada())) {
			i++;
		}
		return i;
	}
	
	public void eliminar(Punto p) {
		int ind = buscarInd(p);
		if(ind < puntos.size()) {
			puntos.remove(ind);
		}
	}
	
	public boolean contiene(Punto p) {  // tb usa .equals
		boolean contiene = false;
		int ind = buscarInd(p);
		if(ind < puntos.size()) {
			contiene = true;
		}
		return contiene;
	}
	
	public String toString(){
		return puntos.toString();
	}
	
}
