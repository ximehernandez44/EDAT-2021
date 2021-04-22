/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Santiago B
 */
public class ColaSanti {

    private Nodo frente;
    private Nodo fin;
    
    public ColaSanti(){
        frente = null;
        fin = null;
    }
    
    public boolean poner(Object elem){
        boolean exito = true;
        Nodo nuevoNodo = new Nodo(elem, null);
        
        if(this.esVacia()){
           this.frente = nuevoNodo; 
        }else{
            this.fin.setEnlace(nuevoNodo);
        }
        
        this.fin = nuevoNodo;
        return exito;
    }
    
    public boolean sacar(){
        boolean exito = true;
        
        if(this.esVacia()){
            exito = false;
        }else{
            this.frente = this.frente.getEnlace();
            if(this.frente == null){
                this.fin = null;
            }
        }
        
        return exito;
    }
    
    public boolean esVacia(){
       return (this.frente == null);
    }
    
    public Object obtenerFrente(){
        return this.frente.getElem();
    }
    
    public void vaciar(){
        this.frente = null;
        this.fin = null;
    }
    
    public String toString(){
        String salida;
        Nodo auxFrente = this.frente;
        if(!this.esVacia()){
            salida = "[";
            while(auxFrente.getEnlace() != null){
                salida += auxFrente.getElem();
                auxFrente = auxFrente.getEnlace();
                if(auxFrente != null){
                    salida += " ";
                }
            }
            salida += "]";
        }else{
            salida = "[cola vacia]";
        }
        return salida;
    }
    
    public ColaSanti clone(){
        ColaSanti clon = new ColaSanti();
        Nodo nodoAux1, nodoAux2;
        
        if(!this.esVacia()){
            nodoAux1 = this.frente;
            clon.frente = new Nodo(nodoAux1.getElem(), null);
            nodoAux1 = nodoAux1.getEnlace();
            nodoAux2 = clon.frente;
            
            while(nodoAux1 != null){
                nodoAux2.setEnlace(new Nodo(nodoAux1.getElem(), null));
                nodoAux2 = nodoAux2.getEnlace();
                nodoAux1 = nodoAux1.getEnlace();
            }
            
            clon.fin = nodoAux2;
        }
        return clon;
    }
    
    /* public Pila clone() {
        //Este metodo se diseño en base a la clase de consulta
        //se usa un aux1 el cual iterará desde el segundo nodo, hasta el ultimo.
        //se usa un aux2 el cual se creará apartir del valor del elemento del nodo aux1, el cual luego de esto, se enlazara con el elemento anterior de la pila.
        
        Pila Clon = new Pila();
        Nodo aux1, nodoClon, aux2;

        if (!this.esVacia()) {
            nodoClon = new Nodo(this.tope.getElem(), null);           
            Clon.tope = nodoClon;                                  
            aux1 = this.tope.getEnlace();                  
            while (aux1 != null) {                        
                aux2 = new Nodo(aux1.getElem(), null);   
                nodoClon.setEnlace(aux2);
                nodoClon = nodoClon.getEnlace();
                aux1 = aux1.getEnlace();
            }
        }
        return Clon;
    }
    */
}
