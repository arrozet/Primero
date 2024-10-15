/*3. Se dispone de un array de MAX (una constante definida) números enteros a, en el que al menos
hay dos números que son distintos (es decir, no son todos iguales). 
Obtenga una función que
tomando como parámetro dicho array, devuelva un elemento del array que sea mayor que el
mínimo de éste. Diseña la función principal (main) para probar el funcionamiento de la función.
Para ello, se leerá de teclado una colección de MAX números enteros con los que se rellenará el
array, se invocará a la función implementada y se mostrará por pantalla el valor devuelto por la
misma. Un ejemplo de ejecución sería (MAX = 10):

Introduzca 10 numeros enteros: 3 3 3 3 5 27 1 9 21 32
Un elemento Mayor que el Minimo es: 5*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 10;
typedef array<int, MAX> TArray;

int mayorMinimo(const TArray& a){
    int cont = 0;
    int res;
    while ((cont < MAX-1) && (a[cont] == a[cont+1])) { // mientras sean iguales y todavia no haya recorrido el array entero, que siga buscando
        cont++;
    }
    if (cont >= MAX-1) { // si se llega hasta el final y no ha habido 2 num distintos, que siga que no hay dos num distitnos
        throw "El array no tiene dos números distintos (al menos)";
    } 
    else if (a[cont] > a[cont+1]) { // si el nº de la pos i es distinto del siguiente y además es mayor, un nº mayor q el mínimo será el de la pos i
        res = a[cont];
    } 
    else { // si el nº de la pos i es distinto del siguiente y además es menor, el nº siguiente será mayor que él y, necesariamente, que el mínimo
        res = a[cont+1];
    }
    return res;
}

void leerDatos(TArray& a){
    cout << "Introduzca " << MAX << " números enteros: " << endl;
    for(int i=0; i<MAX; i++){
        cin >> a[i];
    }
}

int main(){
    TArray a;

    leerDatos(a);

    cout << "Un elemento mayor que el mínimo es: " << mayorMinimo(a) << endl;
    return 0;
}