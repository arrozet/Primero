package ejercicio3_tema2;

public class Conjunto extends Coleccion {
	public Conjunto() {
		super();
	}
	
	@Override
	public void añadir(Punto p) {
		if(!super.contiene(p)) {
			super.añadir(p);  // si no pones el super. se esta haciendo de forma recursiva
		}
	}
}
