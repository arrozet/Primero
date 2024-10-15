#include <iostream>
#include <array>
using namespace std;

const int MAX = 10;

typedef array<int,MAX> TNumeros;
struct Vector {
    TNumeros numeros;	// array de enteros
    int tam;		    // numero de celdas ocupadas
};







void leer(Vector& v) {
	int num;

    cout << "Introduzca una secuencia de numeros enteros";
	cout << " (0 para terminar y como maximo " << MAX
		 << " numeros):\n";

	v.tam = 0;
	cin >> num;
	while (num != 0) {
        if (v.tam < MAX) {
            v.numeros[v.tam] = num;
            v.tam++;
        }
		cin >> num;
	}

}

void escribir(const Vector& v) {
	for (int cont = 0; cont < v.tam; cont++) {
		cout << v.numeros[cont] << " ";
	}
	cout << endl;

}


int buscar(int num, const Vector& v) {
	int cont = 0;

	while ((cont < v.tam) && (v.numeros[cont] != num)) {
			cont++;
	}

	return cont;
}



void borrar(int num, Vector& v) {
	int pos = buscar(num,v);

	if (pos < v.tam) {
		for (int cont = pos; cont < v.tam - 1; cont++) {
			v.numeros[cont] = v.numeros[cont+1];
		}
		v.tam--;
	}
}

int posicion(int num, const Vector& v) {
	int cont = 0;

	while ((cont < v.tam) && (num > v.numeros[cont])) {
			cont++;
	}

	return cont;
}


void insertar(int num, Vector& v) {
	int pos;
	if (v.tam < MAX) {
		pos = posicion(num,v);
		for (int cont = v.tam; cont > pos; cont--) {
			v.numeros[cont] = v.numeros[cont-1];
		}
		v.numeros[pos] = num;
		v.tam++;
	}
}



int main() {
	Vector v;
	int valor;

	leer(v);

	cout << "Introduzca un numero entero a borrar del vector: ";
	cin >> valor;

	borrar(valor,v);

	cout << "El vector despues de borrar es: ";
	escribir(v);

	cout << "Introduzca un numero entero a insertar en el vector: ";
	cin >> valor;

	insertar(valor,v);

	cout << "El vector despues de insertar es: ";
	escribir(v);

	return 0;

}

