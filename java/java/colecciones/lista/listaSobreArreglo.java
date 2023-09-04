import colecciones.Lista;

public class listaSobreArreglo<T> implements Lista<T>{
   public static final int MAX = 100;
   private T[] arraid;
   private int cant;
  
  //constructor por defecto;
  public listaSobreArreglo(){
    arraid = (T[])new Object [MAX];
    cant = 0;
  }
    
  public boolean agregar(T elem){
    if(!(cant == MAX)){
      arraid[cant] = elem;
      nroElement ++;
      return true;
    }else{
      System.out.println("no se pueden agregar mas elementos ");
      return false;
    }
  }
  /**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
  
 public boolean agregarTodos(Lista<T> otraLista){
    if(this.MAX-this.cant >= otraLista.elementos())
      int i;
      for(i = 0;i<otraLista.elementos();i++){}
      return true;
    }else{
      return false;
    }
  }
  
  
  public boolean insertar(T elem, int pos){
      if(cant == MAX){
        return false;
      }
      if(pos < 0 || pos > cant){
        throw new IndexOutOfBoundsException ("indice fuera de rango");
      }
      if(pos == cant){
        arraid[cant] = elem;
        cant++;
        return true;
      }  
      if(pos < cant){
        int i;
        for(i = pos; i<cant;i++){
          arraid[i+1] = arraid[i];
        }
        cant++;
      }
  }
  
  public T eliminar(int indice){
  
  }
  
  public T obtener(int indice){
    if(indice >= cant || indice < 0){
     throw new IndexOutOfBoundsException ("indice fuera de rango");
    }else{
      return arraid[indice];
    }
  }
  
  //public boolean contiene(T elem){
  
  public void vaciar(){
    this.cant = 0;
  }
  
  public int elementos(){
    return cant;
  }
  
  public boolean esVacia(){
    return (cant == 0);
  }
}
