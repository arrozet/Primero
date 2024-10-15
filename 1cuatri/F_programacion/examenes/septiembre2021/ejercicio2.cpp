/*
Rubén Oliva Zamora
Ingeniería del software
Grupo A
Equipo XX
*/

#include <iostream>
#include <array>
using namespace std;
const int MAX = 20;
typedef array<int, MAX> TCartas;
struct TMontones{
    TCartas elem;
    int tam;
};

void leer(TMontones& m){
    // suponiendo que es numero triangular
    cout << "Introduce el numero de montones a introducir: ";
    cin >> m.tam;
    cout << "Introduce los " << m.tam << " montones: " << endl;
    for(int i=0; i<m.tam; i++){
        cin >> m.elem[i];
    }
}

void escribir(const TMontones& m){
    for(int i=0; i<m.tam; i++){
        cout << m.elem[i] << " ";
    }
    cout << endl;
}

bool bulgaro(const TMontones& m){
    int i=0;
    while(i<m.tam && m.elem[i] == (i+1)){
        i++;
    }
    return !(i<m.tam);
}

bool hayHueco(const TMontones& m, int& i){
    while(i<m.tam && m.elem[i]>0){
        i++;
    }
    return i<m.tam;
}

void desplazarIzq(TMontones& m, int ind){
    for(int i=ind+1; i<m.tam; i++){
        m.elem[ind] = m.elem[i];
        ind=i;
    }
    m.tam--;
}

void organizar(TMontones& m){
    int ind=0;
    for(int i=0; i<m.tam; i++){
        m.elem[i]--;
    }
    m.tam++;
    m.elem[m.tam-1] = m.tam-1;

    if(hayHueco(m,ind)){
        desplazarIzq(m,ind);
    }
}

int main(){
    TMontones m;
    m.tam=0;
    leer(m);
    while(!bulgaro(m)){
        organizar(m);
        escribir(m);
    }

    return 0;
}
