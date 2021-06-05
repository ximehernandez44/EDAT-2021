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
 * @author Ximena Hernandez, Santiago Bricenio
 */
public class ArbolGen {

    private NodoGen raiz;

    public ArbolGen() {
        raiz = null;
    }

    public boolean insertar(Object elemNuevo, Object elemPadre) {
        //agrega elemNuevo como hijo de la primera aparicion de elemPadre.
        //Devuelve verdadero si se pudo agregar y falso en caso contrario
        boolean exito = true;

        if (esVacio()) {
            //si esta vacio, lo pone en la raiz
            this.raiz = new NodoGen(elemNuevo);
        } else {
            //busca el padre
            NodoGen padre = obtenerNodo(this.raiz, elemPadre);
            if (padre != null) {
                NodoGen hijoIzq = padre.getHijoIzquierdo();
                //si no tiene hijo izquierdo, lo pone ahi
                if (hijoIzq == null) {
                    padre.setHijoIzquierdo(new NodoGen(elemNuevo));
                } else {
                    //va recorriendo los hijos derechos hasta que haya un enlace nulo, y lo coloca en el ultimo lugar
                    while (hijoIzq.getHermanoDerecho() != null) {
                        hijoIzq = hijoIzq.getHermanoDerecho();
                    }
                    hijoIzq.setHermanoDerecho(new NodoGen(elemNuevo));
                }
            } else {
                exito = false;
            }
        }
        return exito;
    }

    private NodoGen obtenerNodo(NodoGen n, Object buscado) {
        //metodo privado que busca un elemento y devuelve el nodo que lo contiene. Si no se encuentra devuelve null
        
        NodoGen resultado = null;
        if (!esVacio()) {
            if (n != null) {
                if (n.getElem().equals(buscado)) {
                    //si el resultado es n, lo devuelve
                    resultado = n;
                } else {
                    //no es el buscado, busca primero en el hijo izquierdo
                    resultado = obtenerNodo(n.getHijoIzquierdo(), buscado);
                    
                    //si no lo encuentra en el hijo izquierdo, busca en sus hermanos derechos
                    if (resultado == null) {
                        resultado = obtenerNodo(n.getHermanoDerecho(), buscado);
                    }
                }
            }
        }
        return resultado;
    }

    public boolean pertenece(Object elemento) {
        //devuelve verdadero si el elemento pasado por parametro esta en el arbol
        //y falso en caso contrario
        boolean exito = false;
        if (!esVacio()) {
            if (obtenerNodo(this.raiz, elemento) != null) {
                exito = true;
            }
        }
        return exito;
    }

    public Lista ancestros(Object elem) {
        //devuelve una lista con los ancestros del elemento ingresado
        Lista lis = new Lista();

        if (!this.raiz.getElem().equals(elem)) {
            //Si la raiz es el elemento buscado, no hay ancestros
            buscarAncestros(this.raiz, elem, lis, 1);
        }

        return lis;
    }

    private boolean buscarAncestros(NodoGen nodo, Object elem, Lista lis, int pos) {
        boolean encontrado = false;

        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                encontrado = true;
            }

