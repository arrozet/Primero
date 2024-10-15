package parrillatv;

import java.util.Comparator;

public class OrdenAlternativoProgramaTV implements Comparator<ProgramaTV>{
	@Override
	public int compare(ProgramaTV o1, ProgramaTV o2) {
		int res=o1.getNombre().compareToIgnoreCase(o2.getNombre());
		if(res==0) {
			res = Integer.compare(o1.getDuracion(), o2.getDuracion());
			if(res==0) {
				res = o1.getHoraInicio().compareTo(o2.getHoraInicio());
			}
		}
		return res;
	}
}
