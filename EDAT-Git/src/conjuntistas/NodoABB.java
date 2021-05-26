package conjuntistas;

public class NodoABB {
    private Comparable elem;
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB (Comparable elem, NodoABB izq, NodoABB der) {
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
    }

    public NodoABB(Comparable elem) {
        this.elem = elem;
    }

    public Comparable getElem() {
        return elem;
    }
    public NodoABB getIzquierdo() {
        return izquierdo;
    }
    public NodoABB getDerecho() {
        return derecho;
    }
    public void setElem(Comparable elem) {
        this.elem = elem;
    }
    public void setIzquierdo(NodoABB izq) {
        this.izquierdo = izq;
    }
    public void setDerecho(NodoABB der) {
        this.derecho = der;
    }
}
