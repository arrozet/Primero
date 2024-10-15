// por qué si al hashcode añado la calificacion, sigue saliendo que en prueba 1 son iguales?

import ejercicios_tema4.*;
public class PruebaAsignatura {
//	public static void printEstIguales(Estudiante e1, Estudiante e2) {
//		if (e1.equals(e2)) {
//			System.out.println(e1 + " y " + e2 + " son el mismo estudiante");
//		}
//		else {
//			System.out.println(e1 + " y " + e2 + " NO son el mismo estudiante");
//		}
//	}
	public static void main(String[] args) {
		try {
			Asignatura a = new Asignatura();
			System.out.println(a);
			Estudiante e1 = new Estudiante("3245D", "Antonio", 8);
			a.almacenarEstudiante(e1);
			Estudiante e2 = new Estudiante("4536X", "Ana", 6);
			a.almacenarEstudiante(e2);
			Estudiante e3 = new Estudiante("8342P", "Luis", 4);
			a.almacenarEstudiante(e3);
			Estudiante e4 = new Estudiante("4535H", "Carmen", 9);
			a.almacenarEstudiante(e4);
			System.out.println(a);
			a.almacenarEstudiante(new Estudiante("3245D", "Antonio", 5));
			System.out.println(a);
			
			
			a.añadirEstudiante("3424J;Alberto;6.3;5.4;7.8");
			System.out.println(a);
//			a.añadirEstudiante("3424J;Alberto;6.3;5.4;hola");
//			System.out.println(a);
			a.leerEstudiantes("datos.txt");
			System.out.println(a);
			
			

		} catch (EstudianteException e) {
			System.err.println("ERROR: " + e.getMessage());
		}
		
	}

}
