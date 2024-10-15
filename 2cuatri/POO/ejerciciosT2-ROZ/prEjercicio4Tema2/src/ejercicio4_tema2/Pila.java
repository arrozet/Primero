package ejercicio4_tema2;

import java.util.ArrayList;

public class Pila implements EstructuraDeDatos {
	ArrayList<Integer> elementos;
	public Pila() {
		elementos = new ArrayList<>();
	}
	@Override
	public void meter(int elem) {
		elementos.add(0, elem);
	}
	@Override
	public int sacar() {
		if(estaVacia()) {
			throw new RuntimeException("La cola está vacía, no se puede sacar");
		}
		return elementos.remove(0);
	}
	@Override
	public int tamaño() {
		return elementos.size();
	}
	@Override
	public String toString(){
		return elementos.toString();
	}
	
}
