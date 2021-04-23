/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Santiago Briceño, Ximena Hernandez
 */
public class ColaSanti {

    private Nodo frente;
    private Nodo fin;
    
    public ColaSanti(){
        frente = null;
        fin = null;
    }
    
    public boolean poner(Object elem){
        //pone un elemento al final de la cola
        
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
        //saca un elemento del frente de la cola
        
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
        //indica si la cola es vacia
       return (this.frente == null);
    }
    
    public Object obtenerFrente(){
        //devuelve el objeto que esta en tope, es null si esta vacia
        Object s;
        if (esVacia()) {
            s = null;
        } else {
            s = this.frente.getElem();
        }
        return s;
    }
    
    public void vaciar(){
        //vacia la cola
        this.frente = null;
        this.fin = null;
    }
    
    public String toString(){
        //devuelve la cola como string
        
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
        //devuelve una copia de la cola original
        
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
    
}
