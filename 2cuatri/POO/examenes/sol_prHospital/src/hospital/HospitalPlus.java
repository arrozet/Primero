package hospital;

import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class HospitalPlus extends Hospital {

	public HospitalPlus(String nombre, int plantas, int habitaciones) throws HospitalException {
		super(nombre, plantas, habitaciones);
	}

	/**
	 * Devuelve map ordenado que asocia un conjunto ordenado de pacientes a cada
	 * año.
	 * 
	 * @param ano
	 * @return
	 */
	public SortedMap<Integer, SortedSet<Paciente>> pacientesPorAno() {
		SortedMap<Integer, SortedSet<Paciente>> cs = new TreeMap<>();
		for (Paciente p : habitaciones.keySet()) {
			cs.putIfAbsent(p.getAnoDeNacimiento(), new TreeSet<>());
			cs.get(p.getAnoDeNacimiento()).add(p);
		}
		return cs;
	}

	/**
	 * Devuelve map ordenado que asocia el número de pacientes nacidos en un año a
	 * cada año.
	 * 
	 * @param ano
	 * @return
	 */
	public SortedMap<Integer, Integer> numeroDePacientesPorAno() {
		SortedMap<Integer, SortedSet<Paciente>> cs = pacientesPorAno();
		SortedMap<Integer, Integer> ns = new TreeMap<>();
		for (Integer ano : cs.keySet())
			ns.put(ano, cs.get(ano).size());
		return ns;
	}

}
