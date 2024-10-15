package rank;

public class WebExtended extends Web{
	public WebExtended() {
		super();
	}
	
	@Override
	protected void addSiteWithName(String name) {
		Site s = new SiteExtended(name);
		addSite(s);
	}
	
	@Override
	protected void distribute(Site site, double prize) {
		SiteExtended siteEx = (SiteExtended) site;
		if(siteEx.isValid()) {
			super.distribute(siteEx, prize);
		}
		
	}
	
	public void SwitchSiteWithName(String name) {
		SiteExtended se = (SiteExtended) getSite(name);
		boolean b = se.isValid();
		se.setValid(!b);
	}
}
