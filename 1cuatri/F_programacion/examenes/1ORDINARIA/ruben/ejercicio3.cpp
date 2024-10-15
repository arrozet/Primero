/*
Ruben Oliva Zamora
Ingenieria del software
Grupo A
Equipo PC105
*/
#include <iostream>
#include <array>

using namespace std;

const int TAM = 9;
const int MAX_NUM = 10; // el indice 0 no se usa

typedef array<bool, MAX_NUM> TRepe;

typedef array<int,TAM> TFila;
typedef array<TFila,TAM> TMatriz;

typedef array<int,TAM/3> TFila_aux;
typedef array<TFila_aux,TAM/3> TMatriz_aux;

bool casillaValida(const TMatriz& m, int f, int c){
    return (m[f][c]>=0 && m[f][c]<=9);
}

bool elementoRepe(int elemento, const TRepe& r){
    if(elemento==0){
        return false;  // ya que los 0 no cuentan como repes
    }
    else{
        return r[elemento];
    }

}

void validezTira(bool& valida, int elemento, TRepe& r){
    if(!elementoRepe(elemento,r)){
        r[elemento] = true;
    }
    else{
        valida = false;
    }

}

bool filaValida(const TMatriz& m, int f){
    TRepe r = {{}};
    bool valida=true;
    int c=0;
    while(valida && c<TAM){
        if(casillaValida(m,f,c)){  // si la casilla no es valida, la fila no es valida
            // si la fila tiene elementos repetidos distintos de 0, la fila no es valida
            validezTira(valida,m[f][c],r);

            /*if(!elementoRepe(m[f][c],r)){
                r[m[f][c]] = true;
            }
            else{
                valida = false;
            }*/
        }
        else{
            valida = false;
        }
        c++;
    }

    return valida;
}

bool columnaValida(const TMatriz& m, int c){
    int f=0;
    TRepe r={{}};
    bool valida = true;

    while(valida && f<TAM){
        validezTira(valida,m[f][c],r);
        f++;
    }
    return valida;
}
/*
void rellenarMatrizAux(const TMatriz& m, TMatriz_aux& t, int fil, int col){
    int f=0, c=0, aux=col;
    while(f<3){
        c=0;
        col=aux;
        while(c<3){
            t[f][c] = m[fil][col];
            c++;
            col++;
        }
        f++;
        fil++;
    }
}

void comprobarMatrizAux(const TMatriz& m, int fil, int col,bool& valido){
    TMatriz_aux t={{}};
    TRepe r = {{}};
    int cont=0, f=0, c=0;
    while(cont<(TAM/3) && valido){
        rellenarMatrizAux(m,t,fil,col);
        while(valido){
                while(valido && f<(TAM/3)){
                    c=0;
                    while(valido && c<(TAM/3)){
                        if(elementoRepe(t[f][c],r)){
                            valido = false;
                        }
                        c++;
                    }
                    f++;
                }

        }
        cont++;
    }

}*/

bool tableroValido(const TMatriz& m){
    bool valido=true;
    // analisis por filas + comprobacion validez de todas las celdas
    int f=0;
    while(f<TAM && valido){
        if(!filaValida(m,f)){
            valido=false;
        }
        f++;
    }

    // analisis por columnas, considerando que todas las celdas son validas (comprobado anteriormente)
    int c=0;
    while(c<TAM && valido){
        if(!columnaValida(m,c)){
            valido=false;
        }
        c++;
    }

    /*
    // analisis por regiones, considerando que todas las celdas son validas
    f=(TAM/3); // ya que todo sudoku esta formado por 9 bloques.
    c=(TAM/3);
    while(valido && f<=TAM){
        while(valido && c<=TAM){
            comprobarMatrizAux(m,f,c,valido);
            c+=3;
        }
        f+=3;
    }*/


    return valido;

}

int main() {
    cout << "Ruben Oliva Zamora\nIngenieria del software\nGrupo A\nEquipo PC105\n" << endl;
    TMatriz tablero1 =
                    {{ {{5,3,0,0,7,0,0,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,0,0,0,6,0}},
                        {{8,0,0,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                    }};

    TMatriz tablero2 =
                    {{ {{5,3,0,0,7,0,0,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,0,0,0,6,0}},
                        {{8,0,3,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                    }};

    TMatriz tablero3 =
                    {{ {{5,3,0,0,7,0,0,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,2,0,0,6,0}},
                        {{8,0,0,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                    }};

    TMatriz tablero4 =
                    {{ {{5,3,0,0,7,0,6,0,0}},
                        {{6,0,0,1,9,5,0,0,0}},
                        {{0,9,8,0,0,0,0,6,0}},
                        {{8,0,0,0,6,0,0,0,3}},
                        {{4,0,0,8,0,3,0,0,1}},
                        {{7,0,0,0,2,0,0,0,6}},
                        {{0,6,0,0,0,0,2,8,0}},
                        {{0,0,0,4,1,9,0,0,5}},
                        {{0,0,0,0,8,0,0,7,9}}
                    }};

    if (tableroValido(tablero1)) {
        cout << "El tablero1 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero1 es un sudoku NO VALIDO" << endl;
    }

    if (tableroValido(tablero2)) {
        cout << "El tablero2 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero2 es un sudoku NO VALIDO" << endl;
    }

    if (tableroValido(tablero3)) {
        cout << "El tablero3 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero3 es un sudoku NO VALIDO" << endl;
    }

    if (tableroValido(tablero4)) {
        cout << "El tablero4 es un sudoku VALIDO" << endl;
    } else {
        cout << "El tablero4 es un sudoku NO VALIDO" << endl;
    }

    return 0;
}
