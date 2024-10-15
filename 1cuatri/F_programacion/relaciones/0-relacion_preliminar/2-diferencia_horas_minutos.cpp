/* 2. Diseña un algoritmo que lea de teclado dos instantes de tiempo en un mismo día, cada uno
representado por dos números naturales que indican la hora (en formato 24 horas) y los
minutos, y muestre por pantalla la diferencia entre ellos, también expresada en horas y
minutos. Podemos suponer que los datos de entrada son correctos y primero se introduce el
instante anterior y después el posterior. Por ejemplo, si se introduce como primer instante 10
horas y 45 minutos, y como segundo instante 14 horas y 25 minutos, la salida será 3 horas y 40
minutos.*/

#include <iostream>
using namespace std;
const int HORAS_A_SEGUNDOS = 3600; // para pasar de segundos a horas, dividir en lugar de multiplicar.
const int MINUTOS_A_SEGUNDOS = 60; // para pasar de segundos a minutos, dividir en lugar de multiplicar.

int main() {
    int hora1, minutos1, hora2, minutos2;
    float diferencia_en_segundos, diferencia_horas, diferencia_minutos_final;
    
    cout << "Introduce el instante 1 (horas, tecla intro, minutos, tecla intro)" << endl;
    cin >> hora1 >> minutos1;
    cout << "Introduce el instante 2 (horas, tecla intro, minutos, tecla intro)" << endl;
    cin >> hora2 >> minutos2;

    diferencia_en_segundos = abs(hora1*HORAS_A_SEGUNDOS + minutos1*MINUTOS_A_SEGUNDOS - (hora2*HORAS_A_SEGUNDOS + minutos2*MINUTOS_A_SEGUNDOS)); // abs() para que siempre salga positiva
    diferencia_horas = diferencia_en_segundos/HORAS_A_SEGUNDOS; // aquí se divide, porque se pasa de segundos a horas (con decimales)
    diferencia_minutos_final = (diferencia_horas - int(diferencia_horas))*60; //le quitamos la parte entera al numero, para que nos queden los minutos buscador en la unidad horas
                                                                              // en la misma línea, hacemos la conversión de horas a minutos (multiplicar por 60) 
                                                                              // no se pone la constante MINUTOS_A_SEGUNDOS para evitar confusiones, pese a que coincide el factor de conversión con esta conversión, ya que es de horas a minutos, 

    cout << "La diferencia es de " << int(diferencia_horas) << " horas y " << diferencia_minutos_final << " minutos.";

    return 0;
}