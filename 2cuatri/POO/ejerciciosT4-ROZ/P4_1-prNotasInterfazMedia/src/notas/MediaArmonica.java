package notas;

import java.util.List;

public class MediaArmonica implements CalculoMedia{
	public double calcula(List<Alumno> alumnos) throws AlumnoException{
		double sum=0, k=0;
		for(int i=0; i<alumnos.size(); i++) {
			if(alumnos.get(i).getCalificacion()>0) {
				sum+= 1/alumnos.get(i).getCalificacion();
				k++;
			}
		}
		if(k==0) {
			throw new AlumnoException("No hay alumnos");
		}
			
		return k/sum;
	}
}
