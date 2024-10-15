#include <iostream>
#include <string>
#include <array>
using namespace std;

const int MAX_LETRAS = 26;
typedef array<int, MAX_LETRAS> TFrec;

void guardarPrimeraPalabra(const string& texto, TFrec& f){
    for(int i=0; i<int(texto.size()); i++){
        f[texto[i]-'A']++;
    }
}

int main(){
    string primera, palabra;
    TFrec f = {{}};
    cout << "Introduzca un texto (en mayuscula) terminado con la palabra FIN" << endl;
    cin >> primera;

    if(primera != "FIN"){
        guardarPrimeraPalabra(primera, f);
        cin >> palabra;
        cout << "\nLas palabras cuya inicial esta en la primera palabra del texto son: " << endl;
        while(palabra != "FIN"){
            if((f[palabra[0]-'A']) > 0){ // si está en el array de frecuencias de la primera palabra
                cout << palabra << " ";
            }
            cin >> palabra;
        }
    }

    return 0;
}
