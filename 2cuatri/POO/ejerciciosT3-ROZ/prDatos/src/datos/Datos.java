package datos;

import java.util.ArrayList;

public class Datos {
	private ArrayList<Double> datos;
	private ArrayList<String> errores;
	private double min, max;
	
	public Datos(String[] input, double min, double max) {
		this.min = min;
		this.max = max;
		datos = new ArrayList<>();
		errores = new ArrayList<>();
		
		for(int i=0; i<input.length; i++) {
			try {
				double n = Double.parseDouble(input[i]);
				datos.add(n);
			} catch (NumberFormatException e) {
				errores.add(input[i]);
			}		
		}
	}
	
	public double calcMedia() {
		double sum=0, res=0;
		int cont=0;
		for(int i=0; i<datos.size(); i++) {
			if(datos.get(i) >= min && datos.get(i) <= max) {
				sum += datos.get(i);
				cont++;
			}
		}
		if(cont==0) {
			throw new DatosException("No hay datos en el rango especificado");
		}
		
		res = sum/cont;
		
		return res;
	}
	
	public double calcDesvTipica() {
		double media=calcMedia();
		double sum=0, res=0;
		int cont=0;
		
		for(int i=0; i<datos.size(); i++) {
			if(datos.get(i) >= min && datos.get(i) <= max) {
				sum += Math.pow(datos.get(i)-media, 2);
				cont++;
			}
		}
		res=Math.sqrt(sum/cont);
		
		return res;
	}

	public void setRango(String rango) {
		int pos = rango.indexOf(';');
		
		try {
				min = Double.parseDouble(rango.substring(0, pos));
				max = Double.parseDouble(rango.substring(pos+1));
		} catch (NumberFormatException | IndexOutOfBoundsException e) {	// indexout of bounds es por si pos = -1 (no esta)
				throw new DatosException("Error en los datos al establecer el rango");
				//System.out.println("Error en los datos al establecer el rango");
				// asi saldria lo mismo que el output pero es que entonces no lanza la excepcion
		}
	}
	
	public ArrayList<Double> getDatos(){
		return datos;
	}
	
	public ArrayList<String> getErrores() {
		return errores;
	}
	
	@Override
	public String toString() {
		String out =  "Min: " + min + ", Max: " + max + ", \n" + datos.toString() + ", \n" + errores.toString() + ", \n Media: "; 
		
		try{
			out += calcMedia() + ", DesvTipica: " + calcDesvTipica();
		}catch (DatosException e) {
			out += "ERROR, DesvTipica: ERROR";
		}
		
		return out;
	}
}
