package paqVacunas;

public class CompradorVIP extends Comprador {
	private double descuento;
	public CompradorVIP(String nombre, int tam, double desc){
		super(nombre,tam);
		if(desc<0) {
			throw new RuntimeException("Descuento no puede ser <0");
		}
		descuento = desc;
	}
	public CompradorVIP(String nombre, double desc){
		super(nombre);
		if(desc<0) {
			throw new RuntimeException("Descuento no puede ser <0");
		}
		descuento = desc;
	}
	
	@Override
	public double precioTotal() {
		return super.precioTotal()-super.precioTotal()*(descuento/100);
	}
}
