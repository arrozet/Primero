/*2. Diseña una función que recibe como parámetros de entrada un array de MAX (una constante definida) números enteros a y un número entero, y 
devuelve true si el número num está contenido en a y 
false en otro caso. 
Si num está en la colección, la búsqueda se detendrá en el momento de encontrarlo. 

Diseña la función principal (main) para probar el funcionamiento de la función. 
Para ello, se leerá de teclado una colección de MAX números enteros con los que se rellenará el array 
y también se leerá el número entero a buscar en la colección, 
se invocará a la función implementada 
y se mostrará por pantalla una indicación de si el número está o no en la colección. 

Un ejemplo de ejecución sería (MAX = 10):

Introduzca 10 numeros enteros: 4 25 -3 4 2 17 9 5 -7 8
Introduzca el numero a buscar: 2
El numero 2 SI esta en la coleccion*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 10;
typedef array<int, MAX> TArray;

bool encontrarNumero(const TArray& a, int num_buscar){ // el const del array es por si me equivoco, que me diga que no se puede ejecutar la función (MEDIDA DETECCIÓN DE ERRORES)
                                                        // se usa paso por referencia en el array pq son pecha de datos --> no interesa hacer copia

                                                        // en el num_buscar, no se pone referencia pq la copia tiene prácticamente el mismo valor que pasar por referencia,
                                                        // así que es mejor usar paso por valor por si te equivocas, que no afecte al resultado inicial
    bool encontrado = false; 
    int cont = 0;
    while(!encontrado && (cont < MAX)){ // si no lo ha encontrado y todavía no ha recorrido todo el array
        if(a[cont] == num_buscar){
            encontrado = true; // lo ha encontrado --> que salga del bucle
        }
        else{
            cont++; // si no, que siga recorriendo el array
        }
    }
    return encontrado;
}    

void leerDatos(TArray& a, int& num_buscar){
    cout << "Introduzca " << MAX << " números enteros: " << endl;
    for(int i=0; i<MAX; i++){
        cin >> a[i]; // que pasa si le metes mas de 10? --> solo coge 10 y el siguiente lo entiende como numero a buscar
    }
    cout << "Introduzca el número a buscar: " << endl;
    cin >> num_buscar;
}

int main(){
    TArray a;
    int num_buscar;
    leerDatos(a, num_buscar);

    if (encontrarNumero(a, num_buscar)){
        cout << "El número " << num_buscar << " SÍ está en la colección.";
    }
    else{
        cout << "El número " << num_buscar << " NO está en la colección.";
    }
    return 0;
}