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
const int MAX_LETRAS = 26;
typedef array<string, MAX_PAL_DIST> TPalabras;
struct TPal{
    TPalabras elem;
    int tam;
};
typedef array<int, MAX_LETRAS> TFrec;

void frecuenciaPatron(const string& patron, TFrec& f){
    for(int i=0; i<int(patron.size()); i++){
        f[patron[i]-'A']++;
    }
}

bool repe(const string& texto, const TPal& p){
    int i=0;
    bool repe = false;
    while(i<p.tam && !repe){
        if(p.elem[i]==texto){
            repe = true;
        }
        i++;
    }
    return repe;
}


void procesarTexto(const string& texto, int x, const TFrec& f, TPal& p){
    int i=0;
    int cont=0;
    if(!repe(texto,p)){
        while(i<int(texto.size()) && cont<x){
        if(f[texto[i]-'A'] > 0){  // si en la pos de la letra correspondiente en el array de frecuencias es mayor que 0, se cumple la condicion para un caracter
            cont++;
        }
        i++;
        }
        if(cont>=x){
            p.elem[p.tam] = texto;
            p.tam++;
        }
    }

}

void escribir(const TPal& p, int x, const string& patron){
    cout << "\nLas palabras que contienen al menos " << x << " caracteres comunes con " << patron << " son: " << endl;
    for(int i=0; i<p.tam; i++){
        cout << p.elem[i] << " ";
    }
}

int main(){
    string patron, texto;
    int x;
    TFrec f = {{}};
    TPal p;
    p.tam=0;

    cout << "Introduzca el patron: ";
    cin >> patron;
    frecuenciaPatron(patron, f);

    cout << "Introduzca el valor de x: ";
    cin >> x;
    cout << "Introduzca el texto (FIN para terminar): " << endl << endl;
    cin >> texto;

    while(texto!="FIN"){
        procesarTexto(texto,x,f,p);
        cin >> texto;
    }

    escribir(p,x,patron);

    return 0;
}
