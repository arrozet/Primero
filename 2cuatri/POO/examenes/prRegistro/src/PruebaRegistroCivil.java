import nombres.*;

public class PruebaRegistroCivil {

	public static void main(String[] args) {
		try {
			RegistroCivil pr = new RegistroCivil("PR","registrocivil.txt");
			System.out.println(pr);
			System.out.print("Nombres femeninos que empiezan por 'L': ");
			System.out.println(pr.selecciona(new FiltroGeneroInicial('F','L')));
			System.out.print("Nombres de 3 letras: ");
			System.out.println(pr.selecciona(new FiltroLongitud(3)));
					
		} catch (RegistroCivilException e) {
			e.printStackTrace();
		}

	}

}
