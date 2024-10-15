package parrillatv;

import java.util.Collection;
import java.util.SortedSet;

public interface SugerenciasTV {
	SortedSet<ProgramaTV> sugerencias(Collection<ProgramaTV> progs);
}
