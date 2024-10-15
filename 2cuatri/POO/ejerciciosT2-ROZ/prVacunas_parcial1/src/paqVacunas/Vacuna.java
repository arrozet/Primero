package paqVacunas;

public class Vacuna {
	private String codigo;
	private double precio;
	private int cantidad;
	
	public Vacuna(String codigo, double precio, int cantidad) {
		if(precio <= 0 || cantidad <= 0) {
			throw new RuntimeException("No puedes tener un precio negativo o una cantidad negativa");
		}
		
		this.codigo = codigo;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	public Vacuna(String codigo, double precio) {
		if(precio <= 0) {
			throw new RuntimeException("No puedes tener un precio <= 0");
		}
		this.codigo = codigo;
		this.precio = precio;
		this.cantidad = 1;
	}
	
	public double getPrecio() {
		return precio;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setPrecio(double precio) {
		if(precio <= 0) {
			throw new RuntimeException("No puedes tener un precio <= 0");
		}
		this.precio = precio;
	}
	public void setCantidad(int cantidad) {
		if(cantidad <= 0) {
			throw new RuntimeException("No puedes tener un precio <= 0");
		}
		this.cantidad = cantidad;
	}
	
	public double precioTotal() {
		double precio_total = cantidad * precio;
		return precio_total;
	}
	@Override
	public String toString() {
		return "("+ getCodigo() + ": " + getPrecio() + " " + getCantidad() + ")";
	}
}
