import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import ejercicios_tema6.*;

public class PruebaConjEstudiantes {

	public static void main(String[] args) throws EstudianteException{
		try {
			System.out.println("ORDEN NATURAL");
			SortedSet<Estudiante> conj_ord = new TreeSet<>();
			conj_ord.add(new Estudiante("3245D", "Antonio", 8));
			conj_ord.add(new Estudiante("4535H", "Pedro", 4));
			conj_ord.add(new Estudiante("4536X", "Carmen", 6));
			conj_ord.add(new Estudiante("8342P", "Luisa", 9));
			System.out.println(conj_ord);
			
			System.out.println("\nORDEN ALTERNATIVO");
			Comparator<Estudiante> ordAlt = new OrdenAlternativoEstudiante();
			SortedSet<Estudiante> conj_ordAlt = new TreeSet<>(ordAlt);
			conj_ordAlt.addAll(conj_ord);
			System.out.println(conj_ordAlt);
			
			
		} catch (EstudianteException e) {
			System.err.println(e);
		}
	}

}
