// Rubén Oliva Zamora
// Ingeniería del software
// Grupo A
// Equipo XX
#include <iostream>
#include <array>
using namespace std;

const int FILA = 2;
const int COLUMNA = 3;
const int FILA_T = FILA*2;

typedef array<int, COLUMNA> TFila;
typedef array<TFila, FILA> TMatriz_m;

typedef array<int, COLUMNA> TFila;
typedef array<TFila, FILA_T> TMatriz_t;

void leerM(TMatriz_m& m){
    cout << "Introduzca la matriz M (" << FILA << "x" << COLUMNA << "): " << endl;
    for(int f=0; f<FILA; f++){
        for(int c=0; c<COLUMNA; c++){
            cin >> m[f][c];
        }
    }
}

int mediaM(const TMatriz_m& m){
    int suma = 0, media;
    for(int f=0; f<FILA; f++){
        for(int c=0; c<COLUMNA; c++){
            suma += m[f][c];
        }
    }
    media = suma/(FILA*COLUMNA);
    return media;
}

void copiarFilas(const TMatriz_m& m, TMatriz_t& t){
    int f_m = 0;
    for(int f=0; f<FILA_T; f++){
        for(int c=0; c<COLUMNA; c++){
            if(f%2==0){
                t[f][c] = m[f_m][c];
            }
            else{
                t[f][c] = 0;
            }
        }
        if(f%2==0){  // si estabamos en una par, que sume 1 al contador de f_m
            f_m++;
        }
    }
}

bool celdaValida(int f, int c){
    return (f>=0 && f<FILA_T && c>=0 && c<COLUMNA);
}

int calcularVecinos(const TMatriz_t& t, int& num_vecinos, int f_interes, int c_interes, const int media_m){
    int suma=0;
    for(int f=f_interes-1; f<=f_interes+1; f++){
        for(int c=c_interes-1; c<=c_interes+1; c++){
            if(!(f==f_interes && c==c_interes) && celdaValida(f,c)){
                num_vecinos++;
                if(t[f][c]>0){
                    suma+=t[f][c];
                }
                else{
                    suma+=media_m;
                }
            }
        }
    }
    return suma;
}

void calcularFilasImpares(TMatriz_t& t, int media_m){
    int num_vecinos = 0, suma_vecinos = 0;
    for(int f=1; f<FILA_T; f++){
        for(int c=0; c<COLUMNA; c++){
            if(f%2==1){
                num_vecinos = 0;
                suma_vecinos = calcularVecinos(t,num_vecinos,f,c,media_m);
                t[f][c] = suma_vecinos / num_vecinos;
            }
        }
    }
}

void escribirT(const TMatriz_t& t){
    cout << "La matriz T (" << FILA_T << "x" << COLUMNA << ") es la siguiente: " << endl;
    for(int f=0; f<FILA_T; f++){
        for(int c=0; c<COLUMNA; c++){
            cout << t[f][c] << " ";
        }
        cout << endl;
    }
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX\n" << endl;

    TMatriz_m m;
    TMatriz_t t;
    leerM(m);
    int media_m = mediaM(m);
    copiarFilas(m,t);  // copiar filas de m a filas impares de t + inicializar filas impares a 0
    escribirT(t);
    calcularFilasImpares(t, media_m);
    escribirT(t);

    return 0;
}
