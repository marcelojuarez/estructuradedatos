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
	
	public boolean agregar(T elem){
		if(cant == 0){
			ListaSobreLista<T> aux = new ListaSobreLista<>(elem);
			this.cabeza = aux.cabeza;
			this.cant = aux.cant;
			return true;
			/*otra solucion
			Nodo<T> aux = new Nodo<>(elem);
			cabeza = aux;
			cant++;
			*/
		}
		
		Nodo<T> cursor = new Nodo<>(elem);
		cant++;
	}
	
	public void vaciar(){
    		this.cant = 0;
  	}
	
	public int elementos(){
		return this.cant;
	}

	public boolean esVacia(){
		return (this.cant == 0);
	}
}
