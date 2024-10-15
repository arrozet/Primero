#include <iostream>
#include <array>
using namespace std;

const int MAX = 50;
typedef array<int, MAX> TArray;
struct TEstaturas{
    TArray estaturas;
    int tam;
};

void leer(TEstaturas& a){
    cout << "Cuantas estaturas va a introducir (maximo " << MAX << "): ";
    cin >> a.tam;
    cout << "Introduzca las " << a.tam << " estaturas: ";
    for(int i=0; i<a.tam; i++){
        cin >> a.estaturas[i];
    }
}

float mediaArray(const TEstaturas& a){
    float suma=0, media;
    for(int i=0; i<a.tam; i++){
        suma += a.estaturas[i];
    }
    media = suma/a.tam;
    return media;
}

int bajos(const TEstaturas& a, int media){
    int bajos=0;

    for(int i=0; i<a.tam; i++){
        if(a.estaturas[i]<media){
            bajos++;
        }
    }
    return bajos;
}

int altos(const TEstaturas& a, int media){
    int altos=0;

    for(int i=0; i<a.tam; i++){
        if(a.estaturas[i]>media){
            altos++;
        }
    }
    return altos;
}

void escribir(float media,int n_bajos,int n_altos){
    cout << "La media es: " << media << endl;
    cout << "Numero de alumnos mas altos que la media: " << n_altos << endl;
    cout << "Numero de alumnos mas bajos que la media: " << n_bajos << endl;
}

int main(){
    TEstaturas a;
    leer(a);
    float media = mediaArray(a);
    int n_bajos = bajos(a,media);
    int n_altos = altos(a,media);
    escribir(media,n_bajos,n_altos);

    return 0;
}