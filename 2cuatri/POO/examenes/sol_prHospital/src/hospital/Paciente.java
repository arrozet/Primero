package hospital;

import java.util.Objects;

public class Paciente implements Comparable<Paciente> {
	private String nombre, apellidos;
	private String nuss;
	private int anoDeNacimiento;

	/**
	 * Crea un paciente a partir de su nombre, apellidos, número de la seguridad
	 * social, y dia, mes y ano de su fecha de nacimiento.
	 * 
	 * El Número de la Seguridad Social está compuesto por 10 dígitos agrupados en
	 * tres secciones:
	 * 
	 * Los 2 primeros dígitos son el código de la provincia donde se ha solicitado
	 * el número. Los 6 dígitos siguientes son un número secuencial asignado. Los 2
	 * últimos dígitos son de control. Ejemplo: 08 123456 xx.
	 * 
	 * A la hora de calcular el los dígitos de control se calcula de la siguiente
	 * manera: Calculamos el resto de dividir el número formado por los 8 primeros
	 * dígitos (en nuestro ejemplo 08123456) entre 97 (en nuestro ejemplo 08123456 %
	 * 97 = 94). Si el resto es mayor o igual que 10 este será el número de control.
	 * Si el resto es menor que 10 se pone un 0 delante para convertirlo en una
	 * cifra de dos dígitos. Por ejemplo, si el resto fuese 3, quedaría como 03; si
	 * fuese 0, quedaría como 00. En nuestro caso quedaría definitivamente: 08
	 * 12345678 71.
	 * 
	 * @param nom nombre
	 * @param ape apellidos
	 * @param num número de la seguridad social
	 * @param dia dia de nacimiento
	 * @param mes mes de nacimiento
	 * @param ano ano de nacimiento
	 * @throws HospitalException en caso de nombre o apellidos nulos o vacíos, nuss
	 *                           null o con formato no válido, o fecha no válida
	 */
	public Paciente(String nom, String ape, String num, int ano) throws HospitalException {
		if (nom == null || nom.isEmpty())
			throw new HospitalException("Nombre erroneo");
		if (ape == null || nom.isEmpty())
			throw new HospitalException("Apellidos erroneo");
		if (num == null || num.length() != 10
				|| Integer.parseInt(num.substring(0, 8)) % 97 != Integer.parseInt(num.substring(8, 10)))
			throw new HospitalException("NUSS erroneo");
		nombre = nom;
		apellidos = ape;
		nuss = num;
		anoDeNacimiento = ano;
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

	public boolean equals(Object o) {
		boolean r = o instanceof Paciente;
		Paciente p = r ? (Paciente) o : null;
		return r && nombre.equalsIgnoreCase(p.getNombre()) && apellidos.equalsIgnoreCase(p.getApellidos())
				&& nuss.equals(p.nuss) && anoDeNacimiento == p.getAnoDeNacimiento();
	}

	public int hashCode() {
		return Objects.hash(nombre, apellidos, nuss, anoDeNacimiento);
	}

	public String toString() {
		return "Paciente [nombre=" + nombre + ", apellidos=" + apellidos + ", nuss=" + nuss + ", anoDeNacimiento="
				+ anoDeNacimiento + "]";
	}

	public int compareTo(Paciente c) {
		int r = Integer.compare(anoDeNacimiento, c.getAnoDeNacimiento());
		if (r == 0) {
			r = nuss.compareTo(c.getNuss());
			if (r == 0) {
				r = apellidos.compareToIgnoreCase(c.getApellidos());
				if (r == 0)
					r = nombre.compareToIgnoreCase(c.getNombre());
			}
		}
		return r;
	}

}
