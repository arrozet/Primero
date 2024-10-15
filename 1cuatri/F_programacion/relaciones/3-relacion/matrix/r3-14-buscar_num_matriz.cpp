#include <iostream>
#include <array>
using namespace std;

const int NUM_FILAS = 4;
const int NUM_COLUMNAS = 5;
typedef array<int, NUM_COLUMNAS> TFilas;  // la fila tiene n_colum huecos
typedef array<TFilas, NUM_FILAS> TMatriz; // hay n_fila filas

void leer(TMatriz& m){
    cout << "Introduzca una matriz " << NUM_FILAS << "*" << NUM_COLUMNAS << " (fila a fila):\n";
    for(int f=0; f<NUM_FILAS; f++){
        for(int c=0; c<NUM_COLUMNAS; c++){
            cin >> m[f][c];
        }
    }
}

bool esta(int n, TMatriz& m){
    bool existeNum = false;
    int f=0, c=0;
    while(!existeNum && f<NUM_FILAS){
        c=0; // hay que empezar desde el primer numero de la fila cada vez que se mire
        while(!existeNum && c<NUM_COLUMNAS){
            if(m[f][c]==n){
                existeNum = true;
            }
            c++;
        }
        f++;
    }
    return existeNum;
}

int main(){
    TMatriz m;
    int num;

    leer(m);
    cout << "\nIntroduce el número a buscar en la matriz: ";
    cin >> num;
    if(esta(num, m)){
        cout << "\nEl número " << num << " está en la matriz";
    }
    else{
        cout << "\nEl número " << num << " NO está en la matriz";
    }

    return 0;
}
