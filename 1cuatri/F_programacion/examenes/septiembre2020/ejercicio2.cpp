/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/

#include <iostream>
#include <array>
using namespace std;

const int N=4;
typedef array<int, N> TFila;
typedef array<TFila, N> TMatriz;

typedef array<int, N-1> TFila2;
typedef array<TFila, N-1> TMatriz2;

void leer(TMatriz& m){
    cout << "Introduce los numeros enteros para una matriz cuadrada de " << N << "x" << N << ":" << endl;
    for(int f=0; f<N; f++){
        for(int c=0; c<N; c++){
            cin >> m[f][c];
        }
    }
}

void escribir(TMatriz2& m2){
    cout << "La matriz construida " << N-1 << "x" << N-1 << " es:" << endl;
    for(int f=0; f<(N-1); f++){
        for(int c=0; c<(N-1); c++){
            cout << m2[f][c] << " ";
        }
        cout << endl;
    }
}

void construirMatrizReducida(const TMatriz& m1, TMatriz2& m2, int fil, int col){
    int f=0, c=0, f2=0, c2=0;

    while(f<N && f2<(N-1)){
        c=0;
        c2=0;
        while(c<N && c2<(N-1)){
            if(f!=fil && c!=col){
                m2[f2][c2] = m1[f][c];
                c2++;
            }
            c++;
        }
        if(f!=fil){
            f2++;
        }
        f++;
    }
}

int main(){
    TMatriz m1;
    TMatriz2 m2;
    int fil, col;

    leer(m1);
    do{
        cout << "Introduce los indices de la fila y columna: " << endl;
        cin >> fil >> col;
    }while(fil<0 || fil>=N || col<0 || col>=N);


    construirMatrizReducida(m1,m2,fil,col);
    escribir(m2);
    return 0;
}
