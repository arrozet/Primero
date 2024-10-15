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

void escribir(TFrec& f){
    cout << "\nLa frecuencia de cada digito es: " << endl;
    for(int i=0; i<MAX_NUM; i++){
        cout << i << ": " << f[i] << endl;
    }
}

int main(){
    TFrec f ={{}};
    int n=0;
    calcularFrec(f,n);
    escribir(f);

    return 0;
}