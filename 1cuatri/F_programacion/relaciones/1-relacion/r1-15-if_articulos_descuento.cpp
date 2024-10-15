/*15. Escribe un algoritmo para calcular el precio de una partida de artículos aplicando un descuento
creciente con la cantidad comprada según la siguiente tabla (la cantidad comprada se lee por
teclado):
Número de unidades      Precio unitario (euros)
1                       100
2                       95
3                       90
4 o más                 85
Así, por ejemplo, si se introduce una cantidad de 3 unidades, la salida será de 270 euros
(resultado de multiplicar 3 por 90). Si se introduce una cantidad de 7 unidades, la salida será de
595 euros (resultado de multiplicar 7 por 85)*/

#include <iostream>
using namespace std;

const int DESCUENTO = 5;
const int PRECIO_BASE_UNIDAD = 100;

int main() {
    int n, total;  // es correcto dejar las variables sin asignar?
    cout << "¿Cuántos artículos desea comprar?" << endl;
    cin >> n;

    if ((n >= 1) && (n <= 3)) {
        total = n*(PRECIO_BASE_UNIDAD-DESCUENTO*(n-1));
    }
    else {
        total = n*(PRECIO_BASE_UNIDAD-DESCUENTO*3);
    }

    cout << "Tu total es " << total << " euros." << endl;
    return 0; // es necesario (formalmente hablando) poner el return 0?
} 