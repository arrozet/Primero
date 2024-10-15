// por qué si al hashcode añado la calificacion, sigue saliendo que en prueba 1 son iguales?

import ejercicios_tema4.*;
public class PruebaEstudiante {
	public static void printEstIguales(Estudiante e1, Estudiante e2) {
		if (e1.equals(e2)) {
			System.out.println(e1 + " y " + e2 + " son el mismo estudiante");
		}
		else {
			System.out.println(e1 + " y " + e2 + " NO son el mismo estudiante");
		}
	}
	public static void main(String[] args) {
		try {
			// estudiantes iguales
			Estudiante e1 = new Estudiante("2234D", "Antonio", 8);
			Estudiante e2 = new Estudiante("2234d", "Antonio", 7);
			printEstIguales(e1,e2);
			
			// estudiantes distintos
			Estudiante e3 = new Estudiante("2234D", "Carmen", 8);
			Estudiante e4 = new Estudiante("2234H", "Carmen", 8);
			printEstIguales(e3,e4);
			
			// estudiantes con nota final negativa
			Estudiante e5 = new Estudiante("2234D", "Ana", -8);
			Estudiante e6 = new Estudiante("2234H", "Carmen", 8);
			printEstIguales(e5,e6);
			
		} catch (EstudianteException e) {
			System.err.println(e.getMessage());
		}
		
	}

}
