package covid;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Clase que representa el mapa COVID de una comunidad autónoma, donde los distritos sanitarios se organizan
 * por provincias.
 * 
 * @author POO
 *
 */
public class MapaCOVID {
	/**
	 * Variable que representa el nombre de la región o comunidad autónoma
	 */
	private String nombre;
	
	/**
	 * Correspondencia que asocia a cada provincia (nombre) un conjunto de distritos sanitarios
	 */
	private SortedMap<String,SortedSet<DistritoSanitario>> mapa;
	
	/**
	 * Constructor que inicializa el mapa COVID y lee los datos de los distritos
	 * almacenados en un fichero de texto.
	 * 
	 * @param nomFichero	Nombre del fichero con los datos
	 * @throws FileNotFoundException 
	 */
	public MapaCOVID(String region, String nomFichero) throws FileNotFoundException {
		nombre = region;
		mapa = new TreeMap<>();
		leerDatos(nomFichero);
	}
	
	/**
	 * Método para obtener el nombre del mapa (región o comunidad autónoma)
	 * 
	 * @return Nombre del mapa
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * Método para obtener los datos de una provincia (distribuidos por distritos sanitarios)
	 * almcenados en un fichero, asumiendo el siguiente formato:
	 * 		DistritoSanitario(Provincia):población:casosCOVID
	 * Por ejemplo,
	 * 		Axarquía(Málaga):170141:184
	 * @param nomFichero		Nombre del fichero con la información
	 * @throws FileNotFoundException	Cuando el fichero indicado no existe
	 */
	public void leerDatos(String nomFichero) throws FileNotFoundException {
		try(Scanner scFichero = new Scanner(new File(nomFichero))) {
			leerDatos(scFichero);
		}
	}
	
	/**
	 * Método para obtener los datos de una provincia (distribuidos por distritos sanitarios)
	 * procedentes de un Scaner, con el formato por líneas siguiente:
	 * 		DistritoSanitario(Provincia):población:casosCOVID
	 * Por ejemplo,
	 * 		Axarquía(Málaga):170141:184
	 * En caso de que un distrito sanitario aparezca más de una vez en líneas distintas, 
	 * se aadirá la información correspondiente a la primera aparición. 
	 * Si alguna línea no tuviese el formato correcto, se omitirá su procesamiento, y 
	 * se continuará con la siguiente línea.
	 * 
	 * @param sc		Scanner desde el que se obtienen los datos del mapa COVID
	 */
	public void leerDatos(Scanner sc) {
		while (sc.hasNextLine()) {
			String linea = sc.nextLine();
			try(Scanner scLinea = new Scanner(linea)){
				scLinea.useDelimiter("[():]+");
				String distrito = scLinea.next();
				String provincia = scLinea.next();
				int poblacion = scLinea.nextInt();
				int casosCOVID = scLinea.nextInt();
				DistritoSanitario ds = new DistritoSanitario(distrito,poblacion,casosCOVID);
				agregarDistrito(provincia,ds);
			} catch (NoSuchElementException | COVIDException nsee) {
				// Se ignora la línea
			} 
		}
	}
	
	/**
	 * Método para obtener las provincias (sus nombres) almacenadas en el mapa
	 * 
	 * @return	Conjunto con las provincias
	 */
	public Set<String> getProvincias() {
		return mapa.keySet();
	}
	
	/**
	 * Método para obtener todos los distritos sanitarios almacenados en el mapa
	 * 
	 * @return Conjunto con los distritos sanitarios
	 */
	public Set<DistritoSanitario> getDistritos() {
		SortedSet<DistritoSanitario> distritos = new TreeSet<>();
        for (SortedSet<DistritoSanitario> distritosProvincia : mapa.values()) {
            distritos.addAll(distritosProvincia);
        }
        return distritos;
	}
	
