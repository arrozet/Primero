package paqVacunas;

import java.util.ArrayList;

public class Comprador {
	private ArrayList<Vacuna> listaVacunas;
	private int numVacunas;
	private String nombre;
	private final static int TAM_INICIAL = 10;
	
	public Comprador(String nombre_comprador, int tam) {
		if(tam<=0) {
			throw new RuntimeException("El tamaño del array no puede ser <= 0");
		}
		nombre = nombre_comprador;
		numVacunas = 0;
		
		listaVacunas = new ArrayList<>();
	}
	public Comprador(String nombre_comprador) {
		this(nombre_comprador, TAM_INICIAL);
	}
	
	private int vacunaPos(String codigo) {
		int i=0;
		while(i<numVacunas && !(listaVacunas.get(i).getCodigo().equalsIgnoreCase(codigo))) {
			i++;
		}
		return (i<numVacunas ? i : -1);
	}
	
	public void comprar(String codigo, double precio, int cantidad){
		if(cantidad<=0) {
			throw new RuntimeException("La cantidad no puede ser <= 0");
		}
		
		int pos = vacunaPos(codigo);
		if(pos!=-1) {
			listaVacunas.get(pos).setCantidad(listaVacunas.get(pos).getCantidad() + cantidad);
		}
		
		else {
			Vacuna v = new Vacuna(codigo, precio, cantidad);
			listaVacunas.add(v);
			numVacunas++;
		}
	}
	
	public int getNumVacunas() {
		return numVacunas;
	}
	public String getNombre() {
		return nombre;
	}
	public double precioTotal() {
		double suma=0;
		for(int i=0; i<numVacunas; i++) {
			suma += listaVacunas.get(i).precioTotal();
		}
		return suma;
	}
	public void eliminar(String codigo) {
		int pos = vacunaPos(codigo);
		if(pos != -1) {
			listaVacunas.remove(pos); 	// esto no funcion siempre
			numVacunas--;
		}
	}
	@Override
	public String toString() {
		return getNombre() + " = " + listaVacunas.toString();
	}
}
