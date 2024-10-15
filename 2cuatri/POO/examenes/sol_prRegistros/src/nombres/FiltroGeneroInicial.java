package nombres;

public class FiltroGeneroInicial implements Filtro{
	private char genero;
	private char inicial;
	
	public FiltroGeneroInicial(char genero, char inicial) {
		this.genero=genero;
		this.inicial=inicial;
	}

	@Override
	public boolean criterio(Nombre nombre) {
		return nombre.getGenero()==genero && nombre.getNombre().charAt(0)==inicial;
	}

}
