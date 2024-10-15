import ejercicio4_tema2.*;
public class Prueba {
	private static void rellenar(EstructuraDeDatos d) {
		for(int i=0; i<10; i++) {
			d.meter(i);
		}
	}
	private static void vaciar(EstructuraDeDatos d) {
		while(!d.estaVacia()) {
			d.sacar();
		}
	}
	
	public static void main(String[] args) {
		EstructuraDeDatos d;
		switch (args[0].toLowerCase()) {
		case "pila":
			d=new Pila();
			break;
		case "cola":
			d=new Cola();
			break;

		default:
			d=new Aleatoria();
			break;
		}
		
		rellenar(d);
		System.out.println(d);
		System.out.println("Sacamos un elemento: " + d.sacar());
		System.out.println(d);
		vaciar(d);
		System.out.println(d);
	}
}
