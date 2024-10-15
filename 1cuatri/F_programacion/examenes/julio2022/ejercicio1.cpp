/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/
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

int mayorLongitud(const TArray& a){
    int mayor=0, mayor_seccion=0, cont=0, anterior=a[0];
    for(int i=1; i<TAM; i++){
        if(anterior>a[i]){
            cont = 0;
        }
        cont++;
        mayor_seccion = cont;
        anterior = a[i];

        if(mayor_seccion>mayor){
            mayor = mayor_seccion;
        }
    }
    return mayor;
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX" << endl << endl;

    TArray a;
    leer(a);
    cout << "La longitud de la mayor sub-sucesion es: " << mayorLongitud(a);
    return 0;
}
