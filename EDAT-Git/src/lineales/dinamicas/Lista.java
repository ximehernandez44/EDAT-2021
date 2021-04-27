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
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera = null;
    }

    public boolean insertar(Object nuevoElem, int pos) {
        //inserta el elemento nuevo en la posicion pos
        //detecta y reporta error posicion invalida
        boolean exito = true;

        if ((pos < 1) || (pos > this.longitud() + 1)) {
            exito = false;
        } else {
            if (pos == 1) { //crea un nuevo nodo y se enlaza en la cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else { //avanza hasta el elemento en posicion pos - 1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        return exito;
    }

    public boolean eliminar(int pos) {
        //Borra el elemento de la posicion pos. La lista no debe estar
        //vacia, y la posicion recibida debe ser 1 <= pos <= long(lista)
        boolean exito = true;
        if (esVacia()) {
            exito = false;
        } else {
            if (pos < 1 || pos > this.longitud() + 1) {
                exito = false;
            } else {
                if (pos == 1) { //se actualiza la cabecera para q referencie al segundo nodo
                    this.cabecera = this.cabecera.getEnlace();
                } else {
                    Nodo aux = this.cabecera; //se avanza hasta la posicion pos - 1
                    int i = 1;
                    while (i < pos - 1) {
                        aux = aux.getEnlace();
                        i++;
                    } //se reconecta el nodo aux al que sigue del que sigue
                    aux.setEnlace(aux.getEnlace().getEnlace());
                }

            }
        }
        return exito;
    }

    public Object recuperar(int pos) {
        //Devuelve el elemento de la posicion pos
        Object s;
        if (pos < 1 || pos > this.longitud()) {
            //si la posicion no es valida, devuelve null
            s = null;
        } else {
            Nodo aux = this.cabecera; //se avanza hasta la posicion pos
            int i = 1;
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            s = aux.getElem();
        }
        return s;
    }

    public int localizar(Object elem) {
        //devuelve la posicion en la que se encuentra la primera ocurrencia de
        //elem dentro de la lista. En caso de no encontrarlo devuelve  -1.
        int pos = -1;
        int cont = 1;
        Nodo aux = this.cabecera;

        if (!esVacia()) {
            while (aux != null && pos == -1) {
                if (aux.getElem() == elem) {
                    pos = cont;
                }
                aux = aux.getEnlace();
                cont++;
            }
        }
        return pos;
    }

    public int longitud() {
        int pos = 1;
        Nodo aux = this.cabecera;

        if (esVacia()) {
            pos = 0;
        } else {
            while (aux.getEnlace() != null) {
                aux = aux.getEnlace();
                pos++;
            }
        }
        return pos;
    }

    public boolean esVacia() {
        //chequear
        return (this.cabecera == null);
    }

    public void vaciar() {
        this.cabecera = null;
    }

    @Override
    public Lista clone() {
        Lista clon = new Lista();

        if (!this.esVacia()) {
            Nodo copia = new Nodo(this.cabecera.getElem(), null);
            clon.cabecera = copia;
            Nodo original = this.cabecera.getEnlace();
            Nodo nuevo;

            while (original != null) {
                nuevo = new Nodo(original.getElem(), null);
                copia.setEnlace(nuevo);
                copia = copia.getEnlace();
                original = original.getEnlace();
            }
        }
        return clon;

    }

    @Override
    public String toString() {
        String s = "Lista vacia";
        Nodo aux = this.cabecera;

        if (!esVacia()) {
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

    public void invertir() {
        //invierte la estructura original
        Nodo aux = this.cabecera;
        invertirAux(aux);
    }

    private Nodo invertirAux(Nodo aux) {
        if (aux.getEnlace() == null) {
            //nada?
        } else {
            if (aux.getEnlace().getEnlace() != null) {
                invertirAux(aux.getEnlace());
                aux.getEnlace().setEnlace(aux);
            }
        }
        return aux;
    }

    /*public Lista invertir() {
        //devuelve una lista nueva con la estructura invertida
        Lista nueva = new Lista();
        int longitud = this.longitud(), pos, i;

        for (pos = 1; pos <= longitud; pos++) {
            Nodo nuevo = new Nodo(this.recuperar(pos), null);

            if (nueva.esVacia()) {
                nueva.cabecera = nuevo;
            } else {
                nuevo.setEnlace(nueva.cabecera);
                nueva.cabecera = nuevo;
            }

        }
    }*/

 /*eliminarApariciones(TipoElemento x): elimina todas las apariciones de elementos iguales a x,
haciendo un único recorrido de la estructura y sin usar otras operaciones del TDA. Ej: si L1=[1,2,1,3,4]
debe devolver [2,3,4]. En los casos de prueba considere que el elemento a eliminar puede estar repetido
varias veces en cualquier posición.*/
 /*public boolean eliminarApariciones(Object x) {
        int pos = 1;
        Nodo aux1 = this.cabecera;
        Nodo aux2 = this.cabecera;
        boolean exito = true;

        if (esVacia()) {
            exito = false;
        } else {
            while (aux1 != null) {
                if (aux1.getElem() == x) {
                    if (pos == 1) {
                        //si el elemento que se quiere sacar esta en la primera posicion, se actualiza la cabecera
                        this.cabecera = this.cabecera.getEnlace();
                    } else {
                        aux2.setEnlace(aux1.getEnlace());
                    }
                }
                if (pos == 1) {
                    //mantengo aux2 una posicion por detras de aux1
                    aux2 = this.cabecera;
                } else {
                    aux2 = aux2.getEnlace();
                }
                aux1 = aux1.getEnlace();
                pos++;
            }

        }
        return exito;
    }*/
    public void preCargar(Object[] arreglo) {
        //recibe un arreglo y lo carga en la lista

        for (int i = 0; i < arreglo.length; i++) {

            this.insertar(arreglo[i], i + 1);
        }
    }

    public Lista obtenerMultiplos(int num) {
        int i = 1;
        Lista lis = new Lista();
        boolean primera = false;

        if (!esVacia()) {
            Nodo copia = null;
            Nodo nuevo;
            Nodo aux = this.cabecera;

            while (aux != null) {
                if ((i % num) == 0) {
                    nuevo = new Nodo(aux.getElem(), null);
                    if (!primera) {
                        primera = true;
                        lis.cabecera = nuevo;
                        copia = new Nodo(aux.getElem(), null);
                    }
                    copia.setEnlace(nuevo);
                    copia = copia.getEnlace();
                }
                aux = aux.getEnlace();
                i++;
            }
        }
        return lis;
    }

    public void eliminarApariciones(Object x) {
        Nodo aux = this.cabecera;

        if (!esVacia()) {
            while (aux != null) {
                if (aux.getElem().equals(x)) {
                    this.cabecera = this.cabecera.getEnlace();
                } else {
                    if (aux.getEnlace().getElem().equals(x)) {
                        aux.setEnlace(aux.getEnlace().getEnlace());
                     
                    }                    
                }
                aux = aux.getEnlace();
            }
        }
    }

}
