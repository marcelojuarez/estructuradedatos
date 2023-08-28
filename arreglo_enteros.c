#include <stdio.h>
#include <stdlib.h>

//lexico
#define Max 250

typedef struct {
    int arreglo[Max];
    int cant;
}tipo_arreglo;

tipo_arreglo arraid;
int elemento;

//

int es_vacia (tipo_arreglo arreglo){
    return(arreglo.cant == 0);
}

tipo_arreglo agregar(tipo_arreglo arreglo, int elem){
    if(arreglo.cant>= Max){
        printf("error no se pueden agregar mas elementos en este arreglo\n");
    }else{
        for(int i = 0; i < arreglo.cant;i++){
            arreglo.arreglo[i+1] = arreglo.arreglo[i]; 
        }
        arreglo.arreglo[0] = elem;
        arreglo.cant = arreglo.cant + 1;
    }
}

int ins(tipo_arreglo arreglo,int elem, int pos){
    if(pos < 0 || pos > arreglo.cant){
        return -1;
    }

    if(!pos){
        agregar(arreglo, elem);
    }

    if(arreglo.cant >= Max){
        printf("error no se pueden agregar mas elementos sobre este arreglo\n");
    }else{
        for(int i = pos; i<arreglo.cant; i++){

        }
        arreglo.cant = arreglo.cant + 1;
    }
}

tipo_arreglo fin(tipo_arreglo arreglo,int elem){
    ins(arreglo, elem, arreglo.cant); 
    return arreglo;
}

int eliminar_comienzo(tipo_arreglo arreglo){
    if(es_vacia(arreglo)){
        return -1;
    }
    for(int i = 1; i < arreglo.cant; i++ ){
        arreglo.arreglo[i-1] = arreglo.arreglo[i];
    }
    arreglo.cant = arreglo.cant - 1;
    return 0;
}

int eliminar(tipo_arreglo arreglo, int pos){
    if(pos < 0 || pos > arreglo.cant - 1 ){
        return -1;
    }

    if(es_vacia(arreglo)){
        return -1;
    }

    if(!pos){
        eliminar_comienzo(arreglo);
        return 0;
    }
   
    for(int i = pos; i<arreglo.cant - 1; i++){
        arreglo.arreglo[i] = arreglo.arreglo[i+1];
    }
    arreglo.cant = arreglo.cant - 1;
    return 0;
}

int obtener(tipo_arreglo arreglo, int pos){
    if(pos < 0 || pos > arreglo.cant-1){
        printf("error posicion inexistente\n");
    }else{
         return (arreglo.arreglo[pos]);
    }

}

tipo_arreglo reversa(tipo_arreglo arreglo){
    tipo_arreglo revArreglo;
    int j;
    j = arreglo.cant - 1;
    for(int i = 0; i < arreglo.cant;i++){
      revArreglo.arreglo[j] = arreglo.arreglo[i];
      j = j - 1;  
    }
    return revArreglo;
}

tipo_arreglo concat(tipo_arreglo ini, tipo_arreglo cola){
    tipo_arreglo finalArraid;
    for(int i = 0;i < ini.cant ; i++){
        fin(finalArraid,obtener(ini,i));
    }
      for(int i = 0;i < cola.cant ; i++){
        fin(finalArraid,obtener(cola,i));
    }
    return finalArraid;
}

tipo_arreglo sub(tipo_arreglo* arreglo, int i, int j){
    tipo_arreglo subArraid;
    int k;
    for(k = i; k < j; k++){
        fin(subArraid,obtener(&arreglo,k));
    }
    return subArraid;
}

tipo_arreglo copia(tipo_arreglo arreglo){
    return sub(&arreglo, 0, arreglo.cant);
}

int cabeza(tipo_arreglo arreglo){
    return(arreglo.arreglo[0]);
}

tipo_arreglo cola(tipo_arreglo arreglo){
    return sub(&arreglo, 1, arreglo.cant);
}

void mostrar(tipo_arreglo arreglo){
    printf("[");
    for(int i=0;i<arreglo.cant;i++){
        printf("%d",obtener(arreglo,i));
    }
    printf("]");
}


