import ejercicios_tema6.*;

public class PruebaEstudiante {

	public static void main(String[] args) {
		try {
//			// iguales
			Estudiante e1 = new Estudiante("2234D", "Antonio", 8);
			Estudiante e2 = new Estudiante("2234d", "Antonio", 7);
			
//			// menor
//			Estudiante e1 = new Estudiante("3624E", "Luisa", 8);
//			Estudiante e2 = new Estudiante("3624H", "Ana", 7);
			
			// mayor
//			Estudiante e1 = new Estudiante("2234H", "Antonio", 8);
//			Estudiante e2 = new Estudiante("2234D", "Arturo", 7);
			
			int comp = e1.compareTo(e2);
			
			if(comp<0) {
				System.out.println(e1 + " es menor que " + e2);
			}
			else if (comp>0) {
				System.out.println(e1 + " es mayor que " + e2);
			}
			else {
				System.out.println(e1 + " es igual a " + e2);
			}
			
		} catch (EstudianteException e) {
			System.err.println(e.getMessage());
		}

	}

}
