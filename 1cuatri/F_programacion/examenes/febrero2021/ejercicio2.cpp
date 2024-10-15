// Rubén Oliva Zamora
// Ingeniería del software
// Grupo A
// Equipo XX


#include <iostream>
#include <array>
#include <string>
using namespace std;

// falta que compruebe que todos sean digitos
void leer(string& grupo, string& editor, string& libro){
    do{
        cout << "Introduce el código del grupo (primer dígito): " << endl;
        cin >> grupo;
    }while(int(grupo.size()) != 1);
    do{
        cout << "Introduce el código del editor (los siguientes 4 dígitos): " << endl;
        cin >> editor;
    }while(int(editor.size()) != 4);
    do{
        cout << "Introduce el código del libro (los siguientes 4 dígitos): " << endl;
        cin >> libro;
    }while(int(libro.size()) != 4);

}

int calcularCodigoControl(string& calculo_control){
    int digito = 0;
    for(int i=0; i<int(calculo_control.size()); i++){
        digito += (calculo_control[i]-'0') * (i+1);
    }
    digito %= 11;
    return digito;
}

int main(){
    cout << "Rubén Oliva Zamora\n Ingeniería del software\n Grupo A \nEquipo XX" << endl;

    string grupo, editor, libro, calculo_control;
    int digito_control;
    leer(grupo,editor,libro);
    calculo_control = grupo+editor+libro;
    digito_control = calcularCodigoControl(calculo_control);

    cout << "Tu ISBN es: " << calculo_control;
    if(digito_control == 10){
        cout << "X";
    }
    else{
        cout << digito_control;
    }

    return 0;
}
