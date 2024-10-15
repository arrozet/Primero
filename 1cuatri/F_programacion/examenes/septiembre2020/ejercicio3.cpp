/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/

#include <iostream>
#include <array>
#include <string>
using namespace std;
const int MAX = 10;
struct TDatos{
    string nombre;
    int resultado;
    double apuesta;
};
typedef array<TDatos, MAX> TPer;
struct TPersona{
    TPer elem;
    int tam;
};

bool repe(const string& nombre, const TPersona& p, int& ind){
    bool repe=false;
    ind=0;
    while(!repe && ind<p.tam){
        if(nombre==p.elem[ind].nombre){
            repe=true;
        }
        ind++;
    }
    return repe;
}

void pedirResultadoCantidad(TPersona& p, int ind){
    int apuesta;
    cout << "Resultado (0 1 2): ";
    cin >> p.elem[ind].resultado;
    cout << "Cantidad (> 0): ";
    cin >> apuesta;
    p.elem[ind].apuesta += apuesta;
}

void leer(TPersona& p,int& resultado){
    int i=0, ind=0;
    cout << "Introduzca nombres, resultados y cantidades apostadas (FIN para terminar): " << endl;
    cout << "Nombre: ";
    cin >> p.elem[i].nombre;
    while(p.elem[i].nombre != "FIN" && i<MAX){
        p.elem[i].apuesta=0;
        if(!repe(p.elem[i].nombre, p, ind)){
            pedirResultadoCantidad(p, p.tam);
            p.tam++;
        }
        else{
            pedirResultadoCantidad(p,ind-1);
        }
        cout << "Nombre: ";
        i++;
        cin >> p.elem[i].nombre;
    }

    cout << "\n\nIntroduzca el resultado final de la apuesta (0,1,2): ";
    cin >> resultado;
}

void escribirDatos(const TPersona& p){
    cout << endl << endl;
    for(int i=0; i<p.tam; i++){
        cout << p.elem[i].nombre << " " << p.elem[i].resultado << " " << p.elem[i].apuesta << endl;
    }
}

int totalApostado(const TPersona& p){
    int total=0;
    for(int i=0; i<p.tam; i++){
        total+=p.elem[i].apuesta;
    }
    return total;
}

int totalGanador(const TPersona& p, int resultado){
    int total=0;
    for(int i=0; i<p.tam; i++){
        if(p.elem[i].resultado==resultado){
            total+=p.elem[i].apuesta;
        }
    }
    return total;
}

void escribirReintegro(const TPersona& p,int ratio_apuesta,int resultado){
    int reintegro;
    for(int i=0; i<p.tam; i++){
        if(p.elem[i].resultado!=resultado){
            reintegro=0;
        }
        else{
            reintegro=p.elem[i].apuesta*ratio_apuesta;
        }
        cout << p.elem[i].nombre << " " << p.elem[i].resultado << " " << p.elem[i].apuesta << " -> " << reintegro << endl;
    }

}

int main(){
    TPersona p;
    p.tam=0;
    int resultado;
    leer(p,resultado);
    escribirDatos(p);

    int t1 = totalApostado(p), t2=totalGanador(p,resultado);
    double ratio_apuesta=t1/t2;
    cout << endl;
    cout << "Total apostado: " << t1 << endl;
    cout << "Total ganador: " << t2 << endl;
    cout << "Ratio: " << ratio_apuesta;

    cout << endl << endl;
    escribirReintegro(p,ratio_apuesta,resultado);


    return 0;
}
