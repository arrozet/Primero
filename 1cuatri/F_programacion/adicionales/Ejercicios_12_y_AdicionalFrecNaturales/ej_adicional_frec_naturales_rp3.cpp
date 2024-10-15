/*
 ENTRADA: SECUENCIA DE NÚMEROS NATURALES (NEGATIVO PARA TERMINAR)
 SALIDA: CADA UNO DE LOS NÚMEROS NATURALES INTRODUCIDOS JUNTO CON
         EL NÚMERO DE VECES (FRECUENCIA) QUE APARECE
 EN LA ENTRADA HABRÁ UN MÁXIMO DE NÚMEROS NATURALES DISTINTOS
   (CONSTANTE MAX)
*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 50;

struct TElementos {
    int valor;
    int frec;
};

typedef array<TElementos,MAX> TArray;

struct TResultado {
    TArray elementos;
    int nElementos;
};

int buscar(int num, const TResultado& res) {
    int pos = 0;

    while (pos < res.nElementos && res.elementos[pos].valor != num) {
        pos++;
    }

    return pos;
}

void calcular(TResultado& res) {
    int num, pos;

    cout << "Introduzca numeros naturales (maximo "
        << MAX << " distintos) (para terminar introduzca un negativo):\n";

    res.nElementos = 0;

    cin >> num;
    while (num >= 0) {
        pos = buscar(num,res);
        if (pos < res.nElementos) { // num esta almacenado ya en la casilla pos
            res.elementos[pos].frec++;
        } else { // num no esta almacenado
            if (res.nElementos < MAX) { // no esta lleno el array
                res.elementos[res.nElementos].valor = num;
                res.elementos[res.nElementos].frec = 1;
                res.nElementos++;
            }
        }
        cin >> num;
    }

}

void imprimir(const TResultado& res) {
    cout << "La frecuencia de cada numero es:" << endl;
    for (int i = 0; i < res.nElementos; i++) {
        cout << res.elementos[i].valor << ": "
             << res.elementos[i].frec << endl;
    }

}


int main () {
    TResultado res;

    calcular(res);
    imprimir(res);

    return 0;
}
