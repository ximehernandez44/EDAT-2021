package conjuntistas;

public class NodoABB {
    private Object elem; //es Object o Comparable?
    private NodoABB izquierdo;
    private NodoABB derecho;

    public NodoABB (Object elem, NodoABB izq, NodoABB der) {
        this.elem = elem;
        this.izquierdo = izq;
        this.derecho = der;
    }

    public NodoABB(Object elem) {
        this.elem = elem;
    }

    public Object getElem() {
        return elem;
    }
    public NodoABB getIzquierdo() {
        return izquierdo;
    }
    public NodoABB getDerecho() {
        return derecho;
    }
    public void setElem(Object elem) {
        this.elem = elem;
    }
    public void setIzquierdo(NodoABB izq) {
        this.izquierdo = izq;
    }
    public void setDerecho(NodoABB der) {
        this.derecho = der;
    }
}
