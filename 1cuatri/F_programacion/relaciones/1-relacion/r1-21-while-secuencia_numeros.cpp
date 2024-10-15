/*21. Diseña un algoritmo que lea un número entero n por teclado (hay que controlar que sea distinto
de 0). Después se le pedirá al usuario que introducirá por teclado una secuencia de números
enteros terminada en 0. El algoritmo debe determinar si el número n aparece o no en la
secuencia. Para ello, el algoritmo leerá números de la secuencia hasta encontrar el número n o
bien hasta leer el 0, mostrando por pantalla el mensaje correspondiente. En el caso de que se
detecte el número buscado en la secuencia ya no se seguirán leyendo más números. Dos
ejemplos de ejecución serían:

Introduzca el numero entero a buscar (distinto de 0): 3
Introduzca una secuencia de numeros enteros terminada en 0: 4 2 3 -5 7 -6 0
El numero 3 SI aparece en la secuencia

Introduzca el numero entero a buscar (distinto de 0): 3
Introduzca una secuencia de numeros enteros terminada en 0: 4 2 -3 -5 7 -6 0
El numero 3 NO aparece en la secuencia*/

#include <iostream>
using namespace std;

int main(){
    int n_buscar, n;
    cout << "Introduzca el numero entero a buscar (distinto de 0): " << endl;
    cin >> n_buscar;

    cout << "Introduzca una secuencia de numeros enteros terminada en 0: " << endl;
    cin >> n;
    while ((n != n_buscar) && (n != 0)) {
        cin >> n;
    }

    if (n==n_buscar){
        cout << "El número " << n << " SÍ aparece en la secuencia de números" << endl;
    }

    else{
        cout << "El número " << n << " NO aparece en la secuencia de números" << endl;
    }

    return 0;
}