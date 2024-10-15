/*3. Diseña un algoritmo para calcular el salario neto de un trabajador en una determinada empresa.
Para ello se leerán dos números de teclado. El primero será un número real que representa el
sueldo base del empleado. El segundo será un número natural que representa la antigüedad (en
años) del empleado en la empresa. El salario bruto del empleado se calcula sumando al sueldo
base unas gratificaciones por antigüedad. En concreto, el empleado recibirá 60 € por
quinquenio trabajado y 6 € por cada año del tramo para conseguir el siguiente quinquenio.
Finalmente, el salario neto se calcula restando al salario bruto un 20% de impuestos sobre el
salario bruto más un 5% de seguro médico también sobre el salario bruto. Por ejemplo, si se
introducen 1400 euros de sueldo base y una antigüedad de 28 años, el salario neto que
aparecerá por pantalla será de 1288.5 euros.*/

#include <iostream>
using namespace std;
const float IMPUESTOS = 0.2;
const float SEGURO_MEDICO = 0.05;
const int GRATIFICACION_ANO = 6;
const int GRATIFICACION_QUINQUENIO = 60;

int main() {
    int antiguedad, resto_antiguedad;
    float sueldo_base, salario_bruto, salario_neto, reducciones;

    cout << "¿Cuál es el sueldo base?" << endl;
    cin >> sueldo_base;
    cout << "¿Cuántos años llevas en la empresa?" << endl;
    cin >> antiguedad;

    resto_antiguedad = antiguedad%5;

    salario_bruto = sueldo_base + GRATIFICACION_ANO*resto_antiguedad + GRATIFICACION_QUINQUENIO*((antiguedad-resto_antiguedad)/5);

    reducciones = salario_bruto * IMPUESTOS + salario_bruto * SEGURO_MEDICO;
    salario_neto = salario_bruto - reducciones;

    cout << "Tu salario neto será de " << salario_neto << "€."; 
    
    return 0;
}