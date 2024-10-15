package parrillatv;

import java.util.SortedSet;
import java.util.TreeSet;

public class ProgramacionTVPublicidad extends ProgramacionTV{
	
	public ProgramacionTVPublicidad() {
		super();
	}
	@Override
	public void agregar(String cadenaTV, ProgramaTV prog) {
		SortedSet<ProgramaTV> s_aux = new TreeSet<>();
		SortedSet<ProgramaTV> s = cadenas.getOrDefault(cadenaTV, s_aux);
		s.add(prog);
		// adicion
		ProgramaTV publi = new ProgramaTV("Publicidad", prog.getHoraFin(), 5);
		s.add(publi);
		//
		cadenas.put(cadenaTV, s);
		
		
		
	}
}
