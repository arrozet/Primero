/*6. Diseña un algoritmo que lea un texto de longitud indefinida formado por letras mayúsculas (que
termina con un punto) y muestre por pantalla la frecuencia con la que aparece cada una de las
letras del texto. Un ejemplo de ejecución sería:

Introduzca una secuencia de letras mayusculas (punto para terminar):
BAACABDPBHBH.
La frecuencia de cada letra es:
A: 3
B: 4
C: 1
D: 1
H: 2
P: 1*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 27; // las 27 letras mayúsculas
typedef array<int, MAX> TFrec;

void leerDatos(TFrec& frec){
    char c;
    cout << "Introduzca una secuencia de letras mayusculas (punto para terminar): " << endl;
    do{
        cin.get(c);
        if((c >= 'A') && (c <= 'Z')){
            frec[c-'A']++;  // que ponga en la posición 0 si es 'A' el nº de veces que está a
                            // pos 1 --> nº veces B 
                            // y así sucesivamente
        }
    }while(c != '.');
}

void escribir(const TFrec& frec){
    cout << "La frecuencia de cada letra es: " << endl; // no se puede usar for each pq el array está parcialmente lleno
    for(int i = 0; i<MAX; i++){
        if (frec[i] != 0){ // para que no ponga las que están vacías
            cout << char(i+'A') << ": " << frec[i] << endl;
        }
    }
}
int main(){
    TFrec frec = {{}};
    leerDatos(frec);
    escribir(frec);
    return 0;
}