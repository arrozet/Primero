import java.util.*;

import ejercicios_tema6.Estudiante;
import ejercicios_tema6.EstudianteException;
import ejercicios_tema6.OrdenAlternativoEstudiante;

public class PruebaConjEstudiantes {

	public static void main(String[] args) {
		
		// Código para Paso 4
			try {
				//Set<Estudiante> conjEstudiantes = new TreeSet<>();
				Set<Estudiante> conjEstudiantes = 
						new TreeSet<>(new OrdenAlternativoEstudiante());
					
				conjEstudiantes.add(new Estudiante("3245D", "Antonio", 8));
				conjEstudiantes.add(new Estudiante("4536X", "Carmen", 6));
				conjEstudiantes.add(new Estudiante("8342P", "Luisa", 9));
				conjEstudiantes.add(new Estudiante("4535H", "Pedro", 4));
							
				System.out.println("El conjunto es: " + conjEstudiantes);
				
			} catch (EstudianteException e) {
				System.err.println("ERROR: " + e.getMessage());
			}	

	}

}
