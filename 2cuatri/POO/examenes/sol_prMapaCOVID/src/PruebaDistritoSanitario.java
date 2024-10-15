
import java.util.List;

import covid.COVIDException;
import covid.DistritoSanitario;

public class PruebaDistritoSanitario {

	public static void main(String[] args) {
		DistritoSanitario 
			axarquia = new DistritoSanitario("Axarquía", 170141, 184),
			laVega = new DistritoSanitario("La Vega", 110176, 291),
			guadalhorce = new DistritoSanitario("Valle del Guadalhorce", 156298, 262),
			costaSol = new DistritoSanitario("Costa del Sol", 560785, 761),
			malagaDistrito = new DistritoSanitario("Málaga Distrito", 633521, 761),
			serrania = new DistritoSanitario("Serranía", 54999, 99);
		
		List<DistritoSanitario> listaDistritosMalaga = List.of(axarquia,laVega,guadalhorce,costaSol,malagaDistrito,serrania);
		
		int distrito = (int) (Math.random()*(listaDistritosMalaga.size()));
		System.out.println(distrito);
		try {
			listaDistritosMalaga.get(distrito).setCasosCOVID14dias(Integer.parseInt(args[0]));
			System.out.println(listaDistritosMalaga);
		} catch (ArrayIndexOutOfBoundsException aiob) {
			System.err.println("No se ha introducido ningún valor para modificar los casos positivos");
		} catch (NumberFormatException nfe) {
			System.err.println("El valor introducido no es un número entero");
		} catch (COVIDException ce) {
			System.err.println(ce.getMessage());
		}
	}

}
