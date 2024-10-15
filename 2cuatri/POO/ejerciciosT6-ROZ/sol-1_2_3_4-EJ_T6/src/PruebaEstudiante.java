import java.util.Comparator;

import ejercicios_tema6.*;

public class PruebaEstudiante {

	public static void main(String[] args) {
		try {
			// Código para el Paso 1
/*			
			Estudiante est1 = new Estudiante("2234D", "Antonio", 8);
			Estudiante est2 = new Estudiante("2234d", "Antonio", 7);

			//Estudiante est1 = new Estudiante("3624E", "Luisa", 8);
			//Estudiante est2 = new Estudiante("3624H", "Ana", 7);

			//Estudiante est1 = new Estudiante("2234H", "Antonio", 8);
			//Estudiante est2 = new Estudiante("2234D", "Arturo", 7);

			int comp = est1.compareTo(est2);
			
			if (comp < 0) {
				System.out.println(est1 + " es menor que " + est2);
			} else if (comp > 0) {
				System.out.println(est1 + " es mayor que " + est2);
			} else {
				System.out.println(est1 + " y " + est2 + " son iguales");
			}
*/
			
			// Código para el Paso 2
			
			Estudiante est1 = new Estudiante("2234D", "Antonio", 8);
			Estudiante est2 = new Estudiante("2234d", "Antonio", 7);

			//Estudiante est1 = new Estudiante("3624E", "Luisa", 8);
			//Estudiante est2 = new Estudiante("3624H", "Ana", 7);

			//Estudiante est1 = new Estudiante("2234H", "Antonio", 8);
			//Estudiante est2 = new Estudiante("2234D", "Arturo", 7);

		    Comparator<Estudiante> ordAlt = new OrdenAlternativoEstudiante();
		    int comp = ordAlt.compare(est1,est2);
			
			if (comp < 0) {
				System.out.println(est1 + " es menor que " + est2);
			} else if (comp > 0) {
				System.out.println(est1 + " es mayor que " + est2);
			} else {
				System.out.println(est1 + " y " + est2 + " son iguales");
			}
			
			
		} catch (EstudianteException e) {
			System.err.println("ERROR: " + e.getMessage());
		}

	}

}
