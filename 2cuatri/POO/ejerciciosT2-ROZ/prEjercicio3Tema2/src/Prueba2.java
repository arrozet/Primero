import ejercicio3_tema2.*;
public class Prueba2 {

	public static void main(String[] args) {
		Coleccion coleccion = new Conjunto();
		coleccion.añadir(new Punto(1,1));
		System.out.println(coleccion);
		coleccion.añadir(new Punto(1,4));
		System.out.println(coleccion);
		coleccion.añadir(new Punto(2,3));
		System.out.println(coleccion);
		coleccion.añadir(new Punto(1,4));
		System.out.println(coleccion);
		coleccion.eliminar(new Punto(1,4));
		System.out.println(coleccion);
		coleccion.eliminar(new Punto(5,5));
		System.out.println(coleccion);
		System.out.println("Numero de elementos: " + coleccion.numElem());
		coleccion.vaciar();
		System.out.println(coleccion);

	}

}
