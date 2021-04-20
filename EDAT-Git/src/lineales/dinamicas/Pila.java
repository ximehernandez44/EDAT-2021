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
public class Pila {

    private Nodo tope;

    public Pila() {
        this.tope = null;
    }

    public boolean apilar(Object nuevoElem) {
        //crea un nuevo nodo delante de la antigua cabecera
        Nodo nuevo = new Nodo(nuevoElem, this.tope);

        //actualiza el tope para que apunte al nodo nuevo
        this.tope = nuevo;

        //nunca hay error de pila llena, entonces devuelve true
        return true;
    }

    public boolean desapilar() {
        //quita el nodo del tope, devuelve true si se pudo quitar y false si la pila estaba vacia
        boolean exito;

        if (this.tope == null) //Error: pila vacia
        {
            exito = false;
        } else {
            //quita el elemento que esta en tope y decrementa tope
            this.tope = tope.getEnlace();
            exito = true;
        }
        return exito;
    }

    public Object obtenerTope() {
        //devuelve el objeto que esta en tope, null si esta vacia
        
        Object s;
        if (esVacia()) {
            s = null;
        } else {
            s = this.tope.getElem();
        }
        return s;
    }

    public boolean esVacia() {
        //devuelve un boolean indicando si la pila esta vacia
        return (this.tope == null);
    }

    public void vaciar() {
        //vacia la pila
        this.tope = null;
    }

    @Override
    public Pila clone() {
        //crea una pila nueva con una copia de los elementos
       
        Pila clon = new Pila();
        if (!this.esVacia()) {
        Nodo nuevo;
        Nodo copia = new Nodo(this.tope.getElem(), null);   //nuevo nodo que copia el elem del tope
        clon.tope = copia;                                  //le asigno al tope de la pila clonada este nuevo nodo copia
        Nodo original = this.tope.getEnlace();              //asigno el nodo siguiente de la pila original a un auxiliar

        while (original != null) {                          //recorro las pilas y asigno el resto de los nodos
            nuevo = new Nodo(original.getElem(), null);
            copia.setEnlace(nuevo);                         //asigno a la pila clon el enlace al nodo nuevo
            copia = copia.getEnlace();                      //muevo copia al nodo nuevo
            original = original.getEnlace();                //avanzo de posicion en la pila original
        }
        }

        return clon;
    }
    
    @Override
    public String toString() {
        String s;

        if (this.tope == null) {
            s = "Pila vacia";
        } else {
            //se ubica para recorrer la pila
            Nodo aux = this.tope;
            s = "[";

            while (aux != null) {
                //agrega el texto del elem y avanza
                s += aux.getElem().toString();
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
