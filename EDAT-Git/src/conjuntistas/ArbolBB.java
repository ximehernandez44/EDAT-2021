package conjuntistas;

import lineales.dinamicas.Lista;

public class ArbolBB {
    private NodoABB raiz;

    public ArbolBB() {
        this.raiz = null;
    }

    public boolean insertar(Comparable elemento) {
        boolean exito = true;
        if (this.raiz == null) {
            this.raiz = new NodoABB(elemento);
        } else {
            exito = insertarAux(this.raiz, elemento);
        }
        return exito;
    }

    private boolean insertarAux(NodoABB n, Comparable elemento) {
        // precondicion: n no es nulo
        boolean exito = true;

        if ((elemento.compareTo(n.getElem()) == 0)) {
            // Reportar error: Elemento repetido
            exito = false;
        } else if (elemento.compareTo(n.getElem()) < 0) {
            // elemento es menor que.getElem()
            // si tiene HI baja a la izquierda, sino agrega elemento
            if (n.getIzquierdo() != null) {
                exito = insertarAux(n.getIzquierdo(), elemento);
            } else {
                n.setIzquierdo(new NodoABB(elemento));
            }
        } else {
            // elemento es mayor que n.getElem()
            // si tiene HD baja a la derecha, sino agrega elemento
            if (n.getDerecho() != null) {
                exito = insertarAux(n.getDerecho(), elemento);
            } else {
                n.setDerecho(new NodoABB(elemento));
            }
        }
        return exito;
    }

   public boolean eliminar(Comparable elemento) {
        // Recibe un elemento que se desea eliminar y se procede a removerlo.
        // Devuelve verdadero si el elemento se encuentra y falso en caso contrario
        boolean exito = false;
        NodoABB n = this.raiz;
        NodoABB nodoElem = this.raiz;
        NodoABB padre = this.raiz;

        while (!exito && n != null) {
            if (elemento.compareTo(n) == 0) {
                // el elemento es igual
                exito = true;
                nodoElem = n;
            } else {
                if (elemento.compareTo(n.getElem()) < 0) {
                    // el elemento es menor a n, continua por el subarbol izquierdo
                    padre = n;
                    n = n.getIzquierdo();
                } else {
                    //el elemento es mayor a n, continua por el subarbol derecho
                    padre = n;
                    n = n.getDerecho();
                }
            }
        }

        if (exito) {
            if (nodoElem.getIzquierdo() == null && nodoElem.getDerecho() == null) {
                //no tiene hijos, es  hoja
                caso1(nodoElem, padre);
            } else {
                if (nodoElem.getIzquierdo() != null && nodoElem.getDerecho() == null) {
                    //tiene solo un hijo izquierdo
                    caso2(nodoElem, padre, 'I');
                } else {
                    if (nodoElem.getIzquierdo() == null && nodoElem.getDerecho() != null) {
                        //tiene solo un hijo derecho
                        caso2(nodoElem, padre, 'D');
                    } else {
                        //tiene ambos hijos
                        caso3(nodoElem);
                    }
                }
            }
        }

        return exito;
    }

    private void caso1(NodoABB elem, NodoABB padre) {

        if (elem.getElem().compareTo(padre.getElem()) < 0) {
            //el hijo es menor que el padre, es hijo izquierdo
            padre.setIzquierdo(null);
        } else {
            //el hijo es mayor que el padre, es hijo derecho
            padre.setDerecho(null);
        }
    }

    private void caso2(NodoABB elem, NodoABB padre, char pos) {

        if (elem.getElem().compareTo(padre.getElem()) < 0) {
            //el hijo es menor que el padre, es hijo izquierdo
            if (pos == 'I') {
                padre.setIzquierdo(elem.getIzquierdo());
            } else {
                padre.setIzquierdo(elem.getDerecho());
            }
        } else {
            //el hijo es mayor que el padre, es hijo derecho
            if (pos == 'I') {
                padre.setDerecho(elem.getIzquierdo());
            } else {
                padre.setDerecho(elem.getDerecho());
            }
        }
    }

