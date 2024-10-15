/*13. Diseña un algoritmo que lea por teclado dos números enteros y determine si el primero es
divisor del segundo, si el segundo es divisor del primero o si no ocurre nada de eso. Por
ejemplo, si se introducen los números 8 y 2, la salida indicará que 2 es divisor de 8. En cambio,
si se introducen los números 5 y 7, la salida indicará que los números no son divisibles*/

#include <iostream>
using namespace std;

int main () {
    int n1, n2;
    cout << "Introduce tus dos números" << endl;
    cin >> n1 >> n2;

    if (n2!=0 && n1%n2==0){
        cout << n2 << " es divisor de " << n1 << endl;
    }
    else if (n1!=0 && n2%n1==0){
        cout << n1 << " es divisor de " << n2 << endl;
    }
    else{
        cout << "No son divisibles" << endl;
    } 
    return 0;
}