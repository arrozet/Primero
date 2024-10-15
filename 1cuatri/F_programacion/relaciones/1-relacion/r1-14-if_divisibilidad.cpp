/*14. Diseña un algoritmo para determinar si un número entero (leído por teclado) es múltiplo de
alguno de los siguientes números (o de varios de ellos): 3, 4, 5. No es necesario indicar de qué
números en concreto es múltiplo. Por ejemplo, si se introduce el número 12, la salida indicará
que sí es divisible. En cambio, si se introduce el número 17, la salida indicará que no es
divisible.*/

#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Dime un número entero y te diré si es divisible por 3, 4 o 5." << endl;
    cin >> n;

    if ((n%3 == 0) || (n%4 == 0) || (n%5 == 0)) {
        cout << "El número " << n << " es divisible." << endl;
    }
    else {
        cout << "El número " << n << " no es divisible." << endl;
    }
    return 0;
}