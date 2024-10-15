//APELLIDOS Y NOMBRE: 		Oliva Zamora, Rubén
//GRADO: 					Ingeniería del software
//GRUPO: 					A

package hospital;

public class NacioAntesDe implements Criterio{
	private int ano;
	
	public NacioAntesDe(int ano) {
		this.ano = ano;
	}

	@Override
	public boolean cumpleCondicion(Paciente p, Habitacion h) {
		boolean res = false;
		if(p.getAnoDeNacimiento() < ano) {
			res = true;
		}
		return res;
	}
	
	
}
