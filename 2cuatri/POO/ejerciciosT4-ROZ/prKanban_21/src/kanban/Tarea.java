package kanban;

import java.util.Objects;

public class Tarea {
	private String estado;
	private final String titulo;
	private int prioridad;
	private final double horasEstimadas;
	private double horasConsumidas;
	
	public Tarea(String estado, String titulo, int prioridad, double estimadas, double consumidas) throws KanbanException {
		if(titulo.length() <= 0) {
			throw new KanbanException("El título no puede ser vacío.");
		}
		else if (!esEstadoValido(estado.toUpperCase())) {
			throw new KanbanException("El estado debe ser válido (NOINICIADA, ENPROCESO Ó TERMINADA).");
		}
		else if (prioridad < 1 || prioridad > 5) {
			throw new KanbanException("La prioridad debe ser un número entre 1 y 5.");
		}
		else if (consumidas < 0) {
			throw new KanbanException("Las horas consumidas deben ser > que 0.");
		}
		else if (estimadas <= 0) {
			throw new KanbanException("Las horas estimadas deben ser >= que 0.");
		}
		this.estado = estado.toUpperCase();
		this.titulo = titulo;
		this.prioridad = prioridad;
		this.horasEstimadas = estimadas;
		this.horasConsumidas = consumidas;
	}
	
	Tarea(String titulo) throws KanbanException {
		this("NOINICIADA", titulo,1,1,0);
	}
	
	private static boolean esEstadoValido(String est) {
		return est.equals("NOINICIADA") || est.equals("ENPROCESO") || est.equals("TERMINADA");
	}

	public String getEstado() {
		return estado;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getPrioridad() {
		return prioridad;
	}

	public double getHorasEstimadas() {
		return horasEstimadas;
	}

	public double getHorasConsumidas() {
		return horasConsumidas;
	}

	public void setEstado(String estado) throws KanbanException {
		if(!esEstadoValido(estado.toUpperCase())) {
			throw new KanbanException("El estado debe ser válido (NOINICIADA, ENPROCESO Ó TERMINADA).");
		}
		this.estado = estado;
	}

	public void setPrioridad(int prioridad) throws KanbanException{
		if (prioridad < 1 || prioridad > 5) {
			throw new KanbanException("La prioridad debe ser un número entre 1 y 5.");
		}
		this.prioridad = prioridad;
	}

	public void setHorasConsumidas(double horasConsumidas) throws KanbanException{
		if (horasConsumidas < 0) {
			throw new KanbanException("Las horas consumidas deben ser > que 0.");
		}
		this.horasConsumidas = horasConsumidas;
	}
	
	@Override
	public String toString() {
		return "Tarea: " + getTitulo() + ". " + getEstado() + " prioridad:" + getPrioridad() +
				" horas:(" + getHorasConsumidas() +"/"+ getHorasEstimadas()+")";
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Tarea) {
			Tarea t = (Tarea) obj;
			res =  t.getTitulo().equalsIgnoreCase(titulo);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(titulo.toUpperCase());
	}
	
	
}
