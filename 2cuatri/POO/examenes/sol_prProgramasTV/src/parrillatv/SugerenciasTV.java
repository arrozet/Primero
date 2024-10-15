package parrillatv;

import java.util.Collection;
import java.util.SortedSet;

/**
 * Interfaz para representar distintas formas de seleccionar programas de TV
 * de una colección, ordenados según algún criterio.
 * 
 * @author POO
 *
 */
public interface SugerenciasTV {
	/**
	 * Devuelve el conjunto ordenado de programas de TV que satisfagan algún criterio
	 * (dependiente de la clase que implemente la interfaz) del total de programas 
	 * en la colección que se pasa como parámetro.
	 * @param progs	Colección con todos los programas sobre los que hacer la selección
	 * @return				Programas sugeridos según criterio
	 */
	SortedSet<ProgramaTV> sugerencias(Collection<ProgramaTV> progs);
}