            if (!encontrado) {
                lis.insertar(nodo.getElem(), pos);
                NodoGen hijo = nodo.getHijoIzquierdo();

                while (hijo != null && !encontrado) {
                    encontrado = buscarAncestros(hijo, elem, lis, pos + 1);
                    if (!encontrado) {
                        //si no lo encontro buscando por el hijo izquierdo, busca por los hermanos derechos
                        hijo = hijo.getHermanoDerecho();
                    }
                }
                if (!encontrado) {
                    //si ese nodo ni sus hijos son ancestros del nodo buscado, los va quitando de la lista
                    lis.eliminar(pos);
                }
            }
        }
        return encontrado;
    }

    public boolean esVacio() {
        return raiz == null;
    }

    public int altura() {
        //devuelve la altura del arbol. Si esta vacio devuelve -1
        int resultado;
        resultado = -1;

        if (this.raiz != null) {
            resultado = alturaAux(this.raiz, -1);
        }
        return resultado;
    }

    private int alturaAux(NodoGen nodo, int altura) {
        int izq, der;

        if (nodo != null) {
            izq = alturaAux(nodo.getHijoIzquierdo(), altura) + 1;
            der = alturaAux(nodo.getHermanoDerecho(), altura);

            if (izq > der) {
                altura = izq;
            } else {
                altura = der;
            }
        }
        return altura;
    }

    public int nivel(Object elem) {
        //devuelve el nivel de un elemento en el arbol. Si no esta devuelve -1
        return nivelAux(this.raiz, elem, -1);
    }

    private int nivelAux(NodoGen nodo, Object elem, int nivel) {
        int encontrado = -1;
        NodoGen hijo;

        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                encontrado = nivel + 1;
            } else {
                hijo = nodo.getHijoIzquierdo();
                while (encontrado == -1 && hijo != null) {
                    encontrado = nivelAux(hijo, elem, nivel + 1);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return encontrado;
    }
    ////////NIVEL SANTI//////////
    /*public int nivel(Object elem) {
        return nivelAux(this.raiz, elem);
    }

    private int nivelAux(NodoGen nodo, Object elem) {
        int nivel = -1;
        
        if (nodo != null) {
            if (nodo.getElem().equals(elem)) {
                nivel = 0;
            } else {
                nivel = nivelAux(nodo.getHermanoDerecho(), elem);
                if (nivel == -1) {
                    nivel = nivelAux(nodo.getHijoIzquierdo(), elem) + 1;
                }
            }
        }
        return nivel;
    }*/
    //////NIVEL MIO/////////
    /*public int nivel(Object elem) {
        //devuelve el nivel de un elemento en el arbol. Si no esta devuelve -1
        int nivel = -1;

        if (this.raiz != null) {
            if (elem == this.raiz.getElem()) {
                nivel = 0;
            } else {
                //nivel = nivelAux(elem, this.raiz);
            }
        }
        return nivel;
    }*/

 /*public int nivelAux(Object elem, NodoGen n) {
        int res = -1;

        if (n != null) {
            if (n.getElem().equals(elem)) {
                res = 0;
            } else {
                NodoGen hijoIzq = n.getHijoIzquierdo();
                res = nivelAux(elem, hijoIzq);
                //si no lo encuentra en el hijo izquierdo, busca en los hermanos derechos
                if (res == -1) {
                    res = nivelAux(elem, hijoIzq.getHermanoDerecho());
                }
                if (res != -1) {
                    res++;
                }
            }
        }
        return res;
    }*/
    ///////PADRE MIO/////////
    /*public Object padre(Object elem) {
        Object ret;
        if (esVacio()) {
            ret = null; 
        } else {
            ret = padreAux(this.raiz, elem);
        }
        return ret;
    }

    private Object padreAux(NodoGen nodo, Object elem) {
        Object padre = null;
        NodoGen hijo;

        if (nodo != null && nodo.getHijoIzquierdo() != null) {
            if (this.raiz.getElem().equals(elem)) {
                //si la raiz es el elemento, no tiene padre y termina
                padre = null;
                
            } else {
                hijo = nodo.getHijoIzquierdo();
                while (hijo != null && padre == null) { //mientras el hijo exista y no se haya encontrado el padre
                    if (hijo.getElem().equals(elem)) {
                        padre = nodo.getElem();
                    }
                    hijo = hijo.getHermanoDerecho();
                }

                //si no se encuentra, se llama a los hijos
                if (padre == null) {
                    hijo = nodo.getHijoIzquierdo();
                    while (padre == null && hijo != null) {
                        padre = padreAux(hijo, elem);
                        hijo = hijo.getHermanoDerecho();
                    }
                }
            }
        }
        return padre;
    }*/
    /////////////PADRE SANTI////////////////7
    public Object padre(Object hijo) {
        //devuelve el padre del elemento ingresado
        
        Object elemPadre = null;

        if (!esVacio() && !this.raiz.getElem().equals(hijo)) {
            //si es vacio o si la raiz es igual al elemento, entra al metodo recursivo
            //si la raiz es igual al elemento, el padre debe ser nulo porque no tiene padre

            elemPadre = padreAux(this.raiz, hijo, this.raiz.getElem());
        }

        return elemPadre;
    }

    private Object padreAux(NodoGen nodo, Object hijo, Object padreElem) {
        Object ret = null;

        if (nodo != null) {
            if (nodo.getElem().equals(hijo)) {
                ret = padreElem;

            } else {
                //busca el elemento por los hermanos derechos de nodo
                ret = padreAux(nodo.getHermanoDerecho(), hijo, padreElem);

                if (ret == null) {
                    //si no lo encuentra, busca por el hijo izquierdo de nodo
                    ret = padreAux(nodo.getHijoIzquierdo(), hijo, nodo.getElem());
                }
            }
        }
        return ret;
    }

    public Lista listarPreorden() {
        //Devuelve una lista con los elementos del arbol en recorrido preorden
        Lista salida = new Lista();
        listarPreordenAux(this.raiz, salida);
        return salida;
    }

    private void listarPreordenAux(NodoGen n, Lista ls) {

        if (n != null) {
            ls.insertar(n.getElem(), ls.longitud() + 1);

            if (n.getHijoIzquierdo() != null) {
                listarPreordenAux(n.getHijoIzquierdo(), ls);
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPreordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }

        }
    }

    public Lista listarInorden() {
        //Devuelve una lista con los elementos del arbol en el recorrido en inorden
        Lista salida = new Lista();
        listarInordenAux(this.raiz, salida);
        return salida;
    }

    private void listarInordenAux(NodoGen n, Lista ls) {
        if (n != null) {
            //llamado recursivo con primer hijo de n
            if (n.getHijoIzquierdo() != null) {
                listarInordenAux(n.getHijoIzquierdo(), ls);
            }

            //visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);

            //llamados recursivos con los otros hijos de n
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarInordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }

    public Lista listarPosorden() {
        // Devuelve una lista con los elementos del arbol en el recorrido en posorden
        Lista salida = new Lista();

        listarPosordenAux(this.raiz, salida);

        return salida;
    }

    private void listarPosordenAux(NodoGen n, Lista ls) {

        if (n != null) {
            // llamado recursivo con n
            if (n.getHijoIzquierdo() != null) {
                listarPosordenAux(n.getHijoIzquierdo(), ls);
            }

            // llamados recursivos con los otros hijos de n
            if (n.getHijoIzquierdo() != null) {
                NodoGen hijo = n.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarPosordenAux(hijo, ls);
                    hijo = hijo.getHermanoDerecho();
                }
            }

            // visita del nodo n
            ls.insertar(n.getElem(), ls.longitud() + 1);
        }
    }

    public Lista listarPorNiveles() {
        // Devuelve una lista con los elementos del arbol en el recorrido por niveles
        Lista lis = new Lista();

        if (this.raiz != null) {
            listarPorNivelesAux(this.raiz, lis);
        }
        return lis;
    }

    private void listarPorNivelesAux(NodoGen nodo, Lista lis) {
        Cola q = new Cola();
        int i = 1;

        q.poner(nodo);

        while (!q.esVacia()) {
            nodo = (NodoGen) q.obtenerFrente();
            q.sacar();

            lis.insertar(nodo.getElem(), i);
            i++;

            nodo = nodo.getHijoIzquierdo();

            while (nodo != null) {
                q.poner(nodo);
                nodo = nodo.getHermanoDerecho();
            }
        }
    }

    @Override
    public ArbolGen clone() {
        //devuelve un clon
        ArbolGen clon = new ArbolGen();

        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }

        return clon;
    }

    private NodoGen cloneAux(NodoGen n) {
        NodoGen nuevo = null;

        if (n != null) {
            nuevo = new NodoGen(n.getElem());
            nuevo.setHijoIzquierdo(cloneAux(n.getHijoIzquierdo()));
            nuevo.setHermanoDerecho(cloneAux(n.getHermanoDerecho()));
        }
        return nuevo;
    }

    public void vaciar() {
        //quita todos los elementos de la estructura
        this.raiz = null;
    }
    
    public int grado(){
        //devuelve la cantidad maxima de nodos que posee el arbol
        int resultado = -1;
        
        if(!esVacio()){
            resultado = gradoAux(this.raiz, 0);
        }
        
        return resultado;
    }
    
    public int gradoSubarbol(Object elem){
        //devuelve la cantdad maxima de nodos que posee el subarbol del elemento ingresado
        int resultado = -1;
        NodoGen nodo = obtenerNodo(this.raiz, elem);

        if(nodo != null){
            resultado = gradoAux(nodo, 0);
        }
        return resultado;
    }
    
    private int gradoAux(NodoGen nodo, int res){
        NodoGen hijo;
        int aux = 0;

        if(nodo != null){
            hijo = nodo.getHijoIzquierdo();
            if(hijo != null){
                while(hijo != null){
                    aux++;
                    res = gradoAux(hijo, res);
                    if(aux > res){
                        res = aux;
                    }
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
        return res;
    }
    

    @Override
    public String toString() {
        return toStringAux(this.raiz);
    }

    private String toStringAux(NodoGen n) {
        String s = "";
        if (n != null) {
            //visita del nodo n
            s += n.getElem().toString() + " -> ";
            NodoGen hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += hijo.getElem().toString() + ", ";
                hijo = hijo.getHermanoDerecho();
            }

            //comienza recorrido de los hijos de n llamando recursivamente
            //para que cada hijo agregue su cadena a la general
            hijo = n.getHijoIzquierdo();
            while (hijo != null) {
                s += "\n" + toStringAux(hijo);
                hijo = hijo.getHermanoDerecho();
            }

        }
        return s;
    }
    public Lista listarEntreNiveles(int niv1, int niv2) {
        /*
         * Recibe como parámetro dos elementos niv1 y niv2 y devuelve una lista con los
         * elementos del árbol que están entre los niveles niv1 y niv2 inclusive.
         */
        Lista lis = new Lista();
        if (!esVacio()) {
            listarEntreNivelesAux(this.raiz, niv1, niv2, lis, 0);
        }
        return lis;
    }

    private void listarEntreNivelesAux(NodoGen nodo, int niv1, int niv2, Lista lis, int nivActual) {
        if (nodo != null) {
            // Llamado recursivo con primer llamado de nodo.
            if (nodo.getHijoIzquierdo() != null) {
                listarEntreNivelesAux(nodo.getHijoIzquierdo(), niv1, niv2, lis, nivActual++);
            }
            // Visita del nodo.
            if (nivActual >= niv1 && nivActual <= niv2) {
                lis.insertar(nodo.getElem(), lis.longitud() + 1);
            }
            // Llamados recursivos con los otros hijos de nodo.
            if (nodo.getHijoIzquierdo() != null) {
                NodoGen hijo = nodo.getHijoIzquierdo().getHermanoDerecho();
                while (hijo != null) {
                    listarEntreNivelesAux(hijo, niv1, niv2, lis, nivActual++);
                    hijo = hijo.getHermanoDerecho();
                }
            }
        }
    }
}
