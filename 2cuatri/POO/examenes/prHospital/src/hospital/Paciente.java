//APELLIDOS Y NOMBRE: 		Oliva Zamora, Rubén
//GRADO: 					Ingeniería del software
//GRUPO: 					A
package hospital;

import java.util.Objects;

public class Paciente implements Comparable<Paciente>{
	private String nombre;
	private String apellidos;
	private String nuss;		// nº seguridad social
	private int anoDeNacimiento;
	
	public Paciente(String nom, String ape, String num, int ano) throws HospitalException {
		if(nom == null || ape == null || num == null) {
			throw new HospitalException("Estás introduciendo parámetros null");
		}
		else if (nom.length()==0 || ape.length() == 0) {
			throw new HospitalException("Estás introduciendo nombre o apellidos vacíos");
		}
		else if(num.length() != 10) {
			throw new HospitalException("Estás introduciendo un NUSS de longitud distinta de 10 --> " + num + "(longitud " + num.length() + ")");
		}
		else if (!nussValido(num)) {
			throw new HospitalException("Estás introduciendo un NUSS invalido");
		}
		
		this.nombre = nom;
		this.apellidos = ape;
		this.nuss = num;
		this.anoDeNacimiento = ano;
	}
	
	private boolean nussValido(String num) {
		boolean res = false;
		String no_control = num.substring(0, 8);
		String control = num.substring(8);
		try {
			int num_control = Integer.parseInt(control);
			int num_noControl = Integer.parseInt(no_control);
			int resto = num_noControl%97;
			if(resto>=10) {
				res = num_control == num_noControl%97;
			}
			else {
				String aux = "0" + resto;
				res = aux.equalsIgnoreCase(control);
			}
			
		} catch (NumberFormatException e) {
			System.err.println("Hubo un error transformando de String a tipo numeral");
		}
		
		return res;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getNuss() {
		return nuss;
	}

	public int getAnoDeNacimiento() {
		return anoDeNacimiento;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = false;
		if(obj instanceof Paciente) {
			Paciente p = (Paciente) obj;
			res = nombre.equalsIgnoreCase(p.nombre) && apellidos.equalsIgnoreCase(p.apellidos) &&
					nuss.equals(p.nuss) && anoDeNacimiento==p.anoDeNacimiento;
		}
		return res;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(nombre, apellidos, nuss, anoDeNacimiento);
	}

	@Override
	public int compareTo(Paciente o) {
		int res = Integer.compare(anoDeNacimiento,o.getAnoDeNacimiento()); // debe ser justo al revés, aunque asi el output va bien
		if(res==0) {
			res = nuss.compareTo(o.getNuss());
			if(res==0) {
				res = apellidos.compareToIgnoreCase(o.getApellidos());
				if(res==0) {
					res = nombre.compareToIgnoreCase(o.getNombre());
				}
			}
		}
		return res;
	}
	
	@Override
	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellidos=" + apellidos + ", nuss="
				+ nuss + ", anoDeNacimiento=" + anoDeNacimiento + "]";
	}
	
	
	
	
	
}
