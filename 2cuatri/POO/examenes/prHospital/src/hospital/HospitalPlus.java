//APELLIDOS Y NOMBRE: 		Oliva Zamora, Rubén
//GRADO: 					Ingeniería del software
//GRUPO: 					A

package hospital;

//import java.util.Iterator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HospitalPlus extends Hospital{
	public HospitalPlus(String nombre, int plantas, int habitaciones) throws HospitalException {
		super(nombre, plantas, habitaciones);
	}
	
	public SortedMap<Integer, SortedSet<Paciente>> pacientesPorAno(){
		SortedMap<Integer, SortedSet<Paciente>> map = new TreeMap<>();
		
//		SortedSet<Paciente> todos_pacientes = new TreeSet<Paciente>();
//		todos_pacientes.addAll(habitaciones.keySet());
//		
//		while(!todos_pacientes.isEmpty()) {
//			Paciente p1 = todos_pacientes.first();
//			SortedSet<Paciente> paciente_en_año = new TreeSet<Paciente>();;
//			
//			paciente_en_año.add(p1);
//			map.put(p1.getAnoDeNacimiento(), paciente_en_año);
//			todos_pacientes.remove(p1);
//			
//			Iterator<Paciente> iter = todos_pacientes.iterator();
//			
//			while (iter.hasNext()){	// si coincide, los mete con ese
//				Paciente p = iter.next();
//				if(p.getAnoDeNacimiento() == p1.getAnoDeNacimiento()) {
//					SortedSet<Paciente> aux = map.get(p1.getAnoDeNacimiento());
//					aux.add(p);
//					map.put(p1.getAnoDeNacimiento(), aux);
//					iter.remove();
//				}
//			}
//		}
		for(Paciente p : habitaciones.keySet()) {
			map.putIfAbsent(p.getAnoDeNacimiento(), new TreeSet<>());
			map.get(p.getAnoDeNacimiento()).add(p);
		}
		
		return map;
	}
	
	public SortedMap<Integer,Integer> numeroDePacientesPorAno(){
		SortedMap<Integer, Integer> map = new TreeMap<>();
		SortedMap<Integer, SortedSet<Paciente>> aux = pacientesPorAno();
		for(int ano : aux.keySet()) {
			map.put(ano, aux.get(ano).size());
		}
		
		return map;
	}
}
