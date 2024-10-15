/*5. Escriba un programa que efectúe la conversión de un número natural en base 10 a otra
determinada base, sabiendo que el resultado no sobrepasará los 50 dígitos. El usuario introducirá
primero el número en base 10 y después la base a la que convertirlo (el programa debe
asegurarse de que la base no sea ni menor de 2 ni mayor de 9)

Nota: Recordemos que para obtener la representación en una base b de un número en
decimal, dividimos entre b primero el número y después sucesivamente los diferentes
cocientes que se vayan obteniendo hasta que el cociente sea cero. Los diferentes restos
obtenidos en esas sucesivas divisiones constituyen la representación en dicha base b (pero
en orden inverso a como se han ido calculando). 

Por ejemplo, para el número decimal 26 en
base 2 es 11010.
26 | 2
0 13 | 2
1 6 | 2
0 3 | 2
1 1 | 2
1 0*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 50;
typedef array<int, MAX> TArray;

struct TResultado{
    TArray digitos; // array
    int num_digitos; // tamaño array
};

int convertir(int num, int base, TResultado& a){
    a.num_digitos = 0;
    while(num>0){
        a.digitos[a.num_digitos] = num%base;
        num /= base;
        a.num_digitos++;
    }
    return a.num_digitos;
}

void leerDatos(int& num, int& base){
    cout << "Introduce el número natural. ";
    do{
        cin >> num;
    }while(num<0);

    cout << "Introduce la base. ";
    do{
        cin >> base;
    }while(base<2 || base>9);
}

void escribir(const TResultado& a){
    for(int i=a.num_digitos-1; i>=0; i--){  // para que lo lea al revés
        cout << a.digitos[i];
    }
}

int main(){
    TResultado a;
    int num, base;
    leerDatos(num, base);
    convertir(num, base, a); // el array está al revés, pq los restos para hacer la conversión se leen de abajo a arriba, no de arriba a abajo.
    escribir(a);
    
    return 0;
}