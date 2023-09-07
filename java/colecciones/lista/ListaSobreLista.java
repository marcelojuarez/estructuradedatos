package colecciones.lista;


public class ListaSobreLista<T> implements Lista<T>{
		
	private Nodo<T> cabeza;
	private int cant;

	//constructor por defecto
	ListaSobreLista(){
		cabeza = null;
		cant = 0;
	}
	
	//constructor con un elemento
	ListaSobreLista(T valor){
		Nodo<T> punt = new Nodo<>(valor);
		cabeza = punt;
		cant++;
	}
	
	//getter para obtener la cabeza
	public Nodo<T> getCabeza(){
		return cabeza;
	}
	
	/**
	* Agrega un elemento al final de la lista.
	* @param elem el elemento a agregar
	* @return {@code true} sii el elemento pudo ser agregado
	*/
	
	public boolean agregar(T elem){
		if(cant == 0){
			/*ListaSobreLista<T> aux = new ListaSobreLista<>(elem);
			this.cabeza = aux.cabeza;
			this.cant = aux.cant;
			aux.cabeza = null;
			return true;
			otra solucion
			*/
			Nodo<T> aux = new Nodo<>(elem);
			cabeza = aux;
			cant++;
			return true;
		}
		
		Nodo<T> cursor = new Nodo<>(elem);
		cursor = cabeza;
		
		while(cursor.getSiguiente() != null){
			cursor = cursor.getSiguiente();
		}
			Nodo<T> aux = new Nodo<>(elem);
			aux.setSiguiente(null);
			cursor.setSiguiente(aux); 
			cant++;
		return true;
	}
	
	/**
	* Agrega todos los elementos de otra lista, al final de esta lista.
	* @param otraLista lista conteniendo todos los elementos a agregar al final de esta lista
	* @return {@code true} sii todos los elementos en {@code otraLista} fueron agregados
	*/
	public boolean agregarTodos(Lista<T> otraLista){
		
		for(int i = 0;i < otraLista.elementos();i++){
			this.agregar(otraLista.obtener(i));
		}
		return true;
	
	}

