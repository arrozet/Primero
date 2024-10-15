package rank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Web {
	private Set<Link> links;
	protected Set<Site> sites;
	private final static double THRESHOLD = 1E-5;
	private static Random alea = new Random(1);
	
	public Web() {
		links = new HashSet<>();
		sites = new HashSet<>();
//		alea = new Random();
	}
	
	protected void addSite(Site site) {
		sites.add(site);
	}
	
	protected void addSiteWithName(String name) {
		Site s = new Site(name);
		addSite(s);
	}
	
	public void addLink(String dataLink) {
			String[] data = dataLink.split("->");
		if(data.length != 2) {
			throw new IllegalArgumentException(dataLink + " ha dado un problema.");
		}
			addSiteWithName(data[0]);
			addSiteWithName(data[1]);
			links.add(new Link(data[0], data[1]));
	}
	
	public Site getSite(String name) {
		Iterator<Site> iter = sites.iterator();
		boolean encontrado = false;
		Site aux = null;
		while(iter.hasNext() && !encontrado) {
			aux = iter.next();
			if(aux.getName().equalsIgnoreCase(name)) {
				encontrado = true;
			}
		}
		
		if(encontrado) {
			return aux;
		}
		else {
			throw new NoSuchElementException("No se pudo encontrar la página de nombre " + name);
		}
	}
	
	public Set<String> getNames(){
		Set<String> nombres = new HashSet<>();
		
		for (Site s : sites) {
			nombres.add(s.getName());
		}
		
		return nombres;
	}
	
	private Set<Site> getSitesLinkedFrom(Site pagina){
		Set<Site> linkeds = new HashSet<>();
		for (Link l : links) {
			if(l.getOrigin().equalsIgnoreCase(pagina.getName())) {
				linkeds.add(getSite(l.getLinked()));
			}
		}
		return linkeds;
	}

	protected void distribute(Site site, double prize) {
		if(prize>=THRESHOLD) {
//			prize/=2;
			site.addRank(prize/2);
			Set<Site> linkeds = getSitesLinkedFrom(site);
			Iterator<Site> iter = linkeds.iterator();
			
			
			// esto es una busqueda en profundidad, no?
			if(!linkeds.isEmpty()) {
				while(iter.hasNext()) {
					distribute(iter.next(), prize/(2*linkeds.size()));	
				}
			}
			
		}
	}
	
	public void click(String name) {
		try {
			distribute(getSite(name), 1);
		} catch (NoSuchElementException e) {
		}
	}
	
	public void simulateClick(int numClick) {
		List<Site> lista = new ArrayList<>();
		lista.addAll(sites);
		while(numClick>0) {
			click(lista.get(alea.nextInt(lista.size())).getName());
			numClick--;
		}
	}
	
	public SortedSet<Site> getSitesByName(){
		SortedSet<Site> ordered = new TreeSet<>();
		ordered.addAll(sites);
		return ordered;
	}
	
	public SortedSet<Site> getSitesByRank(){
		SortedSet<Site> ordered = new TreeSet<>(new OrdenAlternativoSite());
		ordered.addAll(sites);
		return ordered;
	}
	
	@Override
	public String toString() {
		return "Web(" + sites + ", " + links + ")";
	}

}