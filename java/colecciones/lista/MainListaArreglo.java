package colecciones.lista;

public class MainListaArreglo{
  public static void main(String[] args){
    ListaSobreArreglo array = new ListaSobreArreglo();
    ListaSobreArreglo array2 = new ListaSobreArreglo();
    array.agregar(1);
    array.agregar(2);
    System.out.println(""+ array);
    System.out.println("cantidad de elementos: "+array.elementos());
    //array.insertar(17,1);
    System.out.println("esta vacio este arreglo ?: "+ array.esVacia());
    System.out.println("elemento en la posicion 0 :"+array.obtener(0));
  }
}
