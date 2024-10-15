package nombres;

public class FiltroGeneroInicial implements Filtro{
	private char genero;
	private char inicial;
	
	public FiltroGeneroInicial(char genero, char inicial) {
		this.genero = genero;
		this.inicial = inicial;
	}

	@Override
	public boolean criterio(Nombre n) {
		return n.getGenero()==genero && n.getNombre().toCharArray()[0]==inicial;
	}
	
	
}
