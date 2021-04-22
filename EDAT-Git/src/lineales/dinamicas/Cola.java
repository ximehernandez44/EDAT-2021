/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author ximeh
 */
public class Cola {

    private Nodo frente;
    private Nodo fin;

    public Cola() {
        this.frente = null;
        this.fin = null;
    }

    public boolean poner(Object nuevoElem) {
        //crea un nuevo nodo
        Nodo nuevo = new Nodo(nuevoElem, null);

        //si la cola esta vacia, frente apunta al nodo nuevo
        if (this.frente == null) {
            this.frente = nuevo;
            this.fin = nuevo;
        } else {
            //conecta el nodo nuevo al ultimo
            this.fin.setEnlace(nuevo);
            //apunta fin al nodo nuevo
            this.fin = nuevo;
        }
        return true;
    }
    
    public boolean sacar() {
        boolean exito = true;

        if (this.frente == null) //la cola esta vacia, reporta error
        {
            exito = false;
        } else {
            //al menos hay un elemento:
            //quita el primer elemento y actualiza frente (y fin si queda vacio)
            this.frente = this.frente.getEnlace();
            if (this.frente == null) {
                this.fin = null;
            }
        }

        return exito;
    }

    public Object obtenerFrente() {
        //devuelve el objeto que esta en tope, es null si esta vacia
        Object s;
        if (esVacia()) {
            s = null;
        } else {
            s = this.frente.getElem();
        }
        return s;
    }

    public boolean esVacia() {
        return (this.frente == null);
    }

    public void vaciar() {
        this.frente = null;
        this.fin = null;
    }

    @Override
    public Cola clone() {

        Cola colaClon = new Cola();
        
        if (!this.esVacia()) {
        Nodo nodoClon = new Nodo(this.frente.getElem(), null);
        colaClon.frente = nodoClon;
        Nodo nodoOriginal = this.frente.getEnlace();
        Nodo nodoNuevo;

        while (nodoOriginal != null) {
            nodoNuevo = new Nodo(nodoOriginal.getElem(), null);
            colaClon.fin = nodoNuevo;
            nodoClon.setEnlace(nodoNuevo);
            nodoClon = nodoClon.getEnlace();
            nodoOriginal = nodoOriginal.getEnlace();
        }
        
        }
        return colaClon;
    }

    @Override
    public String toString() {
        String s;

        if (this.frente == null) {
            s = "Pila vacia";
        } else {
            //se ubica para recorrer la pila
            Nodo aux = this.frente;
            s = "[";

            while (aux != null) {
                s += aux.getElem();
                aux = aux.getEnlace();
                if (aux != null) {
                    s += ", ";
                }
            }
            s += "]";
        }
        return s;
    }
}
