import ejercicio2v2_tema2.*;

public class Prueba {
	public static void main(String[] args) {
		Lista lista = new Lista(3);
		lista.añadir(1);
		System.out.println(lista);
		lista.añadir(5);
		System.out.println(lista);
		lista.añadir(2);
		System.out.println(lista);
		lista.añadir(8);
		System.out.println(lista);
		lista.eliminar(5);
		System.out.println(lista);
		lista.eliminar(23);
		System.out.println(lista);
		lista.añadir(1,4);
		System.out.println(lista);
		System.out.println("Numero de elementos: " + lista.numElem());
		lista.vaciar();
		System.out.println(lista);
		
		/*
		 OUTPUT:
		[1]
		[1, 5]
		[1, 5, 2]
		[1, 5, 2, 8]
		[1, 2, 8]
		[1, 2, 8]
		[1, 4, 2, 8]
		Numero de elementos: 4
		[]
		 */
	}
}
