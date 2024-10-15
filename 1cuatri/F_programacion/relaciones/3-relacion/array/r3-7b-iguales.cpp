/*7. Suponiendo que los caracteres con los que trabajamos siempre serán letras mayúsculas y dados
los siguientes tipos (para una constante MAX cualquiera):

typedef array<char, MAX> Componentes;
struct Vector {
 Componentes datos; // array de caracteres
 int tam; // numero de celdas ocupadas (contiguas)
};

b) Diseña una función booleana que, dados dos registros de tipo Vector como parámetros,
devuelva TRUE si son iguales y FALSE en otro caso. Dos registros son iguales si sus arrays
contienen los mismos elementos y en el mismo orden relativo, suponiendo que el primer
elemento sigue al último. Por ejemplo, si los arrays de los registros fueran:

[‘A’,’C’,’D’,’F’,’E’]
[‘D’,’F’,’E’,’A’,’C’]

la función devolvería TRUE.
Supón, además, que cada carácter aparece a lo sumo una vez.
Diseña la función principal (main) para probar el funcionamiento de la función. Para ello,
se leerán de teclado dos secuencias de letras mayúsculas (el carácter ‘\n’ actuará como
terminador de cada una de ellas) con las que se rellenarán dos registros. Para cada
secuencia, si el array datos del registro correspondiente se llena antes de leer el carácter
terminador, los caracteres restantes de la entrada (incluido el terminador) se descartarán
(leyéndolos y no haciendo nada con ellos). Para la lectura de cada carácter utiliza la
instrucción cin.get(). Después se invocará a la función implementada y se mostrará por
pantalla una indicación de si los registros son o no iguales. Dos ejemplos de ejecución
serían (MAX = 20):

Introduzca una secuencia de letras mayusculas (salto de linea para terminar
y como maximo 20 letras): ACDFE
Introduzca una secuencia de letras mayusculas (salto de linea para terminar
y como maximo 20 letras): DFEAC

SI son iguales

Introduzca una secuencia de letras mayusculas (salto de linea para terminar
y como maximo 20 letras): ACDFE
Introduzca una secuencia de letras mayusculas (salto de linea para terminar
y como maximo 20 letras): DEFAC

NO son iguales
*/

#include <iostream>
#include <array>

using namespace std;

const int MAX = 20;
const int MAX_LETRAS = 27;

typedef array<char, MAX> Componentes;

struct Vector {
    Componentes datos; // array de caracteres
    int tam; // numero de celdas ocupadas (contiguas)
};

void entrada(Vector& v, Vector& v2){
    char c;
    v.tam=0;
    v2.tam=0;

    cout << "Introduzca una secuencia de letras mayusculas (salto de linea para terminar y como maximo " << MAX << " letras): " << endl;
    do{
        cin.get(c);
        if(c >= 'A' && c <= 'Z'){
            v.datos[v.tam] = c;
            v.tam++;
        }
    }while(c != '\n' && v.tam<MAX);

    cout << "Introduzca una secuencia de letras mayusculas (salto de linea para terminar y como maximo " << MAX << " letras): " << endl;
    do{
        cin.get(c);
        if(c >= 'A' && c <= 'Z'){
            v2.datos[v2.tam] = c;
            v2.tam++;
        }
    }while(c != '\n' && v2.tam<MAX);
}

void buscarPosPrimer(const Vector& v, const Vector& v2, int& pos2){
    for(int i = 0; i<v2.tam; i++){  // leer el array entero hasta encontrar donde empieza el segundo
        if(v.datos[0] == v2.datos[i]){
            pos2 = i;
        }
    }
}

void incrementoCircular(int& pos2, const Vector& v2){
    if(pos2==v2.tam-1){
        pos2=0;
    }
    else{
        pos2++;
    }
}

bool sonIguales(const Vector& v, const Vector& v2){
    int pos2=0;
    bool iguales = true;

    buscarPosPrimer(v, v2, pos2);

    if(v.tam != v2.tam){
        iguales = false;
    }

    else{
        for(int i = 1; i<v.tam; i++){ // sé que los primeros son iguales
            incrementoCircular(pos2, v2);
            if(v.datos[i] != v2.datos[pos2]){
                iguales = false;
            }
        }
    }
    
    return iguales;
}


int main(){
    Vector v;
    Vector v2;

    entrada(v, v2);

    if (sonIguales(v, v2)){
        cout << "SON IGUALES" << endl;
    }
    else{
        cout << "NO SON IGUALES" << endl;
    }

    return 0;
}