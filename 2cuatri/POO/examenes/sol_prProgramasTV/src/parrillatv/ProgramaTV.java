package parrillatv;

/**
 * Clase que mantiene información sobre los datos de un programa de TV, consistentes en 
 * el nombre del programa (de tipo String), la hora de inicio del programa (de tipo Hora) y la
 * duración del mismo (en minutos, de tipo int).
 * 
 * @author POO
 *
 */
public class ProgramaTV implements Comparable<ProgramaTV> {
	/**
	 * Nombre del programa
	 */
	private String nombre;
	
	/**
	 * Hora de inicio del programa
	 */
	private Hora horaInicio;
	
	/**
	 * Duración en minutos del programa
	 */
	private int duracion;
	
	/**
	 * Constructor para crear un programa de TV a partir de su nombre, 
	 * la hora de comienzo y la duración del mismo.
	 * @param np	Nombre del programa (String)
	 * @param hi		Hora de inicio (Hora)
	 * @param dur	Duración en minutos
	 */
	public ProgramaTV(String np, Hora hi, int dur) {
		// Si la duración es negativa se lanza una excepción
		if (dur<0) throw new ProgramacionTVException("La duración del programa no puede ser negativa");
		nombre = np;
		horaInicio = hi;
		duracion = dur;
	}
	
	/**
	 * Devuelve el nombre del programa
	 * @return	Nombre del programa
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Devuelve la duración del programa
	 * @return	Duración del programa
	 */
	public int getDuracion() {
		return duracion;
	}
	
	/**
	 * Devuelve la hora de inicio del programa
	 * @return	Hora de inicio
	 */
	public Hora getHoraInicio() {
		return horaInicio;
	}
	
	/** 
	 * Calcula la hora de finalización del programa, a partir de la hora de inicio y la duración.
	 * @return	Hora de finalización del programa
	 */
	public Hora getHoraFin() {
		int mm = horaInicio.getMinuto() + duracion;
		int hh = horaInicio.getHora();
		return new Hora(hh,mm);
	}
	
	/**
	 * Dos programas son iguales si tienen el mismo nombre, independientemente de mayúsculas
	 * y minúsculas, la misma hora de inicio y la misma duración.
	 */
	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof ProgramaTV;
		ProgramaTV prog = res? (ProgramaTV) o : null;
		return res && nombre.equalsIgnoreCase(prog.nombre) &&
					horaInicio.equals(prog.horaInicio) && duracion == prog.duracion;
	}
	
	/**
	 * El método hashCode se ha de redefinir para mantener la consistencia con el método equals.
	 */
	@Override
	public int hashCode() {
		return nombre.toUpperCase().hashCode() + horaInicio.hashCode() + Integer.hashCode(duracion);
	}
	
	/**
	 * Un programa se considera menor que otro cuando su hora de inicio es anterior. 
	 * En caso de tener un inicio coincidente, cuando su duración es menor. 
	 * Y si esta también es la misma, cuando el nombre es anterior lexicográficamente, 
	 * sin distinguir minúsculas y mayúsculas.
	 */
	@Override
	public int compareTo(ProgramaTV prog) {
		int res = horaInicio.compareTo(prog.horaInicio);
		if (res == 0)
			res = Integer.compare(duracion, prog.duracion);
		if (res == 0)
			res = nombre.compareToIgnoreCase(prog.nombre);
		return res;
	}
	
	/**
	 * Representación textual de un programa dado por:
	 * 		NOMBRE DEL PROGRAMA @ hora de inicio-duración
	 */
	@Override
	public String toString() {
		return nombre.toUpperCase() + "@" + horaInicio + "-" + duracion;
	}

}
