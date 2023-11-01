package colecciones.arbol;

import java.util.Comparator;
import java.util.List;


import java.util.LinkedList;

/**
 * Árbol binario de busqueda (ABB), es una implementación de {@code Diccionario} mediante nodos encadenados que preserva las propiedades de Diccionario.
 * @param <T> Tipo del valor asociado a los nodos del árbol, debe ser posible definir un orden total para los mismos.
 * @see NodoBinario
 */
public class ABB<T> implements Diccionario<T> {

    private NodoBinario<T> raiz;

    /**
     * Comparador usado para mantener el orden en un ABB, o null.
     */
    private final Comparator<? super T> comparador;

    /**
     * Construye un nuevo árbol vacío ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     */
    public ABB(Comparator<? super T> comparador) {
        this.comparador = comparador;
        this.raiz = null;
    }

    /**
     * Construye un nuevo árbol con un elemento en la raiz, ordenado acorde al comparador dado.
     * @param comparador define una forma de comparar los valores insertados en el arbol.
     * @param valor de la raiz del nuevo arbol si no es null.
     */
    public ABB(Comparator<? super T> comparador, T valor) {
        this.comparador = comparador;
        this.raiz = new NodoBinario<>(valor);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void insertar(T elem) {
        if (this.pertenece(elem)) {
            throw new IllegalArgumentException("El elemento ya se encuentra en el árbol");
        }
        
        if (raiz == null) {
            this.raiz = new NodoBinario<>(elem);
        }else{
            NodoBinario<T> newRaiz = raiz;
            this.insRec(elem, newRaiz);
        }
    }

    private NodoBinario<T> insRec(T elem, NodoBinario<T> newRaiz) {
        if (newRaiz == null) {
            newRaiz = new NodoBinario<>(elem);
            return newRaiz;
        }
        int cmp = comparador.compare(elem, newRaiz.getValor());
        if (cmp == 0) {
             return newRaiz;
        }
        if (cmp < 0) {
            newRaiz.setIzquierdo(insRec(elem, newRaiz.getIzquierdo()));
        } else {
            newRaiz.setDerecho(insRec(elem, newRaiz.getDerecho()));
        }
        return newRaiz;
    }


    /**
     * {@inheritDoc}
     */
    public boolean pertenece(T elem) {
        if (this.raiz == null) {
            return false;
        }
        return this.perteneceRecursivo(raiz,elem);
    }

    private boolean perteneceRecursivo (NodoBinario<T> newRaiz,T elem){
        if (newRaiz == null) {
            return false;
        }
        int cmp = comparador.compare(newRaiz.getValor(),elem);
        if (cmp == 0) {
            return true;
        }
        if (cmp > 0) {
            return this.perteneceRecursivo(newRaiz.getIzquierdo(),elem);
        } else {
            return this.perteneceRecursivo(newRaiz.getDerecho(), elem);
        }
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void borrar(T elem) {
        this.borrarRec(raiz,elem);
    }

    private boolean borrarRec(NodoBinario<T> nodo, T elem){
        int cmp = comparador.compare(nodo.getValor(),elem);
        if (cmp == 0) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
                nodo = null;
                return true;
            }
            if (nodo.getIzquierdo() == null && nodo.getDerecho() != null) {
                nodo = nodo.getDerecho();
                return true;
            }

            if (nodo.getIzquierdo() != null && nodo.getDerecho() == null) {
                nodo = nodo.getIzquierdo();
                return true;
            }

            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                nodo = nodo.getDerecho();
                return true;
            }
        }
        if (cmp > 0) {
            return this.borrarRec(nodo.getIzquierdo(), elem);
        }
        if (cmp < 0) {
            return this.borrarRec(nodo.getDerecho(), elem);
        }
        return true;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void vaciar() {
        raiz = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T raiz() {
        return raiz.getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolIzquierdo() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Diccionario<T> subArbolDerecho() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int elementos() {
        return this.elementosRecursivo(this.raiz) ;
    }

    private int elementosRecursivo (NodoBinario<T> nuevaRaiz){
        if(nuevaRaiz == null){
            return 0;
        }
        return 1 + elementosRecursivo(nuevaRaiz.getIzquierdo()) + elementosRecursivo(nuevaRaiz.getDerecho());
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public int altura() {
        return this.altRec(this.raiz);
    }

    private int altRec(NodoBinario<T> nuevaRaiz){
        if(nuevaRaiz == null){
            return 0;
        }
        return 1 + Math.max(altRec(nuevaRaiz.getIzquierdo()),altRec(nuevaRaiz.getDerecho()));
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean esVacio() {
        return this.raiz == null;
    }

    /**
     * {@inheritDoc}
     */
    public T mayorValor(){
        if (this.esVacio()) {
            throw new IllegalStateException("el arbol es null o vacío");
        }
        NodoBinario<T> nuevaRaiz = raiz;
                
        while (nuevaRaiz.getDerecho().getDerecho() != null) {
            nuevaRaiz = nuevaRaiz.getDerecho();
        }
        return nuevaRaiz.getDerecho().getValor(); 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T menorValor() {
        if (this.raiz == null) {
            throw new IllegalStateException("el arbol es null o vacío");
        }
        NodoBinario<T> nuevaRaiz = raiz;
        while (nuevaRaiz.getIzquierdo().getIzquierdo() != null) {
            nuevaRaiz = nuevaRaiz.getIzquierdo();
        }
        return nuevaRaiz.getIzquierdo().getValor();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T sucesor(T elem) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public T predecesor(T elem) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean repOK() {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        String result = "";
        if (this.esVacio()) {
            result = "{}";
        }
        result = String.valueOf(this.aLista());
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object other) {
        throw new UnsupportedOperationException("TODO: implementar");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista() {
        return aLista(Orden.INORDER);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<T> aLista(Orden orden) {
        List<T> elementos = new LinkedList<>();
        switch (orden) {
            case INORDER:
                return aListaInOrder(raiz, elementos);
            case PREORDER:
                return aListaPreOrder(raiz, elementos);
            case POSTORDER:
                return aListaPostOrder(raiz, elementos);
        }
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido in order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaInOrder(NodoBinario<T> raiz, List<T> elementos) {
        if(raiz.getIzquierdo() != null){
            aListaInOrder(raiz.getIzquierdo(), elementos);
        }
        
        elementos.add(raiz.getValor());
        
        if(raiz.getDerecho() != null){
            aListaInOrder(raiz.getDerecho(), elementos);
        }
        
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido pre order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPreOrder(NodoBinario<T> raiz, List<T> elementos) {
        elementos.add(raiz.getValor());
        
        if(raiz.getIzquierdo() != null){
            aListaInOrder(raiz.getIzquierdo(), elementos);
        }
        
        if(raiz.getDerecho() != null){
            aListaInOrder(raiz.getDerecho(), elementos);
        }
        
        return elementos;
    }

    /* (non-Javadoc)
     * Este método toma un nodo (que puede ser null), una lista de elementos (que no puede ser null)
     * y va llenando la lista con los elementos del árbol según un recorrido post order.
     * Si bien el prefil está pensando para una implementación recursiva, puede probar con una implementación iterativa.
     */
    private List<T> aListaPostOrder(NodoBinario<T> raiz, List<T> elementos) {
        if(raiz.getIzquierdo() != null){
            aListaInOrder(raiz.getIzquierdo(), elementos);
        }
        
        if(raiz.getDerecho() != null){
            aListaInOrder(raiz.getDerecho(), elementos);
        }
        
        elementos.add(raiz.getValor());

        return elementos;
    }


}
