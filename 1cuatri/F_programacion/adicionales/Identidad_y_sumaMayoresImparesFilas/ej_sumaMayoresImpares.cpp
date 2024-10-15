#include <iostream>
#include <array>
using namespace std;

const int NUM_FILAS = 3;
const int NUM_COLUMNAS = 4;

typedef array<int,NUM_COLUMNAS> TFila;
typedef array<TFila,NUM_FILAS> TMatriz;

void leer(TMatriz& m) {
    cout << "Introduzca la matriz fila a fila ("
         << NUM_FILAS << " X " << NUM_COLUMNAS << "):\n";

    for (int f = 0; f < NUM_FILAS; f++) {
        for (int c = 0; c < NUM_COLUMNAS; c++) {
            cin >> m[f][c];
        }
    }
}

int mayorImparFila(const TFila& fila) {
    int mayor = 0;
    int co = 0;

    while (co < NUM_COLUMNAS && fila[co] % 2 == 0) {
        co++;
    }

    if (co < NUM_COLUMNAS) {
        mayor = fila[co];
        co++;
        while (co < NUM_COLUMNAS) {
            if (fila[co] % 2 != 0 && fila[co] > mayor) {
                mayor = fila[co];
            }
            co++;
        }
    }

    return mayor;
}

int sumaMayoresImparesFilas(const TMatriz& m) {
    int suma = 0;

    for (int fi = 0; fi < NUM_FILAS; fi++) {
        suma = suma + mayorImparFila(m[fi]);
    }

    return suma;
}

int main()
{
	TMatriz m;

	leer(m);

	cout << "La suma de los mayores impares de cada fila es: "
		 << sumaMayoresImparesFilas(m);

    return 0;
}

