package notas;

import java.util.List;

public class MediaSinExtremos implements CalculoMedia{
	double min, max;
	public MediaSinExtremos(double min, double max) {
		this.min = min;
		this.max = max;
	}
	
	public double getMin() {
		return min;
	}

	public double getMax() {
		return max;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double calcula(List<Alumno> alumnos) throws AlumnoException{
		double sum=0, k=0;
		for(Alumno a: alumnos) {
			if(a.getCalificacion()>=min && a.getCalificacion()<=max) {
				sum += a.getCalificacion();
				k++;
			}
		}
			
		if(k==0) {
			throw new AlumnoException("No hay alumnos");
		}
		
		return sum/k;
	}
}
