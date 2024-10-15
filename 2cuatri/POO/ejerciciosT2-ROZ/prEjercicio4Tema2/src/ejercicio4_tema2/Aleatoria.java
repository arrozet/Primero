package ejercicio4_tema2;

import java.util.ArrayList;
import java.util.Random;

public class Aleatoria implements EstructuraDeDatos {
	ArrayList<Integer> elementos;
	private Random rnd;
	public Aleatoria() {
		elementos = new ArrayList<>();
		rnd = new Random();
	}
	@Override
	public void meter(int elem) {
		int pos = rnd.nextInt(elementos.size()+1);
		elementos.add(pos, elem);
	}
	@Override
	public int sacar() {
		if(estaVacia()) {
			throw new RuntimeException("La cola está vacía, no se puede sacar");
		}
		int pos = rnd.nextInt(elementos.size());
		return elementos.remove(pos);
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
