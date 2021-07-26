package grafo;

public class NodoVert {
    Object elem;
    NodoVert sigVertice;
    NodoAdy primerAdy;

    public NodoVert(Object elem) {
        this.elem = elem;
    }

    public Object getElem() {
        return elem;
    }

    public void setElem(Object elem) {
        this.elem = elem;
    }

    public NodoVert getSigVertice() {
        return sigVertice;
    }
    
    public void setSigVertice(NodoVert vertice) {
        this.sigVertice = vertice;
    }

    public NodoAdy getPrimerAdy() {
        return primerAdy;
    }

    public void setPrimerAdy(NodoAdy primerAdy) {
        this.primerAdy = primerAdy;
    }

}