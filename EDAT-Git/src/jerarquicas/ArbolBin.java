/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jerarquicas;

import lineales.dinamicas.Lista;
import lineales.dinamicas.Cola;

/**
 *
 * @author Xime Hernandez
 */
public class ArbolBin {

    private NodoArbol raiz;

    public ArbolBin() {
        this.raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre, char lugar) {
        /* Inserta elemNuevo como hijo del primer nodo encontrado en preorden igual
        a elemPadre, como hijo izquierdo (I) o derecho (D), segun lo indique el
        parametro lugar
         */
        boolean exito = true;

        if (this.raiz == null) {
            //si el arbol esta vacio, ponemos el elem nuevo en la raiz
            this.raiz = new NodoArbol(elemNuevo);
        } else {
            //si no esta vacio, se busca al padre
            NodoArbol nodoPadre = obtenerNodo(this.raiz, elemPadre);
            if (nodoPadre != null) {
                if (lugar == 'I' && nodoPadre.getIzquierdo() == null) {
                    //si el padre existe y no tiene HI se lo agrega
                    nodoPadre.setIzquierdo(new NodoArbol(elemNuevo));
                } else {
                    if (lugar == 'D' && nodoPadre.getDerecho() == null) {
                        //si el padre existe y no tiene HD se lo agrega
                        nodoPadre.setDerecho(new NodoArbol(elemNuevo));
                    } else {
                        //si el padre no existe o ya tiene los 2 hijos
                        exito = false;
                    }
                }
            } else {
                exito = false;
            }
        }
        return exito;

    }

