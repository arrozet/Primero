
package libreria;

public class OfertaPrecio implements OfertaFlex {
	private double porcDescuento;
	private double umbralPrecio;
	public OfertaPrecio(double desc, double prec) {
		porcDescuento = desc;
		umbralPrecio = prec;
	}
	@Override
	public double getDescuento(Libro lb) {
		double d = 0;
		if (lb.getPrecioBase() >= umbralPrecio) {
			d = porcDescuento;
		}
		return d;
	}
	@Override
	public String toString() {
		return porcDescuento+"%("+umbralPrecio+")";
	}
}
