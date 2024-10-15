//NOMBRE:		Oliva Zamora, Rubén 
//TITULACIÓN:	Ingeniería del Software
//GRUPO:		A

import java.util.HashSet;
import java.util.Set;

import sociedad.Socio;

public class TestSocio {
	
	private static void sonIguales(Socio s1, Socio s2) {
		if(s1.equals(s2)) {
			System.out.println("Son el mismo socio");
		}
		else {
			System.out.println("Son socios distintos");
		}
	}

	public static void main(String[] args) {	// sale senderismo y escalada con el orden cambiado
		Set<String> s1_interest = new HashSet<>();
		Set<String> s2_interest = new HashSet<>();
		s1_interest.add("Senderismo");
		s1_interest.add("Escalada");
		Socio s1 = new Socio("Layton Kor", s1_interest, 24);
		Socio s2 = new Socio("layton kor", s2_interest, 24);
		System.out.println(s1);
		System.out.println(s2);
		sonIguales(s1, s2);
	}

}
