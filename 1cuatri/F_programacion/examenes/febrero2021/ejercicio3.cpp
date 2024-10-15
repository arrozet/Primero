// Rubén Oliva Zamora
// Ingeniería del software
// Grupo A
// Equipo XX


#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX_CAR_PATRON = 5;
const int MAX_PAL_DIST = 15;
/*
typedef array<string, MAX_PAL_DIST> TPalabras;
struct TPal{
    TPalabras elem;
    int tam;
};
typedef array<char, MAX_CAR_PATRON> TPatron;

struct TLista{
    TPatron letra;
    TPal palabra;
    int tam;
};*/
typedef array<string, MAX_PAL_DIST> TArrayPalabra;
struct TPalabras{
    TArrayPalabra palabras;
    int numPal;
};
struct TDatosXLetra{
    char letra;
    TPalabras listaPalabra;
};
typedef array<TDatosXLetra, MAX_CAR_PATRON> TLetras;
struct TLista{
    TLetras datosPorLetra;
    int numLetra;
};


void leerPatron(string& patron){
    do{
        cout << "Introduzca un patron (longitud maxima =" << MAX_CAR_PATRON << "): ";
        cin >> patron;
    }while(int(patron.size())>MAX_CAR_PATRON);
}

bool carRepe(const string& patron, int cont, const TLista& lista){
    bool repe = false;
    for(int i=0; i<lista.numLetra; i++){
        if(patron[cont] == lista.datosPorLetra[i].letra){
            repe = true;
        }
    }
    return repe;
}

void escogerLetrasPatron(const string& patron, TLista& lista){
    int cont=0;
    bool repe=false;
    while(cont<int(patron.size())){
        repe = carRepe(patron, cont, lista);
        if(!repe){
            lista.datosPorLetra[lista.numLetra].letra = patron[cont];
            lista.datosPorLetra[lista.numLetra].listaPalabra.numPal = 0;
            lista.numLetra++;
        }
        cont++;
    }
}

//revisar
bool palRepe(const string& pal, const TPalabras& listaPalabra){
    bool repe = false;
    int i =0;

    while(i<listaPalabra.numPal && !repe){
        if(pal == listaPalabra.palabras[i]){
            repe = true;
        }
        i++;
    }
    return repe;
}

bool analizarPalabra(const string& pal, TLista& lista, int ind){
    bool esValida = false;
    bool repe = palRepe(pal,lista.datosPorLetra[ind].listaPalabra);
    int cont = 0;


    while(!esValida && !repe && cont<int(pal.size())){
        if(pal[cont]==lista.datosPorLetra[ind].letra){  // si una letra de la palabra es la letra que buscamos, entonces nuestra palabra es valida
            esValida = true;
        }
        cont++;
    }

    return esValida;
}

void procesarPalabra(const string& pal, TLista& lista){
    bool valida;
    // vamos buscando por letra
    for(int i=0; i<lista.numLetra; i++){
        valida = analizarPalabra(pal,lista,i);
        if(valida){
            lista.datosPorLetra[i].listaPalabra.palabras[lista.datosPorLetra[i].listaPalabra.numPal] = pal;
            lista.datosPorLetra[i].listaPalabra.numPal++;
        }
    }
}

void escribirPalabrasCompartidas(TLista& lista){
    cout << "Palabras que comparten letra con las letras del patron: " << endl << endl;
    for(int i=0; i<lista.numLetra; i++){
        cout << lista.datosPorLetra[i].letra << " ";
        for(int j=0; j<lista.datosPorLetra[i].listaPalabra.numPal; j++){
            cout << lista.datosPorLetra[i].listaPalabra.palabras[j] << " ";
        }
        cout << endl;
    }
}

int main(){
    cout << "Rubén Oliva Zamora\n Ingeniería del software\n Grupo A \nEquipo XX" << endl;
    string patron, texto;
    TLista lista;
    lista.numLetra=0;

    leerPatron(patron);
    escogerLetrasPatron(patron, lista);
    cout << lista.datosPorLetra[0].letra;

    cout << "Introduzca un texto (FIN para terminar): ";
    cin >> texto;
    while(texto != "FIN"){
        procesarPalabra(texto, lista);

        cin >> texto;
    }

    escribirPalabrasCompartidas(lista);



    return 0;
}
