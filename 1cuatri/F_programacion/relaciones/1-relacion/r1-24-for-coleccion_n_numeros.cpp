/*24. Escribe un algoritmo que encuentre el mayor, el menor y la media aritmética de una colección
de N números enteros leídos por el teclado donde N es el primero de los números. Un ejemplo
de ejecución sería:
Introduzca la secuencia de numeros: 5 3 7 2 1
El mayor es: 7
El menor es: 1
La media es: 3.6*/

#include <iostream>
using namespace std;

int main(){
    int primer_n, n, mayor, menor, suma_terminos;
    float media;
    cout << "Introduzca la secuencia de números, donde la longitud de dicha secuencia es el primer número." << endl;
    cin >> primer_n;

    mayor = primer_n;
    menor = primer_n;
    suma_terminos = primer_n;
    
    for (int i = primer_n; i>1; i--) { // i>1 porque ya he metido el primer número de la secuencia
        cin >> n;
        if (n>mayor){
            mayor = n;
        }
        else if (n<menor){
            menor = n;
        }
        suma_terminos += n;
    }
    
    media = float(suma_terminos)/float(primer_n);

    cout << "El mayor es: " << mayor << "\n El menor es: " << menor << "\n La media es: " << media << endl;
    return 0;
}