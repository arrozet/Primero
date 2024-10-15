package rank;

import java.util.Locale;
import java.util.Objects;

public class Site implements Comparable<Site>{
	private String name;
	private double rank;
	
	public Site(String name) {
		this.name = name;
		rank = 0;
	}

	public String getName() {
		return name;
	}

	public double getRank() {
		return rank;
	}

	public void addRank(double r) {
		rank += r;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res=false;
		if(obj instanceof Site) {
			Site site = (Site) obj;
			res = site.getName().equalsIgnoreCase(name);
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase());
	}
	
	@Override
	public int compareTo(Site o) {
		int res=name.compareToIgnoreCase(((Site) o).getName());
		return res;
	}
	
	@Override
	public String toString() {
//		return getName() + "(" + getRank() + ")";
		return String.format(Locale.ENGLISH, "%s(%.5f)", name, rank);
	}
	
}
