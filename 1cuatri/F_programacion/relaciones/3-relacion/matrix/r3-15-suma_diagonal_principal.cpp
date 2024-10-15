#include <iostream>
#include <array>
using namespace std;

const int MAX = 5;
typedef array<int, MAX> TFila;
typedef array<TFila, MAX> TMatriz;

void leer(TMatriz& m){
    cout << "Introduce fila a fila una matriz " << MAX << "*" << MAX << ":" << endl;
    for(int f=0; f<MAX; f++){
        for(int c=0; c<MAX; c++){
            cin >> m[f][c];
        }
    }
}

int sumaDiagonalPrincipal(TMatriz& m){
    int suma = m[0][0];
    /*for(int f = 1; f<MAX; f++){
        for(int c = 1; c<MAX; c++){
            if(c==f){
                suma+=m[f][c];
            }
        }
    }*/

    //OTRA OPCIÓN MÁS FÁCIL
    for(int i=1; i<MAX; i++){
        suma += m[i][i];
    }
    return suma;
}

int main(){
    TMatriz m;
    leer(m);
    cout << "La suma de los números de su diagonal principal es " << sumaDiagonalPrincipal(m);
    
    return 0;
}