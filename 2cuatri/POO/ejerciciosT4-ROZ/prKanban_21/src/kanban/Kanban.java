package kanban;

import java.util.ArrayList;

public class Kanban {
	private ArrayList<Tarea> tareas;
	
	public Kanban(String[] datos) {
		tareas = new ArrayList<>();
		
		for(int i = 0; i<datos.length; i++) {
			String[] tarea = datos[i].split(";");
			
			try {
				Tarea taux = new Tarea(tarea[0], tarea[1], Integer.parseInt(tarea[2]), 
						Double.parseDouble(tarea[3]), Double.parseDouble(tarea[4]));
				tareas.add(taux);
				
			} catch (NumberFormatException e) {
				System.err.println("Ha habido un error al convertir a número algún parámetro.");
				
			} catch (KanbanException e) {
				System.err.println(e.getMessage());
			}
			catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}
	
	public String resumenTareas(){
		int contNI=0, contEP=0, contT=0; 
		double h_con=0, h_est=0;
		
		for(Tarea t: tareas) {
			if(t.getEstado().equals("NOINICIADA")) {
				contNI++;
			}
			else if(t.getEstado().equals("ENPROCESO")) {
				contEP++;
			}
			else if(t.getEstado().equals("TERMINADA")) {
				contT++;
			}
			h_con += t.getHorasConsumidas();
			h_est += t.getHorasEstimadas();
		}
		
		return "RESUMEN DE TAREAS\n" + 
		contNI + " No iniciada. " +
		contEP + " En proceso. " + 
		contT + " Terminada.\n" + 
		"Horas consumidas: " + h_con + ". Horas estimadas:" + h_est;
	}
	
	public ArrayList<Tarea> seleccionar(Criterio criterio) {
		return criterio.filtrar(tareas);
	}
	
	@Override
	public String toString() {
		return tareas.toString();
	}
}
