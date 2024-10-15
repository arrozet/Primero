/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/
#include <iostream>
#include <array>
using namespace std;

const int MAX = 4;
// define el tipo TMatriz y diseña el procedimiento rotar
typedef array<int, MAX> TFila;
typedef array<TFila, MAX> TMatriz;


void leer(TMatriz& m) {

	for (int fi = 0; fi < MAX; fi++) {
		for (int co = 0; co < MAX; co++) {
			cin >> m[fi][co];
		}
	}
}

void escribir(const TMatriz& m) {

	for (int fi = 0; fi < MAX; fi++) {
		for (int co = 0; co < MAX; co++) {
			cout <<  m[fi][co] << " ";
		}
		cout << endl;
	}
}

void rotar(TMatriz& m1, TMatriz& m2){
    for(int f=0; f<MAX; f++){
        for(int c=0; c<MAX; c++){
            m2[c][MAX-f-1] = m1[f][c];
        }
    }
}

void rotar(TMatriz& m1, int n){
    TMatriz m2;
    while(n>0){
        m2 = {{}};
        rotar(m1,m2);
        m1=m2;
        n--;
    }
}


int main() {
	TMatriz mat;
	int n;

	cout << "Introduzca los elementos de la matriz ("
                << MAX << " x " << MAX << ") fila a fila:" << endl;
	leer(mat);

	cout << "\nIntroduzca el numero de rotaciones a realizar: ";
	cin >> n;

	rotar(mat,n);

	cout << "\nLa matriz resultado tras las rotaciones es:\n";
	escribir(mat);

	return 0;
}


