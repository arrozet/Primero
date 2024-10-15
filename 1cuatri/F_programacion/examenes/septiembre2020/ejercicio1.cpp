/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 20;
typedef array<int, MAX> TArray;
struct TDatos{
    TArray elem;
    int tam;
};

void leer(TDatos& d){
    cout << "Introduzca una secuencia de enteros positivos acabada en 0: ";
    cin >> d.elem[d.tam];
    while(d.elem[d.tam]!=0 && d.tam<MAX){
        d.tam++;
        cin >> d.elem[d.tam];
    }
}

bool esPerfecto(int n){
    int suma=0;
    for(int i=1; i<n; i++){
        if(n%i==0){
            suma += i;
        }
    }
    return suma==n;
}

int mayorPerfecto(const TDatos& d){
    int mayor_perfecto = -1;
    for(int i=0; i<d.tam; i++){
        if(esPerfecto(d.elem[i]) && mayor_perfecto<d.elem[i]){
            mayor_perfecto = d.elem[i];
        }
    }
    return mayor_perfecto;
}

int main(){
    TDatos d;
    d.tam=0;
    leer(d);
    if(mayorPerfecto(d)==-1){
        cout << "No hay ningun numero perfecto en la secuencia";
    }
    else{
        cout << "El mayor numero perfecto de la secuencia es: " << mayorPerfecto(d);
    }

    return 0;
}
