package hospital;

public class MismaPlanta implements Criterio {
	private int planta;

	public MismaPlanta(int p) {
		planta = p;
	}

	public boolean cumpleCondicion(Paciente c, Habitacion h) {
		return h.getPlanta() == planta;
	}

}
