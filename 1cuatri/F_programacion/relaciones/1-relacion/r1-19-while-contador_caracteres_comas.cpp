/*19. Confecciona un algoritmo que lea de teclado un texto carácter a carácter hasta localizar un
punto, y que al final dé como salida el número de comas encontradas, y el número de
caracteres leídos. Por ejemplo, si se introduce el texto siguiente:
Este, aunque sencillo, es un ejemplo interesante.
La salida será:
Caracteres: 48
De ellos son comas: 2*/

#include <iostream>
using namespace std;

int main(){
    char texto; 
    int contador_caracteres = 0, contador_comas = 0;
    cout << "Dame un texto terminado en punto." << endl; 
    // no se inicializa la variable para arreglar que no cuente el '.'. Cuenta desde NULL a length(texto)-1 => length(texto)
    // si se inicializa, cuenta desde la primera letra hasta length(texto) - 1, es decir, no incluye al punto => length(texto) - 1
    while (texto != '.') {
        cin.get(texto);
        if (texto == ',' ) {
            ++contador_comas;
            ++contador_caracteres;
        }
        else {
            ++contador_caracteres;
        }
    }

    cout << "Caracteres: " << contador_caracteres << endl << "De ellos son comas: " << contador_comas << endl;

    return 0;
}