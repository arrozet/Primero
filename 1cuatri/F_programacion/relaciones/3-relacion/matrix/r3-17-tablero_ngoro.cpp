#include <iostream>
#include <array>
using namespace std;

const int N = 4;
typedef array<int, N+1> TFila;
typedef array<TFila, N> TTablero;

void incrementoCircular(int& x, const int N){
    x %= N;
}

void llenarNGoro(TTablero& t){
    int n = 1, f = 0, c = 0;
    // que ponga el primero
    t[f][c] = n;
    n++;
    while(n<=(N*(N+1))){
        // sumamos y comprobamos si está fuera de índice
        // si lo está, hacemos el incremento circular
        f++;
        c++;
        if(f>(N-1)){
            incrementoCircular(f,N);
        }
        else if(c>N){
            incrementoCircular(c,N+1);
        }
        t[f][c] = n;
        n++;
    }
}

void escribir(TTablero& t){
    for(int f=0; f<N; f++){
        for(int c=0; c<(N+1); c++){
            cout << t[f][c] << " ";
        }
        cout << endl;
    }
}

int main(){
    TTablero t;

    llenarNGoro(t);
    cout << "Tablero N-goro para N = " << N << ": " << endl;
    escribir(t);

    return 0;
}
