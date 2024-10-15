/*1. Escribe un programa lea de teclado un número natural (debe ser mayor de 0 y menor de 10)
que representa el número de filas de una determinada pirámide de dígitos y que muestre por
pantalla dicha pirámide. El formato de la misma será como la que se muestra a continuación,
para una entrada de 5 filas:
1
1 2 1
1 2 3 2 1
1 2 3 4 3 2 1
1 2 3 4 5 4 3 2 1*/

#include <iostream>
using namespace std;

int leer(){
    int n;
    cout << "Introduce el n�mero para hacer el tri�ngulo." << endl;
    do{
        cin >> n;
    }while(n<1 || n>10);
    return n;
}

void escribirBlancos(int n){
    while (n>0){
        cout << "  ";
        n--;
    }
}

void escribirAsc(int fila){
    int num_inicio = 1;
    while(num_inicio <= fila){
        cout << num_inicio << " ";
        num_inicio++;
        }
}

void escribirDesc(int fila){
    int num_final = fila;
    while(num_final > 1){
        num_final--;
        cout << num_final << " ";
        }
}

/*void escribirNum(int fila){
    escribirAsc(fila);
    escribirDesc(fila);
}*/

void escribirTriangulo(int n){
    for(int i=1; i<=n; i++){
        escribirBlancos(n-i);
        escribirAsc(i);
        escribirDesc(i);
        cout << endl;
    }
}



int main(){
    int n;

    n = leer();

    escribirTriangulo(n);

    return 0;
}
