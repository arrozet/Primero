// Rubén Oliva Zamora
// Ingeniería del software
// Grupo A
// Equipo XX
#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST = 15;
typedef array<string, MAX_PAL_DIST> TPalabras_ordenadas;
struct TOrdenadas{
    TPalabras_ordenadas pal;
    int tam;
};

bool estaOrdenada(const string& pal){
    bool esta = true;
    int cont = 1;
    char anterior = pal[0];

    while(cont<(int(pal.size())) && esta){
        if(anterior<=pal[cont]){
            anterior = pal[cont];
        }
        else{
            esta = false;
        }
        cont++;
    }

    return esta;
}

bool existeRepe(const string& pal, const TOrdenadas& ord){
    bool existe = false;
    for(int i=0; i<ord.tam; i++){
        if(pal==ord.pal[i]){
            existe = true;
        }
    }

    return existe;
}

void escribirOrdenadas(const TOrdenadas& ord){
    cout << "Las palabras cuyos caracteres estan ordenados son: " << endl;
    for(int i=0; i<ord.tam; i++){
        cout << ord.pal[i] << " ";
    }
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX\n" << endl;

    TOrdenadas ord;
    string pal;
    bool valida, repe;
    ord.tam=0;

    cout << "Introduzca el texto (FIN para terminar): " << endl;
    cin >> pal;
    while(pal != "FIN"){
        valida = estaOrdenada(pal);
        repe = existeRepe(pal, ord);
        if(valida && !repe){
            ord.pal[ord.tam] = pal;
            ord.tam++;
        }
        cin >> pal;
    }

    escribirOrdenadas(ord);

    return 0;
}
