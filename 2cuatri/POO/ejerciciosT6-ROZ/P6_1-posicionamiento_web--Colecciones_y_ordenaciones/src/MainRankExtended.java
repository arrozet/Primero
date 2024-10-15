//import rank.Web;
import rank.*;

public class MainRankExtended {
	
	public static void invalidar(String name, Web web) {
		SiteExtended a = (SiteExtended) web.getSite(name);
        a.setValid(false);
	}
	
    public static void main(String[] args) {
    	String[] enlaces = {
				"I->C",
				"J->C",
				"A->C",
				"A->D",
				"B->C",
				"B->F",
				"D->F",
				"E->B",
				"E->H",
				"F->G",
				"F->H",
				"G->E",
				"G->H"
		};

        Web web = new WebExtended();
        for (String arc: enlaces) {
            web.addLink(arc);
		}
        
        invalidar("A", web);
        invalidar("I", web);
        invalidar("J", web);
        
        System.out.println(web);
        web.simulateClick(4000);
        System.out.println("Paginas ordenadas alfabeticamente");
        System.out.println(web.getSitesByName());
        System.out.println("Paginas ordenadas por rank");
        System.out.println(web.getSitesByRank());
        
       
    }
}
