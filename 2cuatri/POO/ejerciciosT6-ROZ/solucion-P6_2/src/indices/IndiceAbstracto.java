package indices;

import java.util.LinkedList;
import java.util.List;

public abstract class IndiceAbstracto  implements Indice {
	protected List<String> texto;
	
	public IndiceAbstracto() {
		texto = new LinkedList<String>();
	}

	@Override
	public void agregarFrase(String linea) {
		texto.add(linea);
	}

}
