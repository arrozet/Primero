/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/
#include <iostream>
#include <array>
using namespace std;

const int N = 4;
const int M = 3;
typedef array<int, M> TFila;
typedef array<TFila, N> TImagen;

void leer(TImagen& m){
    cout << "Introduzca la matriz de entrada: " << endl;
    for(int f=0; f<N; f++){
        for(int c=0; c<M; c++){
            cin >> m[f][c];
        }
    }
}

void escribir(TImagen& m){
    cout << "\nLa matriz suavizada es: " << endl;
    for(int f=0; f<N; f++){
        for(int c=0; c<M; c++){
            cout << m[f][c] << " ";
        }
        cout << endl;
    }
}

bool celdaValida(int f, int c){
    return (f>=0 && f<N && c>=0 && c<M);
}

int mediaVecinos(const TImagen& m, int fil, int col){
    int suma=0, num_vecinos=0, media_vecinos;
    for(int f=(fil-1); f<=(fil+1); f++){
        for(int c=(col-1); c<=(col+1); c++){
            if(celdaValida(f,c)){
                suma+=m[f][c];
                num_vecinos++;
            }
        }
    }
    media_vecinos = suma/num_vecinos;
    return media_vecinos;
}

void suavizado(const TImagen& m, TImagen& b){
    for(int f=0; f<N; f++){
        for(int c=0; c<M; c++){
            b[f][c] = mediaVecinos(m, f, c);
        }
    }
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX" << endl << endl;

    TImagen m,b;
    leer(m);
    suavizado(m,b);

    escribir(b);
    return 0;
}
