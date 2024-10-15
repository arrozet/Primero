/*7. Suponiendo que los caracteres con los que trabajamos siempre serán letras mayúsculas y dados
los siguientes tipos (para una constante MAX cualquiera):

typedef array<char, MAX> Componentes;
struct Vector {
 Componentes datos; // array de caracteres
 int tam; // numero de celdas ocupadas (contiguas)
};

a) La moda de un array de caracteres es el carácter del array que se repite más frecuentemente.
Si varios caracteres se repiten con la misma frecuencia máxima, entonces no hay moda.
Escribe un procedimiento con tres parámetros. El primero es de entrada para recibir un
registro de tipo Vector que contiene el array datos con tam caracteres. El segundo 
parámetro es de salida e indicará si se ha encontrado la moda en el array o no. El tercer
parámetro es de salida y será el carácter que representa la moda (si es que existe). Diseña la
función principal (main) para probar el funcionamiento del procedimiento. Para rellenar el
registro, se leerá de teclado una secuencia de letras mayúsculas hasta leer un salto de línea
(carácter ‘\n’, que actúa como terminador de la secuencia). Si el array datos se llena antes
de leer el carácter terminador, los caracteres restantes de la entrada (incluido el terminador)
se descartarán (leyéndolos y no haciendo nada con ellos). Para la lectura de cada carácter
utiliza la instrucción cin.get(). Después se invocará al procedimiento implementado y
se mostrará por pantalla el carácter moda en caso de existir o una indicación de que no hay
moda. Dos ejemplos de ejecución serían (MAX = 20):

Introduzca una secuencia de letras mayusculas (salto de linea para
terminar y como maximo 20 letras): ABACDBAD

La moda es: A

Introduzca una secuencia de letras mayusculas (salto de linea para
terminar y como maximo 20 letras): ABACDBD

NO hay moda
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

bool hayModa(const TFrec& frecuencia, char& m){
    int mayor = 0;
    bool moda = true;
    // encontrar el más repetido
    for(int i=0; i<MAX_LETRAS; i++){
        if (frecuencia[i] > frecuencia[mayor]){
            mayor = i;  // pos en el que está el mayor
        }
    }

    // recorrer el array de nuevo para ver si hay otro igual de frecuente que el de mayor frecuencia
    for(int i=0; i<MAX_LETRAS; i++){
        if ((frecuencia[i] == frecuencia[mayor]) && (i!=mayor)){  // si se repite pero no se trata de la misma casilla
            moda = false;
        }
    }
    
    m = mayor + 'A';    // la letra es la casilla + 'A', pq 'A' equivale a 0
    return moda;
}

void entrada(Vector& v, TFrec& frecuencia){
    char c;
    v.tam=0;
    cout << "Introduzca una secuencia de letras mayusculas (salto de linea para terminar y como maximo " << MAX << " letras): " << endl;
    do{
        cin.get(c);
        if(c >= 'A' && c <= 'Z'){
            frecuencia[c - 'A']++;
            // a la vez creamos el array de datos y el de frecuencia
            v.datos[v.tam] = c;  // literalmente esto no lo uso para nada XD
            v.tam++;
        }
    }while(c != '\n' && v.tam<MAX);
}

int main(){
    Vector v;
    TFrec frecuencia = {{}};
    char m;

    entrada(v, frecuencia);

    if (hayModa(frecuencia, m)){
        cout << "La moda es: " << m;
    }
    else if(hayModa(frecuencia, m) == false){
        cout << "No hay moda";
    }

    return 0;
}