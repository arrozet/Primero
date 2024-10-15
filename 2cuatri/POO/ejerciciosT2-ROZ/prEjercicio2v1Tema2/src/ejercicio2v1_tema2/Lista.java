package ejercicio2v1_tema2;

import java.util.Arrays;

public class Lista {
	private int[] elementos;
	private int numElem;
	private final static int TAM = 10;	// static significa que es una variable de clase. NO pertenece a cada lista, es decir, no es de instancia
	
	
	public Lista(){
		this(TAM);  // hace lo que en el constructor de abajo pero pasando el parametro TAM
	}
	
	public Lista(int tam) {
		if(tam<=0) {
			throw new RuntimeException("ERROR: el tamaño del array es insuficiente");
			// el new es para crear el objeto RuntimeException
		}
		numElem = 0;
		elementos = new int[tam];
	}
	
	
	public int numElem() {
		return numElem;
	}
	
	public int elem(int pos) {
		if(pos<0 || pos >= numElem) {
			throw new RuntimeException("ERROR: posicion incorrecta: " + pos);
		}
		return elementos[pos];
	}
	
	public boolean vacia() {
		return numElem==0;
	}
	
	public void vaciar() {
		// te da igual lo que haya en el array
		numElem=0;
	}
	public void añadir(int elem) {
		// si esta lleno
		if(numElem == elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*numElem);
		}
		
		elementos[numElem] = elem;
		numElem++;
	}
	
	private void desplazarElemDer(int pos) {
		for(int i=numElem; i>pos; i--) {
			elementos[i] = elementos[i-1];
		}
	}
	
	public void añadir(int pos, int elem) {
		// exception
		if(pos<0 || pos > numElem) {  // pos > numElem pq estas añadiendo, es decir, puedes acceder hasta antiguo numElem+1
			throw new RuntimeException("ERROR: posicion incorrecta: " + pos);
		}
		// si lleno
		if(numElem == elementos.length) {
			elementos = Arrays.copyOf(elementos, 2*numElem);
		}
		
		desplazarElemDer(pos);
		elementos[pos] = elem;
		numElem++;
	}
		
	
	private int busqueda(int elem) {
		int i=0;
		while(elementos[i]!=elem && i<numElem) {
			i++;
		}
		return i;
	}
	
	private void desplazarElemIzq(int pos) {
		for(int i=pos; i<numElem; i++) {
			elementos[i] =elementos[i+1];
		}
	}
	
	public void eliminar(int elem) {
		int pos = busqueda(elem);
		
		if(pos < numElem) {
			desplazarElemIzq(pos);
			numElem--;
		}
	}
	
	public boolean contiene(int elem) {
		return elementos[busqueda(elem)] == elem;
	}
	
	public String toString() {
		return Arrays.toString(Arrays.copyOf(elementos, numElem));
	}
	
}
