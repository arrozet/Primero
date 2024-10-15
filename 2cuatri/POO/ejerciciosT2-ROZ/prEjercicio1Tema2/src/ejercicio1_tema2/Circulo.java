package ejercicio1_tema2;

public class Circulo {
	private double radio;
	private Punto centro;
	// constructor
	public Circulo(Punto pto, double n_radio) {centro=pto; radio=n_radio;}
	// metodos
	public double getRadio() {return radio;}
	public void setRadio(double n_radio) {radio=n_radio;}
	public Punto getCentro() {return centro;}
	public void setCentro(Punto pto) {centro=pto;}
	public void trasladar(double a, double b) {centro.trasladar(a, b);}
	public double area() {return Math.PI*Math.pow(radio, 2);}
	
	public String toString() {
		return "Circulo(" + centro + "," + getRadio() + ")";
	}
}