/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/

#include <iostream>
#include <array>
#include <string>
#include <cmath>
using namespace std;
const int MAX = 10;
struct TDatos{
    string nombre;
    int gastos;
    int deuda;
};

typedef array<TDatos, MAX> TElementos;
struct TPersonas{
    TElementos elem;
    int tam;
};

bool estaNombre(const string& nombre, const TPersonas& p, int& i){
    bool esta = false;
    while(!esta && i<p.tam){
        if(p.elem[i].nombre == nombre){
            esta = true;
        }
        i++;
    }
    return esta;
}

void pedirGastos(TPersonas& p, int ind){
    int gastos;
    cout << "Gastos: ";
    cin >> gastos;
    p.elem[ind].gastos += gastos;
}

void leerDatos(const string& nombre, TPersonas& p){
    int ind = 0;
    bool esta = estaNombre(nombre,p,ind);

    if(esta){
        pedirGastos(p, ind-1);
    }
    else{
        p.elem[p.tam].gastos = 0;
        p.elem[p.tam].nombre = nombre;
        pedirGastos(p,p.tam);
        p.tam++;
    }
}

void escribirDatos(const TPersonas& p){
    for(int i=0; i<p.tam; i++){
        cout << p.elem[i].nombre << " ha gastado en comun " << p.elem[i].gastos << endl;
    }
}

int mediaGastos(const TPersonas& p){
    int suma = 0, media;
    for(int i=0; i<p.tam; i++){
        suma += p.elem[i].gastos;
    }
    media = suma / p.tam;
    return media;
}

void calculoDeudas(TPersonas& p, int media){
    for(int i=0; i<p.tam; i++){
        p.elem[i].deuda = p.elem[i].gastos - media;
    }
}

void escribirDeudas(const TPersonas& p){
    for(int i=0; i<p.tam; i++){
        if(p.elem[i].deuda<0){
            cout << p.elem[i].nombre << " debe pagar " << abs(p.elem[i].deuda) << endl;
        }
        else if(p.elem[i].deuda == 0){
            cout << p.elem[i].nombre << " esta a la par" << endl;
        }
        else{
            cout << p.elem[i].nombre << " debe recibir " << p.elem[i].deuda << endl;
        }
    }
    cout << endl;
}

int encontrarMayorDeuda(TPersonas& p, int& deuda_mayor){
    int ind=0;
    deuda_mayor = p.elem[0].deuda;
    for(int i=1; i<p.tam; i++){
        if(p.elem[i].deuda < deuda_mayor){  // se pone negativo pq la mayor deuda es el num negativo mas pequeño
            ind = i;
            deuda_mayor = p.elem[i].deuda;
        }
    }

    return ind;
}

int encontrarRecibidor(TPersonas& p, int& mayor_recibidor){
    int ind=0;
    mayor_recibidor = p.elem[0].deuda;
    for(int i=1; i<p.tam; i++){
        if(p.elem[i].deuda > mayor_recibidor){
            ind = i;
            mayor_recibidor = p.elem[i].deuda;
        }
    }

    return ind;
}

void transferirDinero(TPersonas& p){
    int deuda_mayor, recibidor_mayor;
    int ind_pagar = encontrarMayorDeuda(p,deuda_mayor);
    int ind_recibir = encontrarRecibidor(p,recibidor_mayor);

    if(abs(deuda_mayor) <= recibidor_mayor){
        cout << p.elem[ind_pagar].nombre << " paga " << abs(deuda_mayor) << " a " << p.elem[ind_recibir].nombre << endl;
        p.elem[ind_pagar].deuda += abs(deuda_mayor);
        p.elem[ind_recibir].deuda -= abs(deuda_mayor);
    }
    else{
        cout << p.elem[ind_pagar].nombre << " paga " << recibidor_mayor << " a " << p.elem[ind_recibir].nombre << endl;
        p.elem[ind_pagar].deuda += abs(recibidor_mayor);
        p.elem[ind_recibir].deuda -= abs(recibidor_mayor);
    }
}

bool hayDeudas(const TPersonas& p){
    bool existe = false;
    int i = 0;
    while(!existe && i<p.tam){
        if(p.elem[i].deuda != 0){
            existe = true;
        }
        i++;
    }
    return existe;
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX\n" << endl;

    TPersonas p;
    p.tam = 0;
    string nombre;
    cout << "Introduzca nombres y gastos (FIN para terminar): " << endl;
    cout << "Nombre: ";
    cin >> nombre;
    while(nombre != "FIN"){
        leerDatos(nombre, p);

        cout << "Nombre: ";
        cin >> nombre;
    }
    cout << endl;
    escribirDatos(p);

    int media_gastos;
    media_gastos = mediaGastos(p);
    cout << "\nLa media de gastos en comun es " << media_gastos << endl;

    calculoDeudas(p,media_gastos);
    cout << endl;
    escribirDeudas(p);

    while(hayDeudas(p)){
        transferirDinero(p);
    }




    return 0;
}
