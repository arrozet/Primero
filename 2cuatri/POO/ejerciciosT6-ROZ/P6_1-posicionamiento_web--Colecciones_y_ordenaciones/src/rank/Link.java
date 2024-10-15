package rank;

import java.util.Objects;

public class Link {
	private String origin;
	private String linked;
	
	public Link(String org, String lnk) {
		origin = org;
		linked = lnk;
	}

	public String getOrigin() {
		return origin;
	}

	public String getLinked() {
		return linked;
	}
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Link) {
			Link l = (Link) obj;
			res = l.getOrigin().equalsIgnoreCase(origin) && l.getLinked().equalsIgnoreCase(linked);
		}
		
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(origin.toLowerCase(), linked.toLowerCase());
	}
	
	@Override
	public String toString() {
		return origin + "->" + linked;
	}
	
	
}
