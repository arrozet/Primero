#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST = 15;
const int MAX_REP = 15;

typedef array<int, MAX_REP> TPosiciones;
struct TDatos_pal{
    string palabra;
    TPosiciones posiciones;
    int tam_posiciones;
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
            pal_interes.todas[pal_interes.tam].tam_posiciones = 1;
            pal_interes.todas[pal_interes.tam].palabra = pal;  // rellenando el array 1 a 1, de ahí que se use su tamaño
            // asignación de la primera posición
            pal_interes.todas[pal_interes.tam].posiciones[0] = cont+1;
            pal_interes.tam++;

        }
        else{
            pal_interes.todas[pos_interes].posiciones[pal_interes.todas[pos_interes].tam_posiciones] = cont+1;
            pal_interes.todas[pos_interes].tam_posiciones++;
        }
}

void escribirPalInteres(const TPal& pal){
    cout << "Palabras y posiciones primera y última:" << endl;

    for(int i=0; i<pal.tam; i++){
        cout << pal.todas[i].palabra << " ";
        for(int j=0; j<pal.todas[i].tam_posiciones; j++){
            cout << pal.todas[i].posiciones[j] << " ";
        }
        cout << endl;
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
