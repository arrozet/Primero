package rank;

public class SiteExtended extends Site{
	private boolean valid;
	
	public SiteExtended(String name){
		super(name);
		valid = true;
	}
	
	public void setValid(boolean b) {
		valid = b;
	}

	public boolean isValid() {
		return valid;
	}
	
	@Override
	public String toString() {
		String valid_mark = "";
		if(!valid) {
			valid_mark = "*";
		}
		return super.toString() + valid_mark;
	}
}
