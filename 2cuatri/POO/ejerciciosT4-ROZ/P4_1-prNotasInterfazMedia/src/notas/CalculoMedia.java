package notas;

import java.util.List;

public interface CalculoMedia {
	double calcula(List<Alumno> alumnos) throws AlumnoException;
}
