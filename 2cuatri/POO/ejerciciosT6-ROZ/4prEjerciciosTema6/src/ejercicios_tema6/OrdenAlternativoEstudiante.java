package ejercicios_tema6;

import java.util.Comparator;

public class OrdenAlternativoEstudiante implements Comparator<Estudiante>{
	
	@Override
	public int compare(Estudiante o1, Estudiante o2) {
		int res = o1.getNombre().compareToIgnoreCase(o2.getNombre());
		if(res==0) {
			res = o1.getDni().compareToIgnoreCase(o2.getDni());
		}
		return res;
	}
}
