/*8. Los alumnos de informática desean celebrar una comida un día del presente mes en el que
puedan acudir todos. Se pide realizar un algoritmo que recoja de cada alumno los días que le
vendría bien ir a la comida, e imprima los días concordantes para todos los alumnos o una
indicación de que no hay. Los datos se introducirán por teclado. Primero se introducirá el
número de alumnos que intervienen. Después, por cada alumno se introducirá una única línea
con los números de los días libres separados por espacios (un 0 para terminar). Dos ejemplos
de ejecución:

Numero de alumnos a introducir: 3
Introduzca los dias preferidos por el alumno 1 (introduzca un 0 para
terminar): 3 5 7 15 20 0
Introduzca los dias preferidos por el alumno 2 (introduzca un 0 para
terminar): 4 6 15 18 20 0
Introduzca los dias preferidos por el alumno 3 (introduzca un 0 para
terminar): 15 20 25 0

Los dias comunes son: 15 20

Numero de alumnos a introducir: 2

Introduzca los dias preferidos por el alumno 1 (introduzca un 0 para
terminar): 2 4 7 0
Introduzca los dias preferidos por el alumno 2 (introduzca un 0 para
terminar): 3 8 15 20 0

Los dias comunes son: No hay ningun dia comun*/

#include <iostream>
#include <array>
using namespace std;

const int DIAS = 32; // no se usa indice 0 pq se coge directamente el dia como indice
typedef array<int, DIAS> TFrec;

void leer(TFrec& dias_repes, const int& alumnos){
    int dia;
    for(int i = 1; i<=alumnos; i++){
        cout << "Introduzca los días preferidos por el alumno " << i << " (introduzca un 0 para terminar): ";

        cin >> dia;
        while(dia!=0){
            if(dia>=1 && dia<=31){  // no uso DIAS-1 pq un mes no tiene más de 31 días
                dias_repes[dia]++;
            }
            cin >> dia;
        }
    }
}

int main(){
    int alumnos;
    TFrec diasComunes = {{}};
    bool hayComunes = false;
    cout << "Numero de alumnos a introducir: ";
    cin >> alumnos;
    
    leer(diasComunes, alumnos);

    cout << "Los dias comunes son: ";
    for(int i = 0; i<=DIAS; i++){
        if(diasComunes[i]==alumnos){
            hayComunes = true;
            cout << i << " ";
        }
    }
    if(hayComunes==false){
        cout << "No hay ningun dia comun";
    }
    return 0;
}
