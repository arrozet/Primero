import kanban.*;
public class PruebaTarea {

	public static void main(String[] args) {
		try {
			Tarea t1 = new Tarea("ENPROCESO", "JUAN", 5, 10, 2);
			Tarea t2 = new Tarea("NOINICIADA", "JUAN", 4, 10, 7);
//			// mal estado
//			Tarea t3 = new Tarea("XD", "ASF", 4, 10, 6);
//			// titulo vacio
//			Tarea t4 = new Tarea("NOINICIADA", "", 4, 10, 6);
//			// prioridad fuera de rango
//			Tarea t5 = new Tarea("TERMINADA", "asdf", 45, 10, 6);
			
			System.out.println(t1);
			System.out.println(t2);
			
			if(t1.equals(t2)) {
				System.out.println("Las tareas son igules");
			}
			else {
				System.out.println("Las tareas no son iguales");
			}
		} catch (KanbanException e) {
			System.err.println(e.getMessage());
		}

	}

}
