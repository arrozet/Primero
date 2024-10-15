import ejercicio1_tema2.*;
public class Prueba {

	public static void main(String[] args) {
		Punto p = new Punto(3,5);
		Circulo crcl = new Circulo(p, 4);
		Cilindro cilindro = new Cilindro(crcl,10);
		
		System.out.println("El punto es: " + p); 
		System.out.println("El circulo es: " + crcl);
		System.out.println("El cilindro es: " + cilindro);
		cilindro.trasladar(2, 3);
		System.out.println("El cilindro es: " + cilindro);
		System.out.println("El area del cilindro es: " + cilindro.area());
		
	}

}
