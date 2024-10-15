#include <iostream>
#include <array>
#include <string>
using namespace std;

const int MAX = 20;

struct TFecha{
    int dia,mes,ano;
};

struct TProducto{
    int codigo;
    string nombre;
    double precio;
    TFecha caducidad;
};

typedef array<TProducto, MAX> TArray;
struct TFarmacia{
    TArray productos;
    int tam;
};

void InicializarFarmacia(TFarmacia& f){
    f.productos = {{}};
    f.tam = 0;
}

void LeerProducto(TProducto& p){
    cout << "Datos del producto: " << endl;
    cout << "Código: ";
    cin >> p.codigo;
    cout << "Nombre: ";
    cin >> p.nombre;
    cout << "Precio: ";
    cin >> p.precio;
    cout << "Fecha de caducidad (DD MM AAAA): ";
    cin >> p.caducidad.dia >> p.caducidad.mes >> p.caducidad.ano;
}

void EscribirProducto(const TProducto& p){
    cout << "Datos del producto: " << endl;
    cout << "Código: " << p.codigo << endl;
    cout << "Nombre: " << p.nombre << endl;
    cout << "Precio: " << p.precio << endl;
    cout << "Fecha de caducidad (DD MM AAAA): "<< p.caducidad.dia << "/" << p.caducidad.mes << "/" << p.caducidad.ano;
}

void InsertarProducto(TFarmacia& f, const TProducto& p){
    if(f.tam<MAX){
        f.productos[f.tam] = p;
        f.tam++;
    }
}

void BorrarProducto(TFarmacia& f, int codigo){
    int cont = 0;
    // para encontrar el producto a borrar
    while((cont<f.tam) && (f.productos[cont].codigo != codigo){
        cont++;
    }
    if(cont<f.tam){ // si sigue en el rango efectivo
        f.productos[cont] = f.productos[f.tam-1];  // coges el ultimo, lo pones en la posicion del que vas a borrar
        f.tam--; // y acortas la lista 1 pos
    }

}

void BuscarProductoCodigo(const TFarmacia& f, int codigo, bool& encontrado, TProducto& p){
    int cont = 0;
    // para encontrar el producto a borrar
    while((cont<f.tam) && (f.productos[cont].codigo != codigo){
        cont++;
    }
    encontrado = cont < f.tam;
    if(encontrado){ // si sigue en el rango efectivo
        p = f.productos[i];
    }
}

void BuscarProductoNombre(const TFarmacia& f, string nombre, bool& encontrado, TProducto& p){
    int cont = 0;
    // para encontrar el producto a borrar
    while((cont<f.tam) && (f.productos[cont].nombre != nombre){
        cont++;
    }
    encontrado = cont < f.tam;
    if(encontrado){ // si sigue en el rango efectivo
        p = f.productos[i];
    }
}

void ListarFarmacia(const TFarmacia& f){
    cout << "La farmacia tiene estos productos: " << endl;
    for(int i=0; i<f.tam; i++){
        EscribirProducto(f.productos[i]);
        cout << endl;
    }
}

int main(){

    return 0;
}
