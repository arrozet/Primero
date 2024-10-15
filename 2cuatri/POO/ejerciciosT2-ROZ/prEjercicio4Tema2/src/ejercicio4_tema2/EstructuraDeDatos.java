package ejercicio4_tema2;

public interface EstructuraDeDatos {
	void meter(int elem);
	int sacar();
	int tamaño();
	default boolean estaVacia() {
		return tamaño() == 0;
	};
}
