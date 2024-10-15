#include <iostream>
#include <array>
using namespace std;

const int TAM = 5;
typedef array<char, TAM> TFila;
typedef array<TFila,TAM> TMatriz;

void leer(TMatriz& m){
    for(int i=0; i<TAM; i++){
        for(int j=0; j<TAM; j++){
            cin >> m[i][j];
        }
    }
}

bool celdaValida(int f, int c){
    return (f>=0 && f<TAM && c>=0 && c<TAM);  // si tanto f como c están entre 0 y TAM-1, indices validos
}

int vecinos(const TMatriz& m, int f_interes, int c_interes){
    int vecinos = 0;
    for(int f=f_interes-1; f<=f_interes+1; f++){
        for(int c=c_interes-1; c<=c_interes+1; c++){ // recorriendo los vecinos desde el de la esquina sup izq hasta esquina inf der (ambos incluidos)
            if(!(f==f_interes && c==c_interes) && m[f][c]=='x' && celdaValida(f,c)){  // si no es la celda que estamos estudiando, hay x y es valida que sume 1
                vecinos++;
            }
        }
    }
    return vecinos;
}

void calcularGeneraciones(const TMatriz& m1, TMatriz& m2){
    int vecinos_vivos;
    for(int f=0; f<TAM; f++){
        for(int c=0; c<TAM; c++){
        vecinos_vivos = vecinos(m1, f, c);
            if(m1[f][c]=='o'){  // si está vacía
                if(vecinos_vivos == 3){
                    m2[f][c] = 'x';  // nace ser vivo
                }
                else{
                    m2[f][c] = 'o';  // sigue muerto
                }
            }
            else{  // hay ser vivo
                if(vecinos_vivos == 2 || vecinos_vivos == 3){
                    m2[f][c] = 'x';  // sigue vivo
                }
                else{
                    m2[f][c] = 'o';  // muere, se queda vacia
                }
            }
        }
    }
}

void copiar(const TMatriz& m2, TMatriz& m1){
    for(int f=0; f<TAM; f++){
        for(int c=0; c<TAM; c++){
            m1[f][c] = m2[f][c];
        }
    }
}

void escribir(const TMatriz& m){
    for(int f=0; f<TAM; f++){
        for(int c=0; c<TAM; c++){
            cout << m[f][c];
        }
        cout << endl;
    }
    cout << endl;
}

int main(){
    TMatriz m1, m2;
    int n_gen;
    cout << "Introduzca numero de generaciones: ";
    cin >> n_gen;
    cout << "Introduzca generacion inicial: " << endl;
    leer(m1);

    cout << "\nGeneracion 1 (inicial): " << endl;
    escribir(m1);
    for(int i=2; i<=n_gen; i++){
        calcularGeneraciones(m1,m2);
        cout << "Generación " << i << ":" << endl;
        escribir(m2);
        copiar(m2,m1); // copiar m2 a m1, para poder iterar sobre m1 e ir cambiando el valor de m2
    }
    

    return 0;
}