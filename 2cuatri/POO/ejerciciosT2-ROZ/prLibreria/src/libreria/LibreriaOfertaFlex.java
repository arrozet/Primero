package libreria;

public class LibreriaOfertaFlex extends Libreria {
	private OfertaFlex oferta;
	public LibreriaOfertaFlex(OfertaFlex o) {
		super();
		oferta = o;
	}
	
	public void setOferta(OfertaFlex o) {
		oferta = o;
	}
	
	public OfertaFlex getOferta() {
		return oferta;
	}
	
	@Override 
	public void addLibro(String autor, String titulo, double precio) {
		Libro l = new Libro(autor, titulo, precio);
		if(oferta.getDescuento(l) != 0) {  // no funciona bien, ya que mete siempre ibroOferta
			l = new LibroOferta(autor, titulo, precio, oferta.getDescuento(l));
		}
		anyadirLibro(l);
	}
	
	@Override
	public String toString() {
		return getOferta() + "\n" + super.toString();
	}
	
}
