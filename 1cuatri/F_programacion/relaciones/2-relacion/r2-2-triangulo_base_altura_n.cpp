 #include <iostream>
using namespace std;

int leer(){
    int n;
    cout << "Introduce el n�mero para hacer el tri�ngulo." << endl;
    do{
        cin >> n;
    }while(n<1);
    return n;
}

void escribirBlancos(int n){
    while (n>0){
        cout << " ";
        n--;
    }
}

void escribirAst(int n){
    while (n>0){
        cout << "* ";
        n--;
    }
}

void escribirTriangulo(int n){
    for(int i=1; i<=n; i++){
        escribirBlancos(n-i);
        escribirAst(i);
        cout << endl;
    }
}

int main(){
    int n;

    n = leer();  // lo mismo que leer(n)

    escribirTriangulo(n);

    return 0;
}
