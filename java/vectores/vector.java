package vectores;

public class vector{
	public static final int CAPACIDAD = 30;
	private double[] vec;
	private int cant;
	
//constructor por defecto
public vector(){
	this(CAPACIDAD);
	
}	
//constructor 
public vector (int capacidad){
	vec = new double[capacidad];
	cant = 0;
}

//getter para obtener la cantidad
public int getCant(){
	return cant;
}
public vector multEscalar(double escalar){
	if(cant == 0){
		throw new IllegalStateException("uno de los argumentos no es valido");
	}
	vectorAux = new vector();
	for(int i = 0;i<cant;i++){
		vectorAux.vec[i] = this.vec[i] * escalar;
		vectorAux.cant++;
	}
	return vectorAux;
}

public vector suma(double[] vector2){
	if(!(this.cant == vector2.getCant())){
		throw new IllegalStateException("los elementos deben ser del mismo tamaño");
	}
	vectorAux = new vector(CAPACIDAD);
	for(int i;i< cant;++){
	}
}
}
