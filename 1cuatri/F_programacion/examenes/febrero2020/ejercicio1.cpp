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
typedef array<int,MAX> TArray;
struct TDatos{
    TArray elem;
    int tam;
};

void leerDatos(TDatos& d){
    cout << "Introduzca una secuencia de enteros positivos acabada en 0: ";
    cin >> d.elem[d.tam];
    while(d.elem[d.tam] != 0){
        if(d.elem[d.tam]>0){
            d.tam++;
        }
        cin >> d.elem[d.tam];
    }
}

bool esPrimo(int n){
    int cont = n-1;
    bool primo = true;
    while(cont>1 && primo){
        if(n%cont==0){
            primo = false;
        }
        cont--;
    }
    return primo;
}

int buscarPrimoMayor(const TDatos& d){
    int primo_mayor = 0;
    for(int i=0; i<d.tam; i++){
        if(esPrimo(d.elem[i]) && d.elem[i]>primo_mayor){
            primo_mayor = d.elem[i];
        }
    }
    return primo_mayor;
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX\n" << endl;

    TDatos d;
    d.tam = 0;
    int primo_mayor;

    leerDatos(d);
    primo_mayor = buscarPrimoMayor(d);
    if(primo_mayor >1){
        cout << "El mayor primo de la secuencia es: " << primo_mayor;
    }
    else{
        cout << "No hay ningun primo en la secuencia";
    }

    return 0;
}
