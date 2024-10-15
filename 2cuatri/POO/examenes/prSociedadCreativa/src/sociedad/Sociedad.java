//NOMBRE:		Oliva Zamora, Rubén 
//TITULACIÓN:	Ingeniería del Software
//GRUPO:		A

package sociedad;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class Sociedad {
	private Map<String, Set<Socio>> membersInActivities;
	private Set<Socio> membersNotInActivities;
	
	public Sociedad() {
		membersInActivities = new HashMap<>();
		membersNotInActivities = new HashSet<>();
	}
	
	public void leerDeFichero(String fich) {
		Path fichero = Path.of(fich);
		try(Scanner sc = new Scanner(fichero)){
			while(sc.hasNextLine()) {
				procesarLinea(sc.nextLine());
			}
		}
		catch (IOException e) {
			throw new SociedadException("No se encuentra el fichero" + fich);
		}
	}
	
	private void procesarLinea(String linea) {
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[%]");
			while(sc.hasNext()) {
				String nombre = sc.next();
				String intereses = sc.next();
				int ident = sc.nextInt();
				Set<String> s = procesarIntereses(intereses);
				nuevoSocio(new Socio(nombre, s, ident));
			}
		}
		catch (InputMismatchException e) {
//			System.err.println("El dato a obtener no era el esperado " + e.getMessage());
		}
		catch (NoSuchElementException ee) {
//			System.err.println("No hay mas elementos a obtener " + ee.getMessage());
		}
	}
	
	private Set<String> procesarIntereses(String intereses){
		Set<String> s = new HashSet<>();
		
		try(Scanner sc = new Scanner(intereses)){
			sc.useDelimiter("[,]");
			while(sc.hasNext()) {
				s.add(sc.next());
			}
		}
		catch (InputMismatchException e) {
//			System.err.println("El dato a obtener no era el esperado " + e.getMessage());
		}
		catch (NoSuchElementException ee) {
//			System.err.println("No hay mas elementos a obtener " + ee.getMessage());
		}
		
		return s;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public void nuevoSocio(Socio m) {
		if(!membersNotInActivities.contains(m) && !membersInActivities.values().contains(m)) {
			membersNotInActivities.add(m);
		}
	}
	
	public Set<Socio> inscritos(String actividad){
		return membersInActivities.getOrDefault(actividad.toLowerCase(), null);
	}
	
	protected Socio buscarSocioEnConjunto(Socio s, Set<Socio> ss) {
		boolean encontrado = false;
		Socio buscado = null;
		
		if(ss.contains(s)) {
			Iterator<Socio> iter = ss.iterator();
			
			while(iter.hasNext() && !encontrado) {
				Socio aux = iter.next();
				if(aux.equals(s)) {
					encontrado = true;
					buscado = aux;
				}
			}
		}
		
		return buscado;
	}
	
	public void inscribir(String nombre, int identidicador, String actividad) {
		Socio s = buscarSocioEnConjunto(new Socio(nombre, new HashSet<>(), identidicador), membersNotInActivities);
		if(s!=null) {
			membersNotInActivities.remove(s);
			Set<Socio> socios_actividad = membersInActivities.getOrDefault(actividad.toLowerCase(),new HashSet<>());
			socios_actividad.add(s);
			membersInActivities.put(actividad.toLowerCase(), socios_actividad);
		}
	}
	
	public void guardarSocios(String fichero) {
		try(PrintWriter pw = new PrintWriter(fichero)){
			guardarSocios(pw);
		}
		catch (FileNotFoundException e) {
			throw new SociedadException("No se pudo encontrar el fichero " + fichero);
		}
	}
	
	public void guardarSocios(PrintWriter pw) {
		for (Socio socio : membersNotInActivities) {
			pw.println(socio);
		}
	}
}
