/*2. Escribe un programa que calcule e imprima por pantalla los N primeros números primos,
siendo N un número natural que se introduce por teclado. Por ejemplo, si N = 8, los primos
que se mostrarán por pantalla son 2, 3, 5, 7, 11, 13, 17, 19.*/
#include <iostream>
using namespace std;

void leer(int& n){
    int n;
    cout << "Introduce el n�mero de primos." << endl;
    do{
        cin >> n;
    }while(n<1);
}

bool esPrimo(int n){
    bool primo = true;
    int i = 2;
    while(primo && i <= n)){
        if (n%i == 0){
            primo = false;
        }
        i++;
    }
    return primo;
}

void imprimirPrimos(int numero_primos){
    int num = 2;
    while(numero_primos >= 0){
        if(esPrimo(num)) {
          numero_primos--;
        }
        num++;
    }
}

int main(){
    int n;

    leer(n);

    imprimirPrimos(n);

    return 0;
}
