import nombres.Nombre;
import nombres.RegistroCivilException;

public class PruebaNombre {
	
	public static void printearNombre(String nombre, String genero) {
		char gen = genero.toCharArray()[0];
		if(genero.length()!=1) {
			throw new RegistroCivilException("Alguno de los valores introducidos como género no es una cadena de un único carácter");
		}
		Nombre n1 = new Nombre(gen, nombre);
		System.out.println(n1);
	}

	public static void main(String[] args) {
		try {
			int cont = 0;
			while(cont<args.length) {
				printearNombre(args[cont], args[cont+1]);
				cont+=2;
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("No se proporcionan valores suficientes como argumentos del main " + e.getMessage());
		}catch (RegistroCivilException e) {
			System.err.println(e.getMessage());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
