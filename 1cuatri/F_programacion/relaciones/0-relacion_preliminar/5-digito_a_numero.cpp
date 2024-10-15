/*5. Diseña un algoritmo que lea de teclado tres caracteres dígitos (cada uno de ellos se lee como un
carácter), obtenga el número natural que representan (almacenado en una variable de tipo
entero) y lo muestre por pantalla. Podemos suponer que los datos de entrada son correctos. Por
ejemplo, si se introducen los caracteres dígitos 372, la salida será el valor entero 372.*/

#include <iostream>
using namespace std;
const int DIFERENCIA_TABLA_ASCII = 48; // equivale al carácter '0', que está en la posición 48

int main() {
    char d1, d2, d3;
    int n1;
    
    cout << "Introduce tus dígitos: " << endl;
    cin >> d1 >> d2 >> d3;
    n1 = 100*(d1-DIFERENCIA_TABLA_ASCII) + 10*(d2-DIFERENCIA_TABLA_ASCII) + (d3 - DIFERENCIA_TABLA_ASCII);
    cout << "Tu valor entero será " << n1 << endl;

    return 0;
}