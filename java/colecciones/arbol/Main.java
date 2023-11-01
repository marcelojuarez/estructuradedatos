package colecciones.arbol;

import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        Comparator<Integer> comp = Comparator.naturalOrder();
        ABB<Integer> arbol = new ABB<Integer>(comp, 12);
        arbol.insertar(10);
        arbol.insertar(16);
        arbol.insertar(7);
        arbol.insertar(11);
        arbol.insertar(19);
        arbol.insertar(20);
        System.out.println("arbol :"+arbol.toString());
        System.out.println("altura :" + arbol.altura());
        System.out.println("cant de elementos :" + arbol.elementos());
        System.out.println("Mayor valor: " + arbol.mayorValor()); 
        System.out.println("Menor valor: " + arbol.menorValor()); 
        arbol.borrar(20);
        System.out.println("despues de borrar el 20 :"+arbol.toString());
        //System.out.println("Sucesor: " + arbol.sucesor(10));
        //System.out.println("Predecesor: " + arbol.predecesor(10));
    }
}
