#include <iostream>
#include <array>
using namespace std;

const int MAX_NUM = 10;
typedef array<int, MAX_NUM> TFrec;

void calcularFrec(TFrec& f, int n){
    cout << "Introduzca una secuencia de digitos (negativo termina): ";
    cin >> n;
    while(n>=0){
        if(n<=9){
            f[n]++;
        }
        cin >> n;
    }
}

int mayorFrec(const TFrec& f){
    int mayorFrec = f[0];
    for(int i=1; i<MAX_NUM; i++){
        if(f[i]>mayorFrec){
            mayorFrec = f[i];
        }
    }

    return mayorFrec;
}

void imprimirAsteriscos(int linea, const TFrec& f){
    for(int x: f){
        if(x>=linea){  // si el numero tiene una frec mayor o igual que la linea, que eche un asterisco
            cout << "* ";
        }
        else{
            cout << "  ";
        }
    }
}

void escribir(const TFrec& f){
    int mayor_linea = mayorFrec(f);  // para saber cuantas lineas dibujar
    for(int linea=mayor_linea; linea>=1; linea--){
        imprimirAsteriscos(linea,f);
        cout << endl;
    }

    for(int i=0; i<MAX_NUM; i++){
        cout << i << " ";
    }
}

int main(){
    TFrec f ={{}};
    int n=0;
    calcularFrec(f,n);
    escribir(f);

    return 0;
}