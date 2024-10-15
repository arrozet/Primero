package indices;

import java.util.ArrayList;
import java.util.List;

public abstract class IndiceAbstracto implements Indice{
	protected List<String> frases;
	
	public IndiceAbstracto() {
		frases = new ArrayList<>();
	}
	
	@Override
	public void agregarFrase(String frase) {
		frases.add(frase);
	}
}
