#include <iostream>
#include <array>
using namespace std;

const int MAX = 5;

typedef array<int,MAX> TFila;
typedef array<TFila,MAX> TMatriz;

void leer(TMatriz& m) {
	cout << "Introduzca la matriz fila a fila ("
		 << MAX << " X " << MAX << "):\n";

	for (int f = 0; f < MAX; f++) {
		for (int c = 0; c < MAX; c++) {
			cin >> m[f][c];
		}
	}
}

int sumaDiagonalSecundaria(const TMatriz& m) {
    int suma = 0;

    for (int fi = 0; fi < MAX; fi++) {
        suma += m[fi][MAX-1-fi];
    }

    return suma;
}



int main() {
    TMatriz m;

	leer(m);

	cout << "La suma de la diagonal secundaria es: "
		 << sumaDiagonalSecundaria(m);

    return 0;
}
