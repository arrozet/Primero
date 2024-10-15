#include <iostream>
#include <array>
using namespace std;

const int MAX = 5;

typedef array<int,MAX> TFilas;
typedef array<TFilas,MAX> TMatriz;

void leer(TMatriz& m) {
	cout << "Introduzca la matriz fila a fila ("
		 << MAX << " X " << MAX << "):\n";

	for (int f = 0; f < MAX; f++) {
		for (int c = 0; c < MAX; c++) {
			cin >> m[f][c];
		}
	}
}

int sumaDiagonalPrinc(const TMatriz& m) {
	int res = 0;

	for (int i = 0; i < MAX; i++) {
		res += m[i][i];
	}
	return res;
}




int main()
{
	TMatriz m;

	leer(m);

	cout << "La suma de la diagonal principal es: "
		 << sumaDiagonalPrinc(m);

    return 0;
}

