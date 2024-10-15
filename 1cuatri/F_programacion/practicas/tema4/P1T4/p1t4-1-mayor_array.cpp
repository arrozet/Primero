#include <iostream>
#include <array>
using namespace std;

const int TAM = 10;
typedef array<int, TAM> TArray;

void leer(TArray& a){
    cout << "Introduzca " << TAM << " numeros enteros: ";
    for(int i=0; i<TAM; i++){
        cin >> a[i];
    }
}

int mayor(TArray& a){
    int mayor=a[0];
    for(int i=1; i<TAM; i++){
        if(a[i]>mayor){
            mayor = a[i];
        }
    }

    return mayor;
}

int main(){
    TArray a;
    leer(a);
    
    cout << "El mayor del array es: " << mayor(a);
    return 0;
}