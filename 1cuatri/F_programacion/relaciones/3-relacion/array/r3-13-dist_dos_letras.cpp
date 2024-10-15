/*13. La distancia entre dos letras en un texto es el número de letras que aparecen en el texto entre las
dos letras indicadas. Diseñe un algoritmo que lea un texto de longitud indefinida formado por
letras mayúsculas (que termina con un punto) y muestre por pantalla la máxima distancia entre
cada par de letras repetidas. Aquellas letras que no se repitan no aparecerán en la salida.
Por ejemplo:

Texto de entrada: ABEADDGLAKE.

Salida:
Distancia entre A: 4
Distancia entre D: 0
Distancia entre E: 7*/

#include <iostream>
#include <array>
using namespace std;

const int MAX_LETRAS = 26;
struct TDatos{
    int ultPos;
    int mayDist;
    bool repe;
};

typedef array<TDatos, MAX_LETRAS> TArray;

void escribirMayDist(const TArray& v){
    for(int i=0; i<MAX_LETRAS; i++){
        if(v[i].repe){
            cout << "Distancia entre " << char('A'+i) << ": " << v[i].mayDist << endl;
        }
    }
}

void calcMayorDist(TArray& v){
    char c;
    int pos_actual = 1, dist = 0;

    cout << "Texto de entrada (punto para finalizar): ";
    cin.get(c);
    while(c!='.'){
        if(v[c-'A'].ultPos == 0){  // SI NUNCA HA APARECIDO
            v[c-'A'].ultPos = pos_actual;
        }
        else{
            v[c-'A'].repe = true;  // si ha aparecido, es que está repe
            dist = pos_actual - v[c-'A'].ultPos - 1; // el -1 es un arreglo, ya que al restar se incluye tb la pos de la primera letra

            if(dist > v[c-'A'].mayDist){ // si la dis de ahora es mayor a la anterior, esa es la nueva dist mayor
                v[c-'A'].mayDist = dist;
            }

            v[c-'A'].ultPos = pos_actual;  // la nueva ult pos es la actual
        }
        cin.get(c);
        pos_actual++;
    }
}

int main(){
    TArray v = {{}};  // todo a 0 y a false

    calcMayorDist(v);
    escribirMayDist(v);
    return 0;
}
