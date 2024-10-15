package ejercicio2v2_tema2;

import java.util.ArrayList;

public class Lista {
	private ArrayList<Integer> elementos;
	
	public Lista(){
		elementos = new ArrayList<>();
	}
	
	public Lista(int tam) {
		if(tam<0) {
			throw new RuntimeException("La lista no puede ser de tamaño negativo");
		}
		elementos = new ArrayList<>(tam);
	}
	
	public int numElem() {
		return elementos.size();
	}
	
	public int elem(int pos) {
		if(pos<0 || pos >= elementos.size()) {
			throw new RuntimeException("ERROR: posicion incorrecta: " + pos);
		}
		return elementos.get(pos);
	}
	
	public boolean vacia() {
		return elementos.isEmpty();
	}
	
	public void vaciar() {
		elementos.clear();
	}
	public void añadir(int elem) {
		// como hago lo de ampliar el array?? se amplia solo???
		/*if(numElem == elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*elementos.size());
		}*/
		elementos.add(elem);
	}
	
	public void añadir(int pos, int elem) {
		if(pos<0 || pos > elementos.size()) {  // pos > numElem pq estas añadiendo, es decir, puedes acceder hasta antiguo numElem+1
			throw new RuntimeException("ERROR: posicion incorrecta: " + pos);
		}
		/*// si lleno
		if(numElem == elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*numElem);
		}*/
		elementos.add(pos,elem);
	}
	
	public void eliminar(int elem) {
		elementos.remove((Integer) elem);
	}
	
	public boolean contiene(int elem) {
		return elementos.contains(elem);
	}
	
	public String toString() {
		return elementos.toString();
	}
	
}
