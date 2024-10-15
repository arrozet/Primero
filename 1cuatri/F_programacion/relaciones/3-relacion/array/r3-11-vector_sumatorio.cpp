#include <iostream>
#include <array>
#include <cmath>
using namespace std;

const int N = 5;
typedef array<int, N> Vector;

void leer(Vector& v){
    cout << "Introduzca " << N << " numeros naturales: ";
    for(int i=0; i<N; i++){
        cin >> v[i];
    }
}

int sumatorio(const Vector& v, int inicio, int fin, int centro){
    int suma = 0;

    for(int i=inicio; i<=fin; i++){
        suma += abs(centro-i)*v[i]; // uso abs para no tener que definir dos sumatorios, ya que el segundo es indice-centro; pero da igual pq da positivo igual
    }

    return suma;
}

void calculoCentro(int& centro, bool& existe, Vector& v){
    int sum1, sum2;
    while(centro<N-2 && !existe){
        sum1 = sumatorio(v,0,centro-1,centro);
        sum2 = sumatorio(v,centro+1,N-1,centro);
        if(sum1==sum2){
            existe = true;
        }
        else{
            centro++;
        }
    }
}

int main(){
    Vector v;
    int centro = 1; // pues se empieza a comprobar si se verifica la condicion desde 1 hasta N-2
    bool existeCentro = false;

    leer(v);
    calculoCentro(centro, existeCentro, v);

    if(existeCentro){
        cout << "El centro del vector es el índice " << centro << ", casilla donde está el " << v[centro];
    }
    else{
        cout << "No existe el centro del vector";
    }

    return 0;
}
