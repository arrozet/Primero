 package parrillatv;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

/** 
 * Clase que implementa la interfaz SugerenciasTV de forma
 * que la selección de programas se realiza considerando los que tienen una duración 
 * menor o igual a una duración determinada
 */
public class ProgramasCortos implements SugerenciasTV {
	/**
	 * Duración máxima de los programas a sugerir.
	 */
	private int durMaxima;
	
	/** 
	 * Crea un objeto de la clase proporcionando la duración máxima de los programas a sugerir.
	 * @param dur	Duración máxima
	 */
	public ProgramasCortos(int dur) {
		durMaxima = dur;
	}

	/**
	 * Método que selecciona un conjunto ordenado de programas (según duración)
	 * de la colección de programas que se pasa como argumento.
	 */
	@Override
	public SortedSet<ProgramaTV> sugerencias(Collection<ProgramaTV> progs) {
		SortedSet<ProgramaTV> sugerencias = new TreeSet<>(new OrdenNombreDuracion());
		for (ProgramaTV prog : progs) 
			if (prog.getDuracion() <= durMaxima)
				sugerencias.add(prog);
		return sugerencias;
	}
	
}
