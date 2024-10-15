import hospital.Paciente;
import hospital.HospitalException;

public class MainPaciente {

	public static void main(String[] args) {
		try {
			Paciente c1 = new Paciente("Abraham", "Lincoln", "666944481100", 1809);
			Paciente c2 = new Paciente("Adam", "Smith", "518604637358", 1723);
			Paciente c3 = new Paciente("Adam", "Smith", "518604637358", 1723);

			System.out.printf("%s %ses igual que %s\n", c1, c1.equals(c2) ? "" : "no ", c2);
			System.out.printf("%s %ses igual que %s\n", c2, c2.equals(c3) ? "" : "no ", c3);
			System.out.printf("%s %ses menor que %s\n", c1, c1.compareTo(c2) < 0 ? "" : "no ", c2);
			System.out.printf("%s %ses menor que %s\n", c2, c2.compareTo(c3) < 0 ? "" : "no ", c3);
			new Paciente("Adam", "Smith", "518604637357", 1723);
		} catch (HospitalException e) {
			e.printStackTrace();
		}
	}

}

/**
 * Expected output:
 * 
 * <pre>
Paciente [nombre=Abraham, apellidos=Lincoln, nuss=666944481100, fechaDeNacimiento=1809] no es igual que Paciente [nombre=Adam, apellidos=Smith, nuss=518604637358, fechaDeNacimiento=1723]
Paciente [nombre=Adam, apellidos=Smith, nuss=518604637358, fechaDeNacimiento=1723] es igual que Paciente [nombre=Adam, apellidos=Smith, nuss=518604637358, fechaDeNacimiento=1723]
Paciente [nombre=Abraham, apellidos=Lincoln, nuss=666944481100, fechaDeNacimiento=1809] no es menor que Paciente [nombre=Adam, apellidos=Smith, nuss=518604637358, fechaDeNacimiento=1723]
Paciente [nombre=Adam, apellidos=Smith, nuss=518604637358, fechaDeNacimiento=1723] no es menor que Paciente [nombre=Adam, apellidos=Smith, nuss=518604637358, fechaDeNacimiento=1723]
hospital.HospitalException: NUSS erroneo
	at hospital.Paciente.<init>(Paciente.java:45)
	at MainPaciente.main(MainPaciente.java:16)
 * </pre>
 */