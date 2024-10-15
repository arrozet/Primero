package kanban;

import java.util.ArrayList;

public class CriterioPrioridad implements Criterio{
	int prioridad;
	
	public CriterioPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}
	
	@Override
	public ArrayList<Tarea> filtrar(ArrayList<Tarea> tareas) {
		ArrayList<Tarea> filtrados=new ArrayList<>();
		for(Tarea t:tareas) {
			if(t.getPrioridad() == prioridad) {
				filtrados.add(t);
			}
		}
		return filtrados;
	}
	
	
}
