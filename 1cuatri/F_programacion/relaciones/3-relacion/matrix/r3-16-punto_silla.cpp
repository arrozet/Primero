#include <iostream>
#include <array>
using namespace std;

const int MAX = 10;
typedef array<int, MAX> TFila;
typedef array<TFila, MAX> TArray2Dim;

struct TMatriz{
    TArray2Dim content;
    int tam;
};

void leer(TMatriz& m){
    cout << "Introduzca la matriz fila a fila:" << endl;
    for(int f=0; f<m.tam; f++){
        for(int c=0; c<m.tam; c++){
            cin >> m.content[f][c];
        }
    }
}

void menorFila(const int f, const TMatriz& m, int& col_interes, bool& estricto){
    // se van recorriendo las columnas de la fila de interes, comparando si es menor estricto o no
    int c = 0;
    while(c<m.tam){
        if(m.content[f][c]<m.content[f][col_interes]){
            col_interes = c;
            estricto = true;
        }
        else if(m.content[f][c]==m.content[f][col_interes]){
            estricto = false;
        }
        c++;
    }
}

void mayorColumna(const int c, const TMatriz& m, int& fila_interes, bool& estricto){
    // se van recorriendo las filas de la columna de interes, comparando si es mayor estricto o no
    int f = 0;
    while(f<m.tam){
        if(m.content[f][c]>m.content[fila_interes][c]){
            fila_interes = c;
            estricto = true;
        }
        else if(m.content[f][c]==m.content[fila_interes][c]){
            estricto = false;
        }
        f++;
    }
}

void calcularPuntoSilla(TMatriz& m, bool& hayPuntoSilla, int& col_interes, int& fila_interes){
    int f = 0;
    bool esEstrictoFila, esEstrictoCol;

    while(f<m.tam && !hayPuntoSilla){
        col_interes = 0;
        esEstrictoFila = false;
        menorFila(f, m, col_interes, esEstrictoFila);
        if(esEstrictoFila){
            fila_interes = 0;
            esEstrictoCol = false;
            mayorColumna(col_interes, m, fila_interes, esEstrictoCol);
            if(esEstrictoCol){
                hayPuntoSilla = true;
            }
        }
        f++;
    }
}

int main(){
    TMatriz m;
    bool hayPuntoSilla = false;
    int col_interes, fila_interes;

    cout << "Introduzca dimension de la matriz cuadrada (maximo " << MAX << "): ";
    cin >> m.tam;
    leer(m);

    calcularPuntoSilla(m, hayPuntoSilla, col_interes, fila_interes);
    if(hayPuntoSilla){
        cout << "El punto silla es: " << endl;
        cout << "Fila: " << fila_interes << ", Columna: " << col_interes;
    }
    else{
        cout << "No hay punto de silla";
    }
    return 0;
}
