//APELLIDOS Y NOMBRE: 		Oliva Zamora, Rubén
//GRADO: 					Ingeniería del software
//GRUPO: 					A

import java.io.FileNotFoundException;
//import java.util.Collections;

import hospital.*;

public class MainHospital {

	public static void main(String[] args) {
		try {
			Hospital h = new Hospital("Hospital Regional Universitario de Malaga", 50, 20);
//			h.alta(new Paciente("Hola", "Prueba", "0812345694", 1111));
			h.leePacientes("examenes/prHospital/pacientes.txt");
			h.escribePacientes("examenes/prHospital/output.txt");
			System.out.println(h);
			System.out.println("Selección nacidos <1800:\n"+h.seleccion(new NacioAntesDe(1800)));
			System.out.println("Selección planta 2:\n"+h.seleccion(new MismaPlanta(2)));
			
		} catch (HospitalException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
