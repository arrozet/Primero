package ejercicios_tema4;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Asignatura {
	private ArrayList<Estudiante> estudiantes;
	
	public Asignatura() {
		estudiantes = new ArrayList<>();
	}
	
	public void almacenarEstudiante(Estudiante e) {
		int pos = estudiantes.indexOf(e);
		
		if(pos == -1) {
			estudiantes.add(e);
		}
		else {
			estudiantes.set(pos, e);
		}
	}
	
	// hay que hacerlo con String, StringBuilder y StringJoiner
	
	// String
//	@Override
//	public String toString() {
//		String res = "{";
//		for(int i=0; i<estudiantes.size(); i++) {
//			if(i==estudiantes.size()-1) {
//				res += estudiantes.get(i);
//			}
//			else {
//				res += estudiantes.get(i) + " - ";
//			}
//		}
//		res += "}";
//		
//		return res;
//	}
	
	// StringBuilder
//	@Override
//	public String toString() {
//		StringBuilder res = new StringBuilder("{");
//		for(int i=0; i<estudiantes.size(); i++) {
//			if(i==estudiantes.size()-1) {
//				res.append(estudiantes.get(i));
//			}
//			else {
//				res.append(estudiantes.get(i) + " - ");
//			}
//		}
//		res.append("}");
//		return res.toString();
//	}
	
	// StringJoiner
	@Override
	public String toString() {
		StringJoiner res = new StringJoiner(" - ", "{", "}");
		String aux = "";
		for(int i=0; i<estudiantes.size(); i++) {
			aux = "";
			aux += estudiantes.get(i);
			res.add(aux);
		}
		return res.toString();
	}
}
