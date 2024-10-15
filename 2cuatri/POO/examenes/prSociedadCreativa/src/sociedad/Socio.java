//NOMBRE:		Oliva Zamora, Rubén 
//TITULACIÓN:	Ingeniería del Software
//GRUPO:		A

package sociedad;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringJoiner;

public class Socio implements Comparable<Socio>{
	private String name;
	private Set<String> interests;
	private int ident;
	
	public Socio(String name, Set<String> interests, int ident) {
		if(name == null || name.length()==0 || ident <=0) {
			throw new SociedadException("ERROR: alguno de los parámetros no es válido");
		}
		this.name = name;
		this.ident = ident;
		this.interests = new HashSet<>();
		for(String elem: interests) {
			this.interests.add(elem.toLowerCase());
		}
	}

	public String getName() {
		return name;
	}

	public Set<String> getInterests() {
		return interests;
	}

	public int getIdent() {
		return ident;
	}
	
	@Override
	public String toString() {
		StringJoiner sj = new StringJoiner(",", "[", "]");
		sj.add(name);
		sj.add(interests.toString());
		String aux = ""+ident;
		sj.add(aux);
		return sj.toString();
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Socio) {
			Socio s = (Socio) obj;
			res = name.equalsIgnoreCase(s.getName()) && ident==s.getIdent();
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(name.toLowerCase(), ident);
	}

	@Override
	public int compareTo(Socio o) {
		int res = name.compareToIgnoreCase(o.getName());
		if(res==0) {
			res=Integer.compare(ident, o.getIdent());
		}
		return res;
	}
	
}
