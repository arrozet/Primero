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

const int MAX_PAL_DIST = 10;
typedef array<string, MAX_PAL_DIST> TPal;
struct TPalabras{
    TPal elem;
    int tam;
};

int sumaPal(const string& primera){
    int suma = 0;
    for(int i=0; i<int(primera.size()); i++){
        suma += int(primera[i]);
    }
    return suma;
}

bool repe(const string& pal, const TPalabras& grupo){
    bool repe = false;
    int i=0;
    while(!repe && i<grupo.tam){
        if(grupo.elem[i]==pal){
            repe = true;
        }
        i++;
    }
    return repe;
}

void filtrarPalabra(const string& pal, TPalabras& grupo, const int& suma_primera){
    int nueva_suma = sumaPal(pal);
    if(nueva_suma<suma_primera && !repe(pal,grupo)){
        grupo.elem[grupo.tam] = pal;
        grupo.tam++;
    }
}

bool ordenado(const TPalabras& grupo, int& i){
    string pal = grupo.elem[0];
    while(i<grupo.tam && pal<grupo.elem[i]){
        pal = grupo.elem[i];
        i++;
    }
    return !(i<grupo.tam);  // si no se ha recorrido toda la palabra, es que el array no esta ordenado
}

void ordenarArray(TPalabras& grupo){
    string aux;
    int ind=1;
    while(!ordenado(grupo,ind)){  // con ordenado miras si esta ord y ademas encuentras la pos en la que deja de estarlo
        aux = grupo.elem[ind-1];
        grupo.elem[ind-1] = grupo.elem[ind];
        grupo.elem[ind] = aux;
    }
}

void escribirPalMenores(const TPalabras& grupo, const string& primera){
    cout << "Las palabras que son menores que " << primera << " son: " << endl << endl;
    for(int i=0; i<grupo.tam; i++){
        cout << grupo.elem[i] << " ";
    }
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX\n" << endl;

    string primera, pal;
    int suma_primera;
    TPalabras grupo;
    grupo.tam=0;

    cout << "Introduzca un texto (FIN para terminar): ";
    cin >> primera;
    suma_primera = sumaPal(primera);
    pal = primera;
    while(pal!="FIN"){
        filtrarPalabra(pal,grupo,suma_primera);
        ordenarArray(grupo);
        cin >> pal;
    }

    escribirPalMenores(grupo,primera);


    return 0;
}
