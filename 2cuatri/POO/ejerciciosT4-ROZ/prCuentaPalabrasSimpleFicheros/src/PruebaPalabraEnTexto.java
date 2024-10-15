import cuentapalabras.*;
public class PruebaPalabraEnTexto {

	public static void main(String[] args) {
		PalabraEnTexto pal1 = new PalabraEnTexto("gorra"); 
		PalabraEnTexto pal2 = new PalabraEnTexto("Gorra"); 
		pal1.incrementa();
		System.out.println(pal1);
		System.out.println(pal2);
		if(pal1.equals(pal2)) {
			System.out.println("Las palabras son iguales");
		}

	}

}
