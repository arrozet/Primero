package libreria;

public class OfertaPrecio implements OfertaFlex {
	private double porcDescuento;
	private double umbralPrecio;
	
	public OfertaPrecio(double porcDescuento, double umbralPrecio) {
		this.porcDescuento = porcDescuento;
		this.umbralPrecio = umbralPrecio;
	}
	
	@Override
	public double getDescuento(Libro l) {
		double d =0;
		if(l.getPrecioBase() >= umbralPrecio) {
			d = porcDescuento;
		}
		return d;
	}
	
	public String toString() {
		return porcDescuento + "% (" + umbralPrecio+")"; // lo de umbralPrecio no esta nada claro 
	}
	
}
