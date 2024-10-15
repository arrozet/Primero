
package libreria;

public class LibroOferta extends Libro {
	private double porcDescuento;
	public LibroOferta(String a, String t, double p, double d) {
		super(a, t, p);
		porcDescuento = d;
	}
	public double getDescuento() {
		return porcDescuento;
	}
	@Override
	protected double getBaseImponible() {
		double baseImponible = super.getBaseImponible();
		return baseImponible - baseImponible * getDescuento() / 100;
	}
	@Override
	public String toString() {
		return "("+getAutor()+"; "+getTitulo()+"; "+getPrecioBase()
			+"; "+getDescuento()+"%; "+getBaseImponible()
			+"; "+getIVA()+"%; "+getPrecioFinal()+")";
	}
}
