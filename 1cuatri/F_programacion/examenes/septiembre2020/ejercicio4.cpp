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

const int MAX_PAL_DIST = 30;
typedef array<string, MAX_PAL_DIST> TPalDist;
struct TPal{
    TPalDist elem;
    int tam;
};

bool repe(const string& pal, const TPal& lista){
    int i=0;
    bool repe=false;
    while(i<lista.tam && !repe){
        if(pal==lista.elem[i]){
            repe=true;
        }
        i++;
    }
    return repe;
}

void escribir(const TPal& lista){
    cout << "\nLas palabras ordenadas de menor a mayor longitud son: " << endl;
    for(int i=0; i<lista.tam; i++){
        cout << lista.elem[i] << " ";
    }
}

int encontrarPos(const string& pal, const TPal& lista){
    int i=0;
    while(i<lista.tam && int(pal.size()) >= int(lista.elem[i].size())){
        i++;
    }
    return i;  // cuando ya pal no sea la palabra mas grande, la pos retornada es donde se tiene que meter
}

void abrirHueco(int pos, TPal& l){
    for(int i=l.tam; i>pos; i--){
        l.elem[i] = l.elem[i-1];
    }
}

int main(){
    string palabra;
    TPal lista;
    lista.tam=0;
    int pos=0;

    cout << "Introduzca un texto (FIN para terminar): ";
    cin >> palabra;
    while(palabra!="FIN"){
        if(!repe(palabra,lista)){
            pos = encontrarPos(palabra,lista);
            abrirHueco(pos,lista);
            lista.elem[pos] = palabra;
            lista.tam++;
        }
        cin>>palabra;
    }
    escribir(lista);


    return 0;
}
