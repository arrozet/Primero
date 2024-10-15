/*3.- Escribe un programa que tome como entrada desde teclado dos números naturales (mayores
que cero) "N" e "i", e imprima en pantalla el dígito que ocupa la posición i-ésima del número
N. Si i es mayor que el número de dígitos de N, se escribirá en pantalla -1. Por ejemplo, para N
= 25064 e i = 2, el resultado es el dígito 6, y para i = 7, el resultado es -1.*/

#include <iostream>
using namespace std;

void leer(int& N, int& i){
    cout << "Introduce número y posición desde la derecha (mayores que 0)" << endl;
    do{
        cin >> N >> i;
    }while(N <= 0 || i <= 0);
}

int digito(int& N, int i){ // no pongo paso por referencia en i pq me interesa crear copia, ya que voy a modificar el número
    int resto_digito = 0, digito = 0, aux = 1;
    while(i>0){ // similar a hacer 10^i, pero con una variable auxiliar porque no puedo usar libreria de math
        aux *= 10;
        i--;
    }
    resto_digito = N%(aux); // "corto" el numero por delante 
    digito = resto_digito / (aux/10); // "corto" el numero por detrás --> me queda ese numero
    if(aux > N){
        digito = -1; // que me suelte error si cojo un i>nº digitos del numero
    }
    return digito;
}

void escribir_posicion(int N, int i, int digito){
    cout << "El dígito que ocupa la posición " << i << " del número " << N << " es el número " << digito << "." << endl;
}

int main(){
    int N, i;

    leer(N, i);

    escribir_posicion(N, i, digito(N,i));

    return 0;
}