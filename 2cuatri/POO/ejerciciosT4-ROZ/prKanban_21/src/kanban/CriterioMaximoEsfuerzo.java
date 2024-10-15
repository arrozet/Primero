package kanban;

import java.util.ArrayList;

public class CriterioMaximoEsfuerzo implements Criterio{
	
	public CriterioMaximoEsfuerzo() {
		super();
	}
	
	@Override
	public ArrayList<Tarea> filtrar(ArrayList<Tarea> tareas) {
		ArrayList<Tarea> filtrados=new ArrayList<>();
		double mayorhoras = 0;
		for(Tarea t:tareas) {
			if(t.getHorasEstimadas() > mayorhoras) {
				mayorhoras = t.getHorasEstimadas();
			}
		}
		
		for(Tarea t:tareas) {
			if(t.getHorasEstimadas() == mayorhoras) {
				filtrados.add(t);
			}
		}
		return filtrados;
	}
}
