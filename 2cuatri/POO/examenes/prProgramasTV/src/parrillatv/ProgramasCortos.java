package parrillatv;

import java.util.Collection;
import java.util.SortedSet;
import java.util.TreeSet;

public class ProgramasCortos implements SugerenciasTV{
	private int durMaxima;
	
	public ProgramasCortos(int durMaxima) {
		this.durMaxima = durMaxima;
	}

	@Override
	public SortedSet<ProgramaTV> sugerencias(Collection<ProgramaTV> progs) {
		SortedSet<ProgramaTV> s = new TreeSet<>(new OrdenAlternativoProgramaTV());
		for(ProgramaTV p : progs) {
			if(p.getDuracion()<durMaxima) {
				s.add(p);
			}
		}
		return s;
	}
	
	
}
