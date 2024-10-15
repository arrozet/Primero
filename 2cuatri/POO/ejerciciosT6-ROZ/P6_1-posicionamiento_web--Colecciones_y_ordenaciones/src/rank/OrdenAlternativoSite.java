package rank;

import java.util.Comparator;

public class OrdenAlternativoSite implements Comparator<Site>{
	@Override
	public int compare(Site s1, Site s2) {
		// orden decreciente
		int res = Double.compare(s2.getRank(), s1.getRank());
		if(res==0) {
			res = s1.getName().compareToIgnoreCase(s2.getName());
		}
		return res;
	}
}
