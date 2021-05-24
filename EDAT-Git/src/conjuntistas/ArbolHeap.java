/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conjuntistas;

/**
 *
 * @author Xime Hernandez
 */
public class ArbolHeap {

    private static final int TAMANIO = 14;
    private Comparable[] heap;
    private int ultimo = 0;

    public ArbolHeap() {
        this.heap = new Comparable[this.TAMANIO];
    }

    public boolean insertar(Comparable elem) {
        boolean exito;
        if (this.ultimo + 1 > TAMANIO) {
            //el arreglo esta completo
            exito = false;
        } else {
            this.ultimo++;
            this.heap[ultimo] = elem;

            if (!esVacio()) {
                hacerSubir(ultimo);
            }
            exito = true;
        }

        return exito;
    }

    private void hacerSubir(int posElem) {
        int posPadre = 1;
        boolean salir = false;

        while (!salir) {
            posPadre = posElem / 2;
            if (posPadre > 0) {
                Comparable temp = this.heap[posPadre];
                if (this.heap[posElem].compareTo(this.heap[posPadre]) < 0) {
                    //el nuevo elemento es menor que el padre, intercambio
                    this.heap[posPadre] = this.heap[posElem];
                    this.heap[posElem] = temp;
                    posElem = posPadre;

                } else {
                    //el padre es menor que su hijo
                    salir = true;
                }
            } else {
                //llega a la raiz
                salir = true;
            }
        }
    }

    public boolean eliminarCima() {
        boolean exito;
        if (this.ultimo == 0) {
            //estructura vacia
            exito = false;
        } else {
            //saca la raiz y pone la ultima hoja en su lugar
            this.heap[1] = this.heap[ultimo];
            this.ultimo--;
            //reestablece la propiedad de heap minimo
            hacerBajar(1);
            exito = true;
        }
        return exito;
    }

    private void hacerBajar(int posPadre) {
        int posH;
        Comparable temp = this.heap[posPadre];
        boolean salir = false;

        while (!salir) {
            posH = posPadre * 2;
            if (posH <= this.ultimo) {
                //temp tiene al menos un hijo (izq) y lo considera menor

                if (posH < this.ultimo) {
                    //hijoMenor tiene hermano derecho

                    if (this.heap[posH + 1].compareTo(this.heap[posH]) < 0) {
                        //el hijo derecho es el menor de los dos
                        posH++;
                    }
                }

                //compara al hijo menos con el padre
                if (this.heap[posH].compareTo(temp) < 0) {
                    //el hijo es menor que el padre, los intercambia
                    this.heap[posPadre] = this.heap[posH];
                    this.heap[posH] = temp;
                    posPadre = posH;
                } else {
                    //el padre es menor que sus hijos, esta bien ubicado
                    salir = true;
                }
            } else {
                //el temp es hoja, esta bien ubicado
                salir = true;
            }
        }
    }

    public Object recuperarCima() {
        //precondicion: el arbol no esta vacio
        return this.heap[1];
    }

    public boolean esVacio() {
        return this.ultimo == 0;
    }

    public void vaciar() {
        for (int i = 0; i < this.ultimo; i++) {
            this.heap[i] = null;
        }
        ultimo = 0;
    }

    @Override
    public ArbolHeap clone() {
        ArbolHeap clon = new ArbolHeap();

        if (!esVacio()) {
            clon.ultimo = this.ultimo;
            for (int i = 0; i <= this.ultimo; i++) {
                clon.heap[i] = this.heap[i];
            }

        }

        return clon;
    }

    @Override
    public String toString() {
        String cad = "[";

        if (!esVacio()) {
            for (int i = 1; i <= this.ultimo; i++) {
                cad = cad + this.heap[i] + ", ";
            }
        }
        cad += "]";

        return cad;
    }

}
