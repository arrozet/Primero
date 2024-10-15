#include <iostream>
#include <array>
using namespace std;

const int MAX_CARGOS = 15;
const int MAX_PARTIDOS = 10;

typedef array<int, MAX_CARGOS> TFila;
typedef array<TFila, MAX_PARTIDOS> TTabla;

struct TPartido{
    char nombre;
    int votos;
    int cargos;
};
typedef array<TPartido, MAX_PARTIDOS> TListaPartidos;

struct TDatos{
    int num_cargos;
    int num_partidos;
};

void leer(TDatos& divisores, TListaPartidos& partido){
    do{
        cout << "Introduzca el Número de Cargos (>= 1 y <=" << MAX_CARGOS << "): ";
        cin >> divisores.num_cargos;
    }while(divisores.num_cargos<1 || divisores.num_cargos>MAX_CARGOS);

    do{
        cout << "Introduzca el Número de Partidos (>= 1 y <=" << MAX_PARTIDOS << "): ";
        cin >> divisores.num_partidos;
    }while(divisores.num_partidos<1 || divisores.num_partidos>MAX_PARTIDOS);

    cout << "Introduzca el Nombre (un caracter) y Número de Votos por Partido: " << endl;
    for(int i=0; i<divisores.num_partidos; i++){
        cout << "Partido " << i+1 << ": ";  // i+1 ya que se parte desde 0
        cin >> partido[i].nombre >> partido[i].votos;
        partido[i].cargos = 0;  // todos los cargos de todos los partidos a 0
    }
}

void construirTabla(TTabla& t, const TDatos& d, const TListaPartidos& p){
    for(int f=0; f<d.num_partidos; f++){
        for(int c=0; c<d.num_cargos; c++){
            t[f][c] = (p[f].votos / (c+1));  // c+1 para que empiece desde 1
        }
    }
}

/*void escribirTabla(const TTabla& t, const TDatos& d){
    for(int f=0; f<d.num_partidos; f++){
        for(int c=0; c<d.num_cargos; c++){
            cout << t[f][c] << " ";
        }
        cout << endl;
    }
}*/

void buscarMayor(const TTabla& t, const TDatos& d, int& fil, int& col){
    for(int f=0; f<d.num_partidos; f++){
        for(int c=0; c<d.num_cargos; c++){
            if(t[f][c]>t[fil][col]){
                fil = f;
                col = c;
            }
        }
    }
}

void encontrarCargos(TTabla& t, const TDatos& d, TListaPartidos& p){
    int fil_interes, col_interes, cont = 0;
    while(cont<d.num_cargos){
        fil_interes = 0, col_interes = 0;

        buscarMayor(t, d, fil_interes, col_interes);

        p[fil_interes].cargos++;
        t[fil_interes][col_interes] = 0; // para eliminar de la búsqueda del mayor
        cont++;
    }
}

void escribirCargos(const TDatos& d, const TListaPartidos& p){
    cout << "Los cargos electos son: " << endl;
    for(int i = 0; i<d.num_partidos; i++){
        if(p[i].cargos > 0){
            cout << p[i].nombre << " " << p[i].cargos << endl;
        }
    }

}

int main(){
    TDatos datos;
    TListaPartidos partido;
    TTabla t;

    leer(datos, partido);

    construirTabla(t, datos, partido);
    //escribirTabla(t, datos);

    encontrarCargos(t, datos, partido);
    escribirCargos(datos, partido);

    return 0;
}
