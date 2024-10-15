/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/

#include <iostream>
#include <array>
using namespace std;

const int N = 3;
typedef array<int, N> TFila;
typedef array<TFila, N> TMatriz;

void leer(TMatriz& m){
    cout << "Introduce los numeros enteros para una matriz cuadrada de " << N << "x" << N << ": " << endl;
    for(int f=0; f<N; f++){
        for(int c=0; c<N; c++){
            cin >> m[f][c];
        }
    }
}
void escribir(const TMatriz& m){
    cout << "La matriz introducida es: " << endl;
    for(int f=0; f<N; f++){
        for(int c=0; c<N; c++){
            cout << m[f][c] << " ";
        }
        cout << endl;
    }
}

bool elementosValidos(const TMatriz& m){
    bool valido = true;
    int f=0, c=0;
    while(valido && f<N){
        c=0;
        while(valido && c<N){
            if(m[f][c]<0 || m[f][c] >= 100){
                valido = false;
            }
            c++;
        }
        f++;
    }
    return valido;
}

bool filaEstocastica(const TMatriz& m, int f){
    int suma_fila = 0;
    bool estocastica = false;

    for(int c=0; c<N; c++){
        suma_fila += m[f][c];
    }

    if(suma_fila == 100){
        estocastica = true;
    }
    return estocastica;
}

bool columnaEstocastica(const TMatriz& m, int c){
    int suma_fila = 0;
    bool estocastica = false;

    for(int f=0; f<N; f++){
        suma_fila += m[f][c];
    }

    if(suma_fila == 100){
        estocastica = true;
    }
    return estocastica;
}

bool esEstocastica(const TMatriz& m){
    bool estocastica = elementosValidos(m);
    int f=0, c=0;
    while(estocastica && f<N){
        if(!filaEstocastica(m,f)){
            estocastica = false;
        }
        f++;
    }
    while(estocastica && c<N){
        if(!columnaEstocastica(m,c)){
            estocastica = false;
        }
        c++;
    }

    return estocastica;
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX\n" << endl;

    TMatriz m;
    leer(m);
    escribir(m);

    if(esEstocastica(m)){
        cout << "La matriz introducida SI es doblemente estocastica normalizada";
    }
    else{
        cout << "La matriz introducida NO es doblemente estocastica normalizada";
    }

    return 0;
}
