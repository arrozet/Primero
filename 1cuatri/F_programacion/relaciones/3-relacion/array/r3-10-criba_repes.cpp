/*10. Vamos a trabajar con listas de números enteros de hasta un tamaño máximo de MAX (una
constante cualquiera). Define el tipo de datos TLista para ello y diseña un procedimiento
criba que recibe como parámetros de entrada una lista de números enteros lista1 de tipo
TLista y un número natural x. El procedimiento devolverá como parámetro de salida otra lista
lista2 de tipo TLista que contendrá sólo aquellos números de lista1 que están repetidos
x veces. En la lista lista2 no habrá elementos repetidos. Diseña la función principal (main)
para probar el funcionamiento del procedimiento. Para leer la lista de números lista1, se le
pedirá primero al usuario el número de valores que va a introducir, controlando que éste sea
mayor que 0 y menor o igual que MAX. Ejemplo de ejecución (MAX = 10):

Cuantos numeros desea introducir (maximo 10): 9
Introduzca 9 numeros: 1 3 4 3 1 3 0 -6 4
Introduzca el numero de repeticiones para realizar la criba: 2

La lista cribada es: 1 4
*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 10;
typedef array<bool, MAX> TContados;
typedef array<int, MAX> TArray;
struct TLista{
    TArray elem;
    int tam;
};

void leerDatos(TLista& lista, int& repes){
    int num_intro, n;
    do{
        cout << "Cuantos numeros desea introducir (maximo " << MAX << "): ";
        cin >> num_intro;
    }while(num_intro<=0 || num_intro>MAX);

    lista.tam = 0;
    cout << "Introduzca " << num_intro << " numeros: ";
    for(int i=0; i<num_intro; i++){
        cin >> n;
        lista.elem[i] = n;
        lista.tam++;
    }

    cout << "Introduzca el numero de repeticiones para realizar la criba: ";
    cin >> repes;
}

void hayRepetidos(int pos_repe, const TLista& lista, TContados& contados, int& repe_num){
    contados[pos_repe] = true;

    for(int i = pos_repe+1; i<lista.tam; i++){
        if(lista.elem[pos_repe]==lista.elem[i]){  // si E numero igual al de la iteracion dada, se añade de la lista de contados y se cuenta
            contados[i] = true;
            repe_num++;
        }
    }
}

void criba(const TLista& lista1, TLista& lista2, const int& repes){
    TContados contados = {{}};
    int repe_num = 1;

    lista2.tam = 0;
    for(int i=0; i<lista1.tam; i++){
        if(!contados[i]){
            repe_num = 1;  // volver a 1 el valor del contador de veces repetidas
            hayRepetidos(i,lista1, contados, repe_num); // para marcar los repes
            if(repes==repe_num){  // si hay la cantidad buscada de repes, se añade a la lista
                lista2.elem[lista2.tam] = lista1.elem[i];
                lista2.tam++;
            }
        }
    }
}

void escribirLista(const TLista& lista){
    cout << "La lista cribada es: ";
    for(int i=0; i<lista.tam; i++){
        cout << lista.elem[i] << " ";
    }
}

int main(){
    TLista lista1, lista2;
    int repes;

    leerDatos(lista1, repes);
    criba(lista1, lista2, repes);
    escribirLista(lista2);

    return 0;
}

