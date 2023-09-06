public class Nodo<T>{
	
	private T elem;
	private Nodo<T> siguiente;	

	//getter para obtener el valor
	public T getElem(){
		return elem;
	}

	//setter para cambiar el valor
	public void setElem(T elem){
		this.elem = elem
	}
	
	//getter para obtener la direccion
	public int getSiguiente(){
		return siguiente;
	}
	//setter para cambiar la direccion
	public void setSiguiente(Nodo siguiente){
		this.siguiente = siguiente;
	}

	//constructor 
	public Nodo<T>(T elem){
		this.elem = elem;
		this.siguiente = null;
	}

	
}
