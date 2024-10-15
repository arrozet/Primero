/*4. Diseña un procedimiento que permita invertir el contenido de un array de MAX (una constante
definida) números enteros recibido como parámetro. No se podrán utilizar arrays auxiliares.
Diseña la función principal (main) para probar el funcionamiento del procedimiento. Para
ello, se leerá de teclado una colección de MAX números enteros con los que se rellenará el
array, se invocará al procedimiento implementado y se mostrará por pantalla el contenido del
array modificado.
Ejemplo:
Array Original: 24 12 45 90 7 9 15.
Array Invertido: 15 9 7 90 45 12 24.*/

#include <iostream>
#include <array>
using namespace std; 

const int MAX = 7;
typedef array<int, MAX> Array; 

void leerDatos(Array& datos){
    cout << "Array original: ";
    for(int i=0; i<MAX; i++){
        cin >> datos[i];
    }
}

void invertirArray(Array& datos){
    int aux = 0;
    for(int i = 0; i<MAX/2; i++){ // max/2 pq solo hace falta llegar a la mitad, ya que se van intercambiando los pares
        aux = datos[i];
        datos[i] = datos[MAX-i-1]; // el -1 para que no intente leer un indice inexistente (pues los índices van de 0 a MAX-1)
        datos[MAX-i-1] = aux;
    }
}

void escribirDatos(const Array& datos){
    cout << "Array invertido: ";
    for(int x : datos){  // con for each
        cout << x << " ";
    }
}

int main(){
    Array datos;
    leerDatos(datos);
    invertirArray(datos);
    escribirDatos(datos);
    return 0;
}
