/*7. Suponiendo que los caracteres con los que trabajamos siempre serán letras mayúsculas y dados
los siguientes tipos (para una constante MAX cualquiera):

typedef array<char, MAX> Componentes;
struct Vector {
 Componentes datos; // array de caracteres
 int tam; // numero de celdas ocupadas (contiguas)
};

c) Diseña un procedimiento que tome como parámetros de entrada dos registros con los arrays
ordenados y devuelva (con un parámetro de salida) el registro resultado de realizar la mezcla
ordenada de los dos arrays contenidos en los vectores de entrada. Puede ocurrir que no quepan
todos los caracteres en el registro resultado, perdiéndose los mismos. Diseña la función
principal (main) para probar el funcionamiento del procedimiento. 
Para ello, se leerán de teclado dos secuencias de letras mayúsculas (el carácter ‘\n’ actuará como terminador de cada
una de ellas) con las que se rellenarán dos registros. Para cada secuencia, si el array datos del
registro correspondiente se llena antes de leer el carácter terminador, los caracteres restantes de
la entrada (incluido el terminador) se descartarán (leyéndolos y no haciendo nada con ellos).
Para la lectura de cada carácter utiliza la instrucción cin.get(). Después se invocará al
procedimiento implementado y se mostrará por pantalla el resultado de la mezcla ordenada. Dos
ejemplos de ejecución serían (MAX = 20):

Introduzca una secuencia de letras mayusculas (salto de linea para terminar y
como maximo 20 letras): ACHHQS
Introduzca una secuencia de letras mayusculas (salto de linea para terminar y
como maximo 20 letras): BCPR

La mezcla ordenada es:
ABCCHHPQRS

Introduzca una secuencia de letras mayusculas (salto de linea para terminar y
como maximo 20 letras): ABBBCHPQSTVQ
Introduzca una secuencia de letras mayusculas (salto de linea para terminar y
como maximo 20 letras): CDFFGPRSST

La mezcla ordenada es:
ABBBCCDFFGHPPQRSSSTT
*/

#include <iostream>
#include <array>
using namespace std;

const int MAX = 20;
const int MAX_LETRAS = 27;

typedef array<int, MAX_LETRAS> TFrec;

typedef array<char, MAX> Componentes;
struct Vector {
    Componentes datos; // array de caracteres
    int tam; // numero de celdas ocupadas (contiguas)
};

void entrada(Vector& v){
    char c;
    v.tam = 0;

    cout << "Introduzca una secuencia de letras mayusculas (salto de linea para terminar como maximo 20 letras): " << endl;
    do{
        cin.get(c);
        if(c>='A' && c<='Z'){
            v.datos[v.tam] = c;
            v.tam++;
        }
    }while(c!='\n' && v.tam<MAX);
}

TFrec frecuencia(const Vector& v){
    TFrec frec = {{}};
    int pos;
    for(int i=0; i<v.tam; i++){
        pos = int(v.datos[i]-'A');
        frec[pos]++; // cuenta veces que se repite esa letra en su correspondiente casilla
    }
    return frec;
}

void mezcla(const Vector& v1, const Vector& v2){
    TFrec f1 = frecuencia(v1);
    TFrec f2 = frecuencia(v2);
    for(int i=0; i<MAX_LETRAS; i++){
        if(f1[i] != 0){ // si no es 0, que escriba el caracter tantas veces como esté repetido
            while(f1[i]>0){
                cout << char(int('A'+i));
                f1[i]--;
            }
        }
        if(f2[i] != 0){
            while(f2[i]>0){
                cout << char(int('A'+i));
                f2[i]--;
            }
        }
    }
}

int main(){
    Vector v1, v2;

    entrada(v1);
    entrada(v2);
    mezcla(v1,v2);

    return 0;
}