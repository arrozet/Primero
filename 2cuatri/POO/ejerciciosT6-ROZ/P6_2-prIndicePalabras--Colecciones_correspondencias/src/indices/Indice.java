package indices;

import java.io.PrintWriter;

public interface Indice {
	void agregarFrase(String frase);
	void resolver(String del);
	void presentarIndice(PrintWriter pw);
	default void presentarIndiceConsola() {
		PrintWriter pw=new PrintWriter(System.out, true);
		presentarIndice(pw);
	}
	
}
