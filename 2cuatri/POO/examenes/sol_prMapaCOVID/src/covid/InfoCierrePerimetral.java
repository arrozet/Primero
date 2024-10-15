package covid;


import java.util.Set;
import java.util.TreeSet;

public class InfoCierrePerimetral implements InfoCOVID {
	/**
	 * Constante que determina el cierre perimetral de una población
	 */
	static final int CASOS_CIERRE = 500;
	
	@Override
	public Set<String> obtenerInfo(MapaCOVID mapa) {
		Set<String> res = new TreeSet<>();
		for(String prov : mapa.getProvincias()) {
			int incProv = mapa.incidenciaProvincia(prov);
			if(incProv >= CASOS_CIERRE)
				res.add(prov);
		}
		return res;
	}

}
