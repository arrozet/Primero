/*20. Diseña un programa que lea un único número natural por teclado (hay que controlar que sea
mayor o igual que 0) en una variable de tipo int y muestre por pantalla cuantos dígitos pares
tiene. Por ejemplo: 3445621 tiene 4 dígitos pares; 55914 tiene 1 dígito par. NOTA: El dígito
más a la derecha de un número puede obtenerse calculando el resto de la división por 10 y el
número sin el dígito más a la derecha puede obtenerse dividiendo el número por 10. Ejemplo:
123 % 10 = 3; 123 / 10 = 12.*/

#include <iostream>
using namespace std;

int main(){
    int n = 0, n_original = 0, contador_par = 0;
    cout << "Ponme un número positivo y averiguaré cuántos dígitos pares tiene: " << endl;
    cin >> n;
    
    // comprobación positivo
    while (n <= 0) {
        cout << n << " no me sirve. Tiene que ser un número positivo. Vuelve a intentarlo." << endl;
        cin >> n;
    }

    n_original = n;

    while (n>0) {
        if ((n%2) == 0) { // si el último dígito es par, que sume al contador y que se quede con el número quitándole el último número
            ++contador_par;
            n /= 10;
        }
        else {
            n /= 10;
        }
        // se puede poner el n/=10 fuera de if/else y funcionaría igual. De hecho, es mejor porque repites menos código
    }
    
    cout << "El número " << n_original << " tiene " << contador_par << " dígitos pares." << endl;

    return 0;
} 