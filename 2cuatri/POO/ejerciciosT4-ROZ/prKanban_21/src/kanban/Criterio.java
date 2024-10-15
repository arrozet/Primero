package kanban;

import java.util.ArrayList;

public interface Criterio {
	public ArrayList<Tarea> filtrar(ArrayList<Tarea> tareas);
}
