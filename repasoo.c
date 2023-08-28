#include<stdio.h>
#include<stdlib.h>
struct Tdoblete{
    int info;
    struct Tdoblete *next;
};
    struct Tdoblete *notas;
    struct Tdoblete *aux;
    float acum1;
    float acum2;
    float promApla;
    float promSinApla;
    float cantNotas1;
    float cantNotas2;

void CargarLista (struct Tdoblete **a){
        struct Tdoblete *aux1; 
        int not;
        int i;
    
    *a = NULL;
    printf("ingrese cuantas notas quiere cargar \n");
    scanf("%d",&not);
    
    for(i=0;i<not;i=i+1){
        printf("ingrese las notas \n");
        aux1 = (struct Tdoblete *) malloc (sizeof(struct Tdoblete));
        scanf("%d",&aux1->info);
        aux1->next = *a;
        *a = aux1;
    }
}
void MostrarLista (struct Tdoblete *a){
    struct Tdoblete *aux;
    aux = a;
    while(aux != NULL){
        printf("nota: %d \n",aux->info);
        aux = aux->next;
    }
}
int main(){
    CargarLista(&notas);
    aux = notas;
    MostrarLista(notas);
    acum1 = 0;
    acum2 = 0;
    cantNotas1 = 0;
    cantNotas2 = 0;
    
    while(aux != NULL){
        if(aux->info>4){
            acum1 = acum1 + aux-> info;
            cantNotas1 = cantNotas1 + 1;
        }
        acum2 = acum2 + aux->info;
        cantNotas2 = cantNotas2 + 1;
        aux = aux->next;
    }
    promSinApla = (acum1/cantNotas1);
    promApla    = (acum2/cantNotas2);
    printf("el promedio con aplazos es : %f \n",promApla);
    printf("el promedio sin aplazos es : %f \n",promSinApla);
    return 0;
}
