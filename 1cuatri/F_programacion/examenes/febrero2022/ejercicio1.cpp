// Rubén Oliva Zamora
// Ingeniería del software
// Grupo A
// Equipo XX
#include <iostream>
#include <array>
using namespace std;

const int TAM = 7;
typedef array<int, TAM> TFila;
typedef array<TFila, TAM> TMatriz;

void rellenarPrimero(TMatriz& m){
    // Rellenar primera fila
    for(int c=0; c<TAM; c++){
        m[0][c] = 1;
    }
    // Rellenar primera columna
    for(int f=1; f<TAM; f++){
        m[f][0] = 1;
    }
}

// NO TERMINA DE FUNCIONAR, YA QUE RELLENA CELDAS EXTRA
void calcularTriangulo(TMatriz& m){
    rellenarPrimero(m);
    for(int f=1; f<TAM; f++){
        for(int c=1; c<(TAM-f); c++){
            m[f][c] = m[f][c-1] + m[f-1][c];  // el de la izq + el de arriba
        }
    }
}

void escribirTriangulo(TMatriz& m){
    for(int f=0; f<TAM; f++){
        for(int c=0; c<TAM; c++){
            if(c<(TAM-f)){
                cout << m[f][c] << " ";
            }
        }
        cout << endl;
    }
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX\n" << endl;

    TMatriz m;
    calcularTriangulo(m);
    escribirTriangulo(m);

    return 0;
}
