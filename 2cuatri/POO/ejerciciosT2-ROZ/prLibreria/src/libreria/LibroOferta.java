package libreria;

public class LibroOferta extends Libro {
	private double porcDescuento;
	
	public LibroOferta(String a, String t, double p, double descuento) {
		super(a,t,p);
		porcDescuento = descuento;
	}
	
	public double getDescuento() {
		return porcDescuento;
	}
	
	@Override
	protected double getBaseImponible() {
		return super.getBaseImponible() - super.getBaseImponible()*getDescuento()/100;
	}
	
	@Override
	public String toString() {
		return "(" + super.getAutor() 
		+ "; " + super.getTitulo() 
		+ "; " + super.getPrecioBase()
		+ "; " + getDescuento() + "%"
		+ "; " + getBaseImponible() 
		+ "; " + super.getIVA() + "%"
		+ "; " + super.getPrecioFinal() 
		+ ")";
	}
}
