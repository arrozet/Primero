import java.util.Comparator;

import ejercicios_tema6.*;

public class PruebaEstudiante {

	public static void escribir_comp(int n,Estudiante e1, Estudiante e2) {
		if(n<0) {
			System.out.println(e1 + " es menor que " + e2);
		}
		else if (n>0) {
			System.out.println(e1 + " es mayor que " + e2);
		}
		else {
			System.out.println(e1 + " es igual a " + e2);
		}
	}
	public static void main(String[] args) {
		try {
//			// iguales
//			Estudiante e1 = new Estudiante("2234D", "Antonio", 8);
//			Estudiante e2 = new Estudiante("2234d", "Antonio", 7);
			
//			// menor - mayor en alternativo
//			Estudiante e1 = new Estudiante("3624E", "Luisa", 8);
//			Estudiante e2 = new Estudiante("3624H", "Ana", 7);
			
			// mayor - menor en alternativo
			Estudiante e1 = new Estudiante("2234H", "Antonio", 8);
			Estudiante e2 = new Estudiante("2234D", "Arturo", 7);
			
			int comp1 = e1.compareTo(e2);
			Comparator<Estudiante> ordAlt = new OrdenAlternativoEstudiante();
			int comp2 = ordAlt.compare(e1, e2);
			
			System.out.println("ORDEN NATURAL");
			escribir_comp(comp1, e1, e2);
			System.out.println("ORDEN ALTERNATIVO");
			escribir_comp(comp2, e1, e2);
			
		} catch (EstudianteException e) {
			System.err.println(e.getMessage());
		}

	}

}
