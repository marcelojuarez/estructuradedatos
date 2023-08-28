/*Escriba un programa que, dada una lista de enteros, determine si contiene m ́as elementos posi-
tivos que negativos.*/
#include<stdio.h>
#include<stdlib.h>
//lexico
struct Tdoblete{
    int info;
    struct Tdoblete *next;
};

struct Tdoblete *listaNum;
int negativos;
int positivos;
//

void CargarLista (struct Tdoblete **a){
        struct Tdoblete *aux1; 
        int not;
        int i;
    
    *a = NULL;
    printf("ingrese cuantos numeros quiere cargar \n");
    scanf("%d",&not);
    
    for(i=0;i<not;i=i+1){
        printf("ingrese los numeros \n");
        aux1 = (struct Tdoblete *) malloc (sizeof(struct Tdoblete));
        scanf("%d",&aux1->info);
        aux1->next = *a;
        *a = aux1;
    }
}

int cantNumNeg(struct Tdoblete *a){
    
    int acum;
    struct Tdoblete *aux;

    aux = a;
    acum = 0;
    while(aux != NULL){
        if(aux->info < 0){
            acum = acum + 1;
        }
        aux = aux->next;
    }
    return acum;
}

int cantNumPos(struct Tdoblete *a){
    
    int acum;
    struct Tdoblete *aux;

    aux = a;
    acum = 0;
    while(aux != NULL){
        if(aux->info >= 0){
            acum = acum + 1;
        }
        aux = aux->next;
    }
    return acum;
}

void MostrarLista (struct Tdoblete *a){
    struct Tdoblete *aux;
    aux = a;
    while(aux != NULL){
        printf("numero: %d \n",aux->info);
        aux = aux->next;
    }
}

int main(){
    CargarLista(&listaNum);
    negativos = cantNumNeg(listaNum);
    positivos = cantNumPos(listaNum);
    if(positivos >= negativos){
        printf("mayor cantidad de numeros positivos\n");
    }else{
        printf("mayor cantidad de numeros negativos\n");
    }
    MostrarLista(listaNum);
    return 0;
}