	/**
	* Agrega un elemento en una posicion particular de la lista.
	* @param elem el elemento a agregar
	* @param indice el indice donde se agrega el elemento
	* @return {@code true} sii el elemento pudo ser agregado
	* @throws IndexOutOfBoundsException si {@code indice} &lt; {@code 0}
	*/
	public boolean insertar(T elem, int indice){
		if(indice < 0){
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
		
		if(indice > cant){
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}

		if(indice == cant){
			this.agregar(elem);
			return true;
		}
		
		if(indice == 0){
			Nodo<T> cursor = new Nodo<>(elem);
			cursor.setSiguiente(cabeza);
			cabeza = cursor;
			cant++;
			return true;
		}
	
		if(indice < cant){
			Nodo<T> cursor = new Nodo<>(elem);
			cursor = cabeza;
			for(int i = 0;i < indice - 1 ;i++){
				cursor = cursor.getSiguiente();
			}
			Nodo<T> aux = new Nodo<>(elem);
			aux.setSiguiente(cursor.getSiguiente());
			cursor.setSiguiente(aux);
			aux = null;
			cant++;
			return true;
		}
		return false;
	}

	/**
	* Elimina un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a eliminar
	* @return el elemento eliminado
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T eliminar(int indice){
		if(indice < 0 || indice >= cant){
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
		
		if(indice == 0){
			Nodo<T> aux = new Nodo<>(cabeza.getElem());
			cabeza = cabeza.getSiguiente();
			cant--;
			return aux.getElem();
		}
		//genero un nodo con un elemento cualquiera para facilitar los distintos enlaces(no revise que elemento tenian guardado)
		Nodo<T> cursor = new Nodo<>(cabeza.getElem());
		cursor = cabeza;
		
		for(int i = 0;i < indice - 1;i++){
			cursor = cursor.getSiguiente();
		}
		
		Nodo<T> aux = new Nodo<>(cursor.getElem());
		aux = cursor.getSiguiente();
		cursor.setSiguiente(aux.getSiguiente());
		cant--;
		return aux.getElem();
	}

	/**
	* Obtiene un elemento de esta lista en una posición particular.
	* @param indice el indice el elemento a obtener
	* @return el elemento en la posición {@code indice}
	* @throws IndexOutOfBoundsException si ({@code indice} &lt; {@code 0} || {@code indice} &ge; {@code #elementos()})
	* @see #elementos() 
	*/
	public T obtener(int indice){
		if(indice < 0 || indice >= cant){
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
		
		Nodo<T> cursor = new Nodo<>(cabeza.getElem());
		cursor = cabeza;
		for(int i = 0;i < indice;i++){
			cursor = cursor.getSiguiente();
		}
		return cursor.getElem();
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
		if(desdeInd < 0 || hastaInd > cant || desdeInd > hastaInd){
			throw new IndexOutOfBoundsException("indice fuera de rango");
		}
		
		ListaSobreLista<T> list = new ListaSobreLista();
		for(int i = desdeInd; i < hastaInd;i++){
			list.agregar(this.obtener(i));
		}
		return list; 
	}

	/**
	* Evalua si esta lista contiene un elemento particular, utilizando el método {@code equals(Object)}.
	* @param elem el elemento a buscar
	* @return {@code true} sii, existe un elemento {@code e} en la lista, tal que {@code e == null && elem == null || e.equals(elem)}
	*/
	public boolean contiene(T elem){
		T e;
		Nodo<T> cursor = new Nodo<>(elem);
		cursor = cabeza;
		for(int	 i = 0; i < cant ; i++ ){
			e = cursor.getElem();
			if(e.equals(elem)){
				return true;
			}
			cursor = cursor.getSiguiente();
		}
		
		return false;
	}
	
	public void vaciar(){
    		cabeza = null;
  	}
	
	public int elementos(){
		return cant;
	}

	public boolean esVacia(){
		return (cant == 0);
	}

	public boolean repOK(){
		return true;
	}

	/**
	* Retorna una representación como {@code String} de esta lista. La representación como {@code String} consiste de los elementos en esta lista, en el orden correspondiente a la implementación de la misma, encerrados entre corchetes ("[]"). 
	* Elementos adyacentes están separados mediante los caractéres ", " (coma y espacio). Los elementos son convertidos mediante {@code String.valueOf(Object)}.
	* @return una representación como {@code String} de esta lista
	*/
	@Override
	public String toString(){
		String result = "[";
		Nodo<T> cursor = new Nodo<>(cabeza.getElem());
		cursor = cabeza;
		while(cursor !=  null){
			result = result + String.valueOf(cursor.getElem()); 
			if(!(cursor.getSiguiente()==null)){
				result = result + ",";
			}
			cursor = cursor.getSiguiente();
		}
		
		return result + "]";
	}
	
	/**
	* Evalúa igualdad entre esta y otra lista. La igualdad considera que el tamaño de ambas listas es el mismo, y que los elementos de ambas listas son iguales considerando el orden de los mismos de acuerdo a la implementación de cada lista.
	* La igualdad entre elementos se realiza considerando si ambos son {@code null} o, en caso contrario, mediante el método {@code equals(Object)}.
	* @return {@code true} sii ambas listas tienen los mismos elementos.
	*/
	@Override
	public boolean equals(Object otro){
		if(otro == null)
			return false;
		
		if(otro == this)
			return true;
		
		if(!(otro instanceof ListaSobreLista<?>))
			return false;
			ListaSobreLista<T> otroLista = (ListaSobreLista<T>) otro;
		
		if(!(otroLista.elementos() == this.elementos()))	
			return false;
		
		for(int i = 0;i < this.elementos();i++){
			if(!(this.obtener(i) == otroLista.obtener(i)))
				return false;
			}		
			return true;
		}
	
}
