package notas;

import java.util.List;

public class MediaAritmetica implements CalculoMedia{
	public double calcula(List<Alumno> alumnos) throws AlumnoException{
		if(alumnos.isEmpty()) {
			throw new AlumnoException("No hay alumnos");
		}
		double media=0;
		for(int i=0; i<alumnos.size(); i++) {
			media+=alumnos.get(i).getCalificacion();
		}
			
		return media/alumnos.size();
	}
}
