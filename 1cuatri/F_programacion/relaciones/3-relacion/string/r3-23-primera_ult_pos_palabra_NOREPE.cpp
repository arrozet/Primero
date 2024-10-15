#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST = 15;
struct TDatos_pal{
    string palabra;
    int primPos;
    int ultPos;
};
typedef array<TDatos_pal, MAX_PAL_DIST> TDistancia_pal;
struct TPal{
    TDistancia_pal todas;
    int tam;
};

bool estaEnArray(const string& pal, const TPal& lista, int& cont){
    bool esta = false;
    while(!esta && cont < lista.tam){
        if(lista.todas[cont].palabra==pal){
            esta = true;
        }
        else{
        cont++;
        }
    }
    return esta;
}

void guardarDatos(const string& pal, TPal& pal_interes, int pos_interes, const int cont){
    if(!estaEnArray(pal, pal_interes, pos_interes)){
            pal_interes.todas[pal_interes.tam].palabra = pal;  // rellenando el array 1 a 1, de ahí que se use su tamaño
            // asignación de posiciones
            pal_interes.todas[pal_interes.tam].primPos = cont+1;
            pal_interes.todas[pal_interes.tam].ultPos = cont+1;
            pal_interes.tam++;
        }
        else{
            pal_interes.todas[pos_interes].ultPos = cont+1;
        }
}

void escribirPalInteres(const TPal& pal){
    cout << "Palabras y posiciones primera y última:" << endl;
    for(int i=0; i<pal.tam; i++){
        cout << pal.todas[i].palabra << " " << pal.todas[i].primPos << " " << pal.todas[i].ultPos << endl;
    }
}

int main(){
    string pal;
    TPal pal_interes;
    pal_interes.tam = 0;
    int pos_interes, cont = 0;

    cout << "Introduzca un texto (FIN para terminar): " << endl;
    cin >> pal;
    while(pal != "FIN"){
        pos_interes = 0;
        guardarDatos(pal, pal_interes, pos_interes, cont);

        cont++;
        cin >> pal;
    }

    escribirPalInteres(pal_interes);

    return 0;
}