    private void caso3(NodoABB elem) {
        NodoABB candidatoA = elem.getIzquierdo();
        NodoABB padre = elem.getIzquierdo();

        //candidato A: se baja al hijo izquierdo de N, y se mueve por enlaces
        //a la derecha hasta encontrar el nodo que no tenga hijo derecho
        while (candidatoA.getDerecho() != null) {
            padre = candidatoA;
            candidatoA = candidatoA.getDerecho();
        }

        //se cambia el valor del nodo de elem con ese valor encontrado
        elem.setElem(candidatoA.getElem());

        //se elimina el nodo hijo con caso 1 o 2
        if (candidatoA.getIzquierdo() == null && candidatoA.getDerecho() == null) {
            //no tiene hijos, es  hoja
            caso1(candidatoA, padre);
        } else {
            if (candidatoA.getIzquierdo() != null && candidatoA.getDerecho() == null) {
                //tiene solo un hijo izquierdo
                caso2(candidatoA, padre, 'I');
            } else {
                //tiene solo un hijo derecho
                caso2(candidatoA, padre, 'D');
            }
        }
    }

    public boolean pertenece(Comparable elemento) {
        // Devuelve verdadero si el elemento recibido por parametro esta en el arbol
        // y falso en caso contrario
        boolean exito = false;
        NodoABB n = this.raiz;
        while (n != null && exito == false) {
            if (elemento.compareTo(n) == 0) {
                // el elemento es igual
                exito = true;
            } else {
                if (elemento.compareTo(n.getElem()) < 0) {
                    // el elemento es menor a n, continua por el subarbol izquierdo
                    n = n.getIzquierdo();
                } else {
                    //el elemento es mayor a n, continua por el subarbol derecho
                    n = n.getDerecho();
                }
            }
        }
        return exito;
    }

    public boolean esVacio() {
        return this.raiz == null;
    }

    public void vaciar() {
        this.raiz = null;
    }

    public Lista listar() {
        // recorre el arbol completo y devuelve una lista ordenada con los elementos
        // almacenados
        Lista lis = new Lista();
        listarAux(this.raiz, lis);
        return lis;
    }

    private void listarAux(NodoABB nodo, Lista lis) {
        if (nodo != null) {
            listarAux(nodo.getIzquierdo(), lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarAux(nodo.getDerecho(), lis);
        }
    }

    public Lista listarRango(Comparable elemMinimo, Comparable elemMaximo) {
        // recorre parte del arbol y devuelve una lista ordenada con los elementos que
        // se encuentran en el intervalo [elemMinimo, elemMaximo]
        Lista lis = new Lista();
        listarRangoAux(this.raiz, elemMinimo, elemMaximo,lis);
        return lis;
    }

    private void listarRangoAux(NodoABB nodo, Comparable elemMinimo, Comparable elemMaximo, Lista lis) {
        //busca el elem minimo y guarda todos los elementos en inorden 
        //hasta que llega al elem maximo
        if (nodo != null && ((elemMinimo.compareTo(nodo.getElem())) < 0) || (elemMaximo.compareTo(nodo.getElem())> 0)) {
            listarRangoAux(nodo.getIzquierdo(), elemMinimo, elemMaximo, lis);
            lis.insertar(nodo.getElem(), lis.longitud() + 1);
            listarRangoAux(nodo.getDerecho(), elemMinimo, elemMaximo, lis);
        }
    }

    public Object minimoElem() {
        // devuelve el elemento mas pequenio almacenado
        NodoABB ret = this.raiz;

        while (ret.getIzquierdo() != null) {
            ret = ret.getIzquierdo();
        }
        return ret.getElem();
    }

    public Object maximoElem() {
        // devuelve el elemento mas grande almacenado
        NodoABB ret = this.raiz;

        while (ret.getDerecho() != null) {
            ret = ret.getDerecho();
        }
        return ret.getElem();
    }

    public ArbolBB clone() {
        // devuelve un clon de la estructura original
        ArbolBB clon = new ArbolBB();
        if (this.raiz != null) {
            clon.raiz = cloneAux(this.raiz);
        }

        return clon;
    }

    private NodoABB cloneAux(NodoABB n) {
        NodoABB nuevo = null;

        if (n != null) {
            nuevo = new NodoABB(n.getElem());
            if (n.getIzquierdo() != null) {
                nuevo.setIzquierdo(cloneAux(n.getIzquierdo()));
            }
            if (n.getDerecho() != null) {
                nuevo.setDerecho(cloneAux(n.getDerecho()));
            }
        }
        return nuevo;
    }

    public String toString() {
        // devuelve una cadena con el contenido delarbol
        String cad = "[";

        if (this.raiz == null) {
            cad = "Arbol vacio";
        } else {
            cad = toStringAux(this.raiz, "");
        }
        return cad;
    }

    private String toStringAux(NodoABB nodo, String cad) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null) {
                // si existe el hijo izquierdo, lo agrega a la cadena
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
}
