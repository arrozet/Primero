package covid;


/**
 * Clase que representa los distritos sanitarios de una provincia, incluyendo información sobre su denominación,
 * la población atendida en ese distrito y el número de casos positivos COVID acumulados en los últimos catorce días.
 * 
 * @author POO
 *
 */
public class DistritoSanitario implements Comparable<DistritoSanitario> {
	/**
	 * Nombre del distrito sanitario
	 */
	private String distrito;
	
	/**
	 * Población del distrito sanitario
	 */
	private int poblacion;
	
	/**
	 * Positivos COVID acumulados en los últimos 14 días
	 */
	private int casosCOVID14dias;
	
	/**
	 * Constructor para crear distritos sanitarios, proporcionando su nombre, población y número de casos
	 * positivos COVID acumulados en los últimos 14 días
	 * @param dist	Nombre del distrito
	 * @param pob	número de habitantes del distrito
	 * @param casos	número de casos positivos en los últimos 14 días
	 */
	public DistritoSanitario(String dist, int pob, int casos) {
		if (pob <= 0 || casos < 0)
			throw new COVIDException("La población y el número de casos acumulados deben ser positivos");
		distrito = dist;
		poblacion = pob;
		casosCOVID14dias = casos;
	}
	
	/**
	 * Método para obtener el nombre del distrito
	 * @return	Cadena de caracteres con el nombre del distrito
	 */
	public String getDistrito() {
		return distrito;
	}
	
	/**
	 * Método para obtener el número de habitantes del distrito sanitario
	 * @return	población del distrito
	 */
	public int getPoblacion() {
		return poblacion;
	}
	
	/**
	 * Método para obtener el número de casos COVID acumulados en los últimos 14 días
	 * @return	número de casos COVID acumulados
	 */
	public int getCasosCOVID14dias() {
		return casosCOVID14dias;
	}
	
	/**
	 * Método para modificar el número de casos COVID acumulados en los últimos 14 días
	 * @param nuevosCasos	número actualizado de casos COVID
	 */
	public void setCasosCOVID14dias(int casosActualizados) {
		if(casosActualizados < 0) throw new COVIDException("El número de casos positivos debe ser mayor o igual que cero");
		casosCOVID14dias = casosActualizados;
	}
	
	/**
	 * Método que devuelve la incidencia acumulada calculada como el número de casos por cada 100.000 habitantes
	 * @return	Entero con la incidencia acumulada
	 */
	public int incidenciaAcumulada() {
		return casosCOVID14dias*100000 / poblacion;
	}
	
	/**
	 * Dos objetos de la clase DistritoSanitario se consideran iguales cuando su nombre coincide independientemente de
	 * may�sculas y min�sculas
	 */
	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof DistritoSanitario;
		DistritoSanitario ds = res ? (DistritoSanitario) obj : null;
		return res && distrito.equalsIgnoreCase(ds.distrito);
	}
	
	/**
	 * Redefinición del Método equals consistente con equals
	 */
	@Override
	public int hashCode() {
		return distrito.toUpperCase().hashCode();
	}
	
	/**
	 * Un distrito sanitario se considera menor que otro cuando su denominación es anterior en el orden lexicográfico, independientemente 
	 * de mayúsculas y minúsculas.
	 */
	@Override
	public int compareTo(DistritoSanitario ds) {
		return distrito.compareToIgnoreCase(ds.distrito);
	}
	
	/**
	 * Representación textual de un objeto DistritoSanitario dada por el siguiente formato:
	 * 		Distrito(distrito,casosCOVID)
	 */
	@Override
	public String toString() {
		return "Distrito(" + distrito + "," + casosCOVID14dias + ")";
	}

}
