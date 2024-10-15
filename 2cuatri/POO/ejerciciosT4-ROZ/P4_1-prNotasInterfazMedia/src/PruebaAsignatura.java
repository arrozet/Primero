
import notas.*;

public class PruebaAsignatura {
	
	static final String[] info = {
			"12455666F;Lopez Perez, Pedro;6.7",
			"33678999D;Merlo Gomez, Isabel;5.8",
			"23555875G;Martinez Herrera, Lucia;9.1"
	}; 
	public static void main(String[] args) throws AlumnoException {
		try {
			Asignatura a = new Asignatura("POO", info);
			System.out.println(a.getMedia());
			
			for(int i=0; i<a.getAlumnos().size(); i++) {
				System.out.println(a.getAlumnos().get(i).getDni());
			}
			System.out.println(a.getCalificacion(new Alumno("12455666F", "Lopez Perez, Pedro")));
			System.out.println(a.getCalificacion(new Alumno("12455666F", "Lopez Lopez, Pedro")));
			
		} catch (AlumnoException e) {
			System.err.println(e.getMessage());
		}
	}

}
