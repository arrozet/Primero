package ejercicios_tema6;

import java.util.Comparator;

public class OrdenAlternativoEstudiante 
						implements Comparator<Estudiante>{

	@Override
	public int compare(Estudiante e1, Estudiante e2) {
		int resultado = e1.getNombre().compareToIgnoreCase(e2.getNombre());
		if (resultado == 0) {
			resultado = e1.getDni().compareToIgnoreCase(e1.getDni());
		} 
		return resultado;
	}

}
