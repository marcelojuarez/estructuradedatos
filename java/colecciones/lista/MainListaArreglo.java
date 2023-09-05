package colecciones.lista;

public class MainListaArreglo{
  public static void main(String[] args){
    ListaSobreArreglo array = new ListaSobreArreglo();
    ListaSobreArreglo array2 = new ListaSobreArreglo();
    array.agregar(1);
    array2.agregar(1);
    System.out.println("arreglo es "+ array);
    System.out.println("son iguales arreglo1 y arreglo2 ? : "+ array.equals(array2));
  }
}
