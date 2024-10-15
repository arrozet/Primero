/*
Ruben Oliva Zamora
Ingenieria del software
Grupo A
Equipo PC105
*/

#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_PAL_DIST = 15;
const int MAX_LETRAS = 26;
typedef array<string, MAX_PAL_DIST> TPalabras;
struct TPal{
    TPalabras elem;
    int tam;
};
typedef array<bool, MAX_LETRAS> TPrimera;

void escogerLetras(TPrimera& letra, const string& pal){
    for(int i=0; i<int(pal.size()); i++){
        letra[pal[i]-'A'] = true;
    }
}

bool repe(const TPal& p, const string& pal){
    bool repe=false;
    int i = 0;
    while(!repe && i<p.tam){
        if(p.elem[i]==pal){
            repe = true;
        }
        i++;
    }
    return repe;
}

bool estaVacio(const TPrimera& lista){
    bool vacio = true;
    int i=0;
    while(vacio && i<MAX_LETRAS){
        if(lista[i]==true){
            vacio=false;
        }
        i++;
    }
    return vacio;
}

int numCaracterDistinto(const TPrimera& lista){
    int distintas_primera=0;
    for(int i=0; i<MAX_LETRAS; i++){
        if(lista[i]){
            distintas_primera++;
        }
    }
    return distintas_primera;
}

// REVISAR, NO FUNCIONA BIEN
bool tieneLetrasJustas(const string& pal, const TPrimera& lista){
    int distintas_primera = numCaracterDistinto(lista);
    int distintas_pal=0;
    TPrimera aux = {{}};

    for(int i=0; i<int(pal.size()); i++){
        if(!aux[int(pal[i])-'A']){
            aux[i]=true;  // debería ser "aux[int(pal[i])-'A']=true;"
            distintas_pal++;
        }
    }

    return distintas_primera==distintas_pal;

}


bool tieneLetras(const string& pal, const TPrimera& lista_letras){
    bool tiene=true;
    int i=0;
    if(tieneLetrasJustas(pal,lista_letras)){
            while(tiene && i<int(pal.size())){
                if(!lista_letras[int(pal[i])-'A']){
                    tiene = false;
                }
                i++;
            }
    }
    else{
        tiene=false;
    }

    return tiene;
}

void procesarPalabra(TPal& p, const string& pal, const TPrimera& lista_letras){
    if(tieneLetras(pal,lista_letras)){
        p.elem[p.tam] = pal;
        p.tam++;
    }
}

void escribirLocogramas(const TPal& p){
    cout << "\nLas palabras que son locogramas de la primera son: " << endl;
    for(int i=0; i<p.tam; i++){
        cout << p.elem[i] << endl;
    }
}

int main(){
    cout << "Ruben Oliva Zamora\nIngenieria del software\nGrupo A\nEquipo PC105\n" << endl;

    TPrimera lista_letras = {{}};
    TPal p;
    p.tam=0;
    string pal,primera;

    cout << "Introduzca un texto (FIN para terminar): " << endl;
    cin >> primera;
    escogerLetras(lista_letras,primera);

    while(pal != "FIN"){
        if(!repe(p,pal) && pal!=primera){
            procesarPalabra(p,pal,lista_letras);
        }
        cin >> pal;
    }

    escribirLocogramas(p);

    return 0;
}

