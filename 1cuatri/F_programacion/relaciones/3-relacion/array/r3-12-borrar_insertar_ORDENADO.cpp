#include <iostream>
#include <array>
using namespace std;

const int MAX = 10;
typedef array<int, MAX> TNumeros;
struct Vector {
    TNumeros numeros; // array de enteros
    int tam; // numero de celdas ocupadas (contiguas)
};

void leer(Vector& v){
    int num;

    cout << "Introduzca una secuencia de numeros enteros (0 para terminar y como maximo " << MAX << " numeros): ";

    v.tam = 0;
    cin >> num;
    while(num!=0){
        if(v.tam<MAX){
            v.numeros[v.tam] = num;
            v.tam++;
        }
        cin >> num;
    }
}

int buscar(int n, Vector& v){
    int pos = 0;
    bool existePos = false;

    for(int i=0; i<v.tam; i++){
        if(v.numeros[i]==n && existePos == false){
            pos = i;
            existePos = true;
        }
    }
    return pos;
}

void borrar(int n, Vector& v){
    int pos = buscar(n,v);

    for(int i=pos; i<v.tam; i++){
        v.numeros[i] = v.numeros[i+1];  // desplazo todos los números (desde el del buscado) una pos a la izq
    }
    v.tam--;
}

void escribir(Vector& v){
    for(int i=0; i<v.tam; i++){
        cout << v.numeros[i] << " ";
    }
}

void insertar(int n, Vector& v){
    int pos = 0;

    while(pos < v.tam && v.numeros[pos] <= n){  // se busca la posicion en la que iria el nuevo numero
        pos++;
    }

    v.tam++;
    for(int i = v.tam-1; i>pos; i--){ // se recorre el array al reves y se desplazan todos los numeros una posicion a la derecha
        v.numeros[i] = v.numeros[i-1];
    }
    v.numeros[pos] = n;  // se inserta el numero en la posicion correspondiente
}

int main(){
    Vector v;
    int n;

    leer(v);

    // BORRAR
    cout << "Introduzca un numero entero a borrar del vector: ";
    cin >> n;
    borrar(n,v);
    cout << "El vector despues de borrar es: ";
    escribir(v);

    // INSERTAR
    cout << "\n\nIntroduzca un numero entero a insertar en el vector: ";
    cin >> n;
    insertar(n,v);
    cout << "El vector despues de insertar es: ";

    escribir(v);

    return 0;
}
