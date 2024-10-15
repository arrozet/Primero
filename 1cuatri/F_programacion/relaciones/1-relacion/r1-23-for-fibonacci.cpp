/*23. Diseña un algoritmo que lea un número natural n por teclado (hay que controlar que sea mayor
que 0) y calcule el n-ésimo número de la serie de Fibonacci. Los dos primeros números de esta
serie son el cero y el uno, y a partir de éstos cada número se calcula realizando la suma de los
dos anteriores. Por ejemplo, si se introduce el número 5, la salida será 3, que es el 5º número de
la serie. Si se introduce el número 9, la salida será 21, que es el 9º número de la serie.*/

#include <iostream>
using namespace std;

int main(){
    int n, n1=0, n2=1, n1_viejo;
    cout << "Introduce un número positivo y mayor que 0: " << endl;
    cin >> n;

    while (n<=0) {
        cout << "Ese número no es mayor que 0. Inténtalo de nuevo." << endl;
        cin >> n;
    }

    for (int i=n; i>1; --i){ // por qué i>1?
        n1_viejo = n1;
        n1 = n2;
        n2 += n1_viejo;
        }

    cout << "La posición " << n << " de la serie de Fibonacci es " << n1 << endl;

    return 0;
}