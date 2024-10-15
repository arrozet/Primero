//APELLIDOS Y NOMBRE: 		Oliva Zamora, Rubén
//GRADO: 					Ingeniería del software
//GRUPO: 					A

package hospital;

public class MismaPlanta implements Criterio{
	private int planta;
	
	public MismaPlanta(int planta) {
		this.planta = planta;
	}

	@Override
	public boolean cumpleCondicion(Paciente p, Habitacion h) {
		boolean res = false;
		if(h.getPlanta()==planta) {
			res = true;
		}
		
		return res;
	}
	
	
}
