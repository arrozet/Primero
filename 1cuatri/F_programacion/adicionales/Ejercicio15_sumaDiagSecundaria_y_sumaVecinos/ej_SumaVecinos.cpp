/*
calcular la suma de los vecinos de una celda de una matriz
*/

#include <iostream>
#include <array>
using namespace std;

const int NFIL = 4;
const int NCOL = 5;

typedef array<int,NCOL> TFila;
typedef array<TFila,NFIL> TMatriz;

bool esValida(int fi, int co) {
    return fi >= 0 && fi < NFIL && co >= 0 && co < NCOL;
}

int sumaVecinos(const TMatriz& m, int fila, int columna) {
    int suma = 0;

    if (esValida(fila,columna)) {
        for (int fi = fila-1; fi <= fila+1; fi++) {
            for (int co = columna-1; co <= columna+1; co++) {
                if (!(fi == fila && co == columna) && esValida(fi,co)) {
                    suma += m[fi][co];
                }
            }
        }
    }


    return suma;
}

int main() {
    TMatriz matriz = {{ {{1,2,3,4,5}},
                        {{6,7,8,3,4}},
                        {{5,4,3,2,1}},
                        {{6,7,9,2,4}},
                      }};
    int fila = 2;
    int columna = 2;

    cout << "Resultado: " << sumaVecinos(matriz,fila,columna) << endl;
    return 0;
}
