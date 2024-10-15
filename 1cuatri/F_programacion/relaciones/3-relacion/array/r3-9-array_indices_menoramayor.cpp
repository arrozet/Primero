/*9. Diseña un procedimiento que recibe como parámetro de entrada un array de valores enteros
val y devuelve como parámetro de salida otro array de enteros ind, de forma que el
contenido de cada una de sus celdas es un índice del array val. Los índices estarán
almacenados de forma que, si recorremos el array ind de izquierda a derecha, y visitamos las
celdas de val, cuyo índice nos vamos encontrando en ind, los valores de val se recorrerán
en orden creciente de menor a mayor. El array val no se podrá modificar, ni se puede hacer
una copia del mismo. Por ejemplo:

VER EN EL PDF

Diseña la función principal (main) para probar el funcionamiento del procedimiento. Para
ello, se leerá de teclado una colección de MAX (una constante definida) números enteros con
los que se rellenará el array val, se invocará al procedimiento implementado y se mostrará
por pantalla el contenido del array ind.

*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 5;
typedef array<int, MAX> TArray;
typedef array<bool, MAX> TVistos;

void entrada(TArray& val){
    cout << "Introduzca " << MAX << " números enteros para ordenarlos según la posición: ";
    for(int i = 0; i<MAX; i++){
        cin >> val[i];
    }
}

void menores(const TArray& val, TArray& ind, TVistos& seen){
   
    for(int j=0; j<MAX; j++){
        // CONDICIONES INICIALES
        int pos = 0;  // hay que ponerlo dentro para que se resetee en cada iteración
        if(seen[0]==true){  // si no se pone esto, si la pos previa fue 0 se queda stuckeado (val[pos] siempre va a ser el menor)
            pos++;
        }
        // BÚSQUEDA DE NUEVO MENOR
        for(int i=0; i<MAX; i++){
            if((seen[i]==false) && (val[i]<val[pos])){
                pos = i;
            }
            else if(j==MAX-1){  // si estás en la última iteración de ind, toma el valor en el que seen sea falso pues val[i] que queda nunca < val[pos] (no se va a asignar nueva pos)
                if(seen[i]==false){
                    pos = i;
                }
            }
        }
        // AÑADIDO NUEVO MENOR Y QUITADO DE LA SIGUIENTE ITERACIÓN
        ind[j] = pos; // le metes en la posicion 1 el numero menor del array valores
        seen[pos] = true; // pa que no se vuelva a repetir, pues ya se ha visto
    }
}

void salida(const TArray& val, TArray& ind){
    TVistos seen={{}};

    menores(val, ind, seen);

    cout << "La nueva lista es ";
    for(int i=0; i<MAX; i++){
        cout << ind[i] << " ";
    }
}

int main(){
    TArray val; 
    TArray ind={{}};

    entrada(val);
    salida(val, ind);

    return 0;
}