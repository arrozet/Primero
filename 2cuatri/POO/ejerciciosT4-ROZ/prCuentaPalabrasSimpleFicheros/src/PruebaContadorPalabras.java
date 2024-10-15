import cuentapalabras.ContadorPalabras;

public class PruebaContadorPalabras {

	public static void main(String[] args) {
		ContadorPalabras cPal = new ContadorPalabras();
		String [] datos = {
				"Esta es la primera frase del ejemplo",
				"y esta es la segunda frase"
				};
		
		cPal.incluyeTodas(datos, "[ ]");
		System.out.println(cPal);
	}

}