	/**
	 * Método para agregar un distrito sanitario a una provincia. 
	 * En caso de que un distrito sanitario ya está en la provincia, 
	 * no se hace nada
	 * @param prov	Nombre de la provincia
	 * @param ds		Distrito sanitario a añadir al mapa
	 */
	public void agregarDistrito(String prov, DistritoSanitario ds) {
		SortedSet<DistritoSanitario> distritos = mapa.get(prov);
		if (distritos == null) {
			distritos = new TreeSet<>();
			mapa.put(prov,distritos);
		}
		distritos.add(ds);
	}
	
	/** 
	 * Método que devuelve la incidencia acumulada cada 100.000 habitantes de una 
	 * determinada provincia, obtenida a partir de la población y casos acumulados en cada
	 * distrito universitario de la provincia. En caso de que no conste población o la provincia
	 * no está en el mapa, se devolverá 0 como incidencia acumulada.
	 * @param prov	Provincia
	 * @return				Incidencia acumulada de la provincia
	 */
	public int incidenciaProvincia(String prov) {
		SortedSet<DistritoSanitario> distritos = mapa.getOrDefault(prov,new TreeSet<>());
		int poblacionProv = 0;
		int casosProv = 0;
		for (DistritoSanitario distrito : distritos) {
			poblacionProv += distrito.getPoblacion();
			casosProv += distrito.getCasosCOVID14dias();
		}
		return poblacionProv == 0 ? 0 : casosProv*100000 / poblacionProv;
	}
	
	/**
	 * Método para obtener información COVID dependiendo del objeto InfoCOVID que se pasa como argumento.
	 * La información que se obtiene siempre será un conjunto con las provincias, o con los distritos sanitarios, o ambos, 
	 * que cumplan determinadas condiciones. 
	 * 
	 * @param info	Objeto que implementa la interfaz InfoCOVID
	 * @return			Conjunto de elementos (provincias o distritos) que satisfacen las condiciones definidas en el objeto info
	 */
	public Set<String> obtenerInfoCOVID(InfoCOVID info) {
		return info.obtenerInfo(this);
	}
	
	/**
	 * Método para guardar la información del mapa COVID sobre el fichero indicado en el argumento.
	 * La información se guardará por líneas indicando inicialmente el nombre de la región (en mayúsculas),
	 * seguido de dos puntos, y a continuación el nombre de la provincia y los distritos sanitarios de la misma, 
	 * sangrados con un tabulador.
	 * Por ejemplo:
	 * 
	 * ANDALUCÍA: 
	 * 	Almería
	 *		Distrito(Almería Distrito,246)
	 *		Distrito(Levante-Alto Almanzora,119)
	 *		Distrito(Poniente de Almería,157)
	 *	Cádiz
	 *		Distrito(Bahía de Cádiz-La Janda,542)
	 *		Distrito(Campo de Gibraltar Este,93)
	 *		...
	 * @param nomFichero		Nombre del fichero 
	 * @throws FileNotFoundException	
	 */
	public void mostrarMapa(String nomFichero) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(nomFichero)) {
			mostrarMapa(pw);
		}
	}
	
	/**
	 * Método para enviar la información del mapa COVID sobre el PrintWriter indicado en el argumento.
	 * La información se enviará por líneas indicando inicialmente el nombre de la región (en mayúsculas),
	 * seguido de dos puntos, y a continuación el nombre de la provincia y los distritos sanitarios de la misma, 
	 * sangrados con un tabulador.
	 * Por ejemplo:
	 * 
	 * ANDALUCIA: 
	 * 	Almería
	 *		Distrito(Almería Distrito,246)
	 *		Distrito(Levante-Alto Almanzora,119)
	 *		Distrito(Poniente de Almería,157)
	 *	Cádiz
	 *		Distrito(Bahía de Cádiz-La Janda,542)
	 *		Distrito(Campo de Gibraltar Este,93)
	 *		...
	 * @param pw	PrintWriter sobre el que se envía la información
	 */
	public void mostrarMapa(PrintWriter pw) {
		pw.println(nombre.toUpperCase()+": ");
		for(Map.Entry<String,SortedSet<DistritoSanitario>> entrada : mapa.entrySet()) {
			pw.println(entrada.getKey());
			for(DistritoSanitario distrito : entrada.getValue())
				pw.println("\t" + distrito);
		}
	}

}
