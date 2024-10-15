import java.io.FileNotFoundException;
import java.io.PrintWriter;

import covid.InfoCierrePerimetral;
import covid.InfoCOVID;
import covid.InfoPoblacion;
import covid.MapaCOVID;

/**
 * Clase de prueba del proyecto prMapaCOVID. 
 * Al final de la clase se incluye la salida esperada.
 * 
 * @author POO
 *
 */
public class PruebaMapaCOVID {
	public static void main(String[] args) throws FileNotFoundException {
		// Creamos un objeto MapaCOBID con los datos de Andaluc�a, actualizados a fecha 2 de junio de 2021
		MapaCOVID mapa = new MapaCOVID("Andalucía", "datosCOVID-dist.csv");
		
		// Volcamos en pantalla la información del mapa COVID de Andalucía
		mapa.mostrarMapa(new PrintWriter(System.out,true));
		
		// Guardamos en un fichero la información del mapa COVID de Andalucía
		mapa.mostrarMapa("mapaCOVIDAndalucia.txt");
	
		// Definimos una variable para obtener información diversa. Inicialmente, se inicializa a null
		InfoCOVID info = null;
		
		// Volcamos por pantalla información sobre rangos de población de los distritos sanitariso
		System.out.println("\nINFORMACIÓN DE DISTRITOS SANITARIOS CON");
		int inc = 100000;
		for (int pob = 0; pob < 600000 ; pob+=inc) {
			info = new InfoPoblacion(pob,pob+inc);
			System.out.println("POBLACIÓN ENTRE " + pob + " Y " + (pob+inc) + ": \n\t" + mapa.obtenerInfoCOVID(info));
		}
		info = new InfoPoblacion(600000,2000000);
		System.out.println("POBLACIÓN MAYOR QUE 600000: \n\t" + mapa.obtenerInfoCOVID(info));
		
		// Volcamos por pantalla informaci�n sobre provincias con cierre perimetral
		info = new InfoCierrePerimetral();
		System.out.print("\nINFORMACIÓN DE PROVINCIAS CON CIERRE PERIMETRAL: ");
		System.out.println(mapa.obtenerInfoCOVID(info));
	}
	
/*

ANDALUCÍA: 
Almeria
	Distrito(Almeria Distrito,246)
	Distrito(Levante-Alto Almanzora,119)
	Distrito(Poniente de Almeria,157)
Cadiz
	Distrito(Bahia de Cadiz-La Janda,542)
	Distrito(Campo de Gibraltar Este,93)
	Distrito(Campo de Gibraltar Oeste,251)
	Distrito(Jerez-Costa Noroeste,397)
	Distrito(Sierra de Cadiz,253)
Cordoba
	Distrito(Cordoba Distrito,558)
	Distrito(Cordoba Norte,149)
	Distrito(Cordoba Sur,355)
	Distrito(Guadalquivir,101)
Granada
	Distrito(Granada Distrito,709)
	Distrito(Granada Nordeste,63)
	Distrito(Granada Sur,234)
	Distrito(Metropolitano de Granada,1019)
Huelva
	Distrito(Condado-Campina,572)
	Distrito(Huelva-Costa,691)
	Distrito(Sierra de Huelva-Andavalo Central,112)
Jaen
	Distrito(Jaen,482)
	Distrito(Jaen Nordeste,204)
	Distrito(Jaen Norte,602)
	Distrito(Jaen Sur,259)
Malaga
	Distrito(Axarquia,184)
	Distrito(Costa del Sol,761)
	Distrito(La Vega,291)
	Distrito(Malaga Distrito,761)
	Distrito(Serrania,99)
	Distrito(Valle del Guadalhorce,262)
Sevilla
	Distrito(Aljarafe,663)
	Distrito(Sevilla Distrito,1194)
	Distrito(Sevilla Este,693)
	Distrito(Sevilla Norte,1317)
	Distrito(Sevilla Sur,638)

INFORMACIÓN DE DISTRITOS SANITARIOS CON
POBLACIÓN ENTRE 0 Y 100000: 
	[Cordoba Norte, Granada Nordeste, Jaen Sur, Serrania, Sierra de Huelva-Andavalo Central]
POBLACIÓN ENTRE 100000 Y 200000: 
	[Axarquia, Campo de Gibraltar Este, Campo de Gibraltar Oeste, Condado-Campina, Granada Sur, Guadalquivir, Jaen, Jaen Nordeste, Jaen Norte, La Vega, Levante-Alto Almanzora, Sevilla Este, Sierra de Cadiz, Valle del Guadalhorce]
POBLACIÓN ENTRE 200000 Y 300000: 
	[Cordoba Sur, Granada Distrito, Huelva-Costa, Poniente de Almeria, Sevilla Norte]
POBLACIÓN ENTRE 300000 Y 400000: 
	[Aljarafe, Almeria Distrito, Cordoba Distrito, Jerez-Costa Noroeste]
POBLACIÓN ENTRE 400000 Y 500000: 
	[Metropolitano de Granada, Sevilla Sur]
POBLACIÓN ENTRE 500000 Y 600000: 
	[Bahia de Cadiz-La Janda, Costa del Sol]
POBLACIÓN MAYOR QUE 600000: 
	[Malaga Distrito, Sevilla Distrito]

INFORMACIÓN DE PROVINCIAS CON CIERRE PERIMETRAL: []

*/
}
