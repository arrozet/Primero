/*4. Diseña un algoritmo que lea de teclado tres números naturales que representan el valor de un
ángulo expresado en grados, minutos y segundos, y muestre por pantalla ese valor expresado
en radianes. Podemos suponer que los datos de entrada son correctos. Por ejemplo, si se
introducen 190 grados, 25 minutos y 7 segundos, la salida será 3.32344 radianes.
*/

#include <iostream>
using namespace std;
const float PI = 3.1416;
const float FACTOR_CONVERSION_GRADOS_RADIANES = PI/180;

int main() {
    float grados, minutos, segundos, radianes;

    cout << "Introduce tu valor en grados, minutos y segundos." << endl;
    cin >> grados >> minutos >> segundos;

    radianes = FACTOR_CONVERSION_GRADOS_RADIANES*(grados+(minutos+segundos/60)/60);
    
    cout << "Tu valor equivale a " << radianes << " radianes."; // por qué arroja valor ligeramente != a la solución?

    return 0;
    }