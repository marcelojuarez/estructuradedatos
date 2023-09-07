package colecciones.lista;

public class ListaSobreArreglo<T> implements Lista<T>{
   public static final int MAX = 100;
   private T[] arreglo;
   private int cant;
  
  
  //constructor por defecto;
  public ListaSobreArreglo(){
    arreglo = (T[])new Object [MAX];
    cant = 0;
  }
  
  
  /**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
  */
  public boolean agregar(T elem){
    if(!(cant == MAX)){
      arreglo[cant] = elem;
      cant++;
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
      if(this.MAX-this.cant >= otraLista.elementos()){
        for(int i = 0;i<otraLista.elementos();i++){
          this.agregar(otraLista.obtener(i));
          cant++;
        }
      return true;
      }else{
        return false;
      }
    }
  
  /**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
  	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
  
  public boolean insertar(T elem, int pos){
      boolean result = false;
      if(cant == MAX){
        result = false;
      }
      if(pos < 0 || pos > cant){
        throw new IndexOutOfBoundsException("indice fuera de rango");
      }
      if(pos == cant){
        arreglo[cant] = elem;
        result = true;
      }  
      if(pos < cant){
        int i;
        for(i = pos; i<cant;i++){
          arreglo[i+1] = arreglo[i];
        }
        arreglo[pos] = elem;
        result =true;
      }
      cant++;
      return result;
  }
  
  /**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
  public T eliminar(int indice){
    T contenedor;
    int i;
    if(indice < 0 || indice >= cant){
      throw new IndexOutOfBoundsException("indice fuera de rango");
    }else{
      contenedor = arreglo[indice];
      for(i = indice; i<cant-1;i++){
        arreglo[i] = arreglo[i+1];
      }
    }
    cant--;
    return contenedor;
  }
  /**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
  public T obtener(int indice){
    if(indice >= cant || indice < 0){
     throw new IndexOutOfBoundsException ("indice fuera de rango");
    }else{
      return arreglo[indice];
    }
  }
  
  public boolean contiene(T elem){
    boolean result;
    T e;
    for(int i = 0;i < cant;i++){
         e = this.arreglo[i];
        if(e == elem){
          return true;
        }
    }
    return false;
  }
  
	/**
	* Remueve todos los elementos en la lista.
	*/
  public void vaciar(){
    for(int i = 0;i < cant;i++){
        arreglo[i] = null;
    }
    cant = 0;
  }
  
  /**
	* Retorna la cantidad de elementos agregados a la lista.
  * @return cantidad de elementos en la lista
	*/
  public int elementos(){
    return cant;
  }
  
  /**
	* Permite evaluar si la lista no tiene elementos.
	* Este método es equivalente a:
	* <pre>lista.elementos() == 0</pre>
	* @return {@code true} sii la pila no tiene elementos
  */
  public boolean esVacia(){
    return (cant == 0);
  }
  
  @Override
  public String toString(){
    String result = "";
    for(int i = 0;i < cant;i++){
      result +="posicion "+i+" : "+arreglo[i].toString()+"\n";
    }
    return result;
  }
  
  /**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los  elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
  */
  @Override
  public boolean equals(Object otro){
      int i;  
     if(otro == null)
        return false;
      
      if(otro == this)
        return true;
      
      if(!(otro instanceof ListaSobreArreglo))
        return false;
      ListaSobreArreglo otroArreglo = (ListaSobreArreglo) otro;
      
      if(!(otroArreglo.cant == this.cant)) 
          return false;
      for(i = 0;i < cant;i++){
        if(!(this.arreglo[i] == otroArreglo.arreglo[i]))
            return false;
      }
      return true;  
    }
  //el repOk verifica que los elementos almacenados en esta estructura cumplan con alguna propiedad solicitada
  public boolean repOK(){
    	return true;
  }
 
  /**
	* Retorna la porción de esta lista entre los índice especificados {@code desdeInd}, inclusivo, y {@code hastaInd}, exclusivo, en una nueva lista.
	* Si {@code fromInd} es igual a {@code hastaInd} se retorna un a lista vacía.
	* @param desdeInd el índice inferior, inclusivo
	* @param hastaInd el índice superior, exclusivo
	* @return una nueva lista formada con los elementos entre {@code desdeInd} hasta {@code hastaInd - 1} de esta lista
	* @throws IndexOutOfBoundsException si ({@code fromInd} &lt; {@code 0} || {@code hastaInd} &gt; {@code #elementos()} || {@code desdeInd} &gt; {@code hastaInd})
	* @see #elementos() 
	*/

  public Lista<T> subLista(int desdeInd, int hastaInd){
    ListaSobreArreglo subArreglo = new ListaSobreArreglo();
      int n = desdeInd;
      int j = hastaInd;
      int z = 0;
      for(int i = n; i < j;){
        subArreglo.arreglo[z] = this.arreglo[i];
        subArreglo.cant++;
        z++;
      }
      return subArreglo;
  }
}
