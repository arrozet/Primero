package alturas;

import java.util.Comparator;

public class OrdenAlternativoPais implements Comparator<Pais>{

	@Override
	public int compare(Pais o1, Pais o2) {
		int res=Double.compare(o1.getAltura(),o2.getAltura());
		if(res==0) {
			o1.getNombre().compareTo(o2.getNombre());
		}
		
		return res;
	}
	
}
