package parrillatv;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Clase para representar parrillas de TV, donde los huecos entre programas, son rellanados por anuncios,
 * considerados también instancias de la clase Programa.
 * 
 * @author POO
 *
 */
public class ProgramacionTVCompacta extends ProgramacionTV {
	/**
	 * Redefinición del método leerProgramas que, después de leer la información del fichero,
	 * añade anuncios a la parrilla con el método auxiliar agregarAnuncios.
	 * @throws IOException 
	 */
	@Override
	public void leerProgramas(String fichero) throws IOException {
		super.leerProgramas(fichero);
		agregarAnuncios();
	}
	
	/** 
	 * Método auxiliar para añadir anuncios a la parrilla de todas las cadenas de TV.
	 */
	protected void agregarAnuncios() {
		for (String cadenaTV : cadenas.keySet()) 
			agregarAnuncios(cadenaTV);
	}
	
	/**
	 * Método auxiliar para añadir anuncios a una cadena determinada, proporcionada como parámetro.
	 * Los anuncios se añaden como programas con la denominación "Publicidad", con hora de inicio, 
	 * la hora de finalización del programa anterior, y con duración la necesaria para rellenar el 
	 * hueco hasta la hora de inicio del programa siguiente. Los anuncios comienzan en la hora 00:00.
	 * 
	 * 
	 * @param cadenaTV	Nombre de la cadena de TV
	 */
	protected void agregarAnuncios(String cadenaTV) {
		if (!esConsistente(cadenaTV)) throw new ProgramacionTVException("La parrilla de " + cadenaTV + " incluye programas que se solapan en tiempo de emisi�n"); 
		Hora horaInicio = new Hora(0,0);
		Set<ProgramaTV> publicidad = new HashSet<>();
		for (ProgramaTV pr : cadenas.get(cadenaTV)) {
			int duracion = horaInicio.diferenciaMinutos(pr.getHoraInicio());
			if (duracion > 0) { // Solo se añaden anuncios si hay hueco
				ProgramaTV anuncios = new ProgramaTV("Publicidad",horaInicio,duracion);
				// No se puede añadir directamente la publicidad al map, porque 
				// se produciría una excepción de modificación concurrente de la estructura
				// anyadir(cadenaTV,anuncios); 
				// Por ello, se van añadiendo a un conjunto auxiliar, para añadirlos a los canales al final.
				publicidad.add(anuncios);
			}
			horaInicio = pr.getHoraFin();
		}
		// Añadimos todo el conjunto 
		//SortedSet<ProgramaTV> programas = canales.get(cadenaTV);
		//programas.addAll(publicidad);
		for (ProgramaTV pr : publicidad) {
			agregar(cadenaTV,pr);
		}
	}
	

}
