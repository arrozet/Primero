package ejercicio1_tema2;

public class Cilindro {
	private double altura;
	private Circulo baseCirculo;
	
	public Cilindro(Circulo crcl, double h) {altura=h; baseCirculo=crcl;}
	
	public double getAltura() {return altura;}
	public void setAltura(double h) {altura = h;}
	public Circulo getBase() {return baseCirculo;}
	public void setBase(Circulo crcl) {baseCirculo=crcl;}
	public void trasladar(double a, double b) {baseCirculo.trasladar(a,b);}
	public double area() {return 2 * baseCirculo.area() + 2 * Math.PI * baseCirculo.getRadio() * altura;}
	
	public String toString() {
		return "Cilindro(" + baseCirculo + "," + getAltura() + ")";
	}
	
}
