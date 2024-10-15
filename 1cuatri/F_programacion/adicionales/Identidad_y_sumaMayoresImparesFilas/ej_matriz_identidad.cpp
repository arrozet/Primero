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


bool identidad(const TMatriz& m) {
    bool esIdentidad = true;
    int fi, co;

    fi = 0;
    while (fi < MAX && esIdentidad) {
        co = 0;
        while (co < MAX && esIdentidad) {
            if (fi == co) {
                if (m[fi][co] != 1) {
                    esIdentidad = false;
                }
            } else {
                if (m[fi][co] != 0) {
                    esIdentidad = false;
                }
            }
            co++;
        }
        fi++;
    }

    return esIdentidad;
}

int main() {
    TMatriz m;

    leer(m);

    if (identidad(m)) {
        cout << "La matriz ES una matriz indentidad" << endl;
    } else {
        cout << "La matriz NO es una matriz indentidad" << endl;
    }

    return 0;
}

