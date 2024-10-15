package parrillatv;

import java.util.Objects;

public class ProgramaTV implements Comparable<ProgramaTV> {
	private String nombre;
	private int duracion;
	private Hora horaInicio;
	
	public ProgramaTV(String nombre, Hora hora, int duracion) {	// duracion en minutos
		if(duracion<0) {
			throw new ProgramacionTVException("La duración no puede ser negativa");
		}
		this.duracion = duracion;
		this.nombre = nombre;
		this.horaInicio = hora;
		
	}

	public String getNombre() {
		return nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public Hora getHoraInicio() {
		return horaInicio;
	}
	
	public Hora getHoraFin() {
		Hora horaFin=new Hora(horaInicio.getHora(), horaInicio.getMinuto());
		horaFin.incrementar(duracion);
		return horaFin;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof ProgramaTV) {
			ProgramaTV p = (ProgramaTV) obj;
			res = nombre.equalsIgnoreCase(p.nombre) && 
					horaInicio.equals(p.horaInicio) && duracion==p.duracion;
		}
		
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre.toLowerCase(), horaInicio, duracion);
	}
	
	@Override
	public int compareTo(ProgramaTV o) {
		int res = horaInicio.compareTo(o.horaInicio);
		if(res==0) {
			res = Integer.compare(duracion, o.duracion);
			if(res==0) {
				res = nombre.compareToIgnoreCase(o.nombre);
			}
		}
		return res;
	}
	
	@Override
	public String toString() {
		return nombre.toUpperCase() + "@" + horaInicio + "-" + duracion;
	}
}
