#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST = 10;
typedef array<string, MAX_PAL_DIST> TPalabras_patron;
struct TData{
    TPalabras_patron pal;
    int tam;
};

bool cumplePatron(const string& patron, const string& pal){
    bool cumple = false;
    int cont = 0;
    while(cont < int(pal.size()) && !cumple){
        if(pal[cont]==patron[0] && pal.substr(cont, int(patron.size()))==patron){
            cumple = true;
        }
        cont++;
    }
    return cumple;
}

bool estaEnArray(const TData& d, const string& pal){
    bool esta = false;
    int cont = 0;
    while(!esta && cont<d.tam){
        if(d.pal[cont]==pal){
            esta=true;
        }
        cont++;
    }
    return esta;
}

void escribirPalabrasPatron(const TData& d, const string& patron){
    cout << "Las palabras con el patron " << patron << " son: " << endl;
    for(int i=0; i<d.tam; i++){
        cout << d.pal[i] << " ";
    }
}

int main(){
    TData d;
    string patron, palabra;
    d.tam = 0;

    cout << "Patrón: ";
    cin >> patron;

    cout << "Texto: ";
    cin >> palabra;
    while(palabra != "FIN"){
        if(cumplePatron(patron, palabra) && !estaEnArray(d,palabra)){
            d.pal[d.tam] = palabra;
            d.tam++;
        }
        cin >> palabra;
    }

    escribirPalabrasPatron(d, patron);

    return 0;
}
