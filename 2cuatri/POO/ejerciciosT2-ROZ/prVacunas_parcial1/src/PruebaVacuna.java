

import paqVacunas.Vacuna;

public class PruebaVacuna {
	private static boolean sonIguales(Vacuna v1, Vacuna v2) {
		if(v1.getCodigo().equalsIgnoreCase(v2.getCodigo())) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Vacuna v1 = new Vacuna("V1", 100.0, 2);
		Vacuna v2 = new Vacuna("V2", 50.0, 4);
		
		System.out.println("Vacuna 1 = " + v1 + "\n" + "Vacuna 2 = " + v2);
		v2.setCantidad(v2.getCantidad() + 3);
		System.out.println("Vacuna 1 = " + v1 + "\n" + "Vacuna 2 = " + v2);
		
		Vacuna v3 = new Vacuna("v2", 75.0, 5);
		System.out.println("Vacuna 3 = " + v3);
		
		if(sonIguales(v2,v3)) {
			System.out.println("Las vacunas 2 y 3 son iguales");
		}

	}

}
