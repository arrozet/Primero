package hospital;

public class NacidoAntesDe implements Criterio {
	private int ano;

	public NacidoAntesDe(int a) {
		ano = a;
	}

	public boolean cumpleCondicion(Paciente c, Habitacion h) {
		return Integer.compare(c.getAnoDeNacimiento(), ano) <= -1;
	}

}
