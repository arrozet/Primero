package notas;

import java.util.ArrayList;
import java.util.List;

public class Asignatura {
	private String nombre;
	private List<Alumno> alumnos;
	private List<String> errores;
	
	public Asignatura(String nombre, String[] info) {
		this.nombre = nombre;
		alumnos = new ArrayList<>();
		errores = new ArrayList<>();
		
		for(int i=0; i<info.length; i++) {
			try {
				String[] datos_alumno = info[i].split(";");
				alumnos.add(new Alumno(datos_alumno[0], datos_alumno[1], Double.parseDouble(datos_alumno[2])));
			} catch (AlumnoException e) {
				errores.add("ERROR. " + e.getMessage() + info[i].toString());
//				System.err.println("ERROR. " + e.getMessage() + info[i].toString());
			}
			catch (IndexOutOfBoundsException e) {
				errores.add("ERROR. Faltan datos: " + info[i].toString());
//				System.err.println("ERROR. Faltan datos: " + info[i].toString());
			}
			catch (NumberFormatException e) {
				errores.add("ERROR. Calificación no numérica: " + info[i].toString());
//				System.err.println("ERROR. Calificación no numérica: " + info[i].toString());
			}
			
		}
	}

	public double getCalificacion(Alumno al) throws AlumnoException{
		int pos = alumnos.indexOf(al);
		if(pos == -1) {
			throw new AlumnoException("El alumno " + al + " no se encuentra");
		}
		return alumnos.get(pos).getCalificacion();
	}
	
	public String getNombre() {
		return nombre;
	}

	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	public List<String> getErrores() {
		return errores;
	}
	
	public double getMedia() throws AlumnoException {
		double media=0;
		if(alumnos.size() == 0) {
			throw new AlumnoException("No hay alumnos");
		}
		for(int i=0; i<alumnos.size(); i++) {
			media += alumnos.get(i).getCalificacion();
		}
		media /= alumnos.size();
		return media;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(nombre + ": { ");
		sb.append(alumnos.toString() + "," + errores.toString() + " }");
		
		return sb.toString();
	}
	
	
}
