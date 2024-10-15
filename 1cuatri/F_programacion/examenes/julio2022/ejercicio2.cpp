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

const int MAX_PAL_DIST = 15;

typedef array<string, MAX_PAL_DIST> TPal;
struct TPalDist{
    TPal pal;
    int tam;
};

int sumaCaracteres(const string& pal){
    int suma=0;
    for(int i=0; i<int(pal.size()); i++){
        suma+=int(pal[i]);
    }
    return suma;
}

bool repe(const string& texto, const TPalDist& p){
    bool repe=false;
    int i=0;
    while(!repe && i<p.tam){
        if(texto==p.pal[i]){
            repe = true;
        }
        i++;
    }
    return repe;
}

void procesarTexto(const string& texto, TPalDist& p, int suma_patron){
    if(sumaCaracteres(texto)==suma_patron && !repe(texto,p)){
        p.pal[p.tam] = texto;
        p.tam++;
    }
}

void escribirPalDist(const TPalDist& p){
    cout << "\nLas palabras que cumplen la condición son: " << endl;
    for(int i=0; i<p.tam; i++){
        cout << p.pal[i] << " ";
    }
}

int main(){
    cout << "Rubén Oliva Zamora\nIngeniería del software\nGrupo A\nEquipo XX" << endl << endl;

    TPalDist p;
    p.tam = 0;
    string patron, texto;

    cout << "Introduza el patron: ";
    cin >> patron;

    int suma_patron = sumaCaracteres(patron);

    cout << "Introduzca el texto (FIN para terminar): " << endl;
    cin >> texto;
    while(texto != "FIN"){
        procesarTexto(texto,p,suma_patron);
        cin >> texto;
    }

    escribirPalDist(p);


    return 0;
}
