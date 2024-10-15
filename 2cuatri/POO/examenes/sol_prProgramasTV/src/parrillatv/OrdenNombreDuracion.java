package parrillatv;

import java.util.Comparator;

/**
 * Orden alternativo para ProgramaTV que establece que un programa es menor que otro
 * cuando sus nombres lo son lexicográficamente (independientemente de minúsculas o
 * mayúsculas). En caso de igualdad, cuando es de menor duración. Y si, aún así, coinciden,
 * cuando la hora de inicio es anterior.
 * 
 * @author POO
 *
 */
public class OrdenNombreDuracion implements Comparator<ProgramaTV>{
	public int compare(ProgramaTV p1, ProgramaTV p2) {
		int res = p1.getNombre().compareToIgnoreCase(p2.getNombre());
		if (res == 0) {
			res = Integer.compare(p1.getDuracion(), p2.getDuracion());
			if (res == 0) 
				res =p1.getHoraInicio().compareTo(p2.getHoraInicio());
		}
		return res;
	}
}