    private NodoArbol obtenerNodo(NodoArbol n, Object buscado) {
        /*metodo privado que busca un elemento y devuelve el nodo que
        lo contiene. Si no se encuentra devuelve null*/

        NodoArbol resultado = null;
        if (n != null) {
            if (n.getElem().equals(buscado)) {
                //si el resultado es n, lo devuelve
                resultado = n;
            } else {
                //no es el buscado, busca primero en el hijo izq
                resultado = obtenerNodo(n.getIzquierdo(), buscado);
                //si no lo encuentra en el hijo izquierdo, busca en el der
                if (resultado == null) {
                    resultado = obtenerNodo(n.getDerecho(), buscado);
                }
            }
        }
        return resultado;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public int altura() {
        //devuelve la altura del arbol, es decir, la long
        //del camino mas largo desde la raiz hasta una hoja
        //Nodo vacio: -1, hoja: 0

        int res;
        if (this.raiz == null) {
            //el arbol esta vacio
            res = -1;
        } else {
            res = alturaAux(this.raiz);
        }
        return res;
    }

    private int alturaAux(NodoArbol nodo) {
        int izq, der, res = 0;
        if (!esHoja(nodo) && nodo != null) {
            izq = alturaAux(nodo.getIzquierdo()) + 1;
            der = alturaAux(nodo.getDerecho()) + 1;

            if (izq >= der) {
                res = izq;
            } else {
                res = der;
            }
        }

        return res;
    }

    public int nivel(Object elem) {
        //Devuelve el nivel de elem en el arbol.
        //Si no existe devuelve -1
        int nivel = -1;
        
        if (this.raiz != null) {
        if (elem == this.raiz.getElem()) {
            nivel = 0;
        } else {
            nivel = nivelAux(elem, this.raiz);
        }
        }

        return nivel;

    }

    public int nivelAux(Object elem, NodoArbol n) {
        int res = -1;

        if (n != null) {
            if (n.getElem().equals(elem)) {
                res = 0;

            } else {
                res = nivelAux(elem, n.getIzquierdo());
                //si no lo encuentra en el hijo izquierdo, busca en el der
                if (res == -1) {
                    res = nivelAux(elem, n.getDerecho());
                }
                if (res != -1) {
                    res++;
                }
            }
        }
        return res;

    }

    
    public Object padre(Object elem) {
        Object padre = null;
        
        if (this.raiz != null) {
        if (elem == this.raiz.getElem()) {
            padre = this.raiz.getElem();
        } else {
            if (obtenerNodo(this.raiz, elem) != null) {
                padre = auxPadre(this.raiz, elem).getElem();
            }
        }
        }
        return padre;
    }

    private NodoArbol auxPadre(NodoArbol n, Object hijo) {
        NodoArbol resultado = null;
        // caso base, si la raiz es hoja o hijo derecho es igual a buscado o hijo izquierdo es igual a buscado 
        if (n != null && n.getDerecho() != null) {
        if (esHoja(n) || n.getDerecho().getElem() == hijo || n.getIzquierdo().getElem() == hijo) {
            resultado = n;
        } else { // si no

            resultado = auxPadre(n.getIzquierdo(), hijo); //busca en hijo izquierdo 
            if (resultado != null) {
                resultado = auxPadre(n.getDerecho(), hijo);
            }
        }
        }

        return resultado;
    }

    /*------------------ LISTAR --------------------*/
    public Lista listarPreorden() {
        //retorna una lista con los elementos del arbol en preorden
        Lista lis = new Lista();
        listarPreordenAux(this.raiz, lis);
        return lis;
    }

    private void listarPreordenAux(NodoArbol nodo, Lista lis) {
        //metodo recursivo privado

        if (nodo != null) {
            //visita el elemento en el nodo
            lis.insertar(nodo.getElem(), lis.longitud() + 1); //1

            //recorre a sus hijos en preorden
            listarPreordenAux(nodo.getIzquierdo(), lis);    //2
            listarPreordenAux(nodo.getDerecho(), lis);      //3
        }
    }

    public Lista listarInorden() {
        //devuelve una lista con los elementos en recorrido inorden
        Lista lis = new Lista();
        listarInordenAux(this.raiz, lis);
        return lis;
    }

    private void listarInordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            listarInordenAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarInordenAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarPosorden() {
        //devuelve una lista con los elementos en recorrido posorden
        Lista lis = new Lista();
        listarPosordenAux(this.raiz, lis);
        return lis;
    }
    
    private void listarPosordenAux(NodoArbol nodo, Lista lis) {
        if (nodo != null) {
            listarPosordenAux(nodo.getIzquierdo(), lis);
            listarPosordenAux(nodo.getDerecho(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
        }
    }
    
    public Lista listarPorNiveles() {
        //devuelve una lista con los elementos en recorrido por niveles
        Cola q = new Cola();
        Lista res = new Lista();
        NodoArbol nodoActual;

        if (this.raiz != null) {
            q.poner(this.raiz);

            while (!q.esVacia()) {
                nodoActual = (NodoArbol) q.obtenerFrente();
                q.sacar();
                res.insertar(nodoActual.getElem(), res.longitud() + 1);

                if (nodoActual.getIzquierdo() != null) {
                    q.poner(nodoActual.getIzquierdo());
                    if (nodoActual.getDerecho() != null) {
                        q.poner(nodoActual.getDerecho());
                    }
                }
            }
        }
        return res;
    }

    public ArbolBin clone() {
        //devuelve un clon
        ArbolBin clon = new ArbolBin();
        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }
        
        return clon;
    }
    
    private NodoArbol cloneAux(NodoArbol n) {
        NodoArbol nuevo = null;
        
        if (n != null) {
            nuevo = new NodoArbol(n.getElem());
        if (n.getIzquierdo() != null) {
            nuevo.setIzquierdo(cloneAux(n.getIzquierdo()));
        }
        if (n.getDerecho() != null) {
            nuevo.setDerecho(cloneAux(n.getDerecho()));
        }
        }
        return nuevo;
    }
    
     
    public void vaciar() {
        //Quita todos los elementos de la estructura
        this.raiz = null;
    }

    @Override
    public String toString() {
        //Devuelve una cadena de caracteres que indica cual es la raiz
        //del arbol y quienes son los hijos de cada nodo        
        String cad;
        if (this.raiz == null) {
            cad = "Arbol vacio";
        } else {
            cad = toStringAux(this.raiz, "");
        }
        return cad;
    }

    private String toStringAux(NodoArbol nodo, String cad) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
            //si existe el hijo izquierdo, lo agrega a la cadena
                    cad += "\n" + nodo.getElem() + "     HI: " + nodo.getIzquierdo().getElem();
            } else {
                    cad += "\n" + nodo.getElem() + "     HI: - ";
            }
            if (nodo.getDerecho() != null) {
                    cad += "     HD: " + nodo.getDerecho().getElem();
            } else {
                cad += "      HD:  - ";
            }
            
            if (nodo.getIzquierdo() != null) {
            cad = toStringAux(nodo.getIzquierdo(), cad);
            }
            if (nodo.getDerecho() != null) {
            cad = toStringAux(nodo.getDerecho(), cad);
            }
        }
        return cad;
    }

    //---------------------- EXTRAS ---------------------------
    
    private boolean esHoja(NodoArbol nodo) {
        boolean exito = false;
        if (nodo != null) {
            exito = (nodo.getDerecho() == null && nodo.getIzquierdo() == null);
        }
        return exito;
    }

    /*frontera() que devuelve una lista con la frontera del árbol. Se dene frontera
de un árbol, la secuencia formada por los elementos almacenados en las hojas del árbol, tomadas de
izquierda a derecha.*/
}
